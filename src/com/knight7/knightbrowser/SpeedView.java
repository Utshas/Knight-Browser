package com.knight7.knightbrowser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SpeedView extends Activity implements OnClickListener{
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	EditText e;
	String s;
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speed_view);
		s=getIntent().getExtras().getString("a");
		wv=(WebView)findViewById(R.id.webView1);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setLoadWithOverviewMode(true);
		wv.getSettings().setUseWideViewPort(true);
		wv.setWebViewClient(new ViewClient());
		wv.loadUrl("http://"+s);
		b1=(Button)findViewById(R.id.go);
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);
		b2=(Button)findViewById(R.id.b2);
		b8=(Button)findViewById(R.id.b8);
		b7=(Button)findViewById(R.id.b7);
		b6=(Button)findViewById(R.id.b6);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		e=(EditText)findViewById(R.id.eadd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speed_view, menu);
		return true;
	}

	public void goAddt(String i)
	{
		wv.loadUrl("http://"+i);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.go)
		{
			String address=e.getText().toString();
			goAddt(address);
			InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(e.getWindowToken(),0);
			Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();

		}
		else if(v.getId()==R.id.b2)
		{
			if(wv.canGoBack())
			{
				wv.goBack();
				Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(getApplicationContext(), "No more pages", Toast.LENGTH_SHORT).show();

		}
		else if(v.getId()==R.id.b3)
		{
			if(wv.canGoForward())
			{
				wv.goForward();
				Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();
			}
			else
			Toast.makeText(getApplicationContext(), "No more pages", Toast.LENGTH_SHORT).show();

		}
		else if(v.getId()==R.id.b4)
		{
			Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT).show();
			wv.reload();
			
		}
		else if(v.getId()==R.id.b6)
		{
			Intent intent=new Intent(SpeedView.this, MainActivity.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.b7)
		{
			Intent intent=new Intent(SpeedView.this,SpeedDial.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.b8)
		{
			System.exit(0);
		}
		else
		{
			wv.clearHistory();
			Toast.makeText(getApplicationContext(), "History cleared", Toast.LENGTH_SHORT).show();
		}
	}

}
