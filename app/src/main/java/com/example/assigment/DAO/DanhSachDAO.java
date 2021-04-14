package com.example.assigment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assigment.database.DatabaseHelper;
import com.example.assigment.model.Lists;

import java.util.ArrayList;
import java.util.List;

public class DanhSachDAO {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "danhsach";
    public static final String SQL_DANH_SACH = "CREATE TABLE danhsach(maMon text primary key, monHoc text);";

    public DanhSachDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void addLists(Lists lists){
        ContentValues cvl =new ContentValues();

        cvl.put("maMon",lists.getMaMon());
        cvl.put("monHoc",lists.getMonHoc());
        db.insert(TABLE_NAME,null,cvl);
    }

    public List<Lists> getAll(){
        List<Lists> listSP = new ArrayList<>();
        String getSQL ="select * from danhsach ";
        Cursor cursor=db.rawQuery(getSQL,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String maMon, monHoc;
            maMon = cursor.getString(0);
            monHoc = cursor.getString(1);
            listSP.add(new Lists(maMon, monHoc));
            cursor.moveToNext();
        }
        cursor.close();
        return listSP;
    }
    public List<Lists> getAll1(String a){
        List<Lists> listSP = new ArrayList<>();
        String getSQL ="select * from danhsach where maMon like '%"+a+"%' ";
        Cursor cursor=db.rawQuery(getSQL,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String maMon, monHoc;
            maMon = cursor.getString(0);
            monHoc = cursor.getString(1);
            listSP.add(new Lists(maMon, monHoc));
            cursor.moveToNext();
        }
        cursor.close();
        return listSP;
    }
    public Lists getMonHocByID(String maMon){
        Lists s = null;
        String selection = "maMon=?";
        String[] selectionArgs = {maMon};
        Cursor c = db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            s = new Lists();
            s.setMaMon(c.getString(0));
            s.setMonHoc(c.getString(1));
            break;
        }
        c.close();
        return s;
    }
}
