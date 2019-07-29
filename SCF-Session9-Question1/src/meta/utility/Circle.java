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
	 * 
	 */
	public Circle(){
	}

	public double getArea(){
		return Math.PI * radius * radius;
	}

	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}

	public Point getOrigin(){
		double distance = Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());

		return new Point((distance - radius) * point.getX() / ((distance - radius) + radius), 
				(distance - radius) * point.getY() / ((distance - radius) + radius));
	}

	public boolean isPointEnclosed(Point points){
		double distance = Math.sqrt(Math.abs(points.getX() - point.getX()) * Math.abs(points.getX() - point.getX())) 
				+ Math.sqrt(Math.abs(points.getY() - point.getY()) * Math.abs(points.getY() - point.getY()));
		return distance < radius;
	}

	public ShapeType getShapeType(){
		return ShapeType.CIRCLE;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getOriginDistance() {
		return originDistance;
	}

	public void setOriginDistance() {
		this.originDistance = calculateOriginDistance();
	}

	private double calculateOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getX(), 2) + Math.pow(getOrigin().getY(), 2));
	}
}
