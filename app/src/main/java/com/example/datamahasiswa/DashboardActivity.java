package com.example.datamahasiswa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity{
    Button btnLihat, btnInput, btnInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnLihat = findViewById(R.id.btnLihat);
        btnInput = findViewById(R.id.btnInput);
        btnInfo = findViewById(R.id.btnInfo);

        onClickIntent(btnLihat, ListDataActivity.class);
        onClickIntent(btnInput, InputActivity.class);
        onClickIntent(btnInfo, InfoActivity.class);
    }

    public void onClickIntent(Button btn, final Class dest){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(DashboardActivity.this,dest);
                startActivity(pindah);
            }
        });
    }
}
