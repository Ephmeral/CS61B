public class Planet {
	public double xxPos; 		// x 坐标位置
	public double yyPos;		// y 坐标位置
	public double xxVel; 		// x 轴方向的速度
	public double yyVel; 		// y 轴方向的速度
	public double mass; 		// 星球的重量
	public String imgFileName; 	// 图片名称

	// 构造函数
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	// 拷贝构造函数
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	// 计算两星球之间的距离
	public double calcDistance(Planet p) {
		return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + 
				(yyPos - p.yyPos) * (yyPos - p.yyPos));
	}

	// 计算给定星球对当前星球作用力的大小
	public double calcForceExertedBy(Planet p) {
		double G = 6.67e-11;
		double r = calcDistance(p);
		double F = G * p.mass * mass / (r * r);
		return F;
	}

	// 计算 x 方向上的力大小
	public double calcForceExertedByX(Planet p) {
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double dx = p.xxPos - xxPos;
		double Fx = F * dx / r;
		return Fx;
	}

	// 计算 y 方向上的力大小
	public double calcForceExertedByY(Planet p) {
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double dy = p.yyPos - yyPos;
		double Fy = F * dy / r;
		return Fy;
	}

	public boolean equals(Planet p) {
		if (this == p) return true;
		return false;
	}

	// 计算 x 方向上的合力
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netF = 0.0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (equals(allPlanets[i])) continue;
			netF += calcForceExertedByX(allPlanets[i]);
		}
		return netF;
	}

	// 计算 y 方向上的合力
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netF = 0.0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (equals(allPlanets[i])) continue;
			netF += calcForceExertedByY(allPlanets[i]);
		}
		return netF;
	}

	// 受到力的作用后，更新位置和速度
	public void update(double dt, double fX, double fY) {
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel = xxVel + dt * ax;
		yyVel = yyVel + dt * ay;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
	}
}