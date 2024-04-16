package cinema;

import java.util.ArrayList;

public class Cinema {
    int rows;
    int columns;
    ArrayList<Seat> seats = new ArrayList<>();

    public Cinema() {}

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        addSeats(); // add seats based on rows and columns
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void addSeats() {
        for (int i=1; i <= getRows(); i++ ) {
            for (int j=1; j <= getColumns(); j++) {
                seats.add(new Seat(i, j));
            }
        }
    } // end addSeats
}
