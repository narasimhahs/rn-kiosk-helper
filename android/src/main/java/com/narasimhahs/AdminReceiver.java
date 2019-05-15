package com.oynxapp;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import android.widget.Toast;

public class AdminReceiver extends DeviceAdminReceiver {

  @Override
  public void onEnabled(Context context, Intent intent) {
    Toast.makeText(context, "Device Admin Enabled", Toast.LENGTH_SHORT).show();
  }

  @Override
  public CharSequence onDisableRequested(Context context, Intent intent) {
    return "Warning: Device Admin is going to be disabled.";
  }

  @Override
  public void onDisabled(Context context, Intent intent) {
    Toast.makeText(context, "Device admin disabled", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onLockTaskModeEntering(Context context, Intent intent, String pkg) {
    Toast.makeText(context, "Kiosk Mode enabled", Toast.LENGTH_SHORT).show();
    DevicePolicyManager dpm = getManager(context);
    ComponentName admin = getWho(context);

    String[] restrictions = {
      UserManager.DISALLOW_FACTORY_RESET,
      UserManager.DISALLOW_SAFE_BOOT,
      UserManager.DISALLOW_MOUNT_PHYSICAL_MEDIA,
      UserManager.DISALLOW_ADJUST_VOLUME,
      UserManager.DISALLOW_ADD_USER,
      UserManager.DISALLOW_CREATE_WINDOWS};

    for (String restriction: restrictions) dpm.addUserRestriction(admin, restriction);

  }

  @Override
  public void onLockTaskModeExiting(Context context, Intent intent) {
    Toast.makeText(context, "Kiosk mode disabled", Toast.LENGTH_SHORT).show();

    DevicePolicyManager dpm = getManager(context);
    ComponentName admin = getWho(context);

    String[] restrictions = {
      UserManager.DISALLOW_FACTORY_RESET,
      UserManager.DISALLOW_SAFE_BOOT,
      UserManager.DISALLOW_MOUNT_PHYSICAL_MEDIA,
      UserManager.DISALLOW_ADJUST_VOLUME,
      UserManager.DISALLOW_ADD_USER,
      UserManager.DISALLOW_CREATE_WINDOWS};

    for (String restriction: restrictions) dpm.clearUserRestriction(admin, restriction);
  }
}
