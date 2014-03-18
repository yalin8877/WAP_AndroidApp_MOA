package jp.co.worksap.intern.ServerProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import jp.co.worksap.intern.Activity.LoginActivity;
import jp.co.worksap.intern.Activity.R;
import jp.co.worksap.intern.Constant.Constants;
import jp.co.worksap.intern.Constant.PositionType;
import jp.co.worksap.intern.Entity.UserAccount;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;

public class PersonalInfoHandler {
	
	public Handler GetHandler() {
		return new Handler(){
			@Override
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				//handle the UI
			}
		};
	}

	//Get Account Info from Server
	public void Request(String accountname){
		
		//SET accountname
		UserAccount.mAccountName = accountname;
		
		Socket socket = null;  
		String request = "GET_SETTINGS";   
		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			out.println(request);   
			out.println(accountname);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
			//SET position & settings
			UserAccount.mEmployeeId = Integer.parseInt(br.readLine());
			UserAccount.mPosition = PositionType.GetPositionType(br.readLine());
			UserAccount.mManagerSettings = Constants.DEFAULT_SETTINGS;
			UserAccount.mStaffSettings = Constants.DEFAULT_SETTINGS;
			/*String settings = br.readLine();
			if (UserAccount.mAccountName.equals("manager")) {
				UserAccount.mManagerSettings = settings;
			}
			else {
				UserAccount.mStaffSettings = settings;
			}*/
			
			out.close();  
			br.close();    
			socket.close();   
		}  
		catch (Exception e)   
		{  
			System.out.println(e.toString());
		}  
	}

}
