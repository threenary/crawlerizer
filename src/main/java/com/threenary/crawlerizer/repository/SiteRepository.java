package com.threenary.crawlerizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threenary.crawlerizer.model.Site;

public interface SiteRepository extends JpaRepository<Site, Long>
{
    Site findBySite(String url);

}
