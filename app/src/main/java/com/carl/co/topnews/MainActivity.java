package com.carl.co.topnews;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.carl.co.topnews.bean.NewsClassify;
import com.carl.co.topnews.fragment.NewsMainFragment;
import com.carl.co.topnews.fragment.OtherFragment;
import com.carl.co.topnews.tools.Constants;

import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initView();
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
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsMainFragment()).commit();
    }
    private void switchToTwo(){
        OtherFragment fragment = new OtherFragment();
        Bundle data = new Bundle();
        data.putString("type", "two");
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
    }
    private void switchToThree(){
        OtherFragment fragment = new OtherFragment();
        Bundle data = new Bundle();
        data.putString("type", "three");
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
    }
    private void switchToFore(){
        OtherFragment fragment = new OtherFragment();
        Bundle data = new Bundle();
        data.putString("type", "fore");
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
    }
}
