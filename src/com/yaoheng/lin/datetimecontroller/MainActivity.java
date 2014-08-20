package com.yaoheng.lin.datetimecontroller;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	EditText editText_customTime = null;
	TextView textView_curDateTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText_customTime = (EditText)findViewById(R.id.editText_customTime);
        textView_curDateTime = (TextView)findViewById(R.id.textView_curDateTime);
        
        displayCurDateTime(new Date().toString());
        
        startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void fastClickHandler(View v)
    {
    	Object tag = v.getTag();
    	setNewTime(tag.toString());
    }
    
    public void customSetHandler(View v)
    {
    	String timeStr = editText_customTime.getText().toString();
    	setNewTime(timeStr);
    }
    
    private void setNewTime(String str)
    {
    	if (str == null)
    	{
    		return;
    	}
    	startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
    	
//    	if (str.length() == 0)
//    	{
//    		return;
//    	}
//    	
//    	displayCurDateTime("正在设置 " + str);
//    	
//    	long mins = 0;
//    	String num = str.substring(0, str.length() - 1);
//    	if (str.endsWith("d"))
//    	{
//    		mins += (toInt(num) * 24 * 60);
//    	}
//    	if (str.endsWith("h"))
//    	{
//    		mins += (toInt(num) * 60);
//    	}
//    	else if (str.endsWith("m"))
//    	{
//    		mins += (toInt(num));
//    	}
//    	
//    	long newTiemMillis = System.currentTimeMillis() + mins * 60 * 1000;
//    	System.out.println(newTiemMillis);
    }
    
    private int toInt(String str)
    {
    	int a = 0;
    	try
    	{
    		a = Integer.parseInt(str, 10);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return a;
    }
    
    private void displayCurDateTime(String str)
    {
    	textView_curDateTime.setText(str);
    }
    
}
