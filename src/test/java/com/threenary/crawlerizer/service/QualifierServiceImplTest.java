package com.threenary.crawlerizer.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.threenary.crawlerizer.exception.UnsuportedURLException;
import com.threenary.crawlerizer.model.Site;
import com.threenary.crawlerizer.qualifier.TitleQualifier;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Jsoup.class})
public class QualifierServiceImplTest
{

    @Mock
    QualifierProvider qualifierProvider;

    @Mock
    SiteService siteService;

    @InjectMocks
    QualifierServiceImpl testSubject = new QualifierServiceImpl();


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(qualifierProvider);
        PowerMockito.mockStatic(Jsoup.class);
    }


    @Test
    public void qualify_happyPathTest() throws Exception
    {
        //Given
        String SITE_URL = "marfee.com";

        Connection connection = Mockito.mock(Connection.class);
        TitleQualifier qualifier = Mockito.mock(TitleQualifier.class);

        PowerMockito.when(Jsoup.connect(Mockito.anyString())).thenReturn(connection);

        Mockito.when(connection.get()).thenReturn(getMockedDocument());
        Mockito.when(qualifierProvider.getQualifier(anyString())).thenReturn(qualifier);
        Mockito.when(siteService.save(any(Site.class))).thenReturn(new Site(SITE_URL, true));
        Mockito.when(qualifier.qualify(anyString())).thenReturn(true);

        //When
        testSubject.qualifiy(SITE_URL, "title");

        //Then
        Mockito.verify(siteService, times(1)).save(any(Site.class));
        Mockito.verify(qualifierProvider);
    }


    @Test(expected = UnsuportedURLException.class)
    public void qualify_NotValidUrl_shouldThrowExceptionTest() throws Exception
    {
        //Given
        String SITE_URL = "anything.p223cxx123#$#%";

        //When
        testSubject.qualifiy(SITE_URL, "title");

        //Then exception is thrown
    }
    
    @Test(expected = UnsuportedURLException.class)
    public void qualify_nullUrl_shouldThrowExceptionTest() throws Exception
    {
        //When
        testSubject.qualifiy(null, "title");

        //Then exception is thrown
    }


    private Document getMockedDocument()
    {
        return new Document("uri");
    }

}
