package com.threenary.crawlerizer.qualifier;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Basic title qualifier which will parse the html based on the <title> tag caracheristics:
 * TAG: <title>
 * Keywords: news, noticias
 * 
 */
public class TitleQualifier implements IQualifier
{

    public boolean qualify(String html)
    {
        Document doc = Jsoup.parse(html);
        Elements titles = doc.getElementsByTag("title");
        if (titles.size() == 1)
        {
            Element title = titles.get(0);
            String value = title.text().toLowerCase();
            return value != null && (value.contains("news") || value.contains("noticias"));
        }
        return false;
    }

}
