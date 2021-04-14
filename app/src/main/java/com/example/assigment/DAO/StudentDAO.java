package com.example.assigment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.assigment.database.DatabaseHelper;
import com.example.assigment.model.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "monhoc";
    public static final String SQL_DANH_SACH_MON = "CREATE TABLE monhoc(mamon text primary key, monhoc text);";

    public StudentDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int insertDanhSach(Students lv){
        ContentValues values = new ContentValues();
        values.put("mamon",lv.getMaMon());
        values.put("monhoc",lv.getMonHoc());
        try{
            if (db.insert(TABLE_NAME,null,values)==-1){
                return -1;
            }else {
                return 1;
            }
        }catch (Exception ex){
            Log.e("TAG",ex.toString());
        }
        return 1;
    }
    public List<Students> getMonHoc(){
        List<Students> lsND = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()== false){
            Students nd = new Students();
            nd.setMaMon(cursor.getString(0));
            nd.setMonHoc(cursor.getString(1));
            lsND.add(nd);
            cursor.moveToNext();
        }
        cursor.close();
        return lsND;
    }
}
