package com.example.fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentDinamicoDos extends Fragment {

    TextView texto_recuperar_callback;
    View v;
    public static String KEY_ARG_PARAM1 = "nombre";
    String nombre;

    public static FragmentDinamicoDos newInstance(String nombre) {
        FragmentDinamicoDos fragmentDinamicoDos = new FragmentDinamicoDos();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ARG_PARAM1, nombre);
        fragmentDinamicoDos.setArguments(bundle);

        return fragmentDinamicoDos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombre = this.getArguments().getString(KEY_ARG_PARAM1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_dos, container, false);
        texto_recuperar_callback = v.findViewById(R.id.texto_recuperar_callback);

        texto_recuperar_callback.setText(nombre);

        return v;
    }

}
