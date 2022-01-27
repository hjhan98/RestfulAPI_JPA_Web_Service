package syscon.restapijpaservice.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * error msg
 *
 * @author sungg
 * @version 1.0 (2020-01-24)
 */
@Getter
@AllArgsConstructor
public enum ErrorMessage {

    // 400 Bad Request
    DUPLICATED_USER_ID(40010, "error.duplicated.user.id"),
//    INVALID_REQUEST_PARAMS(40010, "error.invalid.request.params"),
//    INVALID_REQUEST_FORM(40011,"error.invalid.request.form"),
//    INVALID_USER_SIGNIN_INFO("error.invalid.user.signin.info"),
//    INVALID_USER_REGISTER_FORM("error.invalid.user.register.form"),
//    INVALID_USER_OLD_PASSWORD("error.invalid.user.old.password"),
//    INVALID_USER_ID("error.invalid.user.id"),
//    INVALID_USER_PWD("error.invalid.user.pwd"),
//    INVALID_USER_ACTIVE("error.invalid.user.active"),
//    INVALID_USER_ID_PATTERN("error.invalid.user.id.pattern"),
//    INVALID_USER_PWD_PATTERN("error.invalid.user.pwd.pattern"),
//    INVALID_USER_LOGIN("error.invalid.user.login"),



    // 401 Unauthorized
    UNAUTHORIZED_TOKEN(40101, "error.unauthorized.token"),
//    MALFORMED_TOKEN("error.malformed.token"),
//    EXPIRED_TOKEN("error.expired.token"),
//    UNSUPPORTED_TOKEN("error.unsupport.token"),
//    WRONG_TOKEN("error.wrong.token"),
//    UNVALID_TOKEN("error.unvalid.token"),
//    EMPTY_TOKEN("error.empty.token"),
//    UNAUTHORIZED_TOKEN("error.unauthorized.token"),
//    SESSION_IS_WRONG("error.wrong.session"),


    // 404 Not Found
//    USER_NOT_FOUND("error.not-found.user"),
//    SESSION_NOT_FOUND("error.not-found.session"),


    // 408 Request Timeout
//    TIMEOUT_DB("error.timeout.db"),


    // 409 Conflict
//    DUPLICATE_USER_ID("error.duplicate.user.id"),
//    DUPLICATE_USER_EMAIL("error.duplicate.user.email"),


    // 426 Upgrade Required
//    UPGRADE_VERSION_FOR_ANDROID("error.upgrade.version.android"),
//    UPGRADE_VERSION_FOR_IOS("error.upgrade.version.ios"),


    // 503 Service Unavailable
//    UNAVALIABLE_API("error.unavailable.api"),
//    DATA_NOT_FOUND("error.data.not.found"),


    // 500 Internal Server Error
//    NOT_READY_SERVER("error.server.not.ready"),
    ;

    private int code;
    private String description;

}
