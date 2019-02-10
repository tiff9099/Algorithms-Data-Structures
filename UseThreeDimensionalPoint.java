/* 
 * Tiffany & Elsa- Lab 2 (Unit Test)
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class UseThreeDimensionalPoint {

	@Test
	public void testGet() {

		ThreeDimensionalPoint point1 = new ThreeDimensionalPoint(); //creates point1 with type threedimensionalpoint

		assertEquals(0, point1.getX(),0.2); 
		assertEquals(0, point1.getY(),0.2);
		assertEquals(0, point1.getZ(),0.2);
	}
	
	@Test
	public void testShift() {
		ThreeDimensionalPoint point2 = new ThreeDimensionalPoint(); //creates point2 with type threedimensionalpoint
		assertEquals(7, point2.shiftX(7),0.3);
		assertEquals(7, point2.shiftY(7),0.3);
		assertEquals(7, point2.shiftZ(7),0.3);

	}
	
	@Test
	public void testRotateX() {
		ThreeDimensionalPoint point3 = new ThreeDimensionalPoint(1,1,1); //creates points with type threedimensionalpoint
		ThreeDimensionalPoint point4 = new ThreeDimensionalPoint(1,1,1);
		point3.rotateX(Math.PI);
		point4.rotateX(-Math.PI);

		assertEquals(point3.getX(), point4.getX(), .001);
		assertEquals(point3.getY(), point4.getY(), .001);
		assertEquals(point3.getZ(), point4.getZ(), .001);
	}
	
	@Test
	public void testRotateY() {
		ThreeDimensionalPoint point3 = new ThreeDimensionalPoint(1,1,1); //creates points with type threedimensionalpoint
		ThreeDimensionalPoint point4 = new ThreeDimensionalPoint(1,1,1);
		point3.rotateY(Math.PI);
		point4.rotateY(-Math.PI);

		assertEquals(point3.getX(), point4.getX(), .001);
		assertEquals(point3.getY(), point4.getY(), .001);
		assertEquals(point3.getZ(), point4.getZ(), .001);
	}
	
	@Test
	public void testRotateZ() {
		ThreeDimensionalPoint point3 = new ThreeDimensionalPoint(1,1,1); //creates points with type threedimensionalpoint
		ThreeDimensionalPoint point4 = new ThreeDimensionalPoint(1,1,1);
		point3.rotateZ(Math.PI);
		point4.rotateZ(-Math.PI);

		assertEquals(point3.getX(), point4.getX(), .001);
		assertEquals(point3.getY(), point4.getY(), .001);
		assertEquals(point3.getZ(), point4.getZ(), .001);
	}
	
}
