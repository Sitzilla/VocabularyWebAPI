package evansitzes.helpers;

import evansitzes.exceptions.AuthorizationException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by evan on 4/7/16.
 */
public class ValidateAuthToken {

    public static void assertAuthTokenIsValid(final String authToken) {
        if (!StringUtils.equals(System.getenv("ADMIN_KEY"), authToken)) {
            throw new AuthorizationException("Auth token [" + authToken + "] not authorized.");
        }
    }

}
