package com.test.serviceplugin;
import android.content.Intent;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ServicePlugin extends CordovaPlugin {
    private Intent intent;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startService")) {
            if (intent == null)
              intent = new Intent(cordova.getActivity().getApplicationContext(),MyService.class);
            else
              MyService.flag=true;
            cordova.getActivity().getApplicationContext().startService(intent);
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else if (action.equals("stopService")){
            MyService.flag=false;
            cordova.getActivity().getApplicationContext().stopService(intent);
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }
    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}