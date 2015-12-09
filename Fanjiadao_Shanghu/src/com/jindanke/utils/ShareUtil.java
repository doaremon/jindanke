package com.jindanke.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtil {
	public static void setstringvalue(Context context,String key,String value){
		SharedPreferences settings = context.getSharedPreferences("jdk", 0);
		SharedPreferences.Editor editor =settings.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getstringvalue(Context context,String key){
		SharedPreferences settings = context.getSharedPreferences("jdk", 0);
		String name = settings.getString(key,"-1");
		return name;
	}
}
