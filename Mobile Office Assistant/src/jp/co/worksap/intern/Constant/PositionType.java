package jp.co.worksap.intern.Constant;

public class PositionType {
	
	private PositionType(){}
	
	public static enum RPOSITION_TYPE {
		AREA_MANAGER, 
		STAFF, 
		ACCOUNTANT,
	}
	
	public static RPOSITION_TYPE GetPositionType(String request) {
		if (request.equals("AREA_MANAGER")) {
			return RPOSITION_TYPE.AREA_MANAGER;
		} 
		else if (request.equals("STAFF")) {
			return RPOSITION_TYPE.STAFF;
		}
		else if (request.equals("ACCOUNTANT")) {
			return RPOSITION_TYPE.ACCOUNTANT;
		}
		else {
			System.out.println("Unrecognized position : " + request);
			return null;
		}
	}
}
