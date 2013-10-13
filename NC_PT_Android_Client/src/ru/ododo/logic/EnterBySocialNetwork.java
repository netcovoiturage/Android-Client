package ru.ododo.logic;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;

public class EnterBySocialNetwork {
	
	static String url;
	static String SocialNetwork;
	//заходим в систему
	public static void enterInSystem(WebView webview, String nameOfSocialNetwork){
		SocialNetwork=nameOfSocialNetwork;
		if(SocialNetwork.equalsIgnoreCase("_VK")){
			enterByVk(webview);
		}
	}
	
	private static void enterByVk(WebView webview){
		
        webview.setVerticalScrollBarEnabled(false);
        webview.setHorizontalScrollBarEnabled(false);
        webview.clearCache(true);
      
        //Чтобы получать уведомления об окончании загрузки страницы
        webview.setWebViewClient(new WebViewClient());
        
        url=Settings.VK_AUTH_URL+Settings.VK_CLINT_ID+Settings.VK_REDIRECT_URL+Settings.VK_SCOPE+
        		Settings.VK_DISPLAY+Settings.VK_RESPONSE_TYPE;
        webview.loadUrl(url);
        webview.setVisibility(View.VISIBLE);
        
	}
	
	private static void enterByFb(){
		
	}
}

class WebViewClient extends android.webkit.WebViewClient{

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		// TODO Auto-generated method stub
		super.onPageStarted(view, url, favicon);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
