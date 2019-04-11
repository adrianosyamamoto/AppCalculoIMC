package com.example.adrianoyamamoto.appcalculoimc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    public Conexao(Context context) {
        super(context, "Herois", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DADOSIMC (CPF TEXT, PESO REAL, ALTURA REAL, IMC REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE DADOSIMC");
        this.onCreate(db);
    }
}
