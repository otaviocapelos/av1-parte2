package com.example.av1_parte2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.av1_parte2.R;
import com.example.av1_parte2.model.Aluno;

import java.util.List;

public class AlunoAdapter extends BaseAdapter {

    private final List<Aluno> alunos;
    private final Context context;

    public AlunoAdapter(Context context, List<Aluno> alunos) {
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if (convertView == null) view = inflater.inflate(R.layout.list_item, parent, false);

        TextView campoRa = (TextView) view.findViewById(R.id.item_ra);
        campoRa.setText(aluno.getRa());

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(aluno.getNome());

        TextView campoMedia = (TextView) view.findViewById(R.id.item_media);
        campoMedia.setText(new Double(aluno.getMedia()).toString());

        return view;
    }
}
