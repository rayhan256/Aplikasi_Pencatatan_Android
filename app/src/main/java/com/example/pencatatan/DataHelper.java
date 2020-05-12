package com.example.pencatatan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bisnisku.db";
    private static final int DATABASE_VERSION = 1;
    private String sql;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "create table produk(kode text primary key, nama text null,\n" +
                "harga integer null, berat integer null, stok integer null)";
        Log.d("Data", "onCrate " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
