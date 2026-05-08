package me.jmp.math;

import java.util.ArrayList;

public class Vector2 {
    public float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /***
     * Creates a "path" of points between origin and target
     * @param origin origin point
     * @param target target point
     * @return points between origin and target with a spacing of 1 unit between each
     */
    public static ArrayList<Vector2> createPathing(Vector2 origin, Vector2 target) {
        // TODO: Implement this based on the Desmos in the gsheet
        return new ArrayList<Vector2>();
    }

    /***
     * Creates a "path" of points between each point given
     * @param points array of every point to be pathed between
     * @return points between each point in the "points" array with a spacing of 1 unit between each
     */
    public static ArrayList<Vector2> createPathing(ArrayList<Vector2> points) {
        // TODO: Implement this based on the Desmos in the gsheet
        return new ArrayList<Vector2>();
    }
}
