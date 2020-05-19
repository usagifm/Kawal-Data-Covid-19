package com.example.cobarecyccle;

public class GlobalItem {


    private String mTotalPositiveGlobal;
    private String mTotalRecoveredGlobal;
    private String mTotalDeathsGlobal;


    public GlobalItem(String TotalPositiveGlobal, String TotalRecoveredGlobal, String TotalDeathsGlocal){

    mTotalPositiveGlobal = TotalPositiveGlobal;
    mTotalRecoveredGlobal = TotalRecoveredGlobal;
    mTotalDeathsGlobal = TotalDeathsGlocal;

    }

    public String getmTotalPositiveGlobal(){
        return mTotalPositiveGlobal;

    }

    public String getmTotalRecoveredGlobal(){

        return mTotalRecoveredGlobal;
    }

    public String getmTotalDeathsGlobal(){

        return mTotalDeathsGlobal;
    }
}
