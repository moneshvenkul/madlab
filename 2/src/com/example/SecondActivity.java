package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	TextView tv;
	String Value1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		tv=(TextView)findViewById(R.id.textView1);
		Intent in=getIntent();
		Value1=in.getStringExtra("Monesh");
		tv.setText("Welcome"+"\t"+Value1);
		
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle("My Notification")
		.setContentText("Hello");
		
		NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(001,mBuilder.build());
		
		WebView mywebview = (WebView) findViewById(R.id.webView1);  
		mywebview.loadUrl("https://www.google.co.in/");  
		
		Intent in1=new Intent(Intent.ACTION_SEND);
		in1.putExtra(Intent.EXTRA_EMAIL, "mvvenkul@gmail.com");
		in1.putExtra(Intent.EXTRA_SUBJECT, "sub");
		in1.putExtra(Intent.EXTRA_TEXT, "Hello");
		
		in1.setType("message/rfc822");
		startActivity(in.createChooser(in1, "Choose an email client..."));
		
		Toast.makeText(getApplicationContext(), "yeah!", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
