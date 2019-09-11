package com.example.datamahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="DataMsiswa";
    private static final String TABLE_NAME="t_msiswa";

    public DatabaseHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable="Create Table "+TABLE_NAME+"(nmr Integer PRIMARY KEY, nama TEXT, tgllahir TEXT, jk TEXT, alamat TEXT)";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert (MahasiswaBean mahasiswaBean){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("nmr",mahasiswaBean.getNmr());
        values.put("nama",mahasiswaBean.getNama());
        values.put("tgllahir",mahasiswaBean.getTgllahir());
        values.put("jk",mahasiswaBean.getJk());
        values.put("alamat",mahasiswaBean.getAlamat());

        db.insert(TABLE_NAME, null, values);
    }

    public List<MahasiswaBean> selectUserData(){
        ArrayList<MahasiswaBean> msList=new ArrayList<>();

        SQLiteDatabase db= getReadableDatabase();
        String[] columns={"nmr", "nama", "tgllahir", "jk", "alamat"};

        Cursor c=db.query(TABLE_NAME, columns, null, null, null, null, null);

        while (c.moveToNext()){
            int nmr=c.getInt(1);
            String nama=c.getString(0);
            String tgllahir=c.getString(0);
            String jk=c.getString(0);
            String alamat=c.getString(0);

            MahasiswaBean mahasiswaBean=new MahasiswaBean();
            mahasiswaBean.setNmr(nmr);
            mahasiswaBean.setNama(nama);
            mahasiswaBean.setTgllahir(tgllahir);
            mahasiswaBean.setJk(jk);
            mahasiswaBean.setAlamat(alamat);
            msList.add(mahasiswaBean);
        }
        return msList;
    }

    public void delete (int nmr){
        SQLiteDatabase db=getWritableDatabase();
        String whereClause="nmr='"+nmr+"'";
        db.delete(TABLE_NAME, whereClause, null);
    }

    public void update (MahasiswaBean mahasiswaBean){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama",mahasiswaBean.getNama());
        values.put("tgllahir",mahasiswaBean.getTgllahir());
        values.put("jk",mahasiswaBean.getJk());
        values.put("alamat",mahasiswaBean.getAlamat());
        String whereClause="nmr = '"+mahasiswaBean.getNmr()+"'";
        db.update(TABLE_NAME, values, whereClause, null);
    }
}
