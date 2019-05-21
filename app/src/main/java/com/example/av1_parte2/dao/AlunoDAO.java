package com.example.av1_parte2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.av1_parte2.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SQLiteOpenHelper {
    public AlunoDAO(Context context) {
        super(context, "Alunos", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ra TEXT UNIQUE NOT NULL," +
                " nome TEXT NOT NULL," +
                " curso TEXT NOT NULL," +
                " nota_1 REAL NOT NULL DEFAULT 0," +
                " nota_2 REAL NOT NULL DEFAULT 0," +
                " nota_3 REAL NOT NULL DEFAULT 0," +
                " nota_4 REAL NOT NULL DEFAULT 0);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "";
        switch (oldVersion) {
            case 1:
        }
    }

    public void insert(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = getContentValuesAluno(aluno);
        db.insert("Alunos", null, data);
    }

    private ContentValues getContentValuesAluno(Aluno aluno) {
        ContentValues data = new ContentValues();
        data.put("ra", aluno.getRa());
        data.put("nome", aluno.getNome());
        data.put("curso", aluno.getCurso());
        data.put("nota_1", aluno.getNota_1());
        data.put("nota_2", aluno.getNota_2());
        data.put("nota_3", aluno.getNota_3());
        data.put("nota_4", aluno.getNota_4());
        return data;
    }

    public List<Aluno> getAlunos() {
        String sql = "SELECT * FROM Alunos";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Aluno> alunos = new ArrayList<Aluno>();
        while (c.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setId(c.getInt(c.getColumnIndex("id")));
            aluno.setRa(c.getString(c.getColumnIndex("ra")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setCurso(c.getString(c.getColumnIndex("curso")));
            aluno.setNota_1(c.getDouble(c.getColumnIndex("nota_1")));
            aluno.setNota_2(c.getDouble(c.getColumnIndex("nota_2")));
            aluno.setNota_3(c.getDouble(c.getColumnIndex("nota_3")));
            aluno.setNota_4(c.getDouble(c.getColumnIndex("nota_4")));
            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }

    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Integer.toString(aluno.getId())};
        db.delete("Alunos", "id = ?", params);
    }

    public void update(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Integer.toString(aluno.getId())};
        db.update("Alunos", getContentValuesAluno(aluno), "id = ?", params);
    }

}
