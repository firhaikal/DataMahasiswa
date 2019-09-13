package com.example.datamahasiswa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DatabaseHelper dbHelp;
    ListDataActivity listDataActivity;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dbHelp = new DatabaseHelper(this);
        final EditText nmr = (EditText) findViewById(R.id.txtNomor);
        final EditText nama = (EditText) findViewById(R.id.txtNama);
        final EditText tgllahir = (EditText) findViewById(R.id.txtTanggalLahir);
        final EditText jk = (EditText) findViewById(R.id.txtJenisKelamin);
        final EditText alamat = (EditText) findViewById(R.id.txtAlamat);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelp.getWritableDatabase();
                db.execSQL("INSERT INTO t_msiswa(nmr, nama, tgllahir, jk, alamat) VALUES('"+
                        nmr.getText().toString() + "','" +
                        nama.getText().toString() + "','" +
                        tgllahir.getText().toString() + "','" +
                        jk.getText().toString() + "','" +
                        alamat.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                dbHelp.selectUserData();
                finish();
            }
        });
    }
}
