package com.example.assigment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assigment.adapter.ScheduleAdapter;
import com.example.assigment.model.Schedules;

import java.util.ArrayList;
import java.util.List;


public class TestsFragment extends Fragment {
    ListView listView;
    ScheduleAdapter scheduleAdapter;
    List<Schedules> lists1;
    public TestsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tests, container, false);
        listView = view.findViewById(R.id.lvLichHoc);
        lists1 = new ArrayList<>();
        lists1.add(new Schedules("28-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10"));
        lists1.add(new Schedules("30-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10"));
        lists1.add(new Schedules("27-10-2020","VIE1026","Pháp luật","VIE1026.31","12:10-14:10"));
        scheduleAdapter = new ScheduleAdapter(lists1,getContext());
        listView.setAdapter(scheduleAdapter);
        scheduleAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                View views = inflater.inflate(R.layout.my_dialog,null);
                builder.setView(views);
                TextView tvMaMonHocTT = views.findViewById(R.id.tvMaMonHocTT);
                TextView tvMonHocTT = views.findViewById(R.id.tvMonHocTT);
                TextView tvNgayThangTT = views.findViewById(R.id.tvNgayThangTT);
                TextView tvThoiGianTT = views.findViewById(R.id.tvThoiGianTT);
                TextView tvLopTT = views.findViewById(R.id.tvLopTT);
                tvLopTT.setText(lists1.get(position).getLop());
                tvNgayThangTT.setText(lists1.get(position).getNgayThang());
                tvThoiGianTT.setText(lists1.get(position).getThoiGian());
                tvMonHocTT.setText(lists1.get(position).getTenMonHoc());
                tvMaMonHocTT.setText(lists1.get(position).getMaMonHoc());
                builder.setTitle("Thông tin lịch thi cuối môn");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }
}
