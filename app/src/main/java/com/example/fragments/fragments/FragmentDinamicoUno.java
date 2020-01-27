package com.example.fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentDinamicoUno extends Fragment {

    EditText edit_fragment_d_uno;
    Button button_fragment_d_uno;
    View view;
    Context context;
    OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            listener = (OnFragmentUnoListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dinamico_uno, container, false);
        edit_fragment_d_uno = view.findViewById(R.id.edit_fragment_d_uno);
        button_fragment_d_uno = view.findViewById(R.id.button_fragment_d_uno);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button_fragment_d_uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, edit_fragment_d_uno.getText(), Toast.LENGTH_SHORT).show();
                listener.onFragmentUnoSelected(edit_fragment_d_uno.getText().toString());
            }
        });
    }

    public interface OnFragmentUnoListener {
        void onFragmentUnoSelected(String nombre);
    }
}
