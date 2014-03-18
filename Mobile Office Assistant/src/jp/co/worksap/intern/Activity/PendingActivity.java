package jp.co.worksap.intern.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.worksap.intern.Entity.FinancialApplication;
import jp.co.worksap.intern.Entity.UserAccount;
import jp.co.worksap.intern.ServerProcess.ApplicationHandler;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PendingActivity extends Activity  {
	
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
		setContentView(R.layout.activity_pending);
		setTitle("Pending Application");
		
		new Thread(){
			@Override
			public void run() {
				List<FinancialApplication> pending = (new ApplicationHandler()).PendingApplication();
				
				ListView list = (ListView) findViewById(R.id.ListView01);
				List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		        for(int i=0;i<pending.size();i++)  
		        {  
		        	HashMap<String, Object> map = new HashMap<String, Object>();  
		            map.put("date", pending.get(i).GetDate());
		            map.put("title", pending.get(i).GetTitle());  
		            listItem.add(map);  
		        } 
		        
		        String[] stemp = {"date", "title" };
		        int[] itemp = {R.id.date, R.id.title};
		        SimpleAdapter listItemAdapter = new SimpleAdapter(PendingActivity.this, listItem, R.layout.listview_pending, stemp, itemp);
		         
		        list.setAdapter(listItemAdapter);  
		          
		        //添加点击  
		        list.setOnItemClickListener(new OnItemClickListener() {  
		  
		            @Override  
		            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
		                    long arg3) {  
		                  
		            }  
		        });  
				handler.sendEmptyMessage(0);
			}
		}.start();
	}
	
	/*protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		List<FinancialApplication> pending = (new ApplicationHandler()).PendingApplication();
		
		ListView list = (ListView) findViewById(R.id.ListView01);
		List<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<pending.size();i++)  
        {  
        	HashMap<String, Object> map = new HashMap<String, Object>();  
            map.put("date", pending.get(i).GetDate());
            map.put("title", pending.get(i).GetTitle());  
            listItem.add(map);  
        }  

        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, R.layout.listview_pending,       
            new String[] {"date", "title" },  
            new int[] {R.id.date, R.id.title}  
        );  
         
        list.setAdapter(listItemAdapter);  
          
        //click on item  
        list.setOnItemClickListener(new OnItemClickListener() {  
  
            @Override  
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
                    long arg3) {  
                setTitle("点击第"+arg2+"个项目");  
            }  
        });  
	}*/
}
