package laboratory3.task2;

import java.io.*;
import java.util.Scanner;

public class MyClass implements AutoCloseable{
    private String fileName;

    public MyClass(){};
    public MyClass(String fileName){
        this.fileName = fileName;
    }
    public void read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
    public void addSomeData() throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        String line = null;
        while(true){
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if(line.equals("exit"))
                break;
            writer.write(line);
        }
        writer.close();
    }
    @Override
    public void close(){
        System.out.println("Closed");
    }
}
