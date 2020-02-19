package com.pvt.test;

/**
 * Created with IntelliJ IDEA.
 * User: Jiona
 * Date: 22.02.14
 * Time: 5:58
 * To change this template use File | Settings | File Templates.
 */
public class Labyrinth {

    private final int[][] matrix;

    private final int height;
    private final int width;

    public Labyrinth(int[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
    }

    public boolean isRoom(int i, int j){
        if (i<0 || i>=height || j<0 || j>width){
            throw new IllegalArgumentException("field (" + i +"," + j + ") is out of matrix size");
        }
        return matrix[i][j]!=0;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
