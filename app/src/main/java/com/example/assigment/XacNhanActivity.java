package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assigment.DAO.DanhSachDAO;
import com.example.assigment.DAO.StudentDAO;
import com.example.assigment.adapter.StudentAdapter;
import com.example.assigment.model.Lists;
import com.example.assigment.model.Students;

import java.util.ArrayList;
import java.util.List;

public class XacNhanActivity extends AppCompatActivity {
    TextView tvXacNhan;
    Button btnYes,btnNo;
    String monHoc = "";
    String maMon= "";
    List<Students> students = new ArrayList<>();
    StudentDAO studentDAO;
    public List<Lists> lists = new ArrayList<>();
    StudentAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan);
        tvXacNhan = findViewById(R.id.tvXacNhan);
        adapter = new StudentAdapter(students,this);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b!=null){
            maMon = b.getString("maMon");
            monHoc = b.getString("monHoc");
            tvXacNhan.setText("Bạn có muốn đăng kí môn học " + maMon + " không?");
        }
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDAO = new StudentDAO(XacNhanActivity.this);
                DanhSachDAO danhSachDAO = new DanhSachDAO(XacNhanActivity.this);
                try {
                        Lists lists1 = danhSachDAO.getMonHocByID(maMon);
                        if (lists1 != null){
                            int pos = checkDangKi(students, maMon);
                            Students students1 = new Students(maMon,monHoc);
                            if (pos>=0){
                                students.set(pos,students1);
                            }else {
                                if (studentDAO.insertDanhSach(students1)>0){
                                    Toast.makeText(getApplicationContext(),"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                                    students.add(students1);
                                }else {
                                    Toast.makeText(getApplicationContext(),"Đã đăng kí",Toast.LENGTH_SHORT).show();
                                }
                            }

                            adapter.changeDataset(students);
                        }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(XacNhanActivity.this,XacNhanService.class);
                intent.putExtra("mamon",maMon);
                intent.putExtra("monhoc",monHoc);
                startService(intent);
            }
        });
    }
    public int checkDangKi(List<Students> ls, String maMon){
        int pos =-1;
        for (int i=0 ;i<ls.size() ; i++){
            Students danhsach = ls.get(i);
            if (danhsach.getMaMon().equalsIgnoreCase(maMon)){
                pos = i;
                break;
            }
        }
        return pos;
    }

}
