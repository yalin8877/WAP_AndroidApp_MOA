package jp.co.worksap.intern.ServerProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.worksap.intern.Constant.Constants;
import jp.co.worksap.intern.Constant.PositionType;
import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Entity.UserAccount;
import android.os.Handler;
import android.os.Message;

public class ApplicationHandler {
	
	public Handler GetHandler() {
		return new Handler(){
			@Override
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				//handle the UI
			}
		};
	}
	
	public void HandleApplication(String date, boolean bApprove) {
		Socket socket = null;  
		String request = "TRANSACTION_HANDLE";   

		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			out.println(request); 
			//send applicant name
			out.println(date);
			out.println(bApprove ? "0" : "-1");
	
			out.close(); 
			socket.close(); 
		}  
		catch (Exception e)   
		{  
			System.out.println(e.toString());
		}
	}
	
	public FinancialApplication DetailApplication(String date) {
		Socket socket = null;  
		String request = "TRANSACTION_DETAIL";   
		
		FinancialApplication result = new FinancialApplication();
		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			out.println(request); 
			//send applicant name
			out.println(date);
			
			result.SetApplicant(in.readLine());
			result.SetAmount(in.readLine());
			result.SetTitle(in.readLine());
			result.SetDetail(in.readLine());
			out.close(); 
			socket.close(); 
		}  
		catch (Exception e)   
		{  
			System.out.println(e.toString());
		}
		return result;  
	}
	
	public List<FinancialApplication> ToHandleApplication() {
		Socket socket = null;  
		String request = "TANSACTION_TOHANDLE";   
		
		List<FinancialApplication> result = new ArrayList<FinancialApplication>();
		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			out.println(request); 
			//send applicant name
			out.println(UserAccount.mAccountName);
			int num = Integer.parseInt(in.readLine());
			System.out.println("To-handle Application Num: " + num);
			for (int i = 0; i < num; i++) {
				FinancialApplication fapp = new FinancialApplication();
				fapp.SetDate(in.readLine());
				fapp.SetApplicant(in.readLine());
				result.add(fapp);
			}
			
			out.close(); 
			socket.close(); 
		}  
		catch (Exception e)
		{  
			System.out.println(e.toString());
		}
		return result;  
	}
	
	public List<FinancialApplication> PendingApplication() {
		Socket socket = null;  
		String request = "TRANSACTION_PENDING";   
		
		List<FinancialApplication> result = new ArrayList<FinancialApplication>();
		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			out.println(request); 
			//send applicant name
			out.println(UserAccount.mAccountName);
			int num = Integer.parseInt(in.readLine());
			System.out.println("Pending Application Num: " + num);
			for (int i = 0; i < num; i++) {
				FinancialApplication fapp = new FinancialApplication();
				fapp.SetDate(in.readLine());
				fapp.SetTitle(in.readLine());
				result.add(fapp);
			}
			
			out.close(); 
			socket.close(); 
		}  
		catch (Exception e)   
		{  
			System.out.println(e.toString());
		}
		return result;  
	}

	public void NewApplication(FinancialApplication fapp){
		
		Socket socket = null;  
		String request = "TRANSACTION_ADD";   
		try   
		{   
			socket = new Socket(Constants.IP,Constants.PORT); 
			PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);        
			out.println(request); 
			//send Application Content
			out.println(fapp.GetDate());
			out.println(fapp.GetType());
			out.println(fapp.GetStatus());
			out.println(fapp.GetApplicant());
			out.println(fapp.GetManager());
			out.println(fapp.GetAccountant());
			out.println(fapp.GetAmount());
			out.println(fapp.GetTitle());
			out.println(fapp.GetDetail());
			
			out.close(); 
			socket.close();   
		}  
		catch (Exception e)   
		{  
			System.out.println(e.toString());
		}  
	}
}
