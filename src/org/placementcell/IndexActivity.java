package org.placementcell;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class IndexActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);
		TabSpec tab1 = tabhost.newTabSpec("applications");
		tab1.setIndicator("Applications");
		tab1.setContent(new Intent(this,AppActivity.class));
		tabhost.addTab(tab1);
		TabSpec tab2 = tabhost.newTabSpec("Cmp");
		tab2.setIndicator("Company Name");
		tab2.setContent(new Intent(this,CmpActivity.class));
		tabhost.addTab(tab2);
		TabSpec tab3 = tabhost.newTabSpec("CmpReg");
		tab3.setIndicator("Register Company");
		tab3.setContent(new Intent(this,CmpRegActivity.class));
		tabhost.addTab(tab3);
	}
}
