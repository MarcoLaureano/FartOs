package com.example.fartos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fartos.Adapter.CartasAdapter;

import java.util.ArrayList;

public class JugadoresActivity extends AppCompatActivity {
    private ArrayList<String> playerNames;
    private ListView listView;

    RecyclerView mazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        playerNames = getIntent().getStringArrayListExtra("playerNames");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerNames);

        listView = findViewById(R.id.Listjugadors);
        listView.setAdapter(adapter);
        mazo = findViewById(R.id.deckcard);

        //RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mazo.setLayoutManager(layoutManager);
        CartasAdapter cartasAdapter = new CartasAdapter();
        mazo.setAdapter(cartasAdapter);

        //Al pulsar una carta
        mazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear y mostrar el DialogFragment aquí
            }
        });
    }
}