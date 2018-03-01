package com.example.juansebastianquinayasguarin.preexamenlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText nombre, hotmail, contraseña, repitaCont;
    private Button registrar, cancelar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegistroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroFragment newInstance(String param1, String param2) {
        RegistroFragment fragment = new RegistroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista_login = inflater.inflate(R.layout.fragment_registro, container, false);

        nombre = (EditText) vista_login.findViewById(R.id.nombreRegst);
        hotmail = (EditText) vista_login.findViewById(R.id.hotmailRegist);
        contraseña = (EditText) vista_login.findViewById(R.id.contrasenaRegist);
        repitaCont = (EditText) vista_login.findViewById(R.id.repitContRegist);
        registrar = (Button) vista_login.findViewById(R.id.btn_Enviar);
        cancelar = (Button) vista_login.findViewById(R.id.btn_Cancelar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Hotmail = hotmail.getText().toString().trim();
                String repCont = repitaCont.getText().toString().trim();
                String Nombre = nombre.getText().toString().trim();
                String cont = contraseña.getText().toString().trim();
                Log.v("todo", Hotmail + cont + repCont + Nombre);
                System.out.println(cont + " : " + repCont);
                if (!TextUtils.isEmpty(Nombre) && !TextUtils.isEmpty(Hotmail) && !TextUtils.isEmpty(cont) && !TextUtils.isEmpty(repCont)) {
                    if (cont.equals(repCont)) {
                        if (String.valueOf(contraseña.getText()).length() >= 6) {
                            ((MainActivity) getActivity()).registrarUsuario(Nombre, Hotmail, cont);
                        }
                    }
                }else{
                    Toast.makeText(vista_login.getContext(), "por favor rrellene todos los campos.", Toast.LENGTH_SHORT).show();
                }
                ((MainActivity) getActivity()).pantallaLogin();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(vista_login.getContext(), "Compruebe que los campos no esten vacios", Toast.LENGTH_SHORT).show();
            }
        });
        return vista_login;
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
