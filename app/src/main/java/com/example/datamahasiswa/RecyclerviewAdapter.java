package com.example.datamahasiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> { Context context;
    OnUserClickListener listener;

    List<MahasiswaBean> mahasiswaList;

    private String[] dataset;

    public RecyclerviewAdapter(List<MahasiswaBean> mahasiswaList){
        this.dataset = dataset;
    }
    public interface OnUserClickListener{
        void onUserClick(MahasiswaBean currentMs, String action);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_info, null);
        UserViewHolder userViewHolder = new UserViewHolder(view);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {

        final MahasiswaBean currentMs = mahasiswaList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, currentMs.getNmr(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return mahasiswaList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = (TextView)itemView.findViewById(R.id.nama_ms);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
