package com.jindanke.fanjiadao_shanghu.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
/**
 * 启动页面
 * 三秒后跳转到登陆
 *
 */
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	protected void onResume() {
		super.onResume();
		final Timer timer=new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Message message =new Message();
				message.obj=timer;
				handler.sendMessage(message);
			}
		}, 3000, 1000);
	}

	Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Timer timer=(Timer) msg.obj;
			timer.cancel();
			Intent intent=new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
		}};

}
