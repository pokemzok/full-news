package fullnews.backend.core;

import fullnews.backend.api.Article;
import fullnews.backend.api.NewsResponse;
import fullnews.backend.api.newsapi.response.NewsApiResponse;

import java.time.ZoneOffset;
import java.util.stream.Collectors;

class NewsResponseBuilder {

    private NewsApiResponse apiResponse;
    private String country;
    private String category;

    NewsResponseBuilder apiResponse(NewsApiResponse apiResponse){
        this.apiResponse = apiResponse;
        return this;
    }

    NewsResponseBuilder country(String country){
        this.country = country;
        return this;
    }

    NewsResponseBuilder category(String category){
        this.category = category;
        return this;
    }

    NewsResponse build(){
        //FIXME stream null safety
        var articles = apiResponse.getArticles().stream()
                .map(apiArticle -> new Article(
                        apiArticle.getAuthor(),
                        apiArticle.getTitle(),
                        apiArticle.getDescription(),
                        apiArticle.getPublishedAt().withZoneSameInstant(ZoneOffset.UTC).toLocalDate(),
                        apiArticle.getSource().getName(), // FIXME null check here
                        apiArticle.getUrl(),
                        apiArticle.getUrlToImage()
                ))
                .collect(Collectors.toList());
        return new NewsResponse(country, category, articles);
    }
}
