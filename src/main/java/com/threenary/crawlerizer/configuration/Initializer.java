package com.threenary.crawlerizer.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[] {WebConfig.class, PersistenceConfig.class, ThreadConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return null;
    }


    @Override
    protected String[] getServletMappings()
    {
        return new String[] {"/"};
    }

}
