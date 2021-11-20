package laboratory3.task2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (MyClass myClass = new MyClass("file.txt")) {
            myClass.addSomeData();
            myClass.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
