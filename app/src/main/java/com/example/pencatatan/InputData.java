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

public class InputData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    private Button tom1;
    EditText text1, text2, text3, text4, text5;
    String edit;
    TextView textv1, textv2, textv3, textv4, textv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        dbHelper = new DataHelper(this);
        text1 = (EditText)findViewById(R.id.editTextKode);
        text2 = (EditText)findViewById(R.id.editTextNama);
        text3 = (EditText)findViewById(R.id.editTextHarga);
        text4 = (EditText)findViewById(R.id.editTextBerat);
        text5 = (EditText)findViewById(R.id.editTextStok);

        textv1 = (TextView)findViewById(R.id.textViewKode);
        textv2 = (TextView)findViewById(R.id.textViewNama);
        textv3 = (TextView)findViewById(R.id.textViewHarga);
        textv4 = (TextView)findViewById(R.id.textViewBerat);
        textv5 = (TextView)findViewById(R.id.textViewStok);
        tom1 = (Button)findViewById(R.id.buttonSimpan);

        tom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                edit = text1.getText().toString();
                edit = text2.getText().toString();
                edit = text3.getText().toString();
                edit = text4.getText().toString();
                edit = text5.getText().toString();

                if (edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("insert into produk (kode, nama, harga, berat, stok) " + " values('" +
                            text1.getText().toString() + "','" +
                            text2.getText().toString() + "','" +
                            text3.getText().toString() + "','" +
                            text4.getText().toString() + "','" +
                            text5.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Data Tersimpan ", Toast.LENGTH_LONG).show();
                }
                DataProduct.dp.RefreshList();
            }
        });


    }
}
