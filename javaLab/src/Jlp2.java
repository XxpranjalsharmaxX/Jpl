import java.util.Scanner;

public class Jlp2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str.substring(3));
        System.out.println(str.charAt(2));
        System.out.println(str.compareTo("this is a demo string"));
        System.out.println(str.lastIndexOf('a'));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("this");
        stringBuffer.append(" is ");
        stringBuffer.append("stringbuffer");
        System.out.println(stringBuffer.toString());
        System.out.println( stringBuffer.capacity());
        Integer a = sc.nextInt();
        System.out.println(a.toString());
        System.out.println(Integer.max(Integer.parseInt("123400"),a));
        System.out.println(Integer.toBinaryString(a));

    }
}
