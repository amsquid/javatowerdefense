package me.jmp.math;

import java.util.ArrayList;

public class Vector2 {
	public int x, y;

	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/***
	 * Creates a "path" of points between origin and target
	 * @param origin origin point
	 * @param target target point
	 * @param scale distance between points
	 * @return points between origin and target with a spacing of 1 unit between each
	 */
	public static ArrayList<Vector2> createPathing(Vector2 origin, Vector2 target, int scale) {
		int distance = (int) Math.floor(Math.sqrt(Math.pow(origin.x - target.x, 2) + Math.pow(origin.y - target.y, 2)));
		ArrayList<Vector2> points = new ArrayList<>();
		
		for(int i = 0; i <= (distance / scale); i++) {
			points.add(
				new Vector2(
					(int)Math.floor(scale * (i + 1) * (target.x - origin.x) / distance + 1) + origin.x,
					(int)Math.floor(scale * (i + 1) * (target.y - origin.y) / distance + 1) + origin.y
				)
			);
		}

		return points;
	}

	/***
	 * Creates a "path" of points between each point given
	 * @param points array of every point to be pathed between
	 * @param scale distance between points
	 * @return points between each point in the "points" array with a spacing of 1 unit between each
	 */
	public static ArrayList<Vector2> createPathing(ArrayList<Vector2> points, int scale) {
		ArrayList<Vector2> path = new ArrayList<>();
		for(int i = 0; i < points.size() - 1; i++) {
			path.addAll(createPathing(points.get(i), points.get(i + 1), scale));
		}
		return path;
	}

	public static Vector2 getMidwayPoint(Vector2 origin, Vector2 target, float distancePercent) {
		return new Vector2(
			(int) Math.floor(distancePercent * (target.x - origin.x) + origin.x),
			(int) Math.floor(distancePercent * (target.y - origin.y) + origin.y)
		);
	}
}
