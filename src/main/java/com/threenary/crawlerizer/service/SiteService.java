package com.threenary.crawlerizer.service;

import java.util.List;

import com.threenary.crawlerizer.model.Site;

public interface SiteService
{

    Site findById(long id);


    Site save(Site site);


    List<Site> getAll();

}
