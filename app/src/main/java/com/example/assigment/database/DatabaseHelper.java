package com.example.assigment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assigment.DAO.DanhSachDAO;
import com.example.assigment.DAO.ScheduleDAO;
import com.example.assigment.DAO.StudentDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "dbBM";
    final static int VERSION = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DanhSachDAO.SQL_DANH_SACH);
        db.execSQL(StudentDAO.SQL_DANH_SACH_MON);
        db.execSQL(ScheduleDAO.SQL_LICH_HOC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DanhSachDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + StudentDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScheduleDAO.TABLE_NAME);
        onCreate(db);
    }

}
