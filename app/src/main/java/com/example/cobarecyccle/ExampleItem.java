package com.example.cobarecyccle;

public class ExampleItem {

    private String mCountry;
    private String mNewPositive;
    private String mPositive;
    private String mNewRecovered;
    private String mRecovered;
    private String mNewDied;
    private String mDied;

    public ExampleItem(String country,String newpositive, String positive ,String newrecovered, String recovered,String newdied ,String died){
        mCountry = country;
        mNewPositive = newpositive;
        mPositive = positive;
        mNewRecovered = newrecovered;
        mRecovered = recovered;
        mNewDied = newdied;
        mDied = died;

    }


    public String getCountry(){
            return mCountry;

    }
    public String getNewPositive(){
        return mNewPositive;

    }



    public String getPositive(){
        return mPositive;

    }



    public String getNewRecovered(){
        return mNewRecovered;

    }

    public String getRecovered(){
        return mRecovered;

    }

    public String getNewdied(){
        return mNewDied;

    }

    public String getdied(){
        return mDied;

    }



}
