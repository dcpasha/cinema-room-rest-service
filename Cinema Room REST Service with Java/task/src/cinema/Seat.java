package cinema;

public class Seat {
//    private String token;
    private int row;
    private int column;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        setPrice();
    }

    public Seat(){ // this constructor is called by @RequestBody binding
        setPrice();
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrice() {
        // row determines the ticket price
         if (this.row <= 4) {
             this.price = 10;
         } else {
             this.price = 8;
         }
    }
//
    public int getPrice() {
        return this.price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }


    public void setPrice(int price) {
        this.price = price;
    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
}
