import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class HelloUser {
    public static void main(String args[]) {
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        String name = br.readLine();
        System.out.println("Welcome to CI/CD using Jenkins, "+name);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
}