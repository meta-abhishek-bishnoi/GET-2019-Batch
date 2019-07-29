/**
 * @author Abhishek Bishnoi
 * Class to implement the abstract factory to create the reference to the object of shape type like
 * Rectangle, Square, Circle, Regular Polygon and Triangle.
 */
package meta.utility;

import java.util.List;

import meta.utility.Shapes.ShapeType;

public class ShapeFactory{

	/**
	 * Method to create the reference to the object of shape type on the basis of requirement.
	 * @param shapeType : The type of the shape whose object has to be created.
	 * @return : The reference to the object of the shape type.
	 */
	public static Shapes createShape(ShapeType shapeType) {
		Shapes shape ;
		switch (shapeType) {
		case CIRCLE:
			shape = new Circle();
			break;
		case RECTANGLE:
			shape = new Rectangle();
			break;
		case REGULAR_POLYGON:
			shape = new RegularPolygon();
			//new RegularPolygon(point, list.get(0), list.get(1));
			break;
		case SQUARE:
			shape = new Square();
			//new Square(point, list.get(0));
			break;
		case TRIANGLE:
			shape = new Triangle();
			//new Triangle(point, list.get(0), list.get(1), list.get(2), list.get(3));
			break;
		default:
			throw new AssertionError("Invalid Shape Type !!");

		}
		return shape;
	}
}
