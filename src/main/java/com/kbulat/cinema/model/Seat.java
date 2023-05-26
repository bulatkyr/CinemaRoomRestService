package com.kbulat.cinema.model;

public class Seat {

    private final int row;
    private final int column;

    private final int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = calculatePrice(row);
    }

    private static int calculatePrice(int row) {
        if (row <= 4) {
            return 10;
        } else {
            return 8;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }
}
