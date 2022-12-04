package com.company;

import java.util.ArrayList;

public class ChessBoard {

    private final Maharajas maharajas;
    private final int N;
    private final String[][] cells;
    private int X;
    private int Y;
    private ArrayList<Maharajas> currentDiagonal = new ArrayList<>();
    private int tempCountMaharajas = 0;
    private int countMaharajas = 0;

    public ChessBoard(int n) {
        N = n;
        cells = new String[N][N];
        maharajas = new Maharajas(0, 0);
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                cells[x][y] = " . ";
            }
        }
    }

    private void firstDiagonal()
    {
        cells[0][0] = maharajas.model;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (Y < N) {
                    cells[X][Y] = maharajas.model;
                    currentDiagonal.add(new Maharajas(X, Y));
                    tempCountMaharajas++;
                    Y += 3;
                    X += 1;
                    countMaharajas++;
                }
            }
        }
        System.out.println();
        for (Maharajas m: currentDiagonal) {
            System.out.println("Магараджи: "+m.getX()+" "+m.getY());
        }
    }

    private void downDiagonals()
    {
        int tempCount;
        if (tempCountMaharajas < 4){
            tempCount = 4;
        }else tempCount = tempCountMaharajas;
        tempCountMaharajas = 0;
        ArrayList<Maharajas> temp = new ArrayList<>();
        for (Maharajas m: currentDiagonal) {
            if(m.getX() < N-tempCount-1 && m.getY() < N-1) {
                cells[m.getX()+tempCount+1][m.getY()+1] = maharajas.model;
                temp.add(new Maharajas(m.getX()+tempCount,m.getY()+1));
                tempCountMaharajas++;
                countMaharajas++;
            }
        }
        for (Maharajas m: temp) {
            System.out.println("Магараджи: "+m.getX()+" "+m.getY());
        }
        currentDiagonal.removeAll(currentDiagonal);
        currentDiagonal = temp;
        tempCountMaharajas++;
    }

    public void play(){
        System.out.println("Размерность"+" "+N+"x"+N);
        firstDiagonal();
        downDiagonals();
        downDiagonals();
        System.out.println("Общее количество фигур магараджи: "+ countMaharajas);
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (cells[x][y].equals("M")){
                    System.out.println(x+" "+y);
                }
            }
        }
        for (int x = 0; x < N; x++) {
            System.out.println();
            for (int y = 0; y < N; y++) {
                System.out.print(cells[x][y]);
            }
        }
        System.out.println("\n____________________________________________________________________________________________________________________________________________________________");
    }
}