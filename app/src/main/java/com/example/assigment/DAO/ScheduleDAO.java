package com.example.assigment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assigment.database.DatabaseHelper;
import com.example.assigment.model.Schedules;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "LICHHOC";
    public static final String SQL_LICH_HOC = "CREATE TABLE LICHHOC ( ngayThang text primary key, maMonHoc text, tenMonHoc text, lop text, thoiGian text);";

    public ScheduleDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void addLists(Schedules lists){
        ContentValues cvl =new ContentValues();
        cvl.put("ngayThang",lists.getNgayThang());
        cvl.put("maMonHoc",lists.getMaMonHoc());
        cvl.put("tenMonHoc",lists.getTenMonHoc());
        cvl.put("lop",lists.getLop());
        cvl.put("thoiGian",lists.getThoiGian());
        db.insert(TABLE_NAME,null,cvl);
    }

    public List<Schedules> getSchedule(){
        List<Schedules> list = new ArrayList<>();
        Cursor cursor= db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String ngayThang, maMonHoc,tenMonHoc,lop,thoiGian;
            ngayThang = cursor.getString(0);
            maMonHoc = cursor.getString(1);
            tenMonHoc = cursor.getString(2);
            lop = cursor.getString(3);
            thoiGian = cursor.getString(4);
            list.add(new Schedules(ngayThang,maMonHoc, tenMonHoc,lop,thoiGian));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<Schedules> getAll1(String a){
        List<Schedules> listSP = new ArrayList<>();
        String getSQL ="select * from LICHHOC where maMonHoc = '"+a+"' ";
        Cursor cursor=db.rawQuery(getSQL,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String ngayThang, maMonHoc,tenMonHoc,lop,thoiGian;
            ngayThang = cursor.getString(0);
            maMonHoc = cursor.getString(1);
            tenMonHoc = cursor.getString(2);
            lop = cursor.getString(3);
            thoiGian = cursor.getString(4);
            listSP.add(new Schedules(ngayThang,maMonHoc, tenMonHoc,lop,thoiGian));
            cursor.moveToNext();
        }
        cursor.close();
        return listSP;
    }
}
