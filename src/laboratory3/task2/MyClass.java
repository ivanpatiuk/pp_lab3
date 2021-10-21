package laboratory3.task2;

import java.io.*;
import java.util.Scanner;

public class MyClass implements AutoCloseable{
    private String fileName;
    private FileWriter writer;
    private Scanner scanner;

    public MyClass(){};
    public MyClass(String fileName) throws IOException {
        this.fileName = fileName;
        writer = new FileWriter(fileName, false);
        scanner = new Scanner(new File(fileName));
    }
    public void read() throws FileNotFoundException {
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
    public void addSomeData() throws IOException {
        String line = null;
        Scanner in = new Scanner(System.in);
        while(true){
            line = in.nextLine();
            if(line.equals("exit"))
                break;
            writer.write(line);
        }
        writer.close();
        in.close();
    }
    @Override
    public void close() throws IOException {
        writer.close();
        scanner.close();
        System.out.println("Closed");
    }
}
