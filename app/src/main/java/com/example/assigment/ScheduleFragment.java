package com.example.assigment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assigment.DAO.DanhSachDAO;
import com.example.assigment.adapter.ScheduleAdapter;
import com.example.assigment.model.Lists;
import com.example.assigment.model.Schedules;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    ListView listView;
    ScheduleAdapter scheduleAdapter;
    public static List<Schedules> lists1 = new ArrayList<>();
    static AppCompatSpinner spnMaMon;

    public ScheduleFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        listView = view.findViewById(R.id.lvLichHoc);
        spnMaMon = view.findViewById(R.id.spnMaMon);

        Schedules s = new Schedules("14-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s);
        Schedules s1 = new Schedules("15-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s1);
        Schedules s2 = new Schedules("16-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s2);
        Schedules s3 = new Schedules("17-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s3);
        Schedules s4 = new Schedules("18-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s4);
        Schedules s5 = new Schedules("19-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s5);
        Schedules s6 = new Schedules("21-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s6);
        Schedules s7 = new Schedules("22-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s7);
        Schedules s8 = new Schedules("23-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s8);
        Schedules s9 = new Schedules("24-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s9);
        Schedules s10 = new Schedules("25-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s10);
        Schedules s11 = new Schedules("26-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s11);
        Schedules s12 = new Schedules("28-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s12);
        Schedules s13 = new Schedules("29-09-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s13);
        Schedules s14 = new Schedules("30-09-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s14);
        Schedules s15 = new Schedules("01-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s15);
        Schedules s16 = new Schedules("02-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s16);
        Schedules s17 = new Schedules("03-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s17);
        Schedules s18 = new Schedules("05-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s18);
        Schedules s19 = new Schedules("06-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s19);
        Schedules s20 = new Schedules("07-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s20);
        Schedules s21 = new Schedules("08-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s21);
        Schedules s22 = new Schedules("09-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s22);
        Schedules s23 = new Schedules("10-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s23);
        Schedules s24 = new Schedules("12-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s24);
        Schedules s25 = new Schedules("13-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s25);
        Schedules s26 = new Schedules("14-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s26);
        Schedules s27 = new Schedules("15-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s27);
        Schedules s28 = new Schedules("16-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s28);
        Schedules s29 = new Schedules("17-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s29);
        Schedules s30 = new Schedules("19-10-2020","MOB204","Dự án mẫu (ngành Mobile)","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s30);
        Schedules s31 = new Schedules("20-10-2020","MOB201","Lập trình Android nâng cao","PT-15353MOB","12:10-14:10");
        MainActivity.scheduleDAO.addLists(s31);

        lists1 = MainActivity.scheduleDAO.getSchedule();
        scheduleAdapter = new ScheduleAdapter(lists1,getContext());
        listView.setAdapter(scheduleAdapter);
        scheduleAdapter.notifyDataSetChanged();

        DanhSachDAO danhSachDAO = new DanhSachDAO(getActivity());
        List<Lists> lists = danhSachDAO.getAll();
        Lists l = new Lists();
        l.setMaMon("_       Show All     _");
        lists.add(0,l);
        ArrayAdapter<Lists> adapter = new ArrayAdapter<Lists>(getActivity(),android.R.layout.simple_spinner_item,lists);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMaMon.setAdapter(adapter);

        spnMaMon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lists lists2 = (Lists) spnMaMon.getSelectedItem();
                String lop = lists2.getMaMon();
                    if (lop.equalsIgnoreCase("_       Show All     _")) {
                        lists1 = MainActivity.scheduleDAO.getSchedule();
                        ScheduleAdapter sinhVienAdapter = new ScheduleAdapter(lists1,getActivity());
                        listView.setAdapter(sinhVienAdapter);
                        scheduleAdapter.notifyDataSetChanged();
                    }else  {
                        lists1 = MainActivity.scheduleDAO.getAll1(lop);
                        ScheduleAdapter sinhVienAdapter = new ScheduleAdapter(lists1,getActivity());
                        listView.setAdapter(sinhVienAdapter);
                        scheduleAdapter.notifyDataSetChanged();
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                builder.setTitle("Thông tin lịch học");
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
