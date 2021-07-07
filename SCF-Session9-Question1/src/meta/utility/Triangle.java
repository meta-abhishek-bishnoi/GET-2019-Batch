/**
 * @author Abhishek Bishnoi
 * Class to represent the Triangle by implementing the Shape interface.
 */
package meta.utility;

import java.util.Date;
public class Triangle implements Shapes{
	private Point origin;
	private double sideA, sideB, sideC, originDistance, height;
	private Date timeStamp;

	/**
	 * Constructor
	 */
	public Triangle() {
		
	}

	public double getArea(){
		double semiPerimeter = getPerimeter() / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
	}

	/**
	 * @return perimeter
	 */
	public double getPerimeter(){
		return (sideA + sideB + sideC);
	}

	public Point getOrigin(){
		return origin;
	}

	/**
	 * source https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
	 * @return boolean value
	 */
	public boolean isPointEnclosed(Point point){
		boolean enclosed = false;
		double base = Math.sqrt(Math.pow(sideC, 2) - Math.pow(height, 2));
		Point b = new Point(origin.getX() + sideA, origin.getY());
		Point c = new Point(origin.getX() + base, origin.getY() + height);

		if (Math.abs(getArea() - ((getAreaByVertices(point, origin, b)) + getAreaByVertices(point, b, c) 
				+ getAreaByVertices(point, origin, c))) <= 0.001)
			enclosed = true;

		return enclosed;
	}

	/**
	 * source https://mathinstructor.net/2012/08/how-to-find-area-of-triangle-given-three-vertices/ 
	 * @return area of triangle by vertices
	 */
	private double getAreaByVertices(Point a, Point b, Point c) {
		return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * 
				(c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
	}

	public ShapeType getShapeType(){
		return ShapeType.TRIANGLE;
	}

	public double getOriginDistance(){
		return originDistance;
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public void setOriginDistance() {
		this.originDistance = calculateOriginDistance();
	}

	private double calculateOriginDistance() {
		return Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}
}
