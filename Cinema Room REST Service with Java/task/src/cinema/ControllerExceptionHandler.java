package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({InvalidSeatException.class, TicketPurchaseException.class, WrongTokenException.class})
    public ResponseEntity<CustomErrorMessage> handleInvalidSeat(RuntimeException e) {

        CustomErrorMessage body = new CustomErrorMessage(e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<CustomErrorMessage> handleInvalidPassword(RuntimeException e){

        CustomErrorMessage body = new CustomErrorMessage(e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
