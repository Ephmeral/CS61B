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
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-800, 800);


		for (int i = 0; i <planets.length; i++) {
			planets[i].draw();
		}
		/* Shows the drawing to the screen, and waits 2000 milliseconds. */

		
		StdDraw.enableDoubleBuffering();
		int time = 0;
		for (; time < T; time += dt) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);

			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", readRadius(filename));
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}