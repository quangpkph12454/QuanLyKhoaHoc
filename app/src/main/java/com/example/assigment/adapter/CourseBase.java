package com.example.assigment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assigment.R;
import com.example.assigment.model.Lists;

import java.util.List;

public class CourseBase extends BaseAdapter {
    List<Lists> lists ;
    Context context;
    LayoutInflater inflater;

    public CourseBase(List<Lists> lists, Context context) {
        this.lists = lists;
        this.context = context;
        inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView== null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_danhsach,null);
            viewHolder.tvMaLop = convertView.findViewById(R.id.tvMaLop);
            viewHolder.tvMonHoc = convertView.findViewById(R.id.tvMonHoc);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Lists lv = (Lists) lists.get(position);
        viewHolder.tvMaLop.setText(lv.getMaMon());
        viewHolder.tvMonHoc.setText(lv.getMonHoc());
        return convertView;
    }
    public static class ViewHolder{
        TextView tvMaLop,tvMonHoc;
    }
}
