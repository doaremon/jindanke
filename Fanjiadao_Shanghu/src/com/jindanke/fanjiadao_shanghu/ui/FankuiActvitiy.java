package com.jindanke.fanjiadao_shanghu.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
/**
 * 反馈
 * @author jindanke
 *
 */
public class FankuiActvitiy extends BaseActivity {
	private LinearLayout lay_fanhui;
	private TextView title_name;
	private TextView sub;
	
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_fankui);
    	lay_fanhui=(LinearLayout) findViewById(R.id.lay_fanhui);
    	title_name=(TextView) findViewById(R.id.title_name);
    	sub=(TextView) findViewById(R.id.sub);
    	sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(FankuiActvitiy.this, "提交成功", Toast.LENGTH_LONG).show();
				finish();
			}
		});
    	title_name.setText("反馈");
    	lay_fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
                  			finish();	
			}
		});
    	
    	
    }
}
