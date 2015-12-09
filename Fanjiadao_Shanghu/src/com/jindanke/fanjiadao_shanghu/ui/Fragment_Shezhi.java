package com.jindanke.fanjiadao_shanghu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jindanke.App.BaseFragment;
import com.jindanke.fanjiadao_shanghu.R;
import com.jindanke.utils.ShareUtil;
/**
 * 设置
 * @author jindanke
 *
 */
public class Fragment_Shezhi extends BaseFragment implements OnClickListener{
	private View view;
	//当前账号
	private RelativeLayout dangqianzhanghao;
	//当前版本
	private RelativeLayout version;
	//反馈
	private RelativeLayout fankui;
	//退出
	private RelativeLayout gofinish;
	//营业状态
	private TextView textViewtype;
	//营业状态图片
	private ImageView showtype;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_sz, null);
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();
		findid();
		settitile("设置");
	}
	private void settitile(String string) {
		TextView textView=(TextView) view.findViewById(R.id.title_name);		
		textView.setText(string);
		LinearLayout lay_fanhui=(LinearLayout) view.findViewById(R.id.lay_fanhui);
		lay_fanhui.setVisibility(View.GONE);
		lay_fanhui.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			}
		});
	}
	private void findid() {
		dangqianzhanghao=(RelativeLayout) view.findViewById(R.id.dangqianzhanghao);
		fankui=(RelativeLayout) view.findViewById(R.id.fankui);
		version=(RelativeLayout) view.findViewById(R.id.version);
		gofinish=(RelativeLayout) view.findViewById(R.id.gofinish);
		dangqianzhanghao.setOnClickListener(this);
		fankui.setOnClickListener(this);
		version.setOnClickListener(this);
		gofinish.setOnClickListener(this);
		textViewtype=(TextView) view.findViewById(R.id.textViewtype);
		showtype=(ImageView) view.findViewById(R.id.showtype);
		showtype.setOnClickListener(this);
		//这里需要进行判断了，现实在线还是离线
		String type=ShareUtil.getstringvalue(getActivity(), "showtype");
		if("0".equals(type)){
			showzanting();
		}else if("1".equals(type)){
			showzaixian();
		}

	}

	public void showzaixian(){
		textViewtype.setText("营业中");
		showtype.setBackgroundResource(R.drawable.handle_01);
	}

	public void showzanting(){
		textViewtype.setText("暂停营业");
		showtype.setBackgroundResource(R.drawable.handle);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		//跳转当前账号
		case R.id.dangqianzhanghao:
			Intent intent=new Intent(getActivity(), DangqianzhanghuActivity.class);
			startActivity(intent);
			break;

		case R.id.showtype:
			String but_type=ShareUtil.getstringvalue(getActivity(), "showtype");
			//如果当前是0的话，证明现在是未营业，则变为营业
			if("0".equals(but_type)){
				//请求服务器，让他营业
				ShareUtil.setstringvalue(getActivity(), "showtype", "1");
				showzaixian();
			}
			//如果当前是1的话，证明现在是营业，则变为不营业
			else if("1".equals(but_type)){
				//请求服务器，让他不营业
				ShareUtil.setstringvalue(getActivity(), "showtype", "0");
				showzanting();
			}
			break;
			//反馈
		case R.id.fankui:
			Intent intent2=new Intent(getActivity(), FankuiActvitiy.class);
			startActivity(intent2);
			break;
			//版本号
		case R.id.version:
			Toast.makeText(getActivity(), "当前版本1.0", Toast.LENGTH_LONG).show();
			break;
		case R.id.gofinish:
			Intent intent3=new Intent(getActivity(),LoginActivity.class);
			startActivity(intent3);
			getActivity().finish();
			break;
		default:
			break;
		}		
	}

}
