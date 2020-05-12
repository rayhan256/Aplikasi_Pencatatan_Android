package com.example.pencatatan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class DetailData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.TextViewKode);
        text2 = (TextView) findViewById(R.id.TextViewNama);
        text3 = (TextView) findViewById(R.id.TextViewHarga);
        text4 = (TextView) findViewById(R.id.TextViewBerat);
        text5 = (TextView) findViewById(R.id.TextViewStok);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM produk WHERE nama = '" + getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
    }
}
