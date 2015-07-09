package test;

public class Circle extends Shape{ 
	  static Shape s1 = new Shape(1); 
	  Shape s2 = new Shape(3); 
	  Circle(int i){ 
	    super(i); 
	    System.out.println("This is Circle" + i); 
	  } 

	  public static void main(String args[]){ 
	    Circle c1 = new Circle(2); 
	  } 
	} 
