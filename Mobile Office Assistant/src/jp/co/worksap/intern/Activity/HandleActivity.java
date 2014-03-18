package jp.co.worksap.intern.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Entity.UserAccount;
import jp.co.worksap.intern.ServerProcess.ApplicationHandler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class HandleActivity extends Activity {
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			//handle the UI
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handle_detail);
		setTitle("Application Details");

		new Thread(){
			@Override
			public void run() {
				FinancialApplication detail = (new ApplicationHandler()).DetailApplication(UserAccount.mDate);
				TextView date = (TextView) findViewById(R.id.Date);
				TextView type = (TextView) findViewById(R.id.Type);
				TextView amount = (TextView) findViewById(R.id.Amount);
				TextView title = (TextView) findViewById(R.id.Title);
				TextView det = (TextView) findViewById(R.id.Detail);
				date.setText(UserAccount.mDate);
				type.setText("Financial");
				amount.setText(detail.GetAmount());
				title.setText(detail.GetTitle());
				det.setText(detail.GetDetail());
				/*ListView list = (ListView) findViewById(R.id.ListViewItem_detail);
				List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

				HashMap<String, Object> map1 = new HashMap<String, Object>();  
				map1.put("key", "Date");
				map1.put("value", UserAccount.mDate);  
				listItem.add(map1); 
				//map.clear();
				
				HashMap<String, Object> map2 = new HashMap<String, Object>(); 
				map2.put("key", "Type");
				map2.put("value", "Financial");  
				listItem.add(map2); 
				//map.clear();
				
				HashMap<String, Object> map3 = new HashMap<String, Object>(); 
				map3.put("key", "Applicant");
				map3.put("value", detail.GetApplicant());  
				listItem.add(map3); 
				//map.clear();
				
				HashMap<String, Object> map4 = new HashMap<String, Object>(); 
				map4.put("key", "Amount");
				map4.put("value", detail.GetAmount());  
				listItem.add(map4); 
				//map.clear();
				
				HashMap<String, Object> map5 = new HashMap<String, Object>(); 
				map5.put("key", "Title");
				map5.put("value", detail.GetTitle());  
				listItem.add(map5); 
				//map.clear();
				
				HashMap<String, Object> map6 = new HashMap<String, Object>(); 
				map6.put("key", "Detail");
				map6.put("value", detail.GetDetail());  
				listItem.add(map6); 
				//map.clear();

				String[] stemp = {"key", "value" };
				int[] itemp = {R.id.key, R.id.value};
				SimpleAdapter listItemAdapter = new SimpleAdapter(HandleActivity.this, listItem, R.layout.listview_detail, stemp, itemp);
				list.setAdapter(listItemAdapter);  */

				handler.sendEmptyMessage(0);
			}
		}.start();
	}

	public void onButtonClick(View v){
		int id = v.getId();
		final TextView date = (TextView) findViewById(R.id.Date);
		
		switch(id){
		case R.id.approve:
			new Thread(){
				@Override
				public void run() {
					(new ApplicationHandler()).HandleApplication(date.getText().toString(), true);
					handler.sendEmptyMessage(0);
				}
			}.start();
			new AlertDialog.Builder(this).setTitle("Information")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Approved!")
			.setPositiveButton("OK", null).show();
			startActivity(new Intent(HandleActivity.this, TranscationActivity.class));
			finish();
			break;
		case R.id.disapprove:
			new Thread(){
				@Override
				public void run() {
					(new ApplicationHandler()).HandleApplication(date.getText().toString(), false);
					handler.sendEmptyMessage(0);
				}
			}.start();
			new AlertDialog.Builder(this).setTitle("Information!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Disapproved!")
			.setPositiveButton("OK", null).show();
			startActivity(new Intent(HandleActivity.this, TranscationActivity.class));
			finish();
			break;
		}
	}
}
