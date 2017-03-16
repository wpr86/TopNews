package com.carl.co.topnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carl.co.topnews.R;
import com.carl.co.topnews.tools.Constants;
import com.qihoo360.newssdk.export.support.NewsExportArgsUtil;
import com.qihoo360.newssdk.exportui.NewsEmbedListView;

/**
 * Created by Host-0 on 2017/3/13.
 */

public class NewsFragment extends Fragment {
    private String type;
    private NewsEmbedListView mContentView;
    private RelativeLayout mainLayout;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        type = args != null ? args.getString("type") : "";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        mainLayout = (RelativeLayout)view.findViewById(R.id.fragment_rl);
        mContentView = new NewsEmbedListView(getContext());
        Bundle params = new Bundle();
        params.putString(NewsExportArgsUtil.KEY_CHANNEL, type);
        params.putInt(NewsExportArgsUtil.KEY_SCENE, Constants.NEWS_PROTAL_SCENE);
        params.putInt(NewsExportArgsUtil.KEY_SUBSCENE, Constants.NEWS_PROTAL_SUBSCENE);
        params.putInt(NewsExportArgsUtil.KEY_REFER_SCENE, 0);
        params.putInt(NewsExportArgsUtil.KEY_REFER_SUBSCENE, 0);
        mContentView.manualStart(params);
        mainLayout.addView(mContentView);
        return view;
    }
}
