package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class DetailDataActivity extends AppCompatActivity {
    EditText dtNo, dtNama, dtTtl, dtJk, dtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        dtNo = findViewById(R.id.dtlNo);
        dtNama = findViewById(R.id.dtlNama);
        dtTtl = findViewById(R.id.dtlTtl);
        dtJk = findViewById(R.id.dtlJk);
        dtAlamat = findViewById(R.id.dtlAlamat);
        disableThis(dtNo);
        disableThis(dtNama);
        disableThis(dtTtl);
        disableThis(dtJk);
        disableThis(dtAlamat);

        MahasiswaBean mahasiswaBean = getIntent().getParcelableExtra("DETAIL_INTENT");
        dtNo.setText(String.valueOf(mahasiswaBean.getNmr()));
        dtNama.setText(mahasiswaBean.getNama());
        dtTtl.setText(mahasiswaBean.getTgllahir());
        dtJk.setText(mahasiswaBean.getJk());
        dtAlamat.setText(mahasiswaBean.getAlamat());
    }

    public void disableThis(EditText edt){
        edt.setFocusable(false);
    }
}
