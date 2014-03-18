package jp.co.worksap.intern.Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jp.co.worksap.intern.Activity.R;
import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Entity.UserAccount;
import jp.co.worksap.intern.ServerProcess.ApplicationHandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

public class TranscationActivity extends Activity {

	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			//handle the UI
		}
	};

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		new Thread(){
			@Override
			public void run() {
				List<FinancialApplication> pending = (new ApplicationHandler()).ToHandleApplication();
				if (!pending.isEmpty()) {
					ListView list = (ListView) findViewById(R.id.ListView_todo);
					final List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
					for(int i=0;i<pending.size();i++)  
					{  
						HashMap<String, Object> map = new HashMap<String, Object>();  
						map.put("date", pending.get(i).GetDate());
						map.put("applicant", pending.get(i).GetApplicant());  
						listItem.add(map);  
					} 

					String[] stemp = {"date", "applicant" };
					int[] itemp = {R.id.date, R.id.applicant};
					SimpleAdapter listItemAdapter = new SimpleAdapter(TranscationActivity.this, listItem, R.layout.listview_todo, stemp, itemp);

					list.setAdapter(listItemAdapter);  

					list.setOnItemClickListener(new OnItemClickListener() {  

						@Override  
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
								long arg3) {  
							UserAccount.mDate = (listItem.get(arg2)).get("date").toString();
							//setContentView(R.layout.activity_handle);
							startActivity( new Intent(TranscationActivity.this, HandleActivity.class));
						}  
					});  
				}

				handler.sendEmptyMessage(0);
			}
		}.start();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		new Thread(){
			@Override
			public void run() {
				List<FinancialApplication> pending = (new ApplicationHandler()).ToHandleApplication();
				if (!pending.isEmpty()) {
					ListView list = (ListView) findViewById(R.id.ListView_todo);
					final List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
					for(int i=0;i<pending.size();i++)  
					{  
						HashMap<String, Object> map = new HashMap<String, Object>();  
						map.put("date", pending.get(i).GetDate());
						map.put("applicant", pending.get(i).GetApplicant());  
						listItem.add(map);  
					} 

					String[] stemp = {"date", "applicant" };
					int[] itemp = {R.id.date, R.id.applicant};
					SimpleAdapter listItemAdapter = new SimpleAdapter(TranscationActivity.this, listItem, R.layout.listview_todo, stemp, itemp);

					list.setAdapter(listItemAdapter);  

					list.setOnItemClickListener(new OnItemClickListener() {  

						@Override  
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
								long arg3) {  
							UserAccount.mDate = (listItem.get(arg2)).get("date").toString();
							//setContentView(R.layout.activity_handle);
							startActivity( new Intent(TranscationActivity.this, HandleActivity.class));
						}  
					});  
				}

				handler.sendEmptyMessage(0);
			}
		}.start();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transcation);
		setTitle("Applications to Handle");

		new Thread(){
			@Override
			public void run() {
				List<FinancialApplication> pending = (new ApplicationHandler()).ToHandleApplication();
				if (!pending.isEmpty()) {
					ListView list = (ListView) findViewById(R.id.ListView_todo);
					final List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
					for(int i=0;i<pending.size();i++)  
					{  
						HashMap<String, Object> map = new HashMap<String, Object>();  
						map.put("date", pending.get(i).GetDate());
						map.put("applicant", pending.get(i).GetApplicant());  
						listItem.add(map);  
					} 

					String[] stemp = {"date", "applicant" };
					int[] itemp = {R.id.date, R.id.applicant};
					SimpleAdapter listItemAdapter = new SimpleAdapter(TranscationActivity.this, listItem, R.layout.listview_todo, stemp, itemp);

					list.setAdapter(listItemAdapter);  

					list.setOnItemClickListener(new OnItemClickListener() {  

						@Override  
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
								long arg3) {  
							UserAccount.mDate = (listItem.get(arg2)).get("date").toString();
							//setContentView(R.layout.activity_handle);
							startActivity( new Intent(TranscationActivity.this, HandleActivity.class));
						}  
					});  
				}

				handler.sendEmptyMessage(0);
			}
		}.start();
	}
}
