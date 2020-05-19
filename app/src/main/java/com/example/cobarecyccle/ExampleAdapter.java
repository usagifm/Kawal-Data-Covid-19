package com.example.cobarecyccle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{

        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ExampleAdapter(Context context,ArrayList<ExampleItem> exampleList ){
        mContext = context;
        mExampleList = exampleList;

    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String Country = currentItem.getCountry();
//        String newPositive = currentItem.getNewPositive();
        String Positive = currentItem.getPositive();
//        String newRecovered = currentItem.getNewRecovered();
        String Recovered = currentItem.getRecovered();
//        String newDied = currentItem.getNewdied();
        String Died =currentItem.getdied();

        holder.mTextViewCountry.setText(Country);
//        holder.mTextViewNewPositive.setText("New Positive : " + newPositive);
        holder.mTextViewPositive.setText("Total Positive : " + Positive);
//        holder.mTextViewNewRecovered.setText("New Recovered : " + newRecovered);
        holder.mTextViewRecovered.setText("Total Recovered : " + Recovered);
//        holder.mTextViewNewDied.setText("New Deaths : " + newDied);
        holder.mTextViewDied.setText("Total Deaths : " + Died);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewCountry;
        public TextView mTextViewNewPositive;
        public TextView mTextViewPositive;
        public TextView mTextViewNewRecovered;
        public TextView mTextViewRecovered;
        public TextView mTextViewNewDied;
        public TextView mTextViewDied;



        public ExampleViewHolder(View itemView){
            super(itemView);
            mTextViewCountry = itemView.findViewById(R.id.text_view_country);
//            mTextViewNewPositive =itemView.findViewById(R.id.text_view_newpositive);
            mTextViewPositive = itemView.findViewById(R.id.text_view_positive);
//            mTextViewNewRecovered = itemView.findViewById(R.id.text_view_newrecovered);
            mTextViewRecovered = itemView.findViewById(R.id.text_view_recovered);
//            mTextViewNewDied = itemView.findViewById(R.id.text_view_newdied);
            mTextViewDied = itemView.findViewById(R.id.text_view_died);

        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
       if (mListener != null){
           int position  = getAdapterPosition();
           if (position != RecyclerView.NO_POSITION){
               mListener.onItemClick(position);
           }

       }
                }
            });

        }


    }
}
