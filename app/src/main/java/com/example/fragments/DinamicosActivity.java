package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.fragments.FragmentDinamicoDos;
import com.example.fragments.fragments.FragmentDinamicoUno;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class DinamicosActivity extends AppCompatActivity implements View.OnClickListener, FragmentDinamicoUno.OnFragmentUnoListener {

    Button boton_fragment1, boton_fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamicos);
        instancias();
        acciones();

        FragmentManager fragment_manager = getSupportFragmentManager();
        FragmentTransaction fragment_transaction = fragment_manager.beginTransaction();

        fragment_transaction.replace(R.id.frame_fragments_dinamicos, new FragmentDinamicoDos(), "TAG_FG");
        fragment_transaction.addToBackStack(null);
        fragment_transaction.commit();
    }

    private void acciones() {
        boton_fragment1.setOnClickListener(this);
        boton_fragment2.setOnClickListener(this);
    }

    private void instancias() {
        boton_fragment1 = findViewById(R.id.boton_fragment1);
        boton_fragment2 = findViewById(R.id.boton_fragment2);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

        switch (v.getId()){
            case R.id.boton_fragment1:
                ft.replace(R.id.frame_fragments_dinamicos, new FragmentDinamicoUno(), "F1");
                ft.addToBackStack("F1");

                break;
            case R.id.boton_fragment2:
                ft.replace(R.id.frame_fragments_dinamicos, new FragmentDinamicoDos(), "F2");
                ft.addToBackStack("F2");

                break;
        }
        ft.commit();
    }

    @Override
    public void onFragmentUnoSelected(String nombre) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.frame_fragments_dinamicos, FragmentDinamicoDos.newInstance(nombre), "F2");
        ft.addToBackStack(null);
        ft.commit();
    }
}
