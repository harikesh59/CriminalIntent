package com.banbak.harik.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by harik on 12/29/2017.
 */

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;


    public Crime(){
        //Generate Unique Identifier
        this(UUID.randomUUID());
    }
    public Crime(UUID id){
        mID = id;
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setSuspect( String suspect){
        mSuspect = suspect;
    }

    public String getSuspect(){
        return mSuspect;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


}
