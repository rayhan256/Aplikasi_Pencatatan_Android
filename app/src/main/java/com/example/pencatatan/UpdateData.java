package com.example.pencatatan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4, text5;
    String edit;
    TextView textV1,textV2,textV3,textV4,textV5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editTextKode);
        text2 = (EditText) findViewById(R.id.editTextNama);
        text3 = (EditText) findViewById(R.id.editTextHarga);
        text4 = (EditText) findViewById(R.id.editTextBerat);
        text5 = (EditText) findViewById(R.id.editTextStok);
        textV1=(TextView)findViewById(R.id.textViewKode);
        textV2=(TextView)findViewById(R.id.textViewNama);
        textV3=(TextView)findViewById(R.id.textViewHarga);
        textV4=(TextView)findViewById(R.id.textViewBerat);
        textV5=(TextView)findViewById(R.id.textViewStok);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM produk WHERE nama = '" + getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }

        ton1 = (Button) findViewById(R.id.buttonSimpan);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                edit = text1.getText().toString();
                edit=text2.getText().toString();
                edit=text3.getText().toString();
                edit=text4.getText().toString();
                edit=text5.getText().toString();
                if(edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Kolom tidak boleh kosong...",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.execSQL("update produk set nama='"+
                            text2.getText().toString() +"', harga='" +
                            text3.getText().toString()+"', berat='"+
                            text4.getText().toString() +"', stok='" +
                            text5.getText().toString() + "' where kode='" +
                            text1.getText().toString()+"'");
                    Toast.makeText(getApplicationContext(), "Perubahan Tersimpan...", Toast.LENGTH_LONG).show();
                    finish();
                }
                DataProduct.dp.RefreshList();
            }
        });

    }
}
