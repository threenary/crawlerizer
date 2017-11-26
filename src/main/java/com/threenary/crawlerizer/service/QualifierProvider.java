package com.threenary.crawlerizer.service;

import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.qualifier.IQualifier;

public interface QualifierProvider
{
    IQualifier getQualifier(String text) throws QualifierNotFoundException;
}
