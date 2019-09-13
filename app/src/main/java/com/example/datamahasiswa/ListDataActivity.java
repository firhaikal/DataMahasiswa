package com.example.datamahasiswa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity implements MSiswaAdapter.UserActionListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<MahasiswaBean> listMSiswaInfo;
    Context context;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        context = this;

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(ListDataActivity.this,DividerItemDecoration.VERTICAL));

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setupRV();

        btnAdd = findViewById(R.id.btnInp);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inp = new Intent(context,InputActivity.class);
                startActivity(inp);
            }
        });
    }

    public void setupRV(){
        DatabaseHelper db = new DatabaseHelper(this);
        listMSiswaInfo = db.selectUserData();
        MSiswaAdapter adapter = new MSiswaAdapter(this, listMSiswaInfo, this);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserAction(final MahasiswaBean mahasiswaBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pilihan").setPositiveButton("Lihat Detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent detailData = new Intent(context, DetailDataActivity.class);
                        detailData.putExtra("DETAIL_INTENT", String.valueOf(mahasiswaBean));
                        context.startActivity(detailData);

                    }
                }).setNegativeButton("Ubah Data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent updateData = new Intent(context,InputActivity.class);
                updateData.putExtra("UPDATE_INTENT", String.valueOf(mahasiswaBean));
                updateData.putExtra("UPDATE_ACTION","Update");
                context.startActivity(updateData);
            }
        }).setNeutralButton("Hapus Data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper db = new DatabaseHelper(context);
                db.delete(mahasiswaBean.getNmr());
                setupRV();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        Intent pindah = new Intent(this,DashboardActivity.class);
        startActivity(pindah);
    }
}
