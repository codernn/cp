public class ShapeCreator {

	public static void main(String[] args)throws Exception {
      
      // Circle Code
	  	Circle myCircle = new Circle((int)(Math.random()*100+1));
		System.out.println("RANDOMIZED CIRCLE");
		System.out.println("Radius: " + myCircle.getRadius());
		System.out.println("Diameter: " + myCircle.getDiameter());
		System.out.println("Area: " + String.format( "%.2f", myCircle.getArea()));
		System.out.println("Circumference: " + String.format( "%.2f", myCircle.getCircumference()));
		System.out.println();
		myCircle.setRadius(50);
		System.out.println("RE-SIZED CIRCLE");
		System.out.println("Radius: " + myCircle.getRadius());
		System.out.println("Diameter: " + myCircle.getDiameter());
		System.out.println("Area: " + String.format( "%.2f", myCircle.getArea()));
		System.out.println("Circumference: " + String.format( "%.2f", myCircle.getCircumference()));
		System.out.println();
      
		//Rectangle Code
		Rectangle myRectangle = new Rectangle();
		System.out.println("DEFAULT RECTANGLE");
		System.out.println("Length: "+myRectangle.getLength());
		System.out.println("Width: "+myRectangle.getWidth());
		System.out.println("Perimeter: "+myRectangle.getPerimeter());
		System.out.println("Area: "+myRectangle.getArea());
		System.out.println("Number of Side: "+myRectangle.getNumSides());
		myRectangle.setLength(20);
		myRectangle.setWidth(10);
		System.out.println("RESIZED RECTANGLE");
		System.out.println("Length: "+myRectangle.getLength());
		System.out.println("Width: "+myRectangle.getWidth());
		System.out.println("Perimeter: "+myRectangle.getPerimeter());
		System.out.println("Area: "+myRectangle.getArea());
		System.out.println("Number of Side: "+myRectangle.getNumSides());
		
		//SQUARE Code
		Square mySquare = new Square((int)(Math.random()*100+1));
		System.out.println("RANDOMIZED SQUARE");
		System.out.println("Side Lenght: "+mySquare.getSide());
		System.out.println("Perimeter: "+mySquare.getPerimeter());
		System.out.println("Area: "+mySquare.getArea());
		mySquare.setSide(15);
		System.out.println("RESIZED SQUARE");
		System.out.println("Side Lenght: "+mySquare.getSide());
		System.out.println("Perimeter: "+mySquare.getPerimeter());
		System.out.println("Area: "+mySquare.getArea());

		//Triangle Code
		Triangle myTriangle = new Triangle();
		System.out.println("DEFAULT TRIANGLE");
		System.out.println("Side Lenght: "+myTriangle.getLength());
		System.out.println("Perimeter: "+myTriangle.getPerimeter());
		System.out.println("Area: "+myTriangle.getArea());
		System.out.println("Number of Sides: "+myTriangle.getNumSides());
		myTriangle.setLength(25);
		System.out.println("RE-SIZED TRIANGLE");
		System.out.println("Side Lenght: "+myTriangle.getLength());
		System.out.println("Perimeter: "+myTriangle.getPerimeter());
		System.out.println("Area: "+myTriangle.getArea());
		System.out.println("Number of Sides: "+myTriangle.getNumSides());
		
      System.out.close();
      
	}
}