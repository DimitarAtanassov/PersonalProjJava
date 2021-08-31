package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogIn {

	// Connecting Buttons and Textfields from the scene builder
	@FXML
	private Button button;

	@FXML
	private Button signupb;

	@FXML
	private TextField username;

	@FXML
	private TextField Password;

	@FXML
	private Label wrongLogin;

	// Method that is called on action in scene builder
	public void userLogin(ActionEvent event) throws IOException { // The throws io is used to supress exeptions you know
																	// that there will be no error so it becomes a
																	// checked exception
		checkLogin(); // On the actionevent call this method
	}

	public void userSignUp(ActionEvent event) throws IOException {
		signUP();
	}

	private void signUP() throws IOException {
		Main r = new Main();
		r.changeScene("reg.fxml");
	}

	
	  private void checkLogin() throws IOException{ 
		if(username.getText().isEmpty() && Password.getText().isEmpty()) {
			wrongLogin.setText("Please Fill out all the fields");
		}
		boolean usernamecheck = false;
		boolean passwordcheck = false;
		File file = new File("C:\\Users\\dimit\\Desktop\\gcafedb.txt");
		try {
			FileInputStream fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String line;
			
			while((line = br.readLine())!= null ) {
				if(username.getText().equals(line)) {
					usernamecheck = true;
				}
				if(Password.getText().equals(line)) {
					passwordcheck = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(usernamecheck && passwordcheck) {
			Main m = new Main();
			m.changeScene("logged.fxml");
			
		}else {
			wrongLogin.setText("Invalid Login.Please try again");
		}
		 
	  }
	 

}
