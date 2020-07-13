package br.com.projeto.professorpersonal.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Trainer implements Parcelable {

    private String nome;
    private String sobreNome;
    private String numeroCREF;
    private String numeroIdentidade;
    private String email;

    public Trainer(String nome, String sobrenome, String numeroCREF,
                   String numeroIdentidade, String email) {
        this.nome = nome;
        this.sobreNome = sobrenome;
        this.numeroCREF = numeroCREF;
        this.numeroIdentidade = numeroIdentidade;
        this.email = email;
    }

    protected Trainer(Parcel in) {
        nome = in.readString();
        sobreNome = in.readString();
        numeroCREF = in.readString();
        numeroIdentidade = in.readString();
        email = in.readString();
    }

    public static final Creator<Trainer> CREATOR = new Creator<Trainer>() {
        @Override
        public Trainer createFromParcel(Parcel in) {
            return new Trainer(in);
        }

        @Override
        public Trainer[] newArray(int size) {
            return new Trainer[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return "[ nome = " + this.nome +
                "\n sobrenome = " + this.sobreNome +
                "\n email = " + this.email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(sobreNome);
        dest.writeString(numeroCREF);
        dest.writeString(numeroIdentidade);
        dest.writeString(email);
    }
}
