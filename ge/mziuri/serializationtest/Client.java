
package ge.mziuri.serializationtest;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args) {
        
        try {
            Socket socket = new Socket("localhost", 8080);
            Scanner scanner = new Scanner(System.in);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String parts[] = text.split(" ");
                Student student = new Student(parts[0], parts[1]);
                out.writeObject(student);
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
