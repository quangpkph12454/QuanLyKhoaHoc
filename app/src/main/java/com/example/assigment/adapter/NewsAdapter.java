package com.example.assigment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assigment.R;
import com.example.assigment.WebViewActivity;
import com.example.assigment.model.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    List<News> danhsachList;
    Context context;
    LayoutInflater inflater;

    public NewsAdapter(Context context,List<News> danhsachList) {
        this.danhsachList = danhsachList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return danhsachList.size();
    }

    @Override
    public Object getItem(int position) {
        return danhsachList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder ;
        if (convertView ==null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list,null);
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = convertView.findViewById(R.id.tvDescription);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News ds = (News) danhsachList.get(position);
        viewHolder.tvTitle.setText(ds.getTitle());
        viewHolder.tvDescription.setText(ds.getDescription());

        viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(parent.getContext(), WebViewActivity.class);
                String ten = danhsachList.get(position).getLink();
                i.putExtra("Ten",ten);
                parent.getContext().startActivity(i);
            }
        });
        return convertView;
    }
    public static class ViewHolder{
        TextView tvTitle;
        TextView tvDescription;
    }
}
