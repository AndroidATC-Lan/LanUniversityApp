/**
 * Created by Haraldo Filho<haraldo.filho@gmail.com> on 20/05/16.
 *
 * Classe responsavel por fazer a conexao entre os objetos do tipo Instrutor
 * e as views de InstrutoresFragment.
 *
 */

package br.com.lanuniversity.lanuniversity;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InstrutoresAdapter extends ArrayAdapter {

    public InstrutoresAdapter(Context context, List<Instrutor> instrutores  ) {
        super(context, 0, instrutores);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Instrutor instrutor = (Instrutor) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_instrutor, parent, false);
        }

        ImageView imgFotoDoInstrutor = (ImageView) convertView.findViewById(R.id.imgFotoDoInstrutor);
        TextView  txtNomeDoInstrutor = (TextView) convertView.findViewById(R.id.txtNomeDoInstrutor);
        TextView  txtHistoriaDoInstrutor = (TextView) convertView.findViewById(R.id.txtHistoriaDoInstrutor);

        Uri imgUri = Uri.parse(instrutor.getFotoDoInstrutor());
        imgFotoDoInstrutor.setImageURI(imgUri);
        txtNomeDoInstrutor.setText(instrutor.getNome());
        txtHistoriaDoInstrutor.setText(instrutor.getHistoriaDoInstrutor());

        return convertView;
    }

}
