package fullnews.backend.core

import fullnews.backend.api.newsapi.response.NewsApiArticle
import fullnews.backend.api.newsapi.response.NewsApiResponse
import fullnews.backend.api.newsapi.response.NewsSource

import java.time.ZonedDateTime

class MockedNewsApiResponseFactory {

    static NewsApiResponse create(){
        return new NewsApiResponse(
                totalResults: 2,
                status: "200",
                articles: List.of(createTeslaArticle(), createSuperBowlArticle())

        )
    }

    static NewsApiArticle createTeslaArticle(){
        return new NewsApiArticle(
                source: new NewsSource(id: "tesla", name: "Electrek.co"),
                author: "Melon Ask",
                title: "Tesla Model 3 tops list of vehicles that ‘bring the most joy’ - Electrek",
                description: "Tesla Model 3 is topping many lists these days like best-selling all-electric vehicles, best value retention, best-selling premium vehicles in the US, but now it is adding another one to the list",
                url: "https://electrek.co/2019/02/01/tesla-model-3-tops-satisfaction-brings-joy/",
                urlToImage: "https://electrek.co/wp-content/uploads/sites/3/2018/11/Model-3-Performance-Red-Front-Motion-SF-Skyline-e1538058962929.jpg?quality=82&strip=all&w=1600",
                publishedAt: ZonedDateTime.parse("2019-02-02T04:43:00Z"),
                content: "Tesla Model 3 is topping many lists these days like best-selling all-electric vehicles, best value retention, best-selling premium vehicles in the US, but now it is adding another one to the list: the vehicle that ‘brings the most joy’. Consumer Reports relea… [+1896 chars]"
        )
    }

    static NewsApiArticle createSuperBowlArticle(){
        return new NewsApiArticle(
                source: new NewsSource(id: "superBowl", name: "Nesn.com"),
                author: "Adam London",
                title: "Why Colin Cowherd Believes Patriots Will Oust Rams In Super Bowl LIII - NESN",
                description: "It’s been a common theme for sports pundits to pick against the New England Patriots this season, but Colin Cowherd isn’t following his colleagues’ lead for the final contest of t…",
                url: "https://nesn.com/2019/02/why-colin-cowherd-believes-patriots-will-oust-rams-in-super-bowl-liii/",
                urlToImage: "https://nesncom.files.wordpress.com/2019/02/james-white-tom-brady.jpg",
                publishedAt: ZonedDateTime.parse("2019-02-02T04:11:00Z"),
                content: "It’s been a common theme for sports pundits to pick against the New England Patriots this season, but Colin Cowherd isn’t following his colleagues’ lead for the final contest of the campaign. Unlike Max Kellerman and Ray Lewis, Cowherd believes the Patriots w… [+1022 chars]"
        )
    }

}
