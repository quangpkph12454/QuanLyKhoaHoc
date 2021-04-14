package com.example.assigment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.assigment.DAO.DanhSachDAO;
import com.example.assigment.adapter.CourseBase;
import com.example.assigment.model.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListsFragment extends Fragment {
    ListView listView;
    DanhSachDAO danhSachDAO;
    CourseBase courseBase;
    EditText edtTimKiem;
    public static List<Lists> lists = new ArrayList<>();
    public ListsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lists, container, false);
        listView = view.findViewById(R.id.lvDanhSach);
        danhSachDAO = new DanhSachDAO(getActivity());

        Lists l = new Lists("COM107","Tin học");
        danhSachDAO.addLists(l);
        Lists l1 = new Lists("COM108","Nhập môn lập trình");
        danhSachDAO.addLists(l1);
        Lists l2 = new Lists("ENT111","Tiếng Anh 1.1");
        danhSachDAO.addLists(l2);
        Lists l3 = new Lists("MUL101","Thiết kế hình ảnh với Photoshop");
        danhSachDAO.addLists(l3);
        Lists l4 = new Lists("SKI101","Kỹ năng học tập");
        danhSachDAO.addLists(l4);
        Lists l5 = new Lists("COM201","Cơ sở dữ liệu");
        danhSachDAO.addLists(l5);
        Lists l6 = new Lists("ENT121","Tiếng Anh 1.2");
        danhSachDAO.addLists(l6);
        Lists l7 = new Lists("MOB101","Lập trình Java 1");
        danhSachDAO.addLists(l7);
        Lists l8 = new Lists("WEB101","Xây dựng trang Web");
        danhSachDAO.addLists(l8);
        Lists l9 = new Lists("WEB104","Lập trình cơ sở với Javascript");
        danhSachDAO.addLists(l9);
        Lists l10 = new Lists("ENT211","Tiếng Anh 2.1");
        danhSachDAO.addLists(l10);
        Lists l11 = new Lists("MOB102","Lập trình Java 2");
        danhSachDAO.addLists(l11);
        Lists l12 = new Lists("MOB103","Lập trình Android cơ bản");
        danhSachDAO.addLists(l12);
        Lists l13 = new Lists("MOB202","Thiết kế giao diện trên Android");
        danhSachDAO.addLists(l13);
        Lists l14 = new Lists("WEB302","Thiết kế web với HTML5&CSS3");
        danhSachDAO.addLists(l14);
        Lists l15 = new Lists("ENT221","Tiếng Anh 2.2");
        danhSachDAO.addLists(l15);
        Lists l16 = new Lists("MOB201","Lập trình Android nâng cao");
        danhSachDAO.addLists(l16);
        Lists l17 = new Lists("MOB204","Dự án mẫu (ngành Mobile)");
        danhSachDAO.addLists(l17);
        Lists l18 = new Lists("PRO112","Dự án 1 - Lập trình Mobile");
        danhSachDAO.addLists(l18);
        Lists l19 = new Lists("MOB305","Lập trình Game 2D");
        danhSachDAO.addLists(l19);
        Lists l20 = new Lists("MOB306","Lập trình Mobile đa nền tảng");
        danhSachDAO.addLists(l20);
        Lists l21 = new Lists("MOB401","Lập trình game 2D nâng cao");
        danhSachDAO.addLists(l21);
        Lists l22 = new Lists("MOB402","Lập trình Sever cho Android");
        danhSachDAO.addLists(l22);


        lists = danhSachDAO.getAll();
        courseBase = new CourseBase(lists,getContext());
        listView.setAdapter(courseBase);
        courseBase.notifyDataSetChanged();

        edtTimKiem = view.findViewById(R.id.edtTimKiem);

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                        danhSachDAO = new DanhSachDAO(getActivity());
                        lists = danhSachDAO.getAll1(edtTimKiem.getText().toString());
                        courseBase = new CourseBase(lists,getActivity());
                        listView.setAdapter(courseBase);
                        courseBase.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),XacNhanActivity.class);
                Bundle b = new Bundle();
                b.putString("maMon",lists.get(position).getMaMon());
                b.putString("monHoc",lists.get(position).getMonHoc());
                i.putExtras(b);
                startActivity(i);
            }
        });

        return view;
    }
}
