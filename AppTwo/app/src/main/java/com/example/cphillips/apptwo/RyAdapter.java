package com.example.cphillips.apptwo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by CPhillips on 9/29/2017.
 */

public class RyAdapter extends RecyclerView.Adapter<RyAdapter.MyViewHolder> {

    public ArrayList<String> mStrings;

    public RyAdapter(ArrayList<String> stringz){
        mStrings = stringz;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Switch mSwitch;
        private Button mButton;
        private CheckBox mCheckBox;

        public MyViewHolder(View v) {
            super(v);
            mSwitch = (Switch) v.findViewById(R.id.switch2);
            mButton = (Button) v.findViewById(R.id.button2);
            mCheckBox = (CheckBox) v.findViewById(R.id.checkBox2);
        }

        public void bind(String s){
            mButton.setText(s);
        }

        @Override
        public void onClick(View view) {
            Log.d("RecyclerView", "Click!");
        }
    }





    @Override
    public RyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_item, parent, false);
        return new MyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mStrings.get(position));
    }


    @Override
    public int getItemCount() {
        return mStrings.size();
    }
}
