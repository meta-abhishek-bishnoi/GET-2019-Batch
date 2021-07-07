/**
 * @author Abhishek Bishnoi
 * Class to represent the Circle by implementing the Shape interface.
 *
 */
package meta.utility;

import java.util.Date;
public class Circle implements Shapes{
	private Point point;
	private double radius;
	private Date timeStamp;
	private double originDistance;

	/**
	 * Constructor
	 */
	public Circle(){
	}

	/**
	 * @return are of circle
	 */
	public double getArea(){
		return Math.PI * radius * radius;
	}

	/**
	 * @return perimeter of circle
	 */
	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}

	/**
	 * 
	 */
	public Point getOrigin(){
		double distance = Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());

		return new Point((distance - radius) * point.getX() / ((distance - radius) + radius), 
				(distance - radius) * point.getY() / ((distance - radius) + radius));
	}

	/**
	 * @return boolean value if point is enclosed in shape 
	 * if distance of point is less then the radius then it returns true otherwise it returns false 
	 */
	public boolean isPointEnclosed(Point points){
		// if difference of distance is less then radius means it is inside the circle
		double distance = Math.sqrt(Math.abs(points.getX() - point.getX()) * Math.abs(points.getX() - point.getX())) 
				+ Math.sqrt(Math.abs(points.getY() - point.getY()) * Math.abs(points.getY() - point.getY()));
		return distance < radius;
	}

	/**
	 * returns shape Type
	 */
	public ShapeType getShapeType(){
		return ShapeType.CIRCLE;
	}

	/**
	 * 
	 * @return return Point Object
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * 
	 * @param point Point Object
	 * set value of Point
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * 
	 * @return radius of object
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius set radius of object
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @return timeStap
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp set timestap of object creation
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return distance from origin
	 */
	public double getOriginDistance() {
		return originDistance;
	}

	/**
	 * set origin distance from center 
	 */
	public void setOriginDistance() {
		this.originDistance = calculateOriginDistance();
	}

	/**
	 * 
	 * @return this will calculate Origin Distance and return it
	 */
	private double calculateOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getX(), 2) + Math.pow(getOrigin().getY(), 2));
	}
}
