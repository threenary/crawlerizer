package com.threenary.crawlerizer.persistence;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.threenary.crawlerizer.config.PersistenceTestConfig;
import com.threenary.crawlerizer.model.Site;
import com.threenary.crawlerizer.repository.SiteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SiteRepositoryIT
{

    private static final String SITE = "www.cde.com.ar";

    @Resource
    private SiteRepository testSubject;

    @Test
    public void givenSite_whenSave_thenItCanBeRecovered()
    {
        //Given
        Site site = new Site(SITE, Boolean.TRUE);
        
        //When
        testSubject.save(site);

        //Then
        Site retrievedSite = testSubject.findOne(site.getId());
        assertEquals("name incorrect", SITE, retrievedSite.getSite());
    }

}
