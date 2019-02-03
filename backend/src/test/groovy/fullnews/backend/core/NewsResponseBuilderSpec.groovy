package fullnews.backend.core


import fullnews.backend.api.Article
import fullnews.backend.api.NewsResponse
import fullnews.backend.api.newsapi.response.NewsApiArticle
import fullnews.backend.api.newsapi.response.NewsApiResponse
import spock.lang.Specification

import java.time.LocalDate

class NewsResponseBuilderSpec extends Specification {

    def "should correctly build news response from api response and path parameters"() {
        given:
        def country = "pl"
        def category = "technology"
        def newsApiResponse = MockedNewsApiResponseFactory.create()
        when:
        def response = new NewsResponseBuilder()
                .apiResponse(newsApiResponse)
                .country(country)
                .category(category)
                .build()
        then:
        new JsonObject(response).toString() == new JsonObject(new NewsResponse(
                country: country,
                category: category,
                articles: List.of(
                        new Article(
                                author: "Melon Ask",
                                title: "Tesla Model 3 tops list of vehicles that ‘bring the most joy’ - Electrek",
                                description: "Tesla Model 3 is topping many lists these days like best-selling all-electric vehicles, best value retention, best-selling premium vehicles in the US, but now it is adding another one to the list",
                                date: LocalDate.parse("2019-02-02"),
                                sourceName: "Electrek.co",
                                articleUrl: "https://electrek.co/2019/02/01/tesla-model-3-tops-satisfaction-brings-joy/",
                                imageUrl: "https://electrek.co/wp-content/uploads/sites/3/2018/11/Model-3-Performance-Red-Front-Motion-SF-Skyline-e1538058962929.jpg?quality=82&strip=all&w=1600"
                        ),
                        new Article(
                                author: "Adam London",
                                title: "Why Colin Cowherd Believes Patriots Will Oust Rams In Super Bowl LIII - NESN",
                                description: "It’s been a common theme for sports pundits to pick against the New England Patriots this season, but Colin Cowherd isn’t following his colleagues’ lead for the final contest of t…",
                                date: LocalDate.parse("2019-02-02"),
                                sourceName: "Nesn.com",
                                articleUrl: "https://nesn.com/2019/02/why-colin-cowherd-believes-patriots-will-oust-rams-in-super-bowl-liii/",
                                imageUrl: "https://nesncom.files.wordpress.com/2019/02/james-white-tom-brady.jpg"
                        )
                )
        )).toString()
    }

    def "should correctly build news response for incomplete data"() {
        when:
        def response = new NewsResponseBuilder()
                .country(country)
                .category(category)
                .apiResponse(newsApiResponse)
                .build()
        then:
        new JsonObject(response).toString() == expectedResponse
        where:
        country | category | newsApiResponse                                                    | expectedResponse
        null    | null     | null                                                               | new JsonObject(new NewsResponse(null, null, new ArrayList<Article>())).toString()
        null    | null     | new NewsApiResponse()                                              | new JsonObject(new NewsResponse(null, null, new ArrayList<Article>())).toString()
        null    | null     | new NewsApiResponse()                                              | new JsonObject(new NewsResponse(null, null, new ArrayList<Article>())).toString()
        null    | null     | new NewsApiResponse(articles: Arrays.asList(new NewsApiArticle())) | new JsonObject(new NewsResponse(null, null, Arrays.asList(new Article()))).toString()
    }

}

