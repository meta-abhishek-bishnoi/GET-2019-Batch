/*
 * This is Service class for calculating area for different shapes 
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 14-July-2019
 */
package meta.helper;

import java.text.DecimalFormat;

public class SpecificationQn3_ShapeImplementation implements SpecificationQn3_ShapeInterface {

	private DecimalFormat decimalFormat = new DecimalFormat("##.##");
	/*
	 * (non-Javadoc)
	 * @see meta.helper.SpecificationQn3_ShapeInterface#getArea(double, double, java.lang.String)
	 * @param double value of first dimention  
	 * @param double value of second dimention
	 * @param String contains name of that string
	 * Assumption dimention must be positive 
	 * Assumption is shape name or index doesn't match it will return area in -ve as wrong answer
	 * Assumption shape names are in lower case
	 */
	@Override
	public double getArea(double dimentionOne, double dimentionTwo, String shapeName) throws ArithmeticException {
		int shapeIndex = getShapeIndex(shapeName.toLowerCase());
		// getting index for a shape
		/*
		 * operations on the behalf of their indexes
		 */
		if(shapeIndex==0){
			return getTriangleArea(dimentionOne,dimentionTwo);
			//return getTriangleArea()
		}else if(shapeIndex==1){
			return getRectangleArea(dimentionOne,dimentionTwo);
			//return getRectangleArea()
		}else if(shapeIndex==2){
			return getSquareArea(dimentionOne);
			// return getSquareArea()
		}else if(shapeIndex==3){
			return getCircleArea(dimentionOne);
			// return getCircleArea()
		}
		return Double.MIN_VALUE;
		// when index doesn't matches return Double.MIN_VALUE as wrong answer
	}

	/*
	 * @param double value as a radius of circle
	 * @return double as a result value(##.##)-format
	 * Assumption radius is always >= 0  
	 */
	private double getCircleArea(double radius) {
		double circleArea = Math.PI*radius*radius;
		circleArea = Double.parseDouble( decimalFormat.format(circleArea) );
		return circleArea;
	}

	/*
	 * @param double value as a side of square 
	 * @return double as a result value(##.##)-format
	 * Assumption side is always >= 0  
	 */
	private double getSquareArea( double side ) {
		double squareArea = side*side;
		squareArea = Double.parseDouble( decimalFormat.format(squareArea) );
		return squareArea;
	}

	/*
	 * @param double value as a height of rectangle
	 * @param double value as a width of rectangle
	 * @return double as a result value(##.##)-format
	 * Assumption height & width is always >= 0  
	 */
	private double getRectangleArea(double height, double width) {
		double rectangleArea = height*width;
		rectangleArea = Double.parseDouble( decimalFormat.format(rectangleArea) );
		return rectangleArea;
	}

	/*
	 * @param double value as a height of rectangle
	 * @param double value as a base of rectangle
	 * @return double as a result value(##.##)-format
	 * Assumption height & base is always >= 0  
	 */
	private double getTriangleArea(double height, double base) {
		double triangleArea = (height*base)/((double)2);
		triangleArea = Double.parseDouble( decimalFormat.format(triangleArea) );
		return triangleArea;
	}

	/*
	 * @param String as a shape name
	 * @return int index of that shape
	 * Assumption @param is in lower case
	 */
	private int getShapeIndex(String shapeName) {
		String shapes[] = SpecificationQn3_Message.SHAPES;
		int length = shapes.length;
		for( int i=0; i<length; i++ ){
			if(shapeName.equals(shapes[i])){
				return i;
			}
		}
		return -1;
		// didn't match any shape in array
	}

}
