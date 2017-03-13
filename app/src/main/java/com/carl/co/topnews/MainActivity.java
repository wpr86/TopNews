package com.carl.co.topnews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carl.co.topnews.adapter.ItemRecyclerViewAdapter;
import com.carl.co.topnews.adapter.NewsFragmentAdapter;
import com.carl.co.topnews.bean.NewsClassify;
import com.carl.co.topnews.fragment.NewsFragment;
import com.carl.co.topnews.tools.Constants;
import com.carl.co.topnews.tools.Tool;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mRadioGroup_content)
    RecyclerView mRadioGroupContent;
    @BindView(R.id.mColumnHorizontalScrollView)
    HorizontalScrollView mnHorizontalScrollView;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.layout_main)
    LinearLayout layoutMain;

    private List<NewsClassify> newsClassifyList;
    private List<String> newsTitleList;
    // 当前选中栏目
    private int columnSelectIndex = 0;

    private int mScreenWitdh = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mScreenWitdh = Tool.getWindowsWidth(this);
        newsClassifyList = Constants.getData();

        initFragment();
        initTabColumn();

    }

    private void initFragment() {
        NewsFragmentAdapter adapter = new NewsFragmentAdapter(getSupportFragmentManager());
        newsTitleList = new ArrayList<>();
        for (NewsClassify newsClassify : newsClassifyList) {
            Fragment fragment = new NewsFragment();
            Bundle data = new Bundle();
            data.putString("title", newsClassify.getTitle());
            data.putInt("id", newsClassify.getId());
            data.putString("type", newsClassify.getType());
            fragment.setArguments(data);
            adapter.addFragment(fragment);
            newsTitleList.add(newsClassify.getTitle());
        }
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
    }

    /**
     * 初始化Column栏目项
     */
    private void initTabColumn() {
//        mRadioGroupContent.removeAllViews();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRadioGroupContent.setLayoutManager(layoutManager);
        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(this,newsTitleList);
        mRadioGroupContent.setAdapter(adapter);

        adapter.setOnClickListener(new ItemRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                mViewPager.setCurrentItem(position);
            }
        });

        new Thread(){
            @Override
            public void run() {
                super.run();
                while(mRadioGroupContent.getChildCount()<=0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        selectTab(columnSelectIndex);
                    }
                });
            }
        }.start();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mViewPager.setCurrentItem(position);
        selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void selectTab(int tab_postion) {
        columnSelectIndex = tab_postion;
        for (int i = 0; i < mRadioGroupContent.getChildCount(); i++) {
            View checkView = mRadioGroupContent.getChildAt(tab_postion);
            int k = checkView.getMeasuredWidth();
            int l = checkView.getLeft();
            int i2 = l + k / 2 - mScreenWitdh / 2;
            mnHorizontalScrollView.smoothScrollTo(i2, 0);
        }
        //判断是否选中
        for (int j = 0; j <  mRadioGroupContent.getChildCount(); j++) {
            View checkView = mRadioGroupContent.getChildAt(j);
            boolean ischeck;
            if (j == tab_postion) {
                ischeck = true;
            } else {
                ischeck = false;
            }
            checkView.setSelected(ischeck);
        }
    }
}
