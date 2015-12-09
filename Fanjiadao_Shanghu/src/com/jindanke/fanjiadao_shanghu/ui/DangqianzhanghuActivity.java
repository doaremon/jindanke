package com.jindanke.fanjiadao_shanghu.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;

/**
 * 当前账户
 * 
 * @author jindanke
 * 
 */
public class DangqianzhanghuActivity extends BaseActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_dangqianzhanghu);
    	settitile("当前账户");
    }
	private void settitile(String string) {
		TextView textView=(TextView) findViewById(R.id.title_name);		
		textView.setText(string);
		LinearLayout lay_fanhui=(LinearLayout) findViewById(R.id.lay_fanhui);
		lay_fanhui.setVisibility(View.VISIBLE);
		lay_fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				     finish();
			}
		});
	}
}
