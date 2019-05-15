
package com.narasimhahs;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNKioskHelperModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNKioskHelperModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNKioskHelper";
    }

    @ReactMethod
    public void clearDeviceOwnerApp() {
        try {
            Activity mActivity = reactContext.getCurrentActivity();
            if (mActivity != null) {
                DevicePolicyManager myDevicePolicyManager = (DevicePolicyManager) mActivity.getSystemService(Context.DEVICE_POLICY_SERVICE);
                myDevicePolicyManager.clearDeviceOwnerApp(mActivity.getPackageName());
            }
        } catch (Exception e) {
            Log.e("KioskHelper", e.getMessage());
        }
    }

    @ReactMethod
    public void startLockTask() {
        try {
            Activity mActivity = reactContext.getCurrentActivity();
            if (mActivity != null) {
                DevicePolicyManager myDevicePolicyManager = (DevicePolicyManager) mActivity.getSystemService(Context.DEVICE_POLICY_SERVICE);
                ComponentName mDPM = new ComponentName(mActivity, AdminReceiver.class);

                if (myDevicePolicyManager.isDeviceOwnerApp(mActivity.getPackageName())) {
                    String[] packages = {mActivity.getPackageName()};
                    myDevicePolicyManager.setLockTaskPackages(mDPM, packages);
                    mActivity.startLockTask();
                } else {
                    Log.e("KioskHelper", "Could not start lock task");
                }
            }
        } catch (Exception e) {
            Log.e("KioskHelper", e.getMessage());
        }
    }

    @ReactMethod
    public void stopLockTask() {
        try {
            Activity mActivity = reactContext.getCurrentActivity();
            if (mActivity != null) {
                mActivity.stopLockTask();
            }
        } catch (Exception e) {
            Log.e("KioskHelper", e.getMessage());
        }
    }
}