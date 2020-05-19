package com.example.cobarecyccle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GlobalAdaptor extends RecyclerView.Adapter<GlobalAdaptor.GlobalViewHolder> {
    private Context mContextglobal;
    private ArrayList<GlobalItem> mGlobalList;

public GlobalAdaptor(Context contextglobal, ArrayList<GlobalItem> globallist){
    mContextglobal = contextglobal;
    mGlobalList  = globallist;


}

    @NonNull
    @Override
    public GlobalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View viglobal = LayoutInflater.from(mContextglobal).inflate(R.layout.global_item, parent, false);
    return new GlobalViewHolder(viglobal);

}

    @Override
    public void onBindViewHolder(@NonNull GlobalViewHolder holder, int positionglobal) {
        GlobalItem currentItemglobal = mGlobalList.get(positionglobal);
        String globalpos = currentItemglobal.getmTotalPositiveGlobal();
        String globalrec = currentItemglobal.getmTotalRecoveredGlobal();
        String globaldeaths = currentItemglobal.getmTotalDeathsGlobal();

        holder.mPositiveglobal.setText("Positif : "+ globalpos);
        holder.mRecoveredGlobal.setText("Sembuh : " +globalrec);
        holder.mDeathsGlobal.setText("Meninggal : "+globaldeaths);
    }

    @Override
    public int getItemCount() {
        return mGlobalList.size();
    }


    public class GlobalViewHolder extends RecyclerView.ViewHolder{

        public TextView mPositiveglobal,mRecoveredGlobal, mDeathsGlobal;




        public GlobalViewHolder(@NonNull View itemView) {
            super(itemView);

            mPositiveglobal = itemView.findViewById(R.id.global_positive);
            mRecoveredGlobal = itemView.findViewById(R.id.global_recovered);
            mDeathsGlobal = itemView.findViewById(R.id.global_deaths);

        }
    }


}




