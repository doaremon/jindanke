package com.jindanke.fanjiadao_shanghu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.jindanke.App.BaseFragment;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.view.XListView;
import com.jindanke.view.XListView.IXListViewListener;
/**
 * 最新订单
 * @author jindanke
 *
 */
public class Fragment_Zuixindingdan extends BaseFragment implements IXListViewListener{
	private View view;

	private XListView showlist;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_zxdd, null);
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		showlist=(XListView) view.findViewById(R.id.showlist);
		showlist.setPullLoadEnable(false);
		showlist.setPullRefreshEnable(true);
		showlist.setXListViewListener(this);
		Myadapter adapter =new Myadapter();
		showlist.setAdapter(adapter);
	}
	public class Myadapter extends BaseAdapter{

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object getItem(int arg0) {
			return 3;
		}

		@Override
		public long getItemId(int arg0) {
			return 3;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			arg1=LayoutInflater.from(getActivity()).inflate(R.layout.dingdan_adapter, null);
			return arg1;
		}

	}
	@Override
	public void onRefresh() {

		Toast.makeText(getActivity(), "重新请求服务刷新", Toast.LENGTH_LONG).show();
		showlist.stopRefresh();
	}
	@Override
	public void onLoadMore() {

	}
}
