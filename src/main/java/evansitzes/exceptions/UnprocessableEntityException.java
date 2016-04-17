package evansitzes.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.WebServiceException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

/**
 * Created by evan on 4/17/16.
 */
@ResponseStatus(UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends WebServiceException {
    public UnprocessableEntityException(final String message) {
        super(message);
    }

    public UnprocessableEntityException(final Throwable throwable, final String message) {
        super(message, throwable);
    }
}
