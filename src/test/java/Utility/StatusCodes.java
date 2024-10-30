package Utility;

public enum StatusCodes {

    SUCCESS(200, "success"),

    CREATE(201, "created"),

    ACCEPTED(202, "accepted"),

    NO_CONTENT(204, "no content"),

    BAD_REQUEST(400, "bad request"),

    UNAUTHORIZED(401, "unauthroized"),  //Authentication issues (not logged in or invalid credentials)

    FORBIDDEN(403, "forbidden"), //Authorization issues (logged in but insufficient permissions)

    NOT_FOUND(404, "not found"),

    METHOD_NOT_FOUND(405, "method not found"),

    GONE(510, "gone"),
    UNSUPPORTED_MEDIA_TYPE(415, "unsupported Media Type"),
    UNPROCESSED_ENTITY(422, "unprocessed entity"),
    TOO_MANY_REQUESTS(429, "too many requests"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    NOT_IMPLEMENTED(501, "not implemented"),
    BAD_GATEWAY(502, "bad gateway"),
    SERVICE_UNAVAILABLE(503, "service unavailable"),
    GATEWAY_TIMEOUT(504, "gateway timeout");

    public final int statusCode;

    public final String message;

    StatusCodes(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


}