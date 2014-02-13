package hsfsoft.civiltool.civilconfessioncaller;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button 	buttonCECTerminal,
			buttonCECCommissioner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonCECTerminal = (Button)findViewById(R.id.buttonCECTerminal);
		buttonCECCommissioner = (Button)findViewById(R.id.buttonCECCommissioner);
		
		buttonCECTerminal.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
    			Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0223565484"));
                startActivity(intent);
        	}
        });
		
		buttonCECCommissioner.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
    			Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0223565179"));
                startActivity(intent);
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 1, 0,getResources().getString(R.string.reason));
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
/*    			new AlertDialog.Builder(this)
    	    	.setTitle(getResources().getString(R.string.reason))
    	    	.setMessage(getResources().getString(R.string.ReasonDetails))
    	    	.setPositiveButton(getResources().getString(R.string.ok),null)
    	    	.show();*/
    			Intent intent = new Intent(MainActivity.this,CheckWeb.class);
    			startActivity(intent);
    			return true;
    	}
		return false;
    	
    }

	public void exitApp(View v){
		finish();
	}

}
