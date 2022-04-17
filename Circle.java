import java.math.*;
public class Circle extends Shape{
    private double radius;

    public Circle(double rd){
        radius = rd;
    }

    public void setRadius(double rd){
        radius = rd;
    }

    public double getRadius(){
        return radius;
    }

    public double getDiameter(){
        return 2*radius;
    }

    public double getCircumference(){
        return Math.PI*2*radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
