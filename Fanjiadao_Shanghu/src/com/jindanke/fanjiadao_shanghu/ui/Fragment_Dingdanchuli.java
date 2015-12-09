package com.jindanke.fanjiadao_shanghu.ui;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jindanke.App.BaseFragment;
import com.jindanke.App.MyAppContext;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.view.XListView;
import com.jindanke.view.XListView.IXListViewListener;
/**
 * 订单处理
 * @author jindanke
 *
 */
public class Fragment_Dingdanchuli extends BaseFragment implements OnClickListener,IXListViewListener{
	//下啦pop
	private TextView tv_title;
	private View view;
	
	private View popview;
	//title view
	private RelativeLayout rel_title;
	//全部订单
	private RelativeLayout rel_qb;
	//带配送订单
	private RelativeLayout rel_dps;
	//配送中订单
	private RelativeLayout rel_psz;
	//已确认订单
	private RelativeLayout rel_yqr;
	//取消订单
	private RelativeLayout rel_qx;

	private XListView showlist;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_ddcl, null);
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		tv_title=(TextView) view.findViewById(R.id.tv_title);
		tv_title.setOnClickListener(this);
		popview=LayoutInflater.from(getActivity()).inflate(R.layout.popview, null);

		rel_qb=(RelativeLayout) popview.findViewById(R.id.rel_qb);
		rel_dps=(RelativeLayout) popview.findViewById(R.id.rel_dps);
		rel_psz=(RelativeLayout) popview.findViewById(R.id.rel_psz);
		rel_yqr=(RelativeLayout) popview.findViewById(R.id.rel_yqr);
		rel_qx=(RelativeLayout) popview.findViewById(R.id.rel_qx);

		rel_qb.setOnClickListener(this);
		rel_dps.setOnClickListener(this);
		rel_psz.setOnClickListener(this);
		rel_yqr.setOnClickListener(this);
		rel_qx.setOnClickListener(this);

		showlist=(XListView) view.findViewById(R.id.ddcl_showlist);
		showlist.setPullLoadEnable(false);
		showlist.setPullRefreshEnable(true);
		showlist.setXListViewListener(this);
		Myadapter adapter =new Myadapter();
		showlist.setAdapter(adapter);


		rel_title=(RelativeLayout) view.findViewById(R.id.rel_title);
		MyAppContext.popupWindow=new PopupWindow(popview, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		//点击下啦pop
		case R.id.tv_title:
			if(MyAppContext.popupWindow.isShowing()){
				MyAppContext.popupWindow.dismiss();
			}else {
				MyAppContext.popupWindow.showAsDropDown(rel_title);
				String str=tv_title.getText().toString().trim();
				if("全部订单".equals(str)){
					rel_qb.setBackgroundColor(getResources().getColor(R.color.select_bac));
					rel_dps.setBackgroundColor(getResources().getColor(R.color.white));
					rel_psz.setBackgroundColor(getResources().getColor(R.color.white));
					rel_yqr.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qx.setBackgroundColor(getResources().getColor(R.color.white));
				}else if("待配送订单".equals(str)){
					rel_dps.setBackgroundColor(getResources().getColor(R.color.select_bac));
					rel_psz.setBackgroundColor(getResources().getColor(R.color.white));
					rel_yqr.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qx.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qb.setBackgroundColor(getResources().getColor(R.color.white));
				}
				else if("配送中订单".equals(str)){
					rel_psz.setBackgroundColor(getResources().getColor(R.color.select_bac));
					rel_yqr.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qx.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qb.setBackgroundColor(getResources().getColor(R.color.white));
					rel_dps.setBackgroundColor(getResources().getColor(R.color.white));
				}
				else if("用户已确认订单".equals(str)){
					rel_yqr.setBackgroundColor(getResources().getColor(R.color.select_bac));
					rel_qx.setBackgroundColor(getResources().getColor(R.color.white));
					rel_qb.setBackgroundColor(getResources().getColor(R.color.white));
					rel_dps.setBackgroundColor(getResources().getColor(R.color.white));
					rel_psz.setBackgroundColor(getResources().getColor(R.color.white));
				}
				else if("已取消订单".equals(str)){
					rel_qx.setBackgroundColor(getResources().getColor(R.color.select_bac));
					rel_qb.setBackgroundColor(getResources().getColor(R.color.white));
					rel_dps.setBackgroundColor(getResources().getColor(R.color.white));
					rel_psz.setBackgroundColor(getResources().getColor(R.color.white));
					rel_yqr.setBackgroundColor(getResources().getColor(R.color.white));
				}

			}
			break;
			//全部订单
		case R.id.rel_qb:
			tv_title.setText("全部订单");
			MyAppContext.popupWindow.dismiss();
			break;
			//待配送订单
		case R.id.rel_dps:
			tv_title.setText("待配送订单");
			MyAppContext.popupWindow.dismiss();
			break;
			//配送中订单
		case R.id.rel_psz:
			tv_title.setText("配送中订单");
			MyAppContext.popupWindow.dismiss();
			break;
			//已确认订单
		case R.id.rel_yqr:
			tv_title.setText("用户已确认订单");
			MyAppContext.popupWindow.dismiss();
			break;
			//取消订单
		case R.id.rel_qx:
			tv_title.setText("已取消订单");
			MyAppContext.popupWindow.dismiss();
			break;


		default:
			break;
		}		
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
}
