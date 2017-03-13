package com.carl.co.topnews.tools;

import com.carl.co.topnews.bean.NewsClassify;

import java.util.ArrayList;

public class Constants {
	public static ArrayList<NewsClassify> getData() {
		ArrayList<NewsClassify> newsClassify = new ArrayList<NewsClassify>();
		NewsClassify classify = new NewsClassify();
		classify.setId(1);
		classify.setType("youlike");
		classify.setTitle("推荐");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(2);
		classify.setType("newhot");
		classify.setTitle("热点");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(3);
		classify.setType("video");
		classify.setTitle("视频");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(4);
		classify.setType("fun");
		classify.setTitle("娱乐");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(5);
		classify.setType("science");
		classify.setTitle("科技");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(6);
		classify.setType("car");
		classify.setTitle("汽车");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(7);
		classify.setType("militery");
		classify.setTitle("军事");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(8);
		classify.setType("economy");
		classify.setTitle("财经");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(9);
		classify.setType("sport");
		classify.setTitle("体育");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(10);
		classify.setType("funny");
		classify.setTitle("搞笑");
		newsClassify.add(classify);
		classify = new NewsClassify();
		classify.setId(11);
		classify.setType("gossip");
		classify.setTitle("八卦");
		newsClassify.add(classify);
		return newsClassify;
	}
}
