package com.jindanke.fanjiadao_shanghu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
/**
 * 登陆页面
 * @author jindanke
 *
 */
public class LoginActivity extends BaseActivity implements OnClickListener{
	//登陆按钮
	private Button bg_ogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findid();
	}
	private void findid() {
		bg_ogin=(Button) findViewById(R.id.bg_ogin);
		bg_ogin.setOnClickListener(this);

	}
	@Override
	protected void onResume() {
		super.onResume();
	}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bg_ogin:
			Intent intent=new Intent(LoginActivity.this,ShowMainActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}		
	}

}
