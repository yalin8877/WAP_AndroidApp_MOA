package jp.co.worksap.intern.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SettingHandler {
	
	public void GetSettings(BufferedReader in, PrintWriter out) {
		try {
			String accountname = in.readLine();
			System.out.println("Recieve Acount Name : " + accountname);    
			//send back related position & settings
			out.println("2");//employeeid
			out.println("staff");//position
			//out.println("11000001");//settings
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
