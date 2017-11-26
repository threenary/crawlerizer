package com.threenary.crawlerizer.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.threenary.crawlerizer.exception.QualifierNotFoundException;
import com.threenary.crawlerizer.qualifier.IQualifier;

@Service("qualifierProvider")
public class QualifierProviderImpl implements QualifierProvider
{
    private Map<String, IQualifier> qualifiers;


    /**
     * @param qualifiers
     */
    public QualifierProviderImpl(Map<String, IQualifier> qualifiers)
    {
        super();
        this.qualifiers = qualifiers;
    }


    @Override
    public IQualifier getQualifier(String text) throws QualifierNotFoundException
    {
        if (qualifiers.containsKey(text))
        {
            return qualifiers.get(text);
        }
        throw new QualifierNotFoundException(String.format("Unsuported qualifier: %s", text));
    }


    public void setQualifiers(Map<String, IQualifier> qualifiers)
    {
        this.qualifiers = qualifiers;
    }

}
