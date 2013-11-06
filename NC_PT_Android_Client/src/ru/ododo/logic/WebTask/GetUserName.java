package ru.ododo.logic.WebTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import ru.ododo.activities.SocialNetworkAuth;
import ru.ododo.logic.ParsingObject;
import ru.ododo.logic.Settings;
import ru.ododo.logic.SystemState.SysSinglton;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;


public class GetUserName extends AsyncTask<Void, Void, String> {
	
	String data ="";
	String jsonStr="";
	String fullUserName;
	String APIUrl;
	ProgressDialog pb;
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pb=SocialNetworkAuth.getPb();
		pb.setTitle("Get user name");
		pb.show();
	}
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		String userId=SysSinglton.getInstance().getUserId();
		
		APIUrl=Settings.VK_API_ADDRESS+Settings.VK_API_METHOD_NAME+
				Settings.VK_API_USER_ID+userId+Settings.VK_API_LANG;
		
		BufferedReader reader=null;
		try {
			URL url = new URL(APIUrl);
			
			//Send POST request
			URLConnection conn=url.openConnection();
			conn.setDoOutput(true); 
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush(); 
            
            // Get the server response
            
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
            {
                   // Append server response in string
                   sb.append(line + "");
            }
         
            // Append Server Response To Content String
            jsonStr = sb.toString();
            Log.d(Settings.MY_TAG, "JSON: "+jsonStr);
            fullUserName=ParsingObject.getFirstLastName(jsonStr);
            
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			fullUserName="";
		}
		finally
        {
            try
            {
  
                reader.close();
            }

            catch(Exception ex) {fullUserName="";}
        }
		return fullUserName;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		pb.cancel();
		SocialNetworkAuth.finishActivitySocialNetworkAuth();
	}

	
}
