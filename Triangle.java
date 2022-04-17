public class Triangle extends Polygon{
    private double length;
    public double getLength(){
        return length;
    }
    public void setLength(double ln){
        length = ln;
    }
    public Triangle(){
        length = 5;
    }
    public Triangle(double sd){
        length = sd;
    }

    @Override
    public double getPerimeter() {
        return 3*length;
    }

    @Override
    public int getNumSides() {
        return 3;
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3)*length*length)/4;
    }
}
