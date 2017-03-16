package com.carl.co.topnews;

import com.qihoo360.newssdk.NewsSDK;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class MainApplication extends Application
{
	@Override
	public void onCreate() 
	{
		super.onCreate();
		initNewsSdk(this);
	}
	
	private void initNewsSdk(Context context)
	{
        Bundle params = new Bundle();
        params.putBoolean(NewsSDK.KEY_IS_DEBUG, true);
        NewsSDK.init(context, params);
	}
}
