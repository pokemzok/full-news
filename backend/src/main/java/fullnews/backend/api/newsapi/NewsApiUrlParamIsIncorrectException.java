package fullnews.backend.api.newsapi;

public class NewsApiUrlParamIsIncorrectException extends BackendException {

    private final static String CODE = "INCORRECT_URL_PARAM";

    public NewsApiUrlParamIsIncorrectException(String message, Object[] exceptionObjects) {
        super(message, CODE, exceptionObjects);
    }

}
