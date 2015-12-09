package com.jindanke.fanjiadao_shanghu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.jindanke.App.BaseActivity;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.fanjiadao_shanghu.ui.Fragment_Dingdanchuli.Myadapter;
import com.jindanke.view.XListView;
import com.jindanke.view.XListView.IXListViewListener;
/**
 * 用户评价
 * @author jindanke
 *
 */
public class YonghupingjiaActivity extends BaseActivity implements IXListViewListener{
	//返回
	private LinearLayout lay_fanhui;
	//现实评价的listview
	private XListView showpingjia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yonghupingjia);
		findid();
	}
	private void findid() {
		lay_fanhui=(LinearLayout) findViewById(R.id.lay_fanhui);	
		showpingjia=(XListView) findViewById(R.id.showpingjia);
		showpingjia.setPullLoadEnable(false);
		showpingjia.setPullRefreshEnable(true);
		showpingjia.setXListViewListener(this);
		Myadapter adapter =new Myadapter();
		showpingjia.setAdapter(adapter);
		lay_fanhui.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();				
			}
		});
	}
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub

	}
	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub

	}

	public class Myadapter extends BaseAdapter{

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int arg0) {
			return 10;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			arg1=LayoutInflater.from(YonghupingjiaActivity.this).inflate(R.layout.adapter_yonghupingjia, null);
			return arg1;
		}

	}
}
