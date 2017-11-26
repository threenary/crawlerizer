package com.threenary.crawlerizer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private boolean qualification;


    /**
     * @param id
     * @param site
     * @param qualification
     */
    public Site(String site, boolean qualification)
    {
        super();
        this.site = site;
        this.qualification = qualification;
    }


    /**
     * Default constructor
     */
    public Site()
    {
        super();
    }


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getSite()
    {
        return site;
    }


    public void setSite(String site)
    {
        this.site = site;
    }


    public boolean isQualification()
    {
        return qualification;
    }


    public void setQualification(boolean qualification)
    {
        this.qualification = qualification;
    }

}
