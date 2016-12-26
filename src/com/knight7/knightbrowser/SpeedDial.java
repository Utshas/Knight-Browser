package com.knight7.knightbrowser;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SpeedDial extends Activity {
	ListView list;
	ArrayList<String>aeng;
	ArrayAdapter<String>adeng;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speed_dial);
		list=(ListView)findViewById(R.id.listView1);
		aeng=new ArrayList<String>();
		
		aeng.add("Facebook");
		aeng.add("Gmail");
		aeng.add("Yahoo mail");
		aeng.add("Cric Info");
		aeng.add("Goal");
		aeng.add("Newspapers");
		aeng.add("Home");
		
		adeng=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, aeng);
		list.setAdapter(adeng);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_LONG).show();
				if(arg2==0)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "m.facebook.com");
					startActivity(intabt);
				}
				if(arg2==1)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "mail.google.com");
					startActivity(intabt);
				}
				if(arg2==2)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "mail.yahoo.com");
					startActivity(intabt);
				}
				if(arg2==3)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "www.espn cricinfo.com");
					startActivity(intabt);
				}
				if(arg2==4)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "m.goal.com");
					startActivity(intabt);
				}
				if(arg2==5)
				{
					Intent intabt=new Intent(SpeedDial.this,SpeedView.class);
					intabt.putExtra("a", "www.24livenewspaper.com");
					startActivity(intabt);
				}
				if(arg2==6)
				{
					Intent intabt=new Intent(SpeedDial.this,MainActivity.class);
					startActivity(intabt);
				}
				
			}
		});}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speed_dial, menu);
		return true;
	}

}
