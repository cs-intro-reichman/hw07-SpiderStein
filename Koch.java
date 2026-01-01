/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		// Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		/*
		 * // Tests the snowflake function:
		 * // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		 * snowFlake(Integer.parseInt(args[0]));
		 */

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		// Point 1 (1/3 of the way)
		double x3 = x1 + (x2 - x1) / 3;
		double y3 = y1 + (y2 - y1) / 3;

		// Point 2 (2/3 of the way)
		double x4 = x1 + (x2 - x1) * 2 / 3;
		double y4 = y1 + (y2 - y1) * 2 / 3;

		// Point 3 (the peak of the triangle)
		double x5 = (Math.sqrt(3) / 6) * (y1 - y2) + 0.5 * (x1 + x2);
		double y5 = (Math.sqrt(3) / 6) * (x2 - x1) + 0.5 * (y1 + y2);

		// Recursive calls for the 4 segments
		curve(n - 1, x1, y1, x3, y3);
		curve(n - 1, x3, y3, x5, y5);
		curve(n - 1, x5, y5, x4, y4);
		curve(n - 1, x4, y4, x2, y2);
	}

	/** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(-0.5, 1.5);
		StdDraw.setXscale(-0.5, 1.5);
		// Draws a Koch snowflake of depth n

		double x1 = 0, y1 = 0, x2 = 1, y2 = 0;
		double x3 = 0.5;
		double y3 = Math.sqrt(3) / 2;

		curve(n, x2, y2, x1, y1);
		curve(n, x1, y1, x3, y3);
		curve(n, x3, y3, x2, y2);
	}
}
