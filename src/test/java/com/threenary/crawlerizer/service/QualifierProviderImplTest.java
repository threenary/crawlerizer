package com.threenary.crawlerizer.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.qualifier.IQualifier;
import com.threenary.crawlerizer.qualifier.TitleQualifier;

public class QualifierProviderImplTest
{

    private QualifierProvider testSubject = new QualifierProviderImpl(getMockedQualifierMap());


    @Test
    public void getExistingQualifier_shouldReturnQualifierTest() throws QualifierNotFoundException
    {
        //When
        IQualifier qualifier = testSubject.getQualifier("title");

        //Then
        assertThat(qualifier, notNullValue());
    }


    @Test(expected = QualifierNotFoundException.class)
    public void getNonExistingQualifier_shouldThrow_QualifierNotFoundExceptionTest() throws QualifierNotFoundException
    {
        //When
        testSubject.getQualifier("nonexistingqualifier");

        //Then
        //Exception is thrown
    }


    private Map<String, IQualifier> getMockedQualifierMap()
    {
        Map<String, IQualifier> map = new HashMap<>();

        map.put("title", new TitleQualifier());

        return map;
    }

}
