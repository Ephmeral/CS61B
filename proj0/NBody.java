public class NBody {
	// 读取半径
	public static double readRadius(String str) {
		In in = new In(str);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	// 读取星球，以数组形式输出
	public static Planet[] readPlanets(String str) {
		In in = new In(str);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[num];
		for (int i = 0; i < num; i++) {
			planets[i] = new Planet(in.readDouble(), in.readDouble(), 
				in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String imageToDraw = "images/starfield.jpg";
		Planet[] planet = readPlanets(filename);
		StdDraw.setScale(-800, 800);


		for (int i = 0; i <planet.length; i++) {
			planet[i].draw();
		}
		/* Shows the drawing to the screen, and waits 2000 milliseconds. */

		
		StdDraw.enableDoubleBuffering();
		int time = 0;
		for (; time < T; time += dt) {
			double[] xForces = new double[planet.length];
			double[] yForces = new double[planet.length];
			
			for (int i = 0; i < planet.length; i++) {
				xForces[i] = planet[i].calcNetForceExertedByX(planet);
				yForces[i] = planet[i].calcNetForceExertedByY(planet);
			}

			for (int i = 0; i < planet.length; i++) {
				planet[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);

			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}