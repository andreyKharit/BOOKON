package com.pvt.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jiona
 * Date: 22.02.14
 * Time: 6:06
 * To change this template use File | Settings | File Templates.
 */
public class PathFinder {

    private final Labyrinth labyrinth;
    private final Point startPoint;

    //a new matrix to check path
    private int[][] labyrinthMap;
    //available directions
    private int[] dirI =
            {0, 1, 0, -1};
    private int[] dirJ =
            {1, 0, -1, 0};

    public PathFinder(Labyrinth labyrinth, Point startPoint) {
        this.labyrinth = labyrinth;
        this.startPoint = startPoint;
        this.labyrinthMap = new int[this.labyrinth.getWidth()][this.labyrinth.getHeight()];
        for (int[] ints : labyrinthMap) {
            Arrays.fill(ints, 0);
        }
    }

    /**
     * Finds path from start point to end point or return null if there is no path
     *
     * @param endPoint the end point
     * @return the path or null if path doesn't exists
     */
    public List<Point> findPath(Point endPoint) {
        //return null if there is no valid path
        if (!isPathExists(endPoint)) {
            return null;
        }
        List<Point> path = new LinkedList<>();

        //draw the map
        for (int[] ints : labyrinthMap) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int pointI = endPoint.getI();
        int pointJ = endPoint.getJ();

        //found end point number
        int count = labyrinthMap[pointI][pointJ];
        path.add(new Point(pointI, pointJ));

        for (int i = count; i > 0; i--) {
            Deque<Point> checkPointsForCount = new LinkedList<>();
            boolean found = false;
            //adding directions to queue
            for (int d = 0; d < 4; d++) {
                checkPointsForCount.add(new Point(
                                (pointI + dirI[d]),
                                (pointJ + dirJ[d])
                        )
                );
            }
            //checking all directions
            //stop loop after getting first hit
            while (!found || !checkPointsForCount.isEmpty()) {
                Point currentPoint = checkPointsForCount.poll();
                if (currentPoint != null) {
                    int currentI = currentPoint.getI();
                    int currentJ = currentPoint.getJ();
                    if (currentI < labyrinth.getWidth() && currentI >= 0 &&
                            currentJ < labyrinth.getHeight() && currentJ >= 0)
                        if (labyrinthMap[currentPoint.getI()][currentPoint.getJ()] == i - 1) {
                            path.add(currentPoint);
                            pointI = currentI;
                            pointJ = currentJ;
                            found = true;
                        }
                }
            }
        }
        //reversing path for successful test
        Collections.reverse(path);
        return path;
    }

    /**
     * Checks whether path from start point to end point exists
     *
     * @param endPoint the end point
     * @return flag is path exists or not
     */
    public boolean isPathExists(Point endPoint) {
        //checked points list to avoid infinite loop
        List<Point> checkedPoints = new LinkedList<>();

        Queue<Integer> number = new LinkedList<>();
        Queue<Point> pointCheckQueue = new LinkedList<>();
        pointCheckQueue.add(startPoint);
        number.add(0);

        while (!pointCheckQueue.isEmpty() && !number.isEmpty()) {
            Point currentPoint = pointCheckQueue.poll();
            Integer currentNumber = number.poll();
            int pointI = currentPoint.getI();
            int pointJ = currentPoint.getJ();
            //if not outside of labyrinth
            if (!checkedPoints.contains(currentPoint)) {
                if (pointI < labyrinth.getWidth() && pointI >= 0 &&
                        pointJ < labyrinth.getHeight() && pointJ >= 0) {
                    //if current point is free
                    if (labyrinth.isRoom(pointI, pointJ)) {
                        if (currentNumber != null)
                            labyrinthMap[pointI][pointJ] = currentNumber;
                        //if current point is the end
                        if (currentPoint.equals(endPoint)) {
                            return true;
                        } else
                            //add new directions to the check queue
                            for (int d = 0; d < 4; d++) {
                                if (currentNumber != null)
                                    number.add(currentNumber + 1);
                                pointCheckQueue.add(new Point(
                                        (pointI + dirI[d]),
                                        (pointJ + dirJ[d])));
                            }
                    }
                }
                checkedPoints.add(currentPoint);
            }
        }
        return false;
    }
}
