package jp.co.worksap.intern.Activity;

import jp.co.worksap.intern.Activity.R;
import jp.co.worksap.intern.Entity.UserAccount;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class SettingActivity extends Activity {
	private SharedPreferences setting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		//setting = PreferenceManager.getDefaultSharedPreferences(this);
		String setting = (UserAccount.mAccountName.equals("manager") ? 
				UserAccount.mManagerSettings : UserAccount.mStaffSettings);
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				((CheckBox)findViewById(R.id.checkBox1)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 1:
				((CheckBox)findViewById(R.id.checkBox2)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 2:
				((CheckBox)findViewById(R.id.checkBox3)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 3:
				((CheckBox)findViewById(R.id.checkBox4)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 4:
				((CheckBox)findViewById(R.id.checkBox5)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 5:
				((CheckBox)findViewById(R.id.checkBox6)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 6:
				((CheckBox)findViewById(R.id.checkBox7)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 7:
				((CheckBox)findViewById(R.id.checkBox8)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			}
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		/*SharedPreferences.Editor editor = setting.edit();
		
		editor.putBoolean("feature1", ((CheckBox)findViewById(R.id.checkBox1)).isChecked());
		editor.putBoolean("feature2", ((CheckBox)findViewById(R.id.checkBox2)).isChecked());
		editor.putBoolean("feature3", ((CheckBox)findViewById(R.id.checkBox3)).isChecked());
		editor.putBoolean("feature4", ((CheckBox)findViewById(R.id.checkBox4)).isChecked());
		editor.putBoolean("feature5", ((CheckBox)findViewById(R.id.checkBox5)).isChecked());
		editor.putBoolean("feature6", ((CheckBox)findViewById(R.id.checkBox6)).isChecked());
		editor.putBoolean("feature7", ((CheckBox)findViewById(R.id.checkBox7)).isChecked());
		editor.putBoolean("feature8", ((CheckBox)findViewById(R.id.checkBox8)).isChecked());
		
		editor.commit();*/
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		String setting = (UserAccount.mAccountName.equals("manager") ? 
				UserAccount.mManagerSettings : UserAccount.mStaffSettings);
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				((CheckBox)findViewById(R.id.checkBox1)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 1:
				((CheckBox)findViewById(R.id.checkBox2)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 2:
				((CheckBox)findViewById(R.id.checkBox3)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 3:
				((CheckBox)findViewById(R.id.checkBox4)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 4:
				((CheckBox)findViewById(R.id.checkBox5)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 5:
				((CheckBox)findViewById(R.id.checkBox6)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 6:
				((CheckBox)findViewById(R.id.checkBox7)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			case 7:
				((CheckBox)findViewById(R.id.checkBox8)).setChecked(setting.charAt(i) == '1' ? true : false);
				break;
			}
		}
		
		/*((CheckBox)findViewById(R.id.checkBox1)).setChecked( setting.getBoolean("feature1", true) );
		((CheckBox)findViewById(R.id.checkBox2)).setChecked( setting.getBoolean("feature2", true) );
		((CheckBox)findViewById(R.id.checkBox3)).setChecked( setting.getBoolean("feature3", true) );
		((CheckBox)findViewById(R.id.checkBox4)).setChecked( setting.getBoolean("feature4", true) );
		((CheckBox)findViewById(R.id.checkBox5)).setChecked( setting.getBoolean("feature5", true) );
		((CheckBox)findViewById(R.id.checkBox6)).setChecked( setting.getBoolean("feature6", true) );
		((CheckBox)findViewById(R.id.checkBox7)).setChecked( setting.getBoolean("feature7", true) );
		((CheckBox)findViewById(R.id.checkBox8)).setChecked( setting.getBoolean("feature8", true) );*/
	}

	public void onButtonClick(View v) {
		int id = v.getId();
		
		switch(id){
		case R.id.save:
			String setting = "";
			setting += (((CheckBox)findViewById(R.id.checkBox1)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox2)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox3)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox4)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox5)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox6)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox7)).isChecked()) ? "1" : "0";
			setting += (((CheckBox)findViewById(R.id.checkBox8)).isChecked()) ? "1" : "0";
			if (UserAccount.mAccountName.equals("manager")) {
				UserAccount.mManagerSettings = setting;
			}
			else {
				UserAccount.mStaffSettings = setting;
			}
			setContentView(R.layout.activity_main);
			finish();
			break;
		case R.id.logout:
			startActivity( new Intent(SettingActivity.this, LoginActivity.class));
			System.exit(0);
			break;
		}
	}
}
