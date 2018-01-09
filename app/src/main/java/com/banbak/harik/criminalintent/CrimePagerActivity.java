package com.banbak.harik.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by harik on 1/6/2018.
 */

public class CrimePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private static final String EXTRA_CRIME_ID = "com.banbak.harik.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID CrimeID){
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID , CrimeID);
        return intent ;
    }



    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeID  = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);
        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime  crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getID());

            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for (int i= 0; i<mCrimes.size(); i++){
            if (mCrimes.get(i).getID().equals(crimeID)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
