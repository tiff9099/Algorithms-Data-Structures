/* 
 * Lab 2: Java Fundamentals (01-24-19) -Tiffany & Elsa 100
 * This class represents a 3 dimensional point that has a specified 
 * x, y, and z coordinate that are stored as double values.
 */
public class ThreeDimensionalPoint {
	private double x;
	private double y;
	private double z;

	public ThreeDimensionalPoint () {
		x = 0;
		y = 0;
		z = 0;
	}
	public ThreeDimensionalPoint (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX () {
		return x;
	}
	public double getY () {
		return y;
	}
	public double getZ () {
		return z;
	}
	public double shiftX(double amount) {
		return x + amount;
	}
	public double shiftY (double amount) {
		return y + amount;
	}
	public double shiftZ (double amount) {
		return z + amount;
	}
	
	/*allow the rotation of x, y, and z points 
	by a specified angle around a specified axis*/
	public void rotateX (double theta) {
		double newX = x;
		y = y*(Math.cos(theta))-z*(Math.sin(theta));
		double newY = y;
		z = y*(Math.sin(theta))+z*(Math.cos(theta));
		double newZ = z;
	}
	public void rotateY (double theta) {
		x = x*(Math.cos(theta))+z*(Math.sin(theta));
		double newx = x;
		double newY = y;
		z = -x*(Math.sin(theta))+z*(Math.cos(theta));
		double newZ = z;
	}
	public void rotateZ (double theta) {
		x = x*(Math.cos(theta))-y*(Math.sin(theta));
		double newx = x;
		y = x*(Math.sin(theta))+z*(Math.cos(theta));
		double newY = y;
		double newZ = z;
	}
}

