package com.jindanke.fanjiadao_shanghu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jindanke.App.BaseFragment;
import com.jindanke.fanjiadao_shanghu.R;
/**
 * 门店管理
 * @author jindanke
 *
 */
public class Fragment_Mendianguanli extends BaseFragment implements OnClickListener{
	private View view;
	//餐厅公告
	private LinearLayout cantinggonggao;
	//用户评价
	private LinearLayout lay_pingjia;
	//统计
	private LinearLayout lay_tongji;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_mdgl, null);
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		cantinggonggao=(LinearLayout) view.findViewById(R.id.cantinggonggao);
		lay_tongji=(LinearLayout) view.findViewById(R.id.lay_tongji);
		cantinggonggao.setOnClickListener(this);
		lay_tongji.setOnClickListener(this);
		lay_pingjia=(LinearLayout) view.findViewById(R.id.lay_pingjia);
		lay_pingjia.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		Intent intent;
		switch (arg0.getId()) {
		//餐厅公告
		case R.id.cantinggonggao:
			intent=new Intent(getActivity(), CantinggonggaoActivity.class);
			startActivity(intent);
			break;
			//用户评价
		case R.id.lay_pingjia:
			intent=new Intent(getActivity(), YonghupingjiaActivity.class);
			startActivity(intent);
			break;
			//统计
		case R.id.lay_tongji:
			intent=new Intent(getActivity(), TongjiActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
