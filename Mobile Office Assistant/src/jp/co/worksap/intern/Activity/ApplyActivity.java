package jp.co.worksap.intern.Activity;

import jp.co.worksap.intern.Activity.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

public class ApplyActivity extends Activity {
	String [] choices = new String[]{
			"Finance",
			"Human Resource",
			"Materials"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply);
	}
	
	public void onButtonClick(View v){
		int id = v.getId();
		
		switch(id){
		case R.id.new_application:
			Log.i("--->", "new");
			createDialog().show();
			break;
		case R.id.pending_application:
			Log.i("--->", "pending");
			startActivity(new Intent(ApplyActivity.this, PendingActivity.class));
			break;
		case R.id.view_history:
			Log.i("--->", "history");
			break;
		}
	}
	
	public Dialog createDialog(){
		 AlertDialog dialog = new AlertDialog.Builder(this)
         .setTitle("Apply For : ")  
         .setItems(choices, listener).create();  
		 
		 return dialog;
	}
	
	private DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){

		@Override
		public void onClick(DialogInterface dialog, int which) {
			if(which == 0){
				startActivity( new Intent(ApplyActivity.this, AplEditorActivity.class));
				finish();
			}
		}
		
	};
}
