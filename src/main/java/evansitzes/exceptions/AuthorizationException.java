package evansitzes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.WebServiceException;

/**
 * Created by evan on 4/7/16.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends WebServiceException {
    public AuthorizationException(final String message) {
        super(message);
    }

    public AuthorizationException(final Throwable throwable, final String message) {
        super(message, throwable);
    }
}
