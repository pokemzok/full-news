package fullnews.backend.api.newsapi;

public class NewsApiUrlIsIncorrectException extends BackendException {

    private final static String CODE = "INCORRECT_URL";

    public NewsApiUrlIsIncorrectException(String message) {
        super(message, CODE, new Object[]{});
    }

}
