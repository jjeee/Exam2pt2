import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam2 {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            Step1 s1=new Step1();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            step2 s2=new step2();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            step3 s3=new step3();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}