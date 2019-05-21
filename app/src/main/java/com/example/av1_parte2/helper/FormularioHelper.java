package com.example.av1_parte2.helper;

import android.widget.EditText;

import com.example.av1_parte2.FormularioActivity;
import com.example.av1_parte2.R;
import com.example.av1_parte2.model.Aluno;

public class FormularioHelper {
    private int id = 0;
    private final EditText campoRa;
    private final EditText campoNome;
    private final EditText campoCurso;
    private final EditText campoNota_1;
    private final EditText campoNota_2;
    private final EditText campoNota_3;
    private final EditText campoNota_4;
    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        this.campoRa = activity.findViewById(R.id.formulario_ra);
        this.campoNome = activity.findViewById(R.id.formulario_nome);
        this.campoCurso = activity.findViewById(R.id.formulario_curso);;
        this.campoNota_1 = activity.findViewById(R.id.formulario_nota1);
        this.campoNota_2 = activity.findViewById(R.id.formulario_nota2);
        this.campoNota_3 = activity.findViewById(R.id.formulario_nota3);
        this.campoNota_4 = activity.findViewById(R.id.formulario_nota4);
        aluno = new Aluno();
    }

    public Aluno getAluno() {
        aluno.setId(id);
        aluno.setRa(campoRa.getText().toString());
        aluno.setNome(campoNome.getText().toString());
        aluno.setCurso(campoCurso.getText().toString());
        aluno.setNota_1((Double.valueOf(campoNota_1.getText().toString())));
        aluno.setNota_2((Double.valueOf(campoNota_2.getText().toString())));
        aluno.setNota_3((Double.valueOf(campoNota_3.getText().toString())));
        aluno.setNota_4((Double.valueOf(campoNota_4.getText().toString())));
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        id = aluno.getId();
        campoRa.setText(aluno.getRa());
        campoNome.setText(aluno.getNome());
        campoRa.setEnabled(false);
        campoNome.setEnabled(false);
        campoCurso.setText(aluno.getCurso());
        campoNota_1.setText(aluno.getNota_1().toString());
        campoNota_2.setText(aluno.getNota_2().toString());
        campoNota_3.setText(aluno.getNota_3().toString());
        campoNota_4.setText(aluno.getNota_4().toString());
        this.aluno = aluno;
    }
}
