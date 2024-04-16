package cinema;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.FormatFlagsConversionMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController // указывает, что этот класс оперирует не моделями, а данными.
public class CinemaController {
    private final Cinema cinema = new Cinema(9, 9);
    public HashMap<String, Seat> soldTickets = new HashMap<>(); // stores all purchased tickets
    private final Token token = new Token();
    private final HashMap <String, Seat> tokensHashMap = new HashMap<>();

    @GetMapping("/seats")
    public String getCinema() {
        Gson gson = new Gson();
        return gson.toJson(cinema);
    }

    @GetMapping("/tokens")
    public String getTokens() {
        Gson gson = new Gson();
        return gson.toJson(tokensHashMap);
    }

    @GetMapping("/soldTickets")  // shows all sold tickets
    public String getSoldTickets() {
        Gson gson = new Gson();
        return gson.toJson(soldTickets.keySet());
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody Seat seat){
        Gson gson = new Gson();

        // 1) Checks if the seat exists
        if ((seat.getRow() <  1 || (seat.getRow() > cinema.getRows())) || (seat.getColumn() < 1 || seat.getColumn() > cinema.columns)) {
            throw new InvalidSeatException("The number of a row or a column is out of bounds!");
        }

        // 2) Determine if the ticket was sold before. If so, throw and error
        if (soldTickets.containsKey(seat.getRow() + "" + seat.getColumn())) {
            throw new TicketPurchaseException("The ticket has been already purchased!");
        } else {
            UUID uuid = UUID.randomUUID(); // serves as a token of a ticket
            token.setTicket(seat);  // bind the seat
            token.setToken(String.valueOf(uuid)); // add unique token
            tokensHashMap.put(String.valueOf(uuid), seat);

            seat.setPrice(); // to recalculate the ticket price
            soldTickets.put(seat.getRow() + "" + seat.getColumn(), seat); // use row + column as KEY
        }

        return ResponseEntity.ok(gson.toJson(token));

    } // purchaseTicket

    @PostMapping("/return")
    public ResponseEntity<String> returnTicket(@RequestBody Token token) {
        Gson gson = new Gson();

        Seat seat = null;
        if (!tokensHashMap.containsKey(token.getToken())) { // if token does not exist
            throw new WrongTokenException("Wrong token!");
        } else {
            for (Map.Entry<String, Seat> map : tokensHashMap.entrySet()) {
                if (map.getKey().equals(token.getToken())) {

                    seat = new Seat((map.getValue().getRow()),
                            map.getValue().getColumn());

                    Map<String, Object> body = new HashMap<>();
                    body.put("ticket", seat);

                    // remove this seat from the bought list
                    tokensHashMap.remove(token.getToken());

                    // remove from sold tickets
                    soldTickets.remove(seat.getRow() + "" + seat.getColumn());

                    return ResponseEntity.ok(gson.toJson(body));
                }
            }
        }
        return ResponseEntity.ok(gson.toJson(seat));
    } // end returnTicket

    @GetMapping("/stats")
    public ResponseEntity<String> stats(@RequestParam(required = false) String password){
        Gson gson = new Gson();
        int income = 0;
        int available = cinema.getColumns() * cinema.getRows();
        int purchased = 0;

        if (password == null || !password.equals("super_secret")) {
            throw new InvalidPasswordException("The password is wrong!");
        }
        else {
            for (Map.Entry<String, Seat> entry : tokensHashMap.entrySet()) {
                // calculate the stats
                income += entry.getValue().getPrice();
                purchased += 1;
                available -= 1;
            }

            HashMap<String, Integer> body = new HashMap<>();
            body.put("income", income);
            body.put("available", available);
            body.put("purchased", purchased);

            return ResponseEntity.ok(gson.toJson(body));
        }
    }


}

