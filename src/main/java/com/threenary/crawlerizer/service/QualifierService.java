package com.threenary.crawlerizer.service;

import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.exception.UnsuportedURLException;
import com.threenary.crawlerizer.model.Site;

/**
 * Interface which defines the expected behavior of the qualifying service
 */
public interface QualifierService
{

    Site qualifiy(String url, String qualifier) throws QualifierNotFoundException, UnsuportedURLException;
}
