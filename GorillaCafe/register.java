package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class register {
	@FXML
	private Label userName;
	
	@FXML
	private Label pass;
	
	@FXML 
	private Label email;
	
	@FXML
	private Label signup;
	
	@FXML
	private Label signlabel;
	
	@FXML
	private TextField user;
	
	@FXML
	private TextField passText;


	@FXML
	private TextField emailText;
	
	@FXML
	private Button regB;
	
	@FXML
	private Button backb;
	
	
	public void register(ActionEvent event) throws IOException{
		addDB();
	}
	
	public void back(ActionEvent event) throws IOException{
		backToLogin();
	}
	
	private void backToLogin() throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	private void addDB() {
		String usernamedb = user.getText().toString();
		String passworddb = passText.getText().toString();;; 
		FileWriter fw = null;
		File file = new File("C:\\Users\\dimit\\Desktop\\gcafedb.txt");
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//Used to write data to a file and provides methods to do so
		BufferedWriter bw = new BufferedWriter(fw);		//Used to write data into a file more efficiently
		PrintWriter outFile = new PrintWriter(bw);	//Provides the print and println methods so you can write directly to the file; used to print an object in the formatted representation
		outFile.println(usernamedb);
		outFile.println(passworddb);
		signlabel.setText("Signup Complete!");
		outFile.close();
	}
	
	
	
	
}
