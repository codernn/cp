public class Square extends Rectangle {
    public Square(double sd){
        super(sd,sd);
    }
    public double getSide(){
        return getLength();
    }
    public void setSide(double sd){
        setLength(sd);
        setWidth(sd);
    }
}
