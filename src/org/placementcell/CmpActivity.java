package org.placementcell;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CmpActivity extends ListActivity {
	
	public CmpActivity(){
		ListView lv=getListView();			
		SQLiteDatabase db=openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE, null);
		Cursor data=db.rawQuery("select * from info", null);
		ArrayList list=new ArrayList();
		while(data.moveToNext())
		{
		list.add("Company Name: "+data.getString(0)+"  Positions:  "+data.getString(1)+"  Type : "+data.getString(2));	
		}
		db.close();
	ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
			new CmpActivity();
	}
}
