        package com.android;
        import org.apache.cordova.CordovaInterface;
        import org.apache.cordova.CallbackContext;
        import org.apache.cordova.CordovaPlugin;
        import org.apache.cordova.CordovaWebView;
        import android.content.Context;
        import android.telephony.TelephonyManager;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
		import java.util.HashMap;
		import com.alibaba.sdk.android.AppLinkService;
        import com.alibaba.sdk.android.BaseAlibabaSDK;
        import com.alibaba.sdk.android.callback.InitResultCallback;
		import android.util.Log;
		import android.widget.Toast;
        public class AliBaiChuan extends CordovaPlugin {
		private Context  context;
		AppLinkService link;
		
		@Override
        public void initialize(CordovaInterface cordova, CordovaWebView webView) {
              super.initialize(cordova, webView);
         
          context = this.cordova.getActivity().getApplicationContext();
		   BaseAlibabaSDK.asyncInit(context, new InitResultCallback() {

            @Override
            public void onFailure(int i, String s) {
                Log.d("faile","BaseAlibabaSDK init successed");
            }

            @Override
            public void onSuccess() {
                Log.e("success","BaseAlibabaSDK init failed");
            }
        });

          link = BaseAlibabaSDK.getService(AppLinkService.class);
		  
        }

		private boolean turnToAli(final JSONObject options, final CallbackContext callbackContext){
			String serviceName;
			String AliUrl ;
			String IsvCode;
			String keyPid;
			String backUrl;
			try{
				serviceName = options.getString("serviceName");
				AliUrl = options.getString("AliUrl");
			    IsvCode = options.getString("IsvCode");
			    keyPid = options.getString("keyPid");
				backUrl = options.getString("backUrl");
			}catch(JSONException e){
				
              return false;
			}
			 HashMap<String,String> params = new HashMap<String,String>();
                params.put(AppLinkService.PARAM_KEY_ISV_CODE,IsvCode);
                params.put(AppLinkService.PARAM_KEY_PID,keyPid);
                params.put(AppLinkService.PARAM_KEY_BACK_URL,backUrl);
				link.jumpTBURI(context,AliUrl,params);
				
				return true;
		}
		
		
		private boolean jumpToDetail(final JSONObject options, final CallbackContext callbackContext){
			String serviceName;
			String AliUrl ;
			String IsvCode;
			String keyPid;
			String backUrl;
			try{
				serviceName = options.getString("serviceName");
				AliUrl = options.getString("AliUrl");
			    IsvCode = options.getString("IsvCode");
			    keyPid = options.getString("keyPid");
				backUrl = options.getString("backUrl");
			}catch(JSONException e){
				
              return false;
			}
			 HashMap<String,String> params = new HashMap<String,String>();
                params.put(AppLinkService.PARAM_KEY_ISV_CODE,IsvCode);
                params.put(AppLinkService.PARAM_KEY_PID,keyPid);
                params.put(AppLinkService.PARAM_KEY_BACK_URL,backUrl);
				link.jumpDetail(context,AliUrl,params);
				
				return true;
		}
		
		private boolean jumpToShop(final JSONObject options, final CallbackContext callbackContext){
			String serviceName;
			String AliUrl ;
			String IsvCode;
			String keyPid;
			String backUrl;
			try{
				serviceName = options.getString("serviceName");
				AliUrl = options.getString("AliUrl");
			    IsvCode = options.getString("IsvCode");
			    keyPid = options.getString("keyPid");
				backUrl = options.getString("backUrl");
			}catch(JSONException e){
				
              return false;
			}
			 HashMap<String,String> params = new HashMap<String,String>();
                params.put(AppLinkService.PARAM_KEY_ISV_CODE,IsvCode);
                params.put(AppLinkService.PARAM_KEY_PID,keyPid);
                params.put(AppLinkService.PARAM_KEY_BACK_URL,backUrl);
				link.jumpShop(context,AliUrl,params);
				
				return true;
		}
		
        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
          
            JSONObject options;
        try {
            options = args.getJSONObject(0);
          
        } catch (JSONException e) {
           
            return false;
        }
        if (action.equals("jumpToURL")) {
			
            turnToAli(options, callbackContext);
            return true;
        } else if(action.equals("jumpToDetail")){
			jumpToDetail(options,callbackContext);
			return true;
		}else if(action.equals("jumpToShop")){
			jumpToShop(options,callbackContext);
			return true;
		}
        return false;
        }
        }
        