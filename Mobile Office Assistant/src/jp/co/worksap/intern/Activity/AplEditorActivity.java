package jp.co.worksap.intern.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import jp.co.worksap.intern.Activity.R;
import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Entity.UserAccount;
import jp.co.worksap.intern.ServerProcess.ApplicationHandler;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

public class AplEditorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apl_editor);
	}
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			//handle the UI
		}
	};
	
	public void onButtonClick(View v) {
		
		int id = v.getId();
		
		switch(id){
		case R.id.apply:
			final FinancialApplication fapp = new FinancialApplication();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm"); 
			fapp.SetDate(formatter.format(new Date(System.currentTimeMillis())));
			fapp.SetType("1");
			fapp.SetStatus("1");
			fapp.SetApplicant(UserAccount.mAccountName);
			fapp.SetManager(((EditText)findViewById(R.id.Manager)).getText().toString());
			fapp.SetAccountant(((EditText)findViewById(R.id.FinancialStaff)).getText().toString());
			fapp.SetAmount(((EditText)findViewById(R.id.Amount)).getText().toString());
			fapp.SetTitle(((EditText)findViewById(R.id.Title)).getText().toString());
			fapp.SetDetail(((EditText)findViewById(R.id.Detail)).getText().toString());
			
			new Thread(){
				@Override
				public void run() {
					(new ApplicationHandler()).NewApplication(fapp);
					handler.sendEmptyMessage(0);
				}
			}.start();
			new AlertDialog.Builder(AplEditorActivity.this).setTitle("New Application")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("New Application Created!")
			.setPositiveButton("OK", null).show();
			startActivity(new Intent(this, ApplyActivity.class));
			finish();
			break;
		case R.id.discard:
			startActivity(new Intent(this, ApplyActivity.class));
			finish();
			break;
		}
	}
}
