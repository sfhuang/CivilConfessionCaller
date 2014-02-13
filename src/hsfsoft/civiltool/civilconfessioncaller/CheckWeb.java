package hsfsoft.civiltool.civilconfessioncaller;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class CheckWeb extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		WebView webView = (WebView)findViewById(R.id.webView);
		String locationURL="https://www.facebook.com/pages/馮光遠/277581822281583?fref=ts";
		webView.loadUrl(locationURL);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//    	menu.add(0, 1, 0,getResources().getString(R.string.reason));
    	menu.add(0, 0, 0,getResources().getString(R.string.about));
		return true;
    }
	
    //功能選單各項目內容設定
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    		case 0:
    			String app_ver="1.0";
    			try
    			{
    			    app_ver = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
    			}
    			catch (NameNotFoundException e)
    			{
    			    ;
    			}
    			
    			String dialogText = getResources().getString(R.string.AboutSection1)+
    					getResources().getString(R.string.app_name)+
    					getResources().getString(R.string.AboutSection2)+app_ver+
    					getResources().getString(R.string.AboutSection3);

    			new AlertDialog.Builder(this)
    	    	.setTitle(getResources().getString(R.string.about))
    	    	.setMessage(dialogText)
    	    	.setPositiveButton(getResources().getString(R.string.ok),null)
    	    	.show();    			
    			return true;
    		case 1:
    			new AlertDialog.Builder(this)
    	    	.setTitle(getResources().getString(R.string.reason))
    	    	.setMessage(getResources().getString(R.string.ReasonDetails))
    	    	.setPositiveButton(getResources().getString(R.string.ok),null)
    	    	.show();    			
    			return true;
    	}
		return false;
    	
    }

	

}
