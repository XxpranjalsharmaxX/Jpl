abstract class Shape {
   protected double l;
   Shape()
   {
       System.err.println("Enter the value of length");
   }
   Shape(double l)
   {
       this.l=l;
   }

}
class Square extends Shape
{
    Square() throws Exception {
        throw new Exception();
    }
    Square(double l)
    {
        super(l);
    }
    void area()
    {
        System.out.println("Area of square  " + l*l);
    }
}
class Rectangle extends Square
{
    private double b;
    Rectangle(double l,double b)
    {
        super(l);
        this.b = b;
    }
    void area()
    {
        System.out.println("Area of rectangle " + l*b);
    }
}
public class Jlp1
{
    public static void main(String[] args) throws Exception {

        Square s = null;
        try {
            s = new Square();
            s.area();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
        Rectangle r = new Rectangle(3,5);
        r.area();
    }
}