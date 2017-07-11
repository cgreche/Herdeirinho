package br.com.fatecudos.herdeirinho;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * TabManager é uma classe que intergra um TabLayout e um ViewPager e facilita a inserção de tabs
 */

public class TabManager {

    private Activity parentActivity;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CustomPagerAdapter pagerAdapter = null;

    private ArrayList<ViewGroup> tabViews = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();
    private int tabCount;

    public TabManager(Activity parentActivity, int tabLayoutResId, int pagerResId) {
        this.parentActivity = parentActivity;
        tabLayout = (TabLayout)parentActivity.findViewById(tabLayoutResId);
        viewPager = (ViewPager)parentActivity.findViewById(pagerResId);
        tabCount = 0;
    }

    public void setup() {
        pagerAdapter = new CustomPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        //setupWithViewPager() sincronizará o TabLayout com o viewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    public int addTab(String title, ViewGroup layout) {
        int curId = tabCount;
        tabTitles.add(title);
        tabViews.add(layout);
        ++tabCount;
        if(pagerAdapter != null)
            pagerAdapter.notifyDataSetChanged();
        return curId;
    }

    public void removeTab(int position) {
        if(position >= tabCount)
            return;
        tabTitles.remove(position);
        tabViews.remove(position);
        --tabCount;
        if(pagerAdapter != null)
            pagerAdapter.notifyDataSetChanged();
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener listener) {
        tabLayout.addOnTabSelectedListener(listener);
    }

    public int getSelectedTabPosition() {
        return tabLayout.getSelectedTabPosition();
    }

    public String getTitle(int position) {
        return tabTitles.get(position);
    }

    public ViewGroup getView(int position) {
        return tabViews.get(position);
    }

    //Pode-se herdar de um FragmentPagerAdapter ou um PagerAdapter
    //Aqui herdamos de um PagerAdapter para inflar layouts ao invés de usar Fragments
    public class CustomPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View v = tabViews.get(position);
            if(v != null)
                collection.addView(v);
            return v;
        }
        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /*
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            LayoutInflater inflater = getLayoutInflater().from(MainActivity.this);
            View rootView = inflater.inflate(R.layout.tab_main, viewPager, false);
            return null;
        }
        */

        @Override
        public int getCount() {
            return tabCount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles.get(position);
        }
    }
}
