package com.threenary.crawlerizer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.threenary.crawlerizer.qualifier.IQualifier;
import com.threenary.crawlerizer.qualifier.TitleQualifier;
import com.threenary.crawlerizer.service.QualifierProvider;
import com.threenary.crawlerizer.service.QualifierProviderImpl;

@Configuration
@EnableWebMvc
@ComponentScan({"com.threenary.crawlerizer"})
public class WebConfig
{
    @Bean
    public QualifierProvider qualifierProvider()
    {
        Map<String, IQualifier> qualifiers = new HashMap<>();
        qualifiers.put("title", new TitleQualifier());

        return new QualifierProviderImpl(qualifiers);
    }

}
