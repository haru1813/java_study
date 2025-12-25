import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ListCollectionExample {
    public static void main(String[] args){
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<String> array1 = new ArrayList<>();
        array1.add("자바");
        array1.add("파이썬");
        array1.add("물리학");
        System.out.println(array1);
    }
}
