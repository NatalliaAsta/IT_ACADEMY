package homeWork11.utils;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Utils {

    public static void showSteps() {
        System.out.println(Constants.NEXT_STEP);
        System.out.println(Constants.STEP_1);
        System.out.println(Constants.STEP_2);
        System.out.println(Constants.STEP_3);
        System.out.println(Constants.STEP_4);
        System.out.println(Constants.STEP_5);
        System.out.println(Constants.STEP_6);
        System.out.println(Constants.STEP_7);
    }

    public static void showProductList(FileReader reader) throws IOException {
        int c;
        while((c=reader.read())!=-1) {
            System.out.print((char) c);
        }
    }

    public static void clearFile(String fileName) {
        try (PrintWriter bf = new PrintWriter(fileName)) {
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

 }
