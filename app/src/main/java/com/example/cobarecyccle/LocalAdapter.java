package com.example.cobarecyccle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.LocalViewHolder> {
    private Context mContextlocal;
    private ArrayList<LocalItem> mLocalList;

    public LocalAdapter(Context contextlocal ,ArrayList<LocalItem> locallist){
        mContextlocal = contextlocal;
        mLocalList = locallist;

    }

    @NonNull
    @Override
    public LocalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(mContextlocal).inflate(R.layout.local_item, parent , false);
        return  new LocalViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalViewHolder holder, int position) {

        LocalItem currenItemlocal = mLocalList.get(position);

        String provinsi = currenItemlocal.getProvinsi();
        String positif = currenItemlocal.getPositivelocal();
        String sembuh = currenItemlocal.getSembuhlocal();
        String meninggal = currenItemlocal.getMeninggallocal();

        holder.mProvinsi.setText(provinsi);
        holder.mPositif.setText("Positif : "+positif);
        holder.mSembuh.setText("Sembuh : "+sembuh);
        holder.mMeninggal.setText("Meninggal : "+meninggal);


    }

    @Override
    public int getItemCount() {
        return mLocalList.size();
    }

    public class LocalViewHolder extends RecyclerView.ViewHolder{
        public TextView mProvinsi;
        public TextView mPositif;
        public TextView mSembuh;
        public TextView mMeninggal;



        public LocalViewHolder(@NonNull View itemView) {
            super(itemView);

            mProvinsi = itemView.findViewById(R.id.provinsi);
            mPositif = itemView.findViewById(R.id.positif);
            mSembuh = itemView.findViewById(R.id.sembuh);
            mMeninggal = itemView.findViewById(R.id.meninggal);


        }
    }

}
