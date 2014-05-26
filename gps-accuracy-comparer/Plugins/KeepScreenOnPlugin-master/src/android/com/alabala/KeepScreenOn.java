package com.alabala;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
//import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.view.WindowManager;

public class KeepScreenOn extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		System.out.println("Im in the plugin");
		if (action.equalsIgnoreCase("KeepScreenOn")) {
			System.out.println("Start KeepScreenOn");
			cordova.getActivity().runOnUiThread(new Runnable() {
	            public void run() {
	            	cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    				System.out.println("Screen will be kept on. KeepScreenOn");
	            }
	        });
		return true;
     } else if (action.equalsIgnoreCase("alertIn")) {
                String message = args.getString(0);
                this.echo(message, callbackContext);
                return true;
                     
      } else if (action.equalsIgnoreCase("CancelKeepScreenOn")){
			System.out.println("CancelKeepScreenOn");
			cordova.getActivity().runOnUiThread(new Runnable() {
	            public void run() {
	            	cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	            	System.out.println("Screen will not be kept on. Cancel KeepScreenOn");
	            }
	        });
            //cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            //callbackContext.success(action);
            return true;
        } else {
			System.out.println("UNKNOWN");
			callbackContext.error("unknown action" + action);
            return false;
        }
	}
    
       private void echo(String message, CallbackContext callbackContext) {
            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Expected one non-empty string argument.");
            }
        }


}
