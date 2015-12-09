package com.jindanke.fanjiadao_shanghu.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jindanke.App.BaseActivity;
import com.jindanke.App.MyAppContext;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.utils.ShareUtil;
/**
 * 显示首页
 * @author jindanke
 *
 */
public class ShowMainActivity extends BaseActivity implements OnClickListener{
	//设置按钮
	private LinearLayout lay_shezhi;
	//门店管理
	private LinearLayout lay_mendianguanli;
	//订单处理
	private LinearLayout lay_dingdanchuli;
	//最新订单
	private LinearLayout lay_zuixindingdan;
	//子img
	private ImageView img_zxdd,img_ddcl,img_mdgl,img_sz;
	//子tv
	private TextView tv_zxdd,tv_ddcl,tv_mdgl,tv_sz;

	private int tag;

	private FrameLayout showfragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvitiy_showmain);
		findid();
		//默认现实第一个页面， tag＝0
		tag=0;

		//默认加载订单页面
		FragmentTransaction transaction=getFragmentManager().beginTransaction();
		transaction.replace(R.id.showfragment, new Fragment_Zuixindingdan());
		transaction.commit();
		//在这里得下用户现在的营业状态
		String type=ShareUtil.getstringvalue(ShowMainActivity.this, "showtype");
		if("-1".equals(type)){
			//证明这里没有保存值，先请求服务器给他保存一个未营业状态  0 未营业  1营业
			ShareUtil.setstringvalue(ShowMainActivity.this, "showtype", "0");
		}
	}

	private void findid() {
		showfragment=(FrameLayout) findViewById(R.id.showfragment);


		img_zxdd=(ImageView) findViewById(R.id.img_zxdd);
		img_ddcl=(ImageView) findViewById(R.id.img_ddcl);
		img_mdgl=(ImageView) findViewById(R.id.img_mdgl);
		img_sz=(ImageView) findViewById(R.id.img_sz);

		tv_zxdd=(TextView) findViewById(R.id.tv_zxdd);
		tv_ddcl=(TextView) findViewById(R.id.tv_ddcl);
		tv_mdgl=(TextView) findViewById(R.id.tv_mdgl);
		tv_sz=(TextView) findViewById(R.id.tv_sz);



		lay_shezhi=(LinearLayout) findViewById(R.id.lay_shezhi);
		lay_mendianguanli=(LinearLayout) findViewById(R.id.lay_mendianguanli);
		lay_dingdanchuli=(LinearLayout) findViewById(R.id.lay_dingdanchuli);
		lay_zuixindingdan=(LinearLayout) findViewById(R.id.lay_zuixindingdan);
		lay_shezhi.setOnClickListener(this);
		lay_mendianguanli.setOnClickListener(this);
		lay_dingdanchuli.setOnClickListener(this);
		lay_zuixindingdan.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		//最新订单
		case R.id.lay_zuixindingdan:
			if(tag!=0){
				showzuixindingdan();
				FragmentTransaction transaction=getFragmentManager().beginTransaction();
				transaction.replace(R.id.showfragment, new Fragment_Zuixindingdan());
				transaction.commit();
				tag=0;
			}
			if(MyAppContext.popupWindow!=null){
				if(MyAppContext.popupWindow.isShowing()){
					MyAppContext.popupWindow.dismiss();
				}
			}
			break;
			//订单处理
		case R.id.lay_dingdanchuli:
			if(tag!=1){
				showdingdanchuli();
				FragmentTransaction transaction=getFragmentManager().beginTransaction();
				transaction.replace(R.id.showfragment, new Fragment_Dingdanchuli());
				transaction.commit();
				tag=1;
			}
			if(MyAppContext.popupWindow!=null){
				if(MyAppContext.popupWindow.isShowing()){
					MyAppContext.popupWindow.dismiss();
				}
			}
			break;
			//门店管理
		case R.id.lay_mendianguanli:
			if(tag!=2){
				showmendianguanli();
				FragmentTransaction transaction=getFragmentManager().beginTransaction();
				transaction.replace(R.id.showfragment, new Fragment_Mendianguanli());
				transaction.commit();
				tag=2;
			}
			if(MyAppContext.popupWindow!=null){
				if(MyAppContext.popupWindow.isShowing()){
					MyAppContext.popupWindow.dismiss();
				}
			}
			break;
			//设置
		case R.id.lay_shezhi:
			if(tag!=3){
				showshezhi();
				FragmentTransaction transaction=getFragmentManager().beginTransaction();
				transaction.replace(R.id.showfragment, new Fragment_Shezhi());
				transaction.commit();
				tag=3;
			}
			if(MyAppContext.popupWindow!=null){
				if(MyAppContext.popupWindow.isShowing()){
					MyAppContext.popupWindow.dismiss();
				}
			}
			break;

		default:
			break;
		}		
	}

	private void showshezhi() {
		img_zxdd.setBackgroundResource(R.drawable.zuixindingdan_f);
		tv_zxdd.setTextColor(getResources().getColor((R.color.black)));

		img_ddcl.setBackgroundResource(R.drawable.dingdanchulu_f);
		tv_ddcl.setTextColor(getResources().getColor((R.color.black)));

		img_mdgl.setBackgroundResource(R.drawable.mendianguanli_f);
		tv_mdgl.setTextColor(getResources().getColor((R.color.black)));

		img_sz.setBackgroundResource(R.drawable.shezhi_t);
		tv_sz.setTextColor(getResources().getColor((R.color.org)));

	}

	private void showmendianguanli() {
		img_zxdd.setBackgroundResource(R.drawable.zuixindingdan_f);
		tv_zxdd.setTextColor(getResources().getColor(R.color.black));

		img_ddcl.setBackgroundResource(R.drawable.dingdanchulu_f);
		tv_ddcl.setTextColor(getResources().getColor(R.color.black));

		img_mdgl.setBackgroundResource(R.drawable.mendianguanli_t);
		tv_mdgl.setTextColor(getResources().getColor(R.color.org));

		img_sz.setBackgroundResource(R.drawable.shezhi_f);
		tv_sz.setTextColor(getResources().getColor(R.color.black));

	}

	private void showdingdanchuli() {
		img_zxdd.setBackgroundResource(R.drawable.zuixindingdan_f);
		tv_zxdd.setTextColor(getResources().getColor(R.color.black));

		img_ddcl.setBackgroundResource(R.drawable.dingdanchuli_t);
		tv_ddcl.setTextColor(getResources().getColor(R.color.org));

		img_mdgl.setBackgroundResource(R.drawable.mendianguanli_f);
		tv_mdgl.setTextColor(getResources().getColor(R.color.black));

		img_sz.setBackgroundResource(R.drawable.shezhi_f);
		tv_sz.setTextColor(getResources().getColor(R.color.black));

	}

	private void showzuixindingdan() {
		img_zxdd.setBackgroundResource(R.drawable.zuixindingdan_t);
		tv_zxdd.setTextColor(getResources().getColor(R.color.org));

		img_ddcl.setBackgroundResource(R.drawable.dingdanchulu_f);
		tv_ddcl.setTextColor(getResources().getColor(R.color.black));

		img_mdgl.setBackgroundResource(R.drawable.mendianguanli_f);
		tv_mdgl.setTextColor(getResources().getColor(R.color.black));

		img_sz.setBackgroundResource(R.drawable.shezhi_f);
		tv_sz.setTextColor(getResources().getColor(R.color.black));

	}
}
