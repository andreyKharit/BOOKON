package com.pvt.test;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jiona
 * Date: 22.02.14
 * Time: 6:09
 * To change this template use File | Settings | File Templates.
 */
public class PathFinderTest {

    /**
     * 11110
     * 01010
     * 11111
     * 10001
     */
    private final Labyrinth labyrinth1 = new Labyrinth(new int[][]{
            {1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
    });

    @Test
    public void testPathExists() {
        final Point leftTopPoint = new Point(0, 0);
        final PathFinder pathFinder = new PathFinder(labyrinth1, leftTopPoint);

        final Point rightBottomPoint = new Point(4, 4);
        final Point rightTopPoint = new Point(0, 4);

        Assert.assertTrue(pathFinder.isPathExists(rightBottomPoint));
        Assert.assertFalse(pathFinder.isPathExists(rightTopPoint));

        final List<Point> path = pathFinder.findPath(rightBottomPoint);
        Assert.assertEquals(9, path.size());
        Assert.assertEquals(leftTopPoint, path.get(0));
        Assert.assertEquals(rightBottomPoint, path.get(8));

    }


}


