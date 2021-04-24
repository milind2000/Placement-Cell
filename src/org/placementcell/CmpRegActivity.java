package org.placementcell;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CmpRegActivity extends Activity {
	EditText name,number,position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cmpreg);
		 name = (EditText)findViewById(R.id.cmpname);
		number = (EditText)findViewById(R.id.position);
		 position = (EditText)findViewById(R.id.pos);
		 
		 
		Button btn = (Button)findViewById(R.id.cmpregister);
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				String names = name.getText().toString(),numbers = number.getText().toString()
						,positions = position.getText().toString();
				SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
				db.execSQL("insert into info values('"+names+"','"+numbers+"','"+positions+"')");
				db.close();
				Toast.makeText(CmpRegActivity.this, "Company Registered Successfully", Toast.LENGTH_LONG).show();
			}
		});
	}
}
