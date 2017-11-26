package com.threenary.crawlerizer.qualifier;

/**
 *  Interface for qualifying sites.
 * 
 *  This will allow us extend the amount of qualifiers.
 *
 */
public interface IQualifier
{

    boolean qualify(String url);

}
