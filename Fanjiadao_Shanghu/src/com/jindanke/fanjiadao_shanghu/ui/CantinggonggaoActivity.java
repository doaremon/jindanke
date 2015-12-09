package com.jindanke.fanjiadao_shanghu.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
/**
 * 餐厅公告
 * @author jindanke
 *
 */
public class CantinggonggaoActivity extends BaseActivity {

	private LinearLayout lay_fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cantinggonggao);
		findid();
	}
	private void findid() {
		lay_fanhui=(LinearLayout) findViewById(R.id.lay_fanhui);
		lay_fanhui.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
