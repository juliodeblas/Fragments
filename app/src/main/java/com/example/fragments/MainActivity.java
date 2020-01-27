package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import static com.example.fragments.R.id.fragment_estatico_uno;

public class MainActivity extends AppCompatActivity {

    Fragment fragment_estatico_uno, fragment_estatico_dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        //fragment_estatico_uno = findViewById(R.id.fragment_estatico_uno);

        FragmentManager fragment_manager = getSupportFragmentManager();
        fragment_estatico_uno = fragment_manager.findFragmentById(R.id.fragment_estatico_uno);
        fragment_estatico_dos = fragment_manager.findFragmentById(R.id.fragment_estatico_dos);
    }
}
