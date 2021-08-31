import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.SecureRandom;
public class Main {

	public static void main(String args []) {
		String webName = "";	//Used to store the website that the password is made for
		String userName ="";	//Stores to userName for the generated password
		String passWord = "";	//Will be used to store the password
		int passLength = 0;
		InputStreamReader isr = new InputStreamReader(System.in);	//Creates a input reader to read user input from keyboard
		BufferedReader stdin = new BufferedReader(isr);	//Makes the input reader more effective
		System.out.println("What Website will this password be used for");
		try {
			webName = stdin.readLine();
			System.out.println("What is your Username");
			userName = stdin.readLine();
			System.out.println("How long do you want your password to be?");
			passLength = Integer.parseInt(stdin.readLine());
			//Catch a Input/Output error called E
		}catch(IOException e){
			e.printStackTrace();	//This helps you trace your Exceptions
		}
		try {
			//The true after the file location makes it so the new data is appended to the text file rather than overwritting what is currently in it
			PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dimit\\Desktop\\PassGenerator.txt",true));
			out.println("------");
			out.println("Website: " + webName);
			out.println("Username: " + userName);
			out.println("Password: " + PassGen.generate(passLength));
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Password Generated Succesfully");
		
	}
}
//Class to generate random password
class PassGen{
	public static String generate(int passLength) {
		// ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < passLength; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
	}
}
