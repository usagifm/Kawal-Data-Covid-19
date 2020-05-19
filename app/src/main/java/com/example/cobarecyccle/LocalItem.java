package com.example.cobarecyccle;

public class LocalItem {

    private String mProvinsi;
    private String mPositif;
    private String mSembuh;
    private String mMeninggal;

    public LocalItem(String provinsi , String positif , String sembuh , String meninggal){
        mProvinsi = provinsi;
        mPositif = positif;
        mSembuh = sembuh;
        mMeninggal = meninggal;

    }

    public String getProvinsi(){

        return mProvinsi;

    }

    public String getPositivelocal(){

        return  mPositif;

    }

    public String getSembuhlocal(){
        return mSembuh;

    }

    public String getMeninggallocal(){
        return mMeninggal;
    }

}
