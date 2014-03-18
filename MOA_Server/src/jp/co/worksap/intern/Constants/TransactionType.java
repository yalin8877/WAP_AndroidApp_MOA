package jp.co.worksap.intern.Constants;

public class TransactionType {
	
	private TransactionType(){}
	
	public static enum REQUEST_TYPE {
		GET_SETTINGS,
		TRANSACTION_ADD,
		TANSACTION_TOHANDLE,
		TRANSACTION_PENDING,
		TRANSACTION_DETAIL,
		TRANSACTION_HANDLE,
		//TRANSACTION_HISTORY,
	}
	
	public static REQUEST_TYPE GetRequestType(String request) {
		if (request.equals("GET_SETTINGS")) {
			return REQUEST_TYPE.GET_SETTINGS;
		} 
		else if (request.equals("TRANSACTION_ADD")) {
			return REQUEST_TYPE.TRANSACTION_ADD;
		}
		else if (request.equals("TANSACTION_TOHANDLE")) {
			return REQUEST_TYPE.TANSACTION_TOHANDLE;
		}
		else if (request.equals("TRANSACTION_PENDING")) {
			return REQUEST_TYPE.TRANSACTION_PENDING;
		}
		else if (request.equals("TRANSACTION_DETAIL")) {
			return REQUEST_TYPE.TRANSACTION_DETAIL;
		}
		else if (request.equals("TRANSACTION_HANDLE")) {
			return REQUEST_TYPE.TRANSACTION_HANDLE;
		}
		else {
			System.out.println("Unrecognized request : " + request);
			return null;
		}
	}
}
