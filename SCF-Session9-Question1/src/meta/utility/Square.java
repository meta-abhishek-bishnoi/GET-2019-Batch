/**
 * @author Abhishek Bishnoi
 * Class to represent the Square by implementing the Shape interface.
 */
package meta.utility;

import java.util.Date;
public class Square implements Shapes{
	private Date timeStamp;
	private Point origin;
	private double side, originDistance;

	/**
	 * Parameterized Constructor
	 * @param origin : The point at which the square is to be drawn.
	 * @param side : The length of the side of the square.
	 */
	public Square() {
	}

	public double getArea(){
		return side * side;
	}

	public double getPerimeter(){
		return 4 * side;
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return point.getX() >= origin.getX() && point.getX() <= side + origin.getX() && 
				point.getY() >= origin.getY() && point.getY() <= side + origin.getY();
	}

	public ShapeType getShapeType(){
		return ShapeType.SQUARE;
	}

	public double getOriginDistance(){
		return originDistance;
	}

	public Date getTimeStamp(){
		return timeStamp;
	}

	public void setTimeStamp(Date timestamp){
		this.timeStamp = timestamp;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
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
