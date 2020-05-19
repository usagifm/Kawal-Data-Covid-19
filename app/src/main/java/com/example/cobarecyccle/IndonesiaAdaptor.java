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

public class IndonesiaAdaptor extends RecyclerView.Adapter<IndonesiaAdaptor.IndonesiaViewHolder> {
private Context mContextindo;
private ArrayList<IndonesiaItem> mIndoList;

public IndonesiaAdaptor(Context context,ArrayList<IndonesiaItem> indolist){
    mContextindo = context;
    mIndoList = indolist;

}

    @NonNull
    @Override
    public IndonesiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vindo = LayoutInflater.from(mContextindo).inflate(R.layout.indonesia_item, parent , false );
        return new IndonesiaViewHolder(vindo);
    }

    @Override
    public void onBindViewHolder(@NonNull IndonesiaViewHolder holder, int position) {

    IndonesiaItem currenItemindo = mIndoList.get(position);

    String indo = currenItemindo.getmIndo();
    String sakit = currenItemindo.getmKena();
    String sehat = currenItemindo.getmSehat();
    String mati = currenItemindo.getmMati();

    holder.mTextViewIndonesia.setText("Data Covid-19 di "+indo);
    holder.mTextViewKena.setText("Positif : "+sakit);
    holder.mTextViewSehat.setText("Sembuh : "+sehat);
    holder.mTextViewMati.setText("Meninggal : "+mati);

    }

    @Override
    public int getItemCount() {
        return mIndoList.size();
    }


    public class IndonesiaViewHolder extends RecyclerView.ViewHolder{
public TextView mTextViewIndonesia;
public TextView mTextViewKena;
public TextView mTextViewSehat;
public TextView mTextViewMati;

            public IndonesiaViewHolder(View itemView){
                super(itemView);
                mTextViewIndonesia = itemView.findViewById(R.id.indonesia);
                mTextViewKena = itemView.findViewById(R.id.sakit);
                mTextViewSehat = itemView.findViewById(R.id.sehat);
                mTextViewMati = itemView.findViewById(R.id.mati);


            }

    }
}
