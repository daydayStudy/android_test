package com.zhbit.lockscreen;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

	private DevicePolicyManager dpm;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
    }
    
    /**
     * 代码开启管理员
     * @param view
     */
    public void openAdmin(View view) {
    	Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
    	ComponentName deviceAdminSample = new ComponentName(this, MyAdim.class);
    	intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminSample);
    	intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "好处多多");
    	startActivity(intent);
    }

    /**
     * 一键锁屏
     * @param view
     */
    public void lockScreen(View view) {
    	dpm.lockNow();
    }
}
