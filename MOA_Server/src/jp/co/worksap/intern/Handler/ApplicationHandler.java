package jp.co.worksap.intern.Handler;

import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.FileProcessor.ApplicationIO;

public class ApplicationHandler {
	
	public void NewApplication(FinancialApplication fapp) {
		
		String[] params = {fapp.GetDate(), fapp.GetType(), fapp.GetStatus(), fapp.GetApplicant(), 
				fapp.GetManager(), fapp.GetAccountant(), fapp.GetAmount(), fapp.GetTitle(), fapp.GetDetail()};
	
		(new ApplicationIO()).AddApplication(params);
	}
	
	public void HandleApplication(String date, String status) {
		List<String[]> result = (new ApplicationIO()).ReadApplication();
		for (int i = 0; i < result.size(); i++) {
			String dat = (result.get(i))[0];
			if ( dat.equals(date))
			{
				(result.get(i))[2] = status;
				break;
			}
		}
		(new ApplicationIO()).RewriteApplication(result);
	}
	
	public FinancialApplication DetailApplication(String date) {
		List<String[]> result = (new ApplicationIO()).ReadApplication();
		FinancialApplication fapp = new FinancialApplication();
		for (int i = 0; i < result.size(); i++) {
			String dat = (result.get(i))[0];
			if ( dat.equals(date))
			{
				String [] temp = result.get(i);
				fapp.SetApplicant(temp[3]);
				fapp.SetAmount(temp[6]);
				fapp.SetTitle(temp[7]);
				fapp.SetDetail(temp[8]);
				return fapp;
			}
		}
		return null;
	}
	
	public List<FinancialApplication> PendingApplication(String applicant) {
		List<String[]> result = (new ApplicationIO()).ReadApplication();
		List<FinancialApplication> results = new ArrayList<FinancialApplication>();
		for (int i = 0; i < result.size(); i++) {
			String status = (result.get(i))[2];
			if ( !(result.get(i))[3].equals(applicant) || status.equals("0") || status.equals("-1"))
				continue;
			FinancialApplication fapp = new FinancialApplication();
			fapp.SetDate((result.get(i))[0]);
			fapp.SetTitle((result.get(i))[7]);
			results.add(fapp);
		}
		return results;
	}
	
	public List<FinancialApplication> ToHandleApplication(String manager) {
		List<String[]> result = (new ApplicationIO()).ReadApplication();
		List<FinancialApplication> results = new ArrayList<FinancialApplication>();
		for (int i = 0; i < result.size(); i++) {
			String status = (result.get(i))[2];
			if (status.equals("0") || status.equals("-1"))
				continue;
			String mnger = (result.get(i))[4];
			if (!mnger.equals(manager))
				continue;
			FinancialApplication fapp = new FinancialApplication();
			fapp.SetDate((result.get(i))[0]);
			fapp.SetApplicant((result.get(i))[3]);
			results.add(fapp);
		}
		return results;
	}
}
