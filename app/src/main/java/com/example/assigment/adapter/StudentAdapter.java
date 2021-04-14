package com.example.assigment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assigment.R;
import com.example.assigment.model.Students;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Students> lists ;
    Context context;
    LayoutInflater inflater;

    public StudentAdapter(List<Students> lists, Context context) {
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
            convertView = inflater.inflate(R.layout.item_mon_hoc,null);
            viewHolder.tvSTT = convertView.findViewById(R.id.tvSTT);
            viewHolder.tvMaMonHoc = convertView.findViewById(R.id.tvMaMonHoc);
            viewHolder.tvMonHoc1 = convertView.findViewById(R.id.tvMonHoc1);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Students lv = (Students) lists.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position+1));
        viewHolder.tvMaMonHoc.setText(lv.getMaMon());
        viewHolder.tvMonHoc1.setText(lv.getMonHoc());
        return convertView;
    }
    public static class ViewHolder{
        TextView tvSTT,tvMaMonHoc,tvMonHoc1;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<Students> item){
        this.lists = item;
        notifyDataSetChanged();
    }
}
