package com.threenary.crawlerizer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * POJO which models data received in json
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlRank
{
    private String url;

    @JsonIgnore
    private long rank;


    /**
     * Default constructor
     */
    public UrlRank()
    {
        super();
    }


    /**
     * @param url
     * @param rank
     */
    public UrlRank(String url, long rank)
    {
        super();
        this.url = url;
        this.rank = rank;
    }


    public String getUrl()
    {
        return url;
    }


    public void setUrl(String url)
    {
        this.url = url;
    }


    public long getRank()
    {
        return rank;
    }


    public void setRank(long rank)
    {
        this.rank = rank;
    }

}
