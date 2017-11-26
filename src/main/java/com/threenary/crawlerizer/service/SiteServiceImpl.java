package com.threenary.crawlerizer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threenary.crawlerizer.model.Site;
import com.threenary.crawlerizer.repository.SiteRepository;

@Service("siteService")
@Transactional
public class SiteServiceImpl implements SiteService
{
    @Autowired
    private SiteRepository repository;


    @Override
    public Site findById(long id)
    {
        return repository.getOne(id);
    }


    @Override
    public Site save(Site site)
    {
        return repository.save(site);
    }


    @Override
    public List<Site> getAll()
    {
        return repository.findAll();
    }

}
