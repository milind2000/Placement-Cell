package org.placementcell;

import java.util.ArrayList;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AppActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
			ListView lv=getListView();			
			SQLiteDatabase db=openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE, null);
			Cursor data=db.rawQuery("select * from register", null);
			
			ArrayList list=new ArrayList();
			while(data.moveToNext())
			{
			list.add("Roll : "+data.getString(0)+"  Name:  "+data.getString(1)+"  Interested in :  "+data.getString(2));	
			}
			
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
			lv.setAdapter(adapter);
	}
}
