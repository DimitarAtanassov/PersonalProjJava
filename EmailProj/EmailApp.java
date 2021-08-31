
public class EmailApp {
	private String fName;
	private String lName;
	private String depName;
	private String compName;
	private static  String passWord;
	
	//Constructor
	public EmailApp(String fname, String LastName){
		this.fName = fname;
		lName = LastName;
		this.depName = "?";
		this.compName = "?";
	}
	
	public static String RanPass(int length) {
		passWord = "";
		for(int i = 0; i < length;i++) {
			passWord += randomCharacter();
		}
		return passWord;
	}
	
	public String getDepName() {
		return this.depName;
	}
	
	public void setDepName(String DepName) {
		this.depName = DepName;
		
	}
	
	public String getcompName() {
		return this.compName;
	}
	
	public void setcompName(String CompName) {
		this.compName = CompName;
	}
	
	public String email() {
		return this.fName + this.lName + "@" + getcompName() + getDepName() + ".com";
	}
	
	
	
	
	
	
	public static char randomCharacter() {
		//We multiply Math.random() by 62 because there are 26 lowercase letters, 26 uppercase letters, and 10 numbers, and 26 + 26 + 10 = 62
		//This random number has values between 0 (inclusive) and 62 (exclusive)
		int rand = (int)(Math.random()*62);
		
		//0-61 inclusive = all possible values of rand
		//0-9 inclusive = 10 possible numbers/digits
		//10-35 inclusive = 26 possible uppercase letters
		//36-61 inclusive = 26 possible lowercase letters
		//If rand is between 0 (inclusive) and 9 (inclusive), we can say it's a number/digit
		//If rand is between 10 (inclusive) and 35 (inclusive), we can say it's an uppercase letter
		//If rand is between 36 (inclusive) and 61 (inclusive), we can say it's a lowercase letter
		if(rand <= 9) {
			//Number (48-57 in ASCII)
			//To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
			int number = rand + 48;
			//This way, rand = 0 => number = 48 => '0'
			//Remember to cast our int value to a char!
			return (char)(number);
		} else if(rand <= 35) {
			//Uppercase letter (65-90 in ASCII)
			//To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
			int uppercase = rand + 55;
			//This way, rand = 10 => uppercase = 65 => 'A'
			//Remember to cast our int value to a char!
			return (char)(uppercase);
		} else {
			//Lowercase letter (97-122 in ASCII)
			//To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
			int lowercase = rand + 61;
			//This way, rand = 36 => lowercase = 97 => 'a'
			//Remember to cast our int value to a char!
			return (char)(lowercase);
		}
	}
	
}
