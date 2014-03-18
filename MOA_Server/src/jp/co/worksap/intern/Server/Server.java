package jp.co.worksap.intern.Server;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.List;

import jp.co.worksap.intern.Constants.Constants;
import jp.co.worksap.intern.Constants.TransactionType;
import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Handler.ApplicationHandler;
import jp.co.worksap.intern.Handler.SettingHandler;

public class Server implements Runnable {
	
	private void ConsolePrintFinancialApp(FinancialApplication fapp) {
		System.out.println(fapp.GetDate());
		System.out.println(fapp.GetType());
		System.out.println(fapp.GetStatus());
		System.out.println(fapp.GetApplicant());
		System.out.println(fapp.GetManager());
		System.out.println(fapp.GetAccountant());
		System.out.println(fapp.GetAmount());
		System.out.println(fapp.GetTitle());
		System.out.println(fapp.GetDetail());
		System.out.println();
	}
	
	public void run() {  
		ServerSocket serverSocket;
		try {  
			serverSocket = new ServerSocket(Constants.PORT);  
			//System.out.println("Server: " + serverSocket.getLocalPort() + " on " + serverSocket.getInetAddress());
			
			while (true) {  
				Socket client = serverSocket.accept();  
				System.out.println("connect to client " + client.getInetAddress()); 
				try {  
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
					PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(client.getOutputStream())),true); 
					
					String req = in.readLine();
					System.out.println("Request type : " + req); 
					System.out.println(); 
					TransactionType.REQUEST_TYPE request = TransactionType.GetRequestType(req);
					List<FinancialApplication> result = null;
					FinancialApplication fapp = null;
					String date;
					if (request != null) {
						switch (request) 
						{
						case GET_SETTINGS:
							(new SettingHandler()).GetSettings(in, out);
							break;
						case TRANSACTION_ADD:
							fapp = new FinancialApplication();
							fapp.SetDate(in.readLine());
							fapp.SetType(in.readLine());
							fapp.SetStatus(in.readLine());
							fapp.SetApplicant(in.readLine());
							fapp.SetManager(in.readLine());
							fapp.SetAccountant(in.readLine());
							fapp.SetAmount(in.readLine());
							fapp.SetTitle(in.readLine());
							fapp.SetDetail(in.readLine());
							ConsolePrintFinancialApp(fapp);
							(new ApplicationHandler()).NewApplication(fapp);
							break;
						case TRANSACTION_PENDING:
							String applicant = in.readLine();
							System.out.println("Get " + applicant + "'s Pending Application...");
							System.out.println();
							result = (new ApplicationHandler()).PendingApplication(applicant);
							out.println(result.size());
							System.out.println("Pending Application Num: " + result.size());
							System.out.println();
							for (int i = 0; i < result.size(); i++) {
								out.println(result.get(i).GetDate());
								out.println(result.get(i).GetTitle());
							}
							break;
						case TANSACTION_TOHANDLE:
							String manager = in.readLine();
							System.out.println("Get " + manager + "'s To-handle Application...");
							System.out.println();
							result = (new ApplicationHandler()).ToHandleApplication(manager);
							out.println(result.size());
							System.out.println("To-hanle Application Num: " + result.size());
							System.out.println();
							for (int i = 0; i < result.size(); i++) {
								out.println(result.get(i).GetDate());
								out.println(result.get(i).GetApplicant());
							}
							break;
						case TRANSACTION_DETAIL:
							date = in.readLine();
							System.out.println("Get To-handle Application Detail...");
							System.out.println();
							fapp = (new ApplicationHandler()).DetailApplication(date);
							out.println(fapp.GetApplicant());//System.out.println(fapp.GetApplicant());
							out.println(fapp.GetAmount());//System.out.println(fapp.GetAmount());
							out.println(fapp.GetTitle());//System.out.println(fapp.GetTitle());
							out.println(fapp.GetDetail());//System.out.println(fapp.GetDetail());
							break;
						case TRANSACTION_HANDLE:
							date = in.readLine();
							String status = in.readLine();
							(new ApplicationHandler()).HandleApplication(date, status);
							if (status.equals("0"))
								System.out.println("Approve Application...");
							else
								System.out.println("Disapprove Application...");
							System.out.println();
							break;
						default:
							break;     
						}
					}
					
					out.close();  
					in.close();  	    	        	
					//serverSocket.close();
				}  
				catch (Exception e)  
				{  
					System.out.println(e.getMessage());  
					e.printStackTrace();  
				}  
				finally 
				{  
					//System.out.println("disconnect to client " + client.getInetAddress());
					client.close();  
				}  
			}  
		}  
		catch (Exception e)  
		{  
			System.out.println(e.getMessage());  
		}  
	}  

	public static void main(String[] args) {
		Thread desktopServerThread = new Thread(new Server());  
		desktopServerThread.start();
	}

}
