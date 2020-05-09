import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Jlp4 {
    public static void main(String[] args) {
        int a = 1322;
        int b = 0;
        String str = null;
        int [] arr = new int[10];
        try {
            arr[10] = 123;
            int c = a/b;
            FileInputStream fileInputStream = new FileInputStream("text1");
            str.contains("abcd");
            throw new CustomizedException("this is a customized exception");
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}

class CustomizedException extends Exception
{
    CustomizedException()
    {
        System.out.println("this is a customize exception");
    }
    CustomizedException(String exception)
    {
        super(exception);
    }
}
