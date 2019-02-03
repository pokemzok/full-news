package fullnews.backend.core;

import fullnews.backend.api.Article;
import fullnews.backend.api.NewsResponse;
import fullnews.backend.api.newsapi.response.NewsApiResponse;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NewsResponseBuilder {

    private NewsApiResponse apiResponse;
    private String country;
    private String category;

    NewsResponseBuilder apiResponse(NewsApiResponse apiResponse) {
        this.apiResponse = apiResponse;
        return this;
    }

    NewsResponseBuilder country(String country) {
        this.country = country;
        return this;
    }

    NewsResponseBuilder category(String category) {
        this.category = category;
        return this;
    }

    NewsResponse build() {
        var articles = apiResponse == null ? new ArrayList<Article>() : Stream.ofNullable(apiResponse.getArticles())
                .flatMap(Collection::stream)
                .map(apiArticle -> new Article(
                        apiArticle.getAuthor(),
                        apiArticle.getTitle(),
                        apiArticle.getDescription(),
                        apiArticle.getPublishedAt() == null ? null : apiArticle.getPublishedAt().withZoneSameInstant(ZoneOffset.UTC).toLocalDate(),
                        apiArticle.getSource() == null ? null : apiArticle.getSource().getName(),
                        apiArticle.getUrl(),
                        apiArticle.getUrlToImage()
                ))
                .collect(Collectors.toList());
        return new NewsResponse(country, category, articles);
    }

}
