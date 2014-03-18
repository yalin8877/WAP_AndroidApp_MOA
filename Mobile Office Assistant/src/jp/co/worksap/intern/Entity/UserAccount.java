package jp.co.worksap.intern.Entity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import jp.co.worksap.intern.Constant.Constants;
import jp.co.worksap.intern.Constant.PositionType;

import android.app.Application;
import android.os.Handler;

public class UserAccount extends Application {
	
	public UserAccount() {
		//handler = (new Connection()).GetHandler();
	}
	
	//private Handler handler;
	
	public static String mAccountName;
	public static int mEmployeeId;
	public static PositionType.RPOSITION_TYPE mPosition;
	public static String mStaffSettings;
	public static String mManagerSettings;
	public static String mDate;
	
	/*
	public String GetName() {
		return mAccountName;
	}
	public void SetName(String username) {
		mAccountName = username;
	}
	
	public PositionType.RPOSITION_TYPE GetPosition() {
		return mPosition;
	}
	public void SetPosition(PositionType.RPOSITION_TYPE position) {
		mPosition = position;
	}
	
	public String GetSettings() {
		return mSettings;
	}
	public void SetSettings(String set) {
		mSettings = set;
	}
	
	public String GetDate() {
		return mDate;
	}
	public void SetDate(String date) {
		mDate = date;
	}
	*/
	public void RetrieveSettings() {
		
				Socket socket = null;
				try {
					socket = new Socket(Constants.IP,Constants.PORT); 
					PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
					out.println("TRANSACTION_ADD");   

					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
					String msg1 = br.readLine();   	
					if (msg1 != null) {
						System.out.println(msg1);
					}  
					else {
						System.out.println("Wrong data!");
					}
					out.close();  
					br.close();    
					socket.close();   
				} 
				catch (Exception e) {  
					// TODO: handle exception  
					System.out.println(e.toString());
				}  
	}
	
	
}
