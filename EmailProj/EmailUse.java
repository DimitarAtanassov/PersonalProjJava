import java.util.Scanner;
public class EmailUse {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your First Name?");
		String fName = sc.next();
		System.out.println("What is your Last Name?");
		String lName = sc.next();
		EmailApp emApp = new EmailApp(fName, lName);
		System.out.println("What is the Department you work for?");
		String depName = sc.next();
		emApp.setDepName(depName);
		System.out.println("What is the Company you work for?");
		String compName = sc.next();
		emApp.setcompName(compName);
		int length = 0;
		System.out.println("How long do you want your password to be?");
		while(!sc.hasNextInt()) {
			sc.next(); //If user enters input the scanner saves the input 
			System.out.println("Please enter a number!");
		}
		length = sc.nextInt();	//Loads the input into length var
		
		
		String passWord = EmailApp.RanPass(length);
		System.out.println("Your Email is: " + emApp.email());
		System.out.println("Your password is: " + passWord);
		sc.close();
	}
}
