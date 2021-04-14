package com.example.assigment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assigment.R;
import com.example.assigment.model.Schedules;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter {
    List<Schedules> lists ;
    Context context;
    LayoutInflater inflater;

    public ScheduleAdapter(List<Schedules> lists, Context context) {
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
            convertView = inflater.inflate(R.layout.item_lich_hoc,null);
            viewHolder.tvLop = convertView.findViewById(R.id.tvLop);
            viewHolder.tvMaMonHoc = convertView.findViewById(R.id.tvMaMonHoc);
            viewHolder.tvMonHoc = convertView.findViewById(R.id.tvMonHoc2);
            viewHolder.tvNgayThang = convertView.findViewById(R.id.tvNgayThang);
            viewHolder.tvThoiGian = convertView.findViewById(R.id.tvThoiGian);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Schedules lv = (Schedules) lists.get(position);
        viewHolder.tvMaMonHoc.setText(lv.getMaMonHoc());
        viewHolder.tvThoiGian.setText(lv.getThoiGian());
        viewHolder.tvNgayThang.setText(lv.getNgayThang());
        viewHolder.tvLop.setText(lv.getLop());
        viewHolder.tvMonHoc.setText(lv.getTenMonHoc());
        return convertView;
    }
    public static class ViewHolder{
        TextView tvMaMonHoc,tvMonHoc,tvNgayThang,tvThoiGian,tvLop;
    }
}
