package fullnews.backend.api.newsapi;

class BackendException extends RuntimeException {

    private final String code;
    private final Object[] exceptionObjects;


    BackendException(String message, String code, Object[] exceptionObjects) {
        super(message);
        this.code = code;
        this.exceptionObjects = exceptionObjects;
    }
}
