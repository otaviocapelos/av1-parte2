package com.example.av1_parte2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.av1_parte2.adapter.AlunoAdapter;
import com.example.av1_parte2.dao.AlunoDAO;
import com.example.av1_parte2.model.Aluno;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        Button novoAluno = (Button) findViewById(R.id.lista_novo_aluno);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRedirectFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentRedirectFormulario);
            }
        });
        registerForContextMenu(listaAlunos);
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(position);
                Intent redirectFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                redirectFormulario.putExtra("aluno", aluno);
                startActivity(redirectFormulario);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);

        MenuItem itemDeletar = menu.add("Deletar");

        itemDeletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
                dao.deleta(aluno);
                FillAlunos();
                Toast.makeText(ListaAlunosActivity.this, "Deletar o aluno " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void FillAlunos() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.getAlunos();
        AlunoAdapter adapter = new AlunoAdapter(this, alunos);
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FillAlunos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }
}
