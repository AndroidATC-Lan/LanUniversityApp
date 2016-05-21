/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 20/05/16.
 *
 * Classe responsavel por fazer a conexao entre os objetos do tipo Curso
 * e as views de CursosFragment.
 *
 */

package br.com.lanuniversity.lanuniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CursosAdapter extends ArrayAdapter {

    public CursosAdapter(Context context, List<Curso> cursos) {
        super(context, 0, cursos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Curso curso = (Curso) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_curso, parent, false);
        }

        TextView txtNomeDoCurso = (TextView) convertView.findViewById(R.id.txtNomeDoCurso);
        TextView txtConteudoDoCurso = (TextView) convertView.findViewById(R.id.txtConteudoDoCurso);

        txtNomeDoCurso.setText(curso.getNomeDoCurso());
        txtConteudoDoCurso.setText(curso.getConteudoDoCurso());

        return convertView;
    }
}
