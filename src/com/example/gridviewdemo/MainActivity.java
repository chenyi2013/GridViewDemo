package com.example.gridviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ViewPager mAdvPager;
	private ViewPager mContentPager;
	private ArrayList<Integer> mImages;
	private ArrayList<View> mViews;
	private LayoutInflater mLayoutInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLayoutInflater = getLayoutInflater();

		initData();
		initView();

	}

	public void initView() {
		mAdvPager = (ViewPager) findViewById(R.id.adv_top);
		mContentPager = (ViewPager) findViewById(R.id.content);
		mViews = new ArrayList<View>();
		for (int i = 0; i < mImages.size(); i++) {
			View view = mLayoutInflater.inflate(R.layout.adv_item, mAdvPager,
					false);
			mViews.add(view);
		}
		mAdvPager.setAdapter(new AdvPager());
	}

	public void initData() {
		mImages = new ArrayList<Integer>();
		mImages.add(R.drawable.a);
		mImages.add(R.drawable.b);
		mImages.add(R.drawable.c);
		mImages.add(R.drawable.d);
	}

	class AdvPager extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImages.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {

			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			ImageView view = (ImageView)mViews.get(position);
			view.setImageResource(mImages.get(position));
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			container.removeView(mViews.get(position));
		}
	}
}
