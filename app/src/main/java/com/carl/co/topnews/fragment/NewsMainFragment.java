package com.carl.co.topnews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carl.co.topnews.R;
import com.carl.co.topnews.adapter.NewsFragmentAdapter;
import com.carl.co.topnews.bean.NewsClassify;
import com.carl.co.topnews.tools.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Host-0 on 2017/3/14.
 */

public class NewsMainFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        NewsFragmentAdapter adapter = new NewsFragmentAdapter(getFragmentManager());

        for (NewsClassify newsClassify : Constants.getData()) {
            Fragment fragment = new NewsFragment();
            Bundle data = new Bundle();
            data.putString("title", newsClassify.getTitle());
            data.putInt("id", newsClassify.getId());
            data.putString("type", newsClassify.getType());
            fragment.setArguments(data);
            adapter.addFragment(fragment, newsClassify.getTitle());
        }
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
