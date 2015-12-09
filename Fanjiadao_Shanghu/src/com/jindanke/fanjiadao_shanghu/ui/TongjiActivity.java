package com.jindanke.fanjiadao_shanghu.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.utils.CalendarView;
import com.jindanke.utils.CalendarView.OnItemClickListener;
/**
 * 营业统计
 * @author jindanke
 *
 */
public class TongjiActivity extends BaseActivity  implements OnClickListener{
	private LinearLayout fanhui;

	private CalendarView calendar;
	private LinearLayout calendarLeft;
	private TextView calendarCenter;
	private LinearLayout calendarRight;
	private SimpleDateFormat format;

	private TextView mouth_right;
	private TextView mouth_left;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tongji);
		findid();
	}
	private void findid() {
		fanhui=(LinearLayout) findViewById(R.id.fanhui);
		fanhui.setOnClickListener(this);
		mouth_right=(TextView) findViewById(R.id.mouth_right);
		mouth_left=(TextView) findViewById(R.id.mouth_left);
		Log.i("chenghao", "-------");
		format = new SimpleDateFormat("yyyy-MM-dd");
		//获取日历控件对象
		calendar = (CalendarView)findViewById(R.id.calendar);
		calendar.setSelectMore(false); //单选  

		calendarLeft = (LinearLayout)findViewById(R.id.calendarLeft);
		calendarCenter = (TextView)findViewById(R.id.calendarCenter);
		calendarRight = (LinearLayout)findViewById(R.id.calendarRight);
		try {
			//设置日历日期
			Date date = format.parse("2015-01-01");
			calendar.setCalendarData(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获取日历中年月 ya[0]为年，ya[1]为月（格式大家可以自行在日历控件中改）
		String[] ya = calendar.getYearAndmonth().split("-"); 
		calendarCenter.setText(ya[0]+"年"+ya[1]+"月");
		int mouth=Integer.parseInt(ya[1]);
		mouth_left.setText((mouth-1)+"月");
		mouth_right.setText((mouth+1)+"月");

		calendarLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//点击上一月 同样返回年月 
				String leftYearAndmonth = calendar.clickLeftMonth(); 
				String[] ya = leftYearAndmonth.split("-"); 
				calendarCenter.setText(ya[0]+"年"+ya[1]+"月");
				int mouth=Integer.parseInt(ya[1]);
				if((mouth-1)==0){
					mouth_left.setText("12月");
				}else {
					mouth_left.setText((mouth-1)+"月");
				}
				if((mouth+1)==13){
					mouth_right.setText("1月");
				}else {
					mouth_right.setText((mouth+1)+"月");
				}


			}
		});
		calendarRight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//点击下一月
				String rightYearAndmonth = calendar.clickRightMonth();
				String[] ya = rightYearAndmonth.split("-"); 
				calendarCenter.setText(ya[0]+"年"+ya[1]+"月");
				int mouth=Integer.parseInt(ya[1]);
				if((mouth-1)==0){
					mouth_left.setText("12月");
				}else {
					mouth_left.setText((mouth-1)+"月");
				}
				if((mouth+1)==13){
					mouth_right.setText("1月");
				}else {
					mouth_right.setText((mouth+1)+"月");
				}
			}
		});
		//设置控件监听，可以监听到点击的每一天（大家也可以在控件中根据需求设定）
		calendar.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void OnItemClick(Date selectedStartDate,
					Date selectedEndDate, Date downDate) {
				if(calendar.isSelectMore()){
					Toast.makeText(getApplicationContext(), format.format(selectedStartDate)+"到"+format.format(selectedEndDate), Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(getApplicationContext(), format.format(downDate), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.fanhui:
			finish();
			break;

		default:
			break;
		}		
	}
}
