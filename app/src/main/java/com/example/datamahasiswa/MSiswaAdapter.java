package com.example.datamahasiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MSiswaAdapter extends RecyclerView.Adapter<MSiswaAdapter.MyUserViewHolder> {
    List<MahasiswaBean> mahasiswaBeanList;
    Context context;
    UserActionListener listener;

    public interface UserActionListener{
        void onUserAction(MahasiswaBean mahasiswaBean);
    }

    public MSiswaAdapter(Context context, List<MahasiswaBean> listmahasiswaBean, UserActionListener listener){
        this.context=context;
        this.mahasiswaBeanList = listmahasiswaBean;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MSiswaAdapter.MyUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_info, parent, false);
        MyUserViewHolder vh = new MyUserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyUserViewHolder holder, int position) {
        final MahasiswaBean curMs = mahasiswaBeanList.get(position);
        holder.txtNama.setText(curMs.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserAction(curMs);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaBeanList.size();
    }

    public class MyUserViewHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        LinearLayout container;

        public MyUserViewHolder(@NonNull View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.nama_ms);
            container = itemView.findViewById(R.id.nmholder);
        }
    }

}
