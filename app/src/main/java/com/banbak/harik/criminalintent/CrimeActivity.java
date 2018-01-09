package com.banbak.harik.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.banbak.harik.criminalintent.crime_id";


    @Override
    protected Fragment createFragment(){

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
