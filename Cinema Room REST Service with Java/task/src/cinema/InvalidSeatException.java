package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidSeatException extends RuntimeException{
    public InvalidSeatException(String msg) {
        super(msg);
    }
}
