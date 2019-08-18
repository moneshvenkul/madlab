package com.example;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText editText1,editText2;
	private Button btn_add;
	private Button btn_sub;
	private Button btn_mul;
	private Button btn_div;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    
    public void addListenerOnButton(){
		// TODO Auto-generated method stub
    	editText1=(EditText)findViewById(R.id.editText1);
    	editText2=(EditText)findViewById(R.id.editText2);
    	btn_add=(Button)findViewById(R.id.button1); 
    	btn_sub=(Button)findViewById(R.id.button2); 
    	btn_mul=(Button)findViewById(R.id.button3); 
    	btn_div=(Button)findViewById(R.id.button4); 
    	
    	btn_add.setOnClickListener(new OnClickListener(){
    		
    		@SuppressLint({ "ShowToast", "UnlocalizedSms" }) @Override
    		public void onClick(View view)
    		{
    			String Value1=editText1.getText().toString();
    			String Value2=editText2.getText().toString();
    			int a = Integer.parseInt(Value1);
    			int b = Integer.parseInt(Value2);
    			int c=a+b;
    			Toast.makeText(getApplicationContext(),String.valueOf(c), Toast.LENGTH_LONG).show();
    			
    			if((a==4)&&(b==4))
    			{
    				Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_LONG).show();
    			}
    			
    			//Getting intent and PendingIntent instance  
    			Intent intent=new Intent(getApplicationContext(),MainActivity.class);  
    			PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
    			  
    			//Get the SmsManager instance and call the sendTextMessage method to send message                 
    			SmsManager sms=SmsManager.getDefault();  
    			sms.sendTextMessage("7989283721", null, "hello javatpoint", pi,null);  
    			Toast.makeText(getApplicationContext(), "sent", Toast.LENGTH_LONG).show();
    			
    			Intent in=new Intent(MainActivity.this,SecondActivity.class);
    			in.putExtra("Monesh",Value1);   			
    			startActivity(in);
    			
    			
    			
    		}

			

			
    	});
		
	}

	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
