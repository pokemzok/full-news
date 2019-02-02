package fullnews.backend.core

import fullnews.backend.api.newsapi.NewsApiUrlIsIncorrectException
import fullnews.backend.api.newsapi.NewsApiUrlParamIsIncorrectException
import spock.lang.Specification

class NewsApiUrlSpec extends Specification {

    def "should construct correct url for GET news api request"() {
        given:
        def correctApiConfiguration = new NewsApiConfiguration(
                topHeadlinesUrl: "https://newsapi.org/v2/top-headlines",
                key: "sampleKey"
        )
        def country = "pl"
        def category = "technology"
        when:
        def newsApiUrlString = new NewsApiUrl(correctApiConfiguration, country, category).toString()
        then:
        newsApiUrlString == "https://newsapi.org/v2/top-headlines?apiKey=sampleKey&country=pl&category=technology"
    }

    def "should throw exception during url construction because required params are no present"() {
        when:
        new NewsApiUrl(apiConfig, country, technology).toString()
        then:
        def ex = thrown(expectedException)
        ex.getMessage() == message
        where:
        apiConfig                                                    | country | technology | expectedException                   | message
        null                                                         | null    | null       | NullPointerException                | "apiConfiguration is marked @NonNull but is null"
        new NewsApiConfiguration()                                   | null    | null       | NullPointerException                | "country is marked @NonNull but is null"
        new NewsApiConfiguration()                                   | ""      | null       | NullPointerException                | "category is marked @NonNull but is null"
        new NewsApiConfiguration()                                   | ""      | ""         | NewsApiUrlIsIncorrectException      | "News api url is incorrect. Current url value is [null]"
        new NewsApiConfiguration(topHeadlinesUrl: "url")             | ""      | ""         | NewsApiUrlParamIsIncorrectException | "News api url parameter is incorrect. Param apiKey has value of [null]"
        new NewsApiConfiguration(topHeadlinesUrl: "url", key: "key") | ""      | ""         | NewsApiUrlParamIsIncorrectException | "News api url parameter is incorrect. Param country has value of []"
        new NewsApiConfiguration(topHeadlinesUrl: "url", key: "key") | " "     | ""         | NewsApiUrlParamIsIncorrectException | "News api url parameter is incorrect. Param country has value of [ ]"
        new NewsApiConfiguration(topHeadlinesUrl: "url", key: "key") | "pl"    | ""         | NewsApiUrlParamIsIncorrectException | "News api url parameter is incorrect. Param category has value of []"
        new NewsApiConfiguration(topHeadlinesUrl: "url", key: "key") | "pl"    | " "        | NewsApiUrlParamIsIncorrectException | "News api url parameter is incorrect. Param category has value of [ ]"
    }

}
