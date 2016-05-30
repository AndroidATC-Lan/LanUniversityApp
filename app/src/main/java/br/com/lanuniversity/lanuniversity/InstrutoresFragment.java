package br.com.lanuniversity.lanuniversity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.lanuniversity.lanuniversity.Constants;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstrutoresFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstrutoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstrutoresFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private List<Instrutor> instrutores;
    private ArrayAdapter adapter;

    public InstrutoresFragment() {
        // Required empty public constructor
    }

    public static InstrutoresFragment newInstance() {
        InstrutoresFragment fragment = new InstrutoresFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String jsonServerAddress = Constants.cAPI_INSTRUTORES;
//        Log.d("Server address", jsonServerAddress);
//
//        HttpJsonConnection jsonConnection = new HttpJsonConnection();
//        jsonConnection.execute(jsonServerAddress);
        try {
//            String jsonString = jsonConnection.get();
            String jsonString = getResources().getString(R.string.instrutores_txt);
            Instrutores jsonInstrutores = new Instrutores();
            instrutores = jsonInstrutores.getInstrutores(jsonString);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_instrutores, container, false);
        InstrutoresAdapter adapter = new InstrutoresAdapter(this.getContext(),instrutores);
        ListView listInstrutores = (ListView) rootView.findViewById(R.id.lstInstrutores);
        listInstrutores.setAdapter(adapter);

        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
