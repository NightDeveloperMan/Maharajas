package com.company;

public class Maharajas {

    public final String model = " M "; // фигурка модели
    private final int x; //положение
    private final int y; //положение


    public Maharajas(int x, int y) { // констурктор
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    } // геттер

    public int getY() {
        return y;
    } // геттер

}
