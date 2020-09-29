import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Circle {

	double rotation;

	public Bullet(Point center, double rotation) {
		super(center.clone(), 10);
		this.rotation = rotation;
	}

	@Override
	public void paint(Graphics brush, Color color) {
		brush.setColor(color);
		brush.fillOval((int) center.x, (int) center.y, radius, radius);
	}

	@Override
	public void move() {
		center.x += 2 * Math.cos(Math.toRadians(rotation));
		center.y += 2 * Math.sin(Math.toRadians(rotation));
	}

	public boolean outOfbounds() {
		boolean outOfbounds = false;
		if(center.x > Asteroids.SCREEN_WIDTH) {
			outOfbounds = true;
		}
		if(center.y > Asteroids.SCREEN_HEIGHT) {
			outOfbounds = true;
		}
		if(center.x < 0) {
			outOfbounds = true;
		}
		if(center.y < 0) {
			outOfbounds = true;
		}
		return outOfbounds;
	}
	
	public Point getCenter() {
		return center;
	}

}
