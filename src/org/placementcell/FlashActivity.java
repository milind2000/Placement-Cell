package org.placementcell;
import android.content.Intent;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class FlashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
        File file = getApplicationContext().getDatabasePath("mydata.sqlite");
        if(!file.exists()){
        db.execSQL("create table login_tpo (id varchar(30)primary key, password varchar(30))");        
        db.execSQL("create table application (roll varchar(30) primary key,name varchar(30),cgpa float" +
        		",year varchar(30),gender varchar(10),companies varchar(30),contact int(10))");
        db.execSQL("create table info (cmp_name varchar(30) primary key,opening int,position varchar(100))");
        db.execSQL("create table register (roll varchar(30) primary key unique,name varchar(30),cmp varchar(200)" +
        		",gender varchar(10),dob varchar(10),city varchar(30),section varchar(5))");
      	db.execSQL("insert into login_tpo values ('milind' , 'abc')");
        db.close();       
        }
        
        TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(FlashActivity.this,LoginActivity.class));
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(tt, 2000);
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flash, menu);
        return true;
    }
    
}
