package org.placementcell;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	EditText rollNo,name,cmp;
	RadioGroup radiogroup;
	RadioButton male,female;
	DatePicker date;
	Spinner city;
	CheckBox a,b;
	Button register,clear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		rollNo = (EditText)findViewById(R.id.roll);
		name = (EditText)findViewById(R.id.name);
		cmp = (EditText)findViewById(R.id.cmp);
		radiogroup = (RadioGroup)findViewById(R.id.radiogroup);
		male = (RadioButton)findViewById(R.id.male);
		female = (RadioButton)findViewById(R.id.female);
		date = (DatePicker)findViewById(R.id.date);
		city = (Spinner)findViewById(R.id.city);
		a = (CheckBox)findViewById(R.id.a);
		b = (CheckBox)findViewById(R.id.b);
		register = (Button)findViewById(R.id.register);
		clear = (Button)findViewById(R.id.clear);
		
		String cityCollection[]= {"Indore","Mumbai","Bhopal","Delhi"};
		ArrayAdapter<String>data = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityCollection);
		city.setAdapter(data);
		
		register.setOnClickListener(	new android.view.View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				
				
				String roll = rollNo.getText().toString();
				String names = name.getText().toString();
				String comp = cmp.getText().toString();
				String gender = " ";
				if(radiogroup.getCheckedRadioButtonId()== R.id.female)gender = "female";
				else if (radiogroup.getCheckedRadioButtonId()== R.id.male) gender = "male";
				String dob = date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
				String cityn = (String)city.getSelectedItem();
				String section =" ";
				if(a.isSelected())section +="A";
				if(b.isSelected()) section +="B";
				SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
				db.execSQL("insert into register values('"+roll+"','"+names+"','"+comp+"','"+gender+"','"+dob+"'," +
						"'"+cityn+"','"+section+"')");
				db.close();
					Toast.makeText(RegisterActivity.this, "Application Successfully registered!", Toast.LENGTH_LONG).show();								
	}
		});
	}
}
