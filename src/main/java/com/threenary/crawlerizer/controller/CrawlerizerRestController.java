package com.threenary.crawlerizer.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.threenary.crawlerizer.dto.UrlRank;
import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.exception.UnsuportedURLException;
import com.threenary.crawlerizer.model.Site;
import com.threenary.crawlerizer.service.QualifierService;
import com.threenary.crawlerizer.service.SiteService;

/**
 * API REST Controller
 *
 */
@Controller
public class CrawlerizerRestController
{
    static final Logger LOG = Logger.getLogger(CrawlerizerRestController.class.getName());
    
    @Autowired
    private QualifierService qualifierService;

    @Autowired
    private SiteService siteService;


    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody List<Site> getAll()
    {
        return siteService.getAll();
    }


    @RequestMapping(value = "/crawlOne", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Site crawlOne(@RequestBody final UrlRank urlRank, @RequestParam(value = "qualifier") String qualifier)
        throws QualifierNotFoundException, UnsuportedURLException
    {
        return qualifierService.qualifiy(urlRank.getUrl(), qualifier);
    }


    @RequestMapping(value = "/crawl", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Async
    public @ResponseBody void crawl(@RequestBody final List<UrlRank> urls, @RequestParam(value = "qualifier") String qualifier)
        throws QualifierNotFoundException, UnsuportedURLException
    {
        urls.parallelStream().forEach(url -> {
            try
            {
                qualifierService.qualifiy(url.getUrl(), qualifier);
            }
            catch (QualifierNotFoundException | UnsuportedURLException e)
            {
                LOG.warning(String.format("[%s] Error processing: %s", url.getUrl(), e));
            }
        });
    }
}
