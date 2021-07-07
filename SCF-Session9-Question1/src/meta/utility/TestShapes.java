package meta.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import meta.utility.Shapes.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestShapes{

	/**
	 * 
	 */
	@Test
	public void rectangle_PassTest(){
		Shapes rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list = Arrays.asList(4,2);
		if(rectangle instanceof Rectangle){
		    ((Rectangle)rectangle).setOrigin(new Point(1, 1));
		    ((Rectangle)rectangle).setLength(list.get(0));
		    ((Rectangle)rectangle).setBreadth(list.get(1));
		    ((Rectangle)rectangle).setOriginDistance();
		}
		assertEquals(8.0, rectangle.getArea(), 0.01);
		assertEquals(12, rectangle.getPerimeter(), 0.01);
		assertTrue(rectangle.isPointEnclosed(new Point(2, 1)));
		assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
	}

	@Test
	public void square_PassTest(){
		Shapes square = ShapeFactory.createShape(ShapeType.SQUARE);
		List<Integer> list = Arrays.asList(4);
		if(square instanceof Square){
			((Square)square).setOrigin(new Point(1, 1));
			((Square)square).setSide(list.get(0));
			((Square)square).setOriginDistance();
		}
		assertEquals(16.0, square.getArea(), 0.01);
		assertEquals(16.0, square.getPerimeter(), 0.01);
		assertTrue(square.isPointEnclosed(new Point(2, 1)));
		assertTrue(square.isPointEnclosed(new Point(5, 5)));
	}

	@Test
	public void triangle_PassTest(){
		Shapes triangle = ShapeFactory.createShape(ShapeType.TRIANGLE);
		List<Integer> list= Arrays.asList(4, 3, 2, 1);
		if(triangle instanceof Triangle){
			((Triangle)triangle).setOrigin(new Point(1,1));
			((Triangle)triangle).setSideA(list.get(0));
			((Triangle)triangle).setSideB(list.get(1));
			((Triangle)triangle).setSideC(list.get(2));
			((Triangle)triangle).setHeight(list.get(3));
			((Triangle)triangle).setOriginDistance();
		}
		assertEquals(2.904, triangle.getArea(), 0.001);
		assertEquals(9, triangle.getPerimeter(), 0.001);
		assertFalse(triangle.isPointEnclosed(new Point(2, 0)));
		assertFalse(triangle.isPointEnclosed(new Point(5, 0)));
	}

	@Test
	public void circle_PassTest(){
		Shapes circle = ShapeFactory.createShape(ShapeType.CIRCLE);
		List<Integer> list =  Arrays.asList(4);
		if(circle instanceof Circle){
			((Circle)circle).setPoint(new Point(1, 1));
			((Circle)circle).setRadius(list.get(0));
			((Circle)circle).setOriginDistance();
		}
		assertEquals(50.265, circle.getArea(), 0.001);
		assertEquals(25.133, circle.getPerimeter(), 0.001);
		assertTrue(circle.isPointEnclosed(new Point(2, 1)));
		assertFalse(circle.isPointEnclosed(new Point(10, 5)));
	}

	@Test
	public void addShape_PassTest(){

		Screen screen = new Screen(100, 100);
		Shapes shape = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list = Arrays.asList(4,2);
		if(shape instanceof Rectangle){
		    ((Rectangle)shape).setOrigin(new Point(1, 1));
		    ((Rectangle)shape).setLength(list.get(0));
		    ((Rectangle)shape).setBreadth(list.get(1));
		    ((Rectangle)shape).setOriginDistance();
		}
		screen.addShape(shape);
	}

	@Test(expected = AssertionError.class)
	public void addShape_Exception_WhenShapeObjectIsNull(){
		Screen screen = new Screen(100, 100);
		screen.addShape(null);
	}

	@Test(expected = AssertionError.class)
	public void addShape_Exception_WhenGivenPointIsOutsideTheScreen(){

		Screen screen = new Screen(100, 100);
		Shapes shape = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list = Arrays.asList(4,2);
		if(shape instanceof Rectangle){
		    ((Rectangle)shape).setOrigin(new Point(120, 1));
		    ((Rectangle)shape).setLength(list.get(0));
		    ((Rectangle)shape).setBreadth(list.get(1));
		    ((Rectangle)shape).setOriginDistance();
		}
		screen.addShape(shape);
	}

	@Test
	public void deleteShape_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list = Arrays.asList(4,2);
		if(shape instanceof Rectangle){
		    ((Rectangle)shape).setOrigin(new Point(1, 1));
		    ((Rectangle)shape).setLength(list.get(0));
		    ((Rectangle)shape).setBreadth(list.get(1));
		    ((Rectangle)shape).setOriginDistance();
		}
		screen.addShape(shape);
		screen.deleteShape(shape);
	}

	@Test(expected = AssertionError.class)
	public void deleteShape_Exception_WhenShapeIsNull(){
		Screen screen = new Screen(100, 100);
		screen.deleteShape(null);
	}

	@Test
	public void deleteShapeType_PassTest(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list1 = Arrays.asList(2,3);
		if(shape1 instanceof Rectangle){
		    ((Rectangle)shape1).setOrigin(new Point(1, 1));
		    ((Rectangle)shape1).setLength(list1.get(0));
		    ((Rectangle)shape1).setBreadth(list1.get(1));
		    ((Rectangle)shape1).setOriginDistance();
		}
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list2 = Arrays.asList(8,4);
		if(shape2 instanceof Rectangle){
		    ((Rectangle)shape2).setOrigin(new Point(1, 1));
		    ((Rectangle)shape2).setLength(list2.get(0));
		    ((Rectangle)shape2).setBreadth(list2.get(1));
		    ((Rectangle)shape2).setOriginDistance();
		}
		screen.addShape(shape2);

		screen.deleteShapeType(ShapeType.RECTANGLE);
	}

	@Test(expected = AssertionError.class)
	public void deleteShapeType_Exception_ShapeTypeIsNull(){
		Screen screen = new Screen(100, 100);
		screen.deleteShapeType(null);
	}
	
	@Test
	public void sortByArea_TestPass(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list1 = Arrays.asList(4,5);
		if(shape1 instanceof Rectangle){
		    ((Rectangle)shape1).setOrigin(new Point(1, 1));
		    ((Rectangle)shape1).setLength(list1.get(0));
		    ((Rectangle)shape1).setBreadth(list1.get(1));
		    ((Rectangle)shape1).setOriginDistance();
		}
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE);
		List<Integer> list2 = Arrays.asList(4);
		if(shape2 instanceof Square){
			((Square)shape2).setOrigin(new Point(1, 1));
			((Square)shape2).setSide(list2.get(0));
			((Square)shape2).setOriginDistance();
		}
		screen.addShape(shape2);

		List<Shapes> sortedShapeByArea = screen.sortByArea();
		assertEquals(sortedShapeByArea, Arrays.asList(shape2, shape1));
	}

	@Test(expected = AssertionError.class)
	public void sortByArea_Exception_NoShapeOnScreen(){
		Screen screen = new Screen(100, 100);
		screen.sortByArea();
	}

	@Test
	public void sortByPerimeter_TestPass(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list1 = Arrays.asList(4,5);
		if(shape1 instanceof Rectangle){
		    ((Rectangle)shape1).setOrigin(new Point(1, 1));
		    ((Rectangle)shape1).setLength(list1.get(0));
		    ((Rectangle)shape1).setBreadth(list1.get(1));
		    ((Rectangle)shape1).setOriginDistance();
		}
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE);
		List<Integer> list2 = Arrays.asList(4);
		if(shape2 instanceof Square){
			((Square)shape2).setOrigin(new Point(1, 1));
			((Square)shape2).setSide(list2.get(0));
			((Square)shape2).setOriginDistance();
		}
		screen.addShape(shape2);

		List<Shapes> sortedShapeByPerimeter = screen.sortByPerimeter();
		assertEquals(sortedShapeByPerimeter, Arrays.asList(shape2, shape1));
	}

	@Test(expected = AssertionError.class)
	public void sortByPerimeter_Exception_NoShape(){
		Screen screen = new Screen(100, 100);
		screen.sortByPerimeter();
	}

	@Test
	public void sortByOriginDistance_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		List<Integer> list1 = Arrays.asList(4,5);
		if(shape1 instanceof Rectangle){
		    ((Rectangle)shape1).setOrigin(new Point(12, 31));
		    ((Rectangle)shape1).setLength(list1.get(0));
		    ((Rectangle)shape1).setBreadth(list1.get(1));
		    ((Rectangle)shape1).setOriginDistance();
		}
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE);
		List<Integer> list2 = Arrays.asList(4);
		if(shape2 instanceof Square){
			((Square)shape2).setOrigin(new Point(15, 4));
			((Square)shape2).setSide(list2.get(0));
			((Square)shape2).setOriginDistance();
		}
		screen.addShape(shape2);

		Shapes shape3 = ShapeFactory.createShape(ShapeType.CIRCLE);
		List<Integer> list =  Arrays.asList(4);
		if(shape3 instanceof Circle){
			((Circle)shape3).setPoint(new Point(5, 5));
			((Circle)shape3).setRadius(list.get(0));
			((Circle)shape3).setOriginDistance();
		}
		screen.addShape(shape3);

		List<Shapes> sortedShapeByOriginDistance = screen.sortByOriginDistance();

		assertEquals(sortedShapeByOriginDistance, Arrays.asList(shape3, shape2, shape1));
	}

	@Test(expected = AssertionError.class)
	public void sortByOriginDistance_Exception_NoShape(){
		Screen screen = new Screen(100, 100);
		screen.sortByOriginDistance();
	}
}
