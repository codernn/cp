public class Rectangle extends Polygon{

    private double length,width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(){
        length = 10;
        width = 5;
    }

    public Rectangle(double ln, double wi){
        length = ln;
        width = wi;
    }

    @Override
    public double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public int getNumSides() {
        return 4;
    }

    @Override
    public double getArea() {
        return length*width;
    }
    
}
