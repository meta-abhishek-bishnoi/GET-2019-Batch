
/**
 * @author Abhishek Bishnoi
 * Class to represent the Rectangle by implementing the Shape interface.
 */
package meta.utility;

import java.util.Date;

public class Rectangle implements Shapes{
	private Date timeStamp;
	private Point origin;
	private double length, breadth, originDistance;

	/**
	 * 
	 */
	public Rectangle(){
	}

	/**
	 * @return : The point at which the rectangle is drawn.
	 */
	public Point getPoint(){
		return origin;
	}

	public double getArea(){
		return length * breadth;
	}

	public double getPerimeter(){
		return 2 * (length + breadth);
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return point.getX() >= origin.getX() && point.getX() <= length + origin.getX() 
				&& point.getY() >= origin.getY() && point.getY() <= breadth+origin.getY();
	}

	public ShapeType getShapeType(){
		return ShapeType.RECTANGLE;
	}

	public double getOriginDistance(){
		return originDistance;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
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
