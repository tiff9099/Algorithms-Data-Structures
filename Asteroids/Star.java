import java.awt.*;

public class Star extends Circle {
	public Star(Point center, int radius) {
		super(center, radius);
	}
	public void paint(Graphics brush, Color color) {
		brush.setColor(color);
		brush.fillOval((int) center.x, (int) center.y, radius, radius);
	}
	//Because you do not want the stars to move across the screen, simply leave the move() method empty.
	public void move() {

	}
}