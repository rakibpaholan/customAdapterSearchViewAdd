package com.example.customadaptersearchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListVewAdapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListVewAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconTv;
    }
    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row,null);
            /*locate the view in row , xml*/
            holder.mTitleTv = view.findViewById(R.id.title_id);
            holder.mDescTv = view.findViewById(R.id.description_id);
            holder.mIconTv = view.findViewById(R.id.icon_id);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        /* set the result into view*/
        holder.mTitleTv.setText(modelList.get(position).getTitle());
        holder.mDescTv.setText(modelList.get(position).getDesc());
        /*set image*/
        holder.mIconTv.setImageResource(modelList.get(position).getIcon());

        /*insert View Item click*/

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*code here*/
            }
        });

        return view;
    }
    /*filter*/
    public  void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if (charText.length()==0){
            modelList.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){

                if(model.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    modelList.add(model);
                }



            }
        }

        notifyDataSetChanged();
    }
}
