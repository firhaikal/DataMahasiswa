package com.example.datamahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

public class MahasiswaBean implements Parcelable {
    int nmr;
    String nama;
    String tgllahir;
    String jk;
    String alamat;

    protected MahasiswaBean(Parcel in) {
        this.nmr = in.readInt();
        this.nama = in.readString();
        this.tgllahir = in.readString();
        this.jk = in.readString();
        this.alamat = in.readString();
    }

    public MahasiswaBean() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nmr);
        dest.writeString(this.nama);
        dest.writeString(this.tgllahir);
        dest.writeString(this.jk);
        dest.writeString(this.alamat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MahasiswaBean> CREATOR = new Parcelable.Creator<MahasiswaBean>() {
        @Override
        public MahasiswaBean createFromParcel(Parcel source) {
            return new MahasiswaBean(source);
        }

        @Override
        public MahasiswaBean[] newArray(int size) {
            return new MahasiswaBean[size];
        }
    };

    public int getNmr() {
        return nmr;
    }

    public void setNmr(int nmr) {
        this.nmr = nmr;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
