package com.company;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i < 12; i++) {
            if (i == 0)
            {
                System.err.println("Размер доски может быть только натуральным числом!!!");
            } else {
                ChessBoard chessBoard = new ChessBoard(i);
                chessBoard.play();
            }
        }


    }
}
