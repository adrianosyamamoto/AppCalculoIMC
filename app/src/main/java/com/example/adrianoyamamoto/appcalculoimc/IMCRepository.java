package com.example.adrianoyamamoto.appcalculoimc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class IMCRepository {
    SQLiteDatabase db;

    public IMCRepository(Context context) {
        Conexao cn = new Conexao(context);
        db = cn.getWritableDatabase();
    }

    public void salvar(IMC dadosImc) {
        ContentValues valores = new ContentValues();

        valores.put("CPF", dadosImc.getCPF());
        valores.put("PESO", dadosImc.getPeso());
        valores.put("ALTURA", dadosImc.getAltura());
        valores.put("IMC", dadosImc.getImc());

        db.insert("DADOSIMC", null, valores);
    }

    public IMC listarPorCPF(String cpf) {

        Cursor cursor = db.rawQuery("SELECT * FROM DADOSIMC WHERE CPF = '" + cpf + "'" , null);

        if(cursor.moveToFirst()) {
            IMC dadosImc = new IMC();

            dadosImc.setPeso(cursor.getFloat(cursor.getColumnIndex("PESO")));
            dadosImc.setCPF(cursor.getString(cursor.getColumnIndex("CPF")));
            dadosImc.setAltura(cursor.getFloat(cursor.getColumnIndex("ALTURA")));
            dadosImc.setImc(cursor.getFloat(cursor.getColumnIndex("IMC")));

            return dadosImc;
        }

        return null;
    }
}
