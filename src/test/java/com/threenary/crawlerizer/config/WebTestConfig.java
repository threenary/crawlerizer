package com.threenary.crawlerizer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.threenary.crawlerizer.controller", "com.threenary.crawlerizer.repository", "com.threenary.crawlerizer.service"})
public class WebTestConfig
{

}
