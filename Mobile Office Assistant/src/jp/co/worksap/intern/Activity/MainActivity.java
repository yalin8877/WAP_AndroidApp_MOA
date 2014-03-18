package jp.co.worksap.intern.Activity;

import jp.co.worksap.intern.Activity.R;
import jp.co.worksap.intern.Entity.UserAccount;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(this);
		
		((Button)findViewById(R.id.button1)).setVisibility(setting.getBoolean("feature1", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button2)).setVisibility(setting.getBoolean("feature2", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button3)).setVisibility(setting.getBoolean("feature3", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button4)).setVisibility(setting.getBoolean("feature4", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button5)).setVisibility(setting.getBoolean("feature5", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button6)).setVisibility(setting.getBoolean("feature6", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button7)).setVisibility(setting.getBoolean("feature7", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button8)).setVisibility(setting.getBoolean("feature8", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button9)).setVisibility(setting.getBoolean("feature9", true) ? View.VISIBLE:View.GONE);*/
		String setting = (UserAccount.mAccountName.equals("manager") ? 
				UserAccount.mManagerSettings : UserAccount.mStaffSettings);
		((Button)findViewById(R.id.button1)).setVisibility(setting.charAt(0) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button2)).setVisibility(setting.charAt(1) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button3)).setVisibility(setting.charAt(2) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button4)).setVisibility(setting.charAt(3) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button5)).setVisibility(setting.charAt(4) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button6)).setVisibility(setting.charAt(5) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button7)).setVisibility(setting.charAt(6) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button8)).setVisibility(setting.charAt(7) == '1' ? View.VISIBLE:View.GONE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId() == R.id.action_settings){
			startActivity(new Intent(MainActivity.this, SettingActivity.class));
			return true;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		String setting = (UserAccount.mAccountName.equals("manager") ? 
				UserAccount.mManagerSettings : UserAccount.mStaffSettings);
		((Button)findViewById(R.id.button1)).setVisibility(setting.charAt(0) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button2)).setVisibility(setting.charAt(1) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button3)).setVisibility(setting.charAt(2) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button4)).setVisibility(setting.charAt(3) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button5)).setVisibility(setting.charAt(4) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button6)).setVisibility(setting.charAt(5) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button7)).setVisibility(setting.charAt(6) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button8)).setVisibility(setting.charAt(7) == '1' ? View.VISIBLE:View.GONE);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		String setting = (UserAccount.mAccountName.equals("manager") ? 
				UserAccount.mManagerSettings : UserAccount.mStaffSettings);
		((Button)findViewById(R.id.button1)).setVisibility(setting.charAt(0) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button2)).setVisibility(setting.charAt(1) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button3)).setVisibility(setting.charAt(2) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button4)).setVisibility(setting.charAt(3) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button5)).setVisibility(setting.charAt(4) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button6)).setVisibility(setting.charAt(5) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button7)).setVisibility(setting.charAt(6) == '1' ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button8)).setVisibility(setting.charAt(7) == '1' ? View.VISIBLE:View.GONE);
		
		/*SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(this);
		
		((Button)findViewById(R.id.button1)).setVisibility(setting.getBoolean("feature1", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button2)).setVisibility(setting.getBoolean("feature2", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button3)).setVisibility(setting.getBoolean("feature3", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button4)).setVisibility(setting.getBoolean("feature4", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button5)).setVisibility(setting.getBoolean("feature5", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button6)).setVisibility(setting.getBoolean("feature6", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button7)).setVisibility(setting.getBoolean("feature7", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button8)).setVisibility(setting.getBoolean("feature8", true) ? View.VISIBLE:View.GONE);
		((Button)findViewById(R.id.button9)).setVisibility(setting.getBoolean("feature9", true) ? View.VISIBLE:View.GONE);*/
	}

	public void onButtonClick(View v){
		int id = v.getId();
		
		switch(id){
		case R.id.button1:
			startActivity(new Intent(this, TranscationActivity.class));
			break;
		case R.id.button2:
			startActivity(new Intent(this, ApplyActivity.class));
			break;
		case R.id.button3:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button4:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button5:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button6:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button7:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button8:
			new AlertDialog.Builder(this).setTitle("Sorry!")
			.setIcon(android.R.drawable.ic_dialog_info).setMessage("Not implemented yet!")
			.setPositiveButton("OK", null).show();
			break;
		case R.id.button9:
			startActivity(new Intent(this, SettingActivity.class));
			break;
		}
	}
}
