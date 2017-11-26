package com.threenary.springmvc;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.web.WebDelegatingSmartContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.threenary.crawlerizer.config.PersistenceTestConfig;
import com.threenary.crawlerizer.config.WebTestConfig;
import com.threenary.crawlerizer.service.SiteService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader = WebDelegatingSmartContextLoader.class, classes = {WebTestConfig.class, PersistenceTestConfig.class})
public class CrawlerizerRestControllerIT
{
    private MockMvc mockMvc;

    @Mock
    SiteService siteService;

    @InjectMocks
    private CrawlerizerRestControllerIT testSubject;

    private final String jsonBody = "{\"url\": \"www.cde.com.ar\", \"rank\": \"55\"}";


    @Before
    public void preTest()
    {
        initMocks(this);

        mockMvc =
            MockMvcBuilders
                .standaloneSetup(testSubject)
                .build();
    }


    @Test
    @Ignore
    public void crawlOne() throws Exception
    {
        mockMvc
            .perform(
                post("/crawlOne")
                    .content(jsonBody)
                    .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("[{\"id\":1,\"site\":\"www.cde.com.ar\",\"qualification\":\"false\"}]"));
    }

}
