# crawlerizer
This project consists of a simple REST API in which one can post a JSON object consisting of an url, which is parsed by the backend and it tries to crawl the result trying to _qualify_ the content.

## List of Endpoints

*/crawlOne*
```json
{
  "url": "cde.com.ar",
  "rank": 834987
  }
```
*/crawl*
```json
[    
    {
        "url": "cde.com.ar",
        "rank": 834987
    },
    {
        "url": "clarin.com",
        "rank": 834987
    }
]
```
*/getAll*

## Qualifier
Is a basic component intended to find a regular text in the tags of the html content. Currently is extensible via adding a new implementation of the _IQualifier_ interface.

By default, it will apply the _TitleQualifier_ which is in charge of search keywords in the <title> tag to find some matches.

# Instructions
Clone the repo and simply run ```mvn install``` inside the unzipped project's folder. If successful this should produce a war file inside the target folder which can be deployed in the server, or import it in your favorite IDE and deploy it into the embeded server to be run

# Advice
Since I faced conflicts when trying to integrate testing the REST API, a [Postman](https://www.getpostman.com/) file is included into ```/crawlerizer/src/test/resources``` the to import and allow the basic runs on the application
