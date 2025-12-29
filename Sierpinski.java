/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		// Almost perfect equilateral triangle, but practically without tilting,
		// there must be a coordinate with irrational, and it can be stored in a double,
		// which means that it will not be stored accurately, and therefore there won't be
		// formed a perfect equilateral triangle also.
		StdDraw.setCanvasSize(850, 850);
		StdDraw.setScale(0, 902);
		StdDraw.setVisible(false);
		sierpinski(n, 0, 902, 451, 0, 0, 780);
		StdDraw.setVisible(true);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			return;
		}

		// Draw the triangle
		double[] x = {x1, x2, x3};
		double[] y = {y1, y2, y3};
		StdDraw.polygon(x, y);

		// Between vertex 1 and 2
		double x12 = (x1 + x2) / 2;
		double y12 = (y1 + y2) / 2;
		// Between vertex 2 and 3
		double x23 = (x2 + x3) / 2;
		double y23 = (y2 + y3) / 2;
		// Between vertex 3 and 1
		double x31 = (x3 + x1) / 2;
		double y31 = (y3 + y1) / 2;

		sierpinski(n - 1, x1, x12, x31, y1, y12, y31);
		sierpinski(n - 1, x12, x2, x23, y12, y2, y23);
		sierpinski(n - 1, x31, x23, x3, y31, y23, y3);
	}
}
