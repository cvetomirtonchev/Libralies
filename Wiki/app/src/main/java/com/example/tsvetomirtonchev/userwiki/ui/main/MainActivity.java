package com.example.tsvetomirtonchev.userwiki.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.ui.albums.AlbumsFragment;
import com.example.tsvetomirtonchev.userwiki.ui.base.BaseActivity;
import com.example.tsvetomirtonchev.userwiki.ui.posts.PostsFragment;
import com.example.tsvetomirtonchev.userwiki.ui.profile.MyProfileFragment;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    //Constants
    public static final int NO_ALPHA_VALUE = 255;
    public static final int HALF_ALPHA_VALUE = NO_ALPHA_VALUE / 2;
    public static final int POSTS_INDEX = 0;
    public static final int ALBUMS_INDEX = 1;
    public static final int PROFILE_INDEX = 2; // profile should be in navigation drawer

    //Data
    private String[] mMainTabsTitles;
    //Views
    private Toolbar mToolbar;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mToolbar = findViewById(R.id.toolbar);
        setupViewPager();
    }


    @SuppressWarnings("ConstantConditions")
    private void setupViewPager() {
        updateTabTitles();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(POSTS_INDEX).setIcon(R.drawable.ic_icon).getIcon().setAlpha(HALF_ALPHA_VALUE);
        mTabLayout.getTabAt(ALBUMS_INDEX).setIcon(R.drawable.ic_icon).getIcon().setAlpha(HALF_ALPHA_VALUE);
        mTabLayout.getTabAt(PROFILE_INDEX).setIcon(R.drawable.ic_icon).getIcon().setAlpha(HALF_ALPHA_VALUE);

        mTabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        if (mMainTabsTitles.length > position) {
            mToolbar.setTitle(mMainTabsTitles[position]);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        onTabSelected(tab);

    }


    private void updateTabTitles() {
        String[] tabNames = {
                getString(R.string.tab_albums),
                getString(R.string.tab_posts),
                getString(R.string.tab_my_profile),
        };
        mMainTabsTitles = tabNames;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            TextView textView = rootView.findViewById(R.id.section_label);
            textView.setText("Not implemented yet");
            return rootView;
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the
     * sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        private SparseArray<Fragment> mRegisteredFragments;

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            mRegisteredFragments = new SparseArray<>();
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return AlbumsFragment.newInstance();
                case 1:
                    return PostsFragment.newInstance();
                case 2:
                    return MyProfileFragment.newInstance();
                default:
                    return PlaceholderFragment.newInstance(position);
            }
        }

        @Override
        public int getCount() {
            return mMainTabsTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            mRegisteredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            mRegisteredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        Fragment getRegisteredFragment(int position) {
            return mRegisteredFragments.valueAt(position);
        }

        SparseArray<Fragment> getRegisteredFragments() {
            return mRegisteredFragments;
        }
    }

}
