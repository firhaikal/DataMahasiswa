package com.example.datamahasiswa;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    EditText tNo, tNama, tTtl, tJk, tAlamat, label;
    Button btnSubmit;
    String no,act = "Submit";
    MahasiswaBean updated;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        context = this;

        act = getIntent().getStringExtra("UPDATE_ACTION");
        updated = getIntent().getParcelableExtra("UPDATE_INTENT");
        if (act==null){
            act = "Submit";
        }else {
            no = String.valueOf(updated.getNmr());
        }

        tNo = findViewById(R.id.txtNomor);
        tNama = findViewById(R.id.txtNama);
        tTtl = findViewById(R.id.txtTanggalLahir);
        tJk = findViewById(R.id.txtJenisKelamin);
        tAlamat = findViewById(R.id.txtAlamat);

        btnSubmit = findViewById(R.id.btnSimpan);
        if (act.equals("Update")){
            btnSubmit.setText("Update Data");
            tNo.setText(no);
            tNo.setFocusable(false);
            tNama.setText(updated.getNama());
            tTtl.setText(updated.getTgllahir());
            tJk.setText(updated.getJk());
            tAlamat.setText(updated.getAlamat());
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                MahasiswaBean curMB = new MahasiswaBean();
                String btnStatus = btnSubmit.getText().toString();
                if (btnStatus.equals("Simpan")){
                    curMB.setNmr(Integer.parseInt(tNo.getText().toString()));
                    curMB.setNama(tNama.getText().toString());
                    curMB.setTgllahir(tTtl.getText().toString());
                    curMB.setJk(tJk.getText().toString());
                    curMB.setAlamat(tAlamat.getText().toString());
                    db.insert(curMB);
                    Intent pindah = new Intent(context, DashboardActivity.class);
                    context.startActivity(pindah);
                }
                if (btnStatus.equals("Update Data")){
                    curMB.setNmr(Integer.parseInt(tNo.getText().toString()));
                    curMB.setNama(tNama.getText().toString());
                    curMB.setTgllahir(tTtl.getText().toString());
                    curMB.setJk(tJk.getText().toString());
                    curMB.setAlamat(tAlamat.getText().toString());
                    db.update(curMB);
                    Intent pindah = new Intent(context, ListDataActivity.class);
                    context.startActivity(pindah);
                }
            }
        });
    }
}
