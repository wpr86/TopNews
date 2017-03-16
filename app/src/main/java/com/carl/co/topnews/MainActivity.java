package com.carl.co.topnews;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.carl.co.topnews.fragment.NewsMainFragment;
import com.carl.co.topnews.fragment.OtherFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.frame_content)
    FrameLayout frameContent;

    private ActionBarDrawerToggle mDrawerToggle;

    private Fragment mNewsFragment = new NewsMainFragment();
    private Fragment mOtherFragment2 = new OtherFragment();
    private Fragment mOtherFragment3 = new OtherFragment();
    private Fragment mOtherFragment4 = new OtherFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getWindow().setFormat(PixelFormat.TRANSPARENT);  // 防止添加surfaceView 时闪下黑屏的问题
        } catch (Exception e) {
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initView();
        initFragments();
        switchToMain();
    }

    private void initView(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerContent(mNavigationView);
        mNavigationView.inflateHeaderView(R.layout.navigation_header);
    }

    private void initFragments(){
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mNewsFragment = new NewsMainFragment();

        mOtherFragment2 = new OtherFragment();
        Bundle data = new Bundle();
        data.putString("type", "two");
        mOtherFragment2.setArguments(data);

        mOtherFragment3 = new OtherFragment();
        data = new Bundle();
        data.putString("type", "three");
        mOtherFragment3.setArguments(data);

        mOtherFragment4 = new OtherFragment();
        data = new Bundle();
        data.putString("type", "fore");
        mOtherFragment4.setArguments(data);

        mFragmentTransaction.add(R.id.frame_content, mNewsFragment, "mNewsFragment");
        mFragmentTransaction.add(R.id.frame_content, mOtherFragment2, "mOtherFragment2");
        mFragmentTransaction.add(R.id.frame_content, mOtherFragment3, "mOtherFragment3");
        mFragmentTransaction.add(R.id.frame_content, mOtherFragment4, "mOtherFragment4");

        mFragmentTransaction.hide(mNewsFragment);
        mFragmentTransaction.hide(mOtherFragment2);
        mFragmentTransaction.hide(mOtherFragment3);
        mFragmentTransaction.hide(mOtherFragment4);
        mFragmentTransaction.commit();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_1:
                                switchToMain();
                                break;
                            case R.id.navigation_2:
                                switchToTwo();
                                break;
                            case R.id.navigation_3:
                                switchToThree();
                                break;
                            case R.id.navigation_4:
                                switchToFore();
                                break;
                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void switchToMain(){
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsMainFragment()).commit();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.show(mNewsFragment);
        mFragmentTransaction.hide(mOtherFragment2);
        mFragmentTransaction.hide(mOtherFragment3);
        mFragmentTransaction.hide(mOtherFragment4);
        mFragmentTransaction.commit();
    }
    private void switchToTwo(){
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.hide(mNewsFragment);
        mFragmentTransaction.show(mOtherFragment2);
        mFragmentTransaction.hide(mOtherFragment3);
        mFragmentTransaction.hide(mOtherFragment4);
        mFragmentTransaction.commit();
    }
    private void switchToThree(){
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.hide(mNewsFragment);
        mFragmentTransaction.hide(mOtherFragment2);
        mFragmentTransaction.show(mOtherFragment3);
        mFragmentTransaction.hide(mOtherFragment4);
        mFragmentTransaction.commit();
    }
    private void switchToFore(){
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.hide(mNewsFragment);
        mFragmentTransaction.hide(mOtherFragment2);
        mFragmentTransaction.hide(mOtherFragment3);
        mFragmentTransaction.show(mOtherFragment4);
        mFragmentTransaction.commit();
    }
}
