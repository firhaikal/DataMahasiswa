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

public class DashboardActivity extends Fragment implements View.OnClickListener {
    Button btnLihat, btnInput, btnInfo;
    Context context;

    public DashboardActivity(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getActivity();
        btnLihat =view.findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(this);
        btnInput =view.findViewById(R.id.btnInput);
        btnInput.setOnClickListener(this);
        btnInfo =view.findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLihat:
                Intent lihat = new Intent(view.getContext(), ListDataActivity.class);
                startActivity(lihat);
                break;
            case R.id.btnInput:
                Intent input = new Intent(view.getContext(), InputActivity.class);
                startActivity(input);
                break;
            case R.id.btnInfo:
                Intent info = new Intent(view.getContext(), InfoActivity.class);
                startActivity(info);
                break;
        }
    }
}
