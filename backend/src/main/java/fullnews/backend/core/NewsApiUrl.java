package fullnews.backend.core;

import fullnews.backend.api.newsapi.NewsApiUrlIsIncorrectException;
import fullnews.backend.api.newsapi.NewsApiUrlParamIsIncorrectException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class NewsApiUrl {

    private final static String API_KEY_PARAM = "apiKey";
    private final static String COUNTRY_PARAM = "country";
    private final static String CATEGORY_PARAM = "category";

    @NonNull
    private final NewsApiConfiguration apiConfiguration;

    @NonNull
    private final String country;

    @NonNull
    private final String category;

    public String toString() {
        NewsApiUrlPreconditions.check(this);
        return apiConfiguration.getTopHeadlinesUrl()
                .concat("?")
                .concat(createRequiredUrlParam(API_KEY_PARAM, apiConfiguration.getKey()))
                .concat("&")
                .concat(createRequiredUrlParam(COUNTRY_PARAM, this.country))
                .concat("&")
                .concat(createRequiredUrlParam(CATEGORY_PARAM, this.category));
    }

    private String createRequiredUrlParam(String paramName, String paramValue) {
        return paramName
                .concat("=")
                .concat(paramValue);
    }

    private static class NewsApiUrlPreconditions {

        static void check(NewsApiUrl newsApiUrl) {
            notNullOrBlankUrl(newsApiUrl.apiConfiguration.getTopHeadlinesUrl());
            notNullOrBlankUrlParameter(newsApiUrl.apiConfiguration.getKey(), API_KEY_PARAM);
            notNullOrBlankUrlParameter(newsApiUrl.country, COUNTRY_PARAM);
            notNullOrBlankUrlParameter(newsApiUrl.category, CATEGORY_PARAM);
        }

        private static void notNullOrBlankUrl(String url) {
            if (url == null || url.isBlank()) {
                throw new NewsApiUrlIsIncorrectException(
                    "News api url is incorrect. Current url value is [" + url+"]"
                );
            }
        }

        private static void notNullOrBlankUrlParameter(String param, String paramName) {
            if (param == null || param.isBlank()) {
                throw new NewsApiUrlParamIsIncorrectException(
                        "News api url parameter is incorrect. Param " + paramName + " has value of [" + param+"]",
                        new Object[]{param, paramName}
                );
            }
        }
    }

}
