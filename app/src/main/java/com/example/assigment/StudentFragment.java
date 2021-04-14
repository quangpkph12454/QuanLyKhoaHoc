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

import com.example.assigment.DAO.StudentDAO;
import com.example.assigment.adapter.StudentAdapter;
import com.example.assigment.model.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    public static List<Students> dsMonHoc = new ArrayList<>();
    ListView lvHoc;
    StudentAdapter adapter = null;
    StudentDAO studentDAO;

    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        lvHoc = view.findViewById(R.id.lvHoc);
        studentDAO = new StudentDAO(getActivity());
        dsMonHoc = studentDAO.getMonHoc();
        adapter = new StudentAdapter(dsMonHoc,getActivity());
        lvHoc.setAdapter(adapter);
        lvHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                View views = inflater.inflate(R.layout.my_dialog_lv,null);
                builder.setView(views);
                TextView tvMaMonHocTT = views.findViewById(R.id.tvMaMonHocTT);
                TextView tvMonHocTT = views.findViewById(R.id.tvMonHocTT);
                tvMonHocTT.setText(dsMonHoc.get(position).getMonHoc());
                tvMaMonHocTT.setText(dsMonHoc.get(position).getMaMon());
                builder.setTitle("Thông tin môn đăng kí");
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
