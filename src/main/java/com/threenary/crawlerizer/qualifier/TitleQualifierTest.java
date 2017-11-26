package com.threenary.crawlerizer.qualifier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TitleQualifierTest
{
    TitleQualifier testSubject = new TitleQualifier();


    @Test
    public void qualifyHappyPath()
    {
        assertThat(testSubject.qualify(htmlWithTitle), is(true));
    }


    @Test
    public void qualify_htmlWithNoNews_shouldReturnFalseTest()
    {
        assertThat(testSubject.qualify(htmlWithTitleNoNews), is(false));
    }


    @Test
    public void qualify_htmlWithMoreThanOneTitle_shouldReturnFalseTest()
    {
        assertThat(testSubject.qualify(htmlWithMoreThanOneTitle), is(false));
    }


    @Test
    public void qualify_withEmptyHtml_shouldReturnFalse()
    {
        assertThat(testSubject.qualify(htmlEmpty), is(false));
    }

    private static final String htmlWithTitle = "<html><title>Noticias</title></html>";

    private static final String htmlWithTitleNoNews = "<html><title>Other Text</title></html>";

    private static final String htmlWithMoreThanOneTitle = "<html><title>Noticias</title><title>Noticias</title></html>";

    private static final String htmlEmpty = "";

}
