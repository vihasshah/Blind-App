package com.blindapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blindapp.Models.GridModel;
import com.blindapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Vihas on 06-03-2017.
 */

public class CustomGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<GridModel> arrayList;

    public CustomGridAdapter(Context context, ArrayList<GridModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        TextView nameTV;
        ImageView imageTV;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.single_row_grid,parent,false);
            holder.nameTV = (TextView) convertView.findViewById(R.id.single_row_text);
            holder.imageTV = (ImageView) convertView.findViewById(R.id.single_row_icon);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        // set name
        holder.nameTV.setText(arrayList.get(position).getName());
        // set image using picasso library
        Picasso.with(context).load(arrayList.get(position).getPath()).into(holder.imageTV);

        return convertView;
    }
}
