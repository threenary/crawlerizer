package com.threenary.crawlerizer.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.exception.UnsuportedURLException;
import com.threenary.crawlerizer.model.Site;
import com.threenary.crawlerizer.qualifier.IQualifier;

/**
 * Service with the logic to process multiple request for qualification
 * @author Gonzalo
 *
 */
@Service("qualifierService")
public class QualifierServiceImpl implements QualifierService
{

    static final Logger LOG = Logger.getLogger(QualifierServiceImpl.class.getName());

    @Autowired
    QualifierProvider qualifierProvider;

    @Autowired
    SiteService siteService;


    @Override
    public Site qualifiy(String url, String text) throws QualifierNotFoundException, UnsuportedURLException
    {
        IQualifier qualifier = qualifierProvider.getQualifier(text);

        if (url != null)
        {
            try
            {
                String decoded = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
                boolean result = this.getUrlQualification(decoded, qualifier);
                Site site = new Site(decoded, result);

                LOG.info(String.format("[%s] qualified as [%s]", decoded, result));

                return siteService.save(site);
            }
            catch (UnsupportedEncodingException | IllegalArgumentException e)
            {
                throw new UnsuportedURLException(String.format("[%s] is not possible to process", url), e);
            }
        }
        throw new UnsuportedURLException(String.format("[null] is not possible to process"));
    }


    /**
     * Pulls the url content and applies the quailifier
     * @param url {@link String}
     * @param qualifier {@link IQualifier}
     * @return {@link Boolean} that indicates weather the url visited is qualified or not according to the {@link IQualifier}
     */
    @Async("threadPoolTaskExecutor")
    private boolean getUrlQualification(String url, IQualifier qualifier)
    {
        LOG.info(String.format("[%s] Parsing data for qualification", url));

        try
        {
            Document document = Jsoup.connect("http://" + url).get();

            if (document != null && document.html() != null)
            {
                return qualifier.qualify(document.html());
            }
        }
        catch (IOException e)
        {
            LOG.warning("[" + url + "] Couldn't be parsed url");
            return false;

        }
        return false;
    }
}
