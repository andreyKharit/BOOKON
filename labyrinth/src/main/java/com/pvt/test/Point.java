package com.pvt.test;

/**
 * Created with IntelliJ IDEA.
 * User: Jiona
 * Date: 22.02.14
 * Time: 6:06
 * To change this template use File | Settings | File Templates.
 */
public class Point {

    private int i;
    private int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Point() {
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (i != point.i) return false;
        if (j != point.j) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }
}
