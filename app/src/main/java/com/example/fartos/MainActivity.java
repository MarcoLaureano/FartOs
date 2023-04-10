package com.example.fartos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private ArrayList<EditText> playerEditTexts;
    private Button start, addPlayer, removePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerEditTexts = new ArrayList<>();

        layout = findViewById(R.id.layout);
        playerEditTexts.add((EditText) findViewById(R.id.player1));
        playerEditTexts.add((EditText) findViewById(R.id.player2));
        playerEditTexts.add((EditText) findViewById(R.id.player3));

        start = findViewById(R.id.start);
        addPlayer = findViewById(R.id.addPlayer);
        removePlayer = findViewById(R.id.removePlayer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arePlayerNamesEmpty()) {
                    Toast.makeText(MainActivity.this, "Introduce los nombres de todos los jugadores", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, JugadoresActivity.class);
                    intent.putStringArrayListExtra("playerNames", getPlayerNames());
                    startActivity(intent);
                }
            }
        });


        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerEditTexts.size() < 6) {
                    EditText newEditText = new EditText(MainActivity.this);
                    newEditText.setHint("Nombre del jugador");
                    playerEditTexts.add(newEditText);
                    layout.addView(newEditText);
                } else {
                    Toast.makeText(MainActivity.this, "Ya has añadido el número máximo de jugadores", Toast.LENGTH_SHORT).show();
                }
            }
        });

        removePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerEditTexts.size() > 3) {
                    EditText removedEditText = playerEditTexts.remove(playerEditTexts.size() - 1);
                    layout.removeView(removedEditText);
                } else {
                    Toast.makeText(MainActivity.this, "No puedes quitar más jugadores", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean arePlayerNamesEmpty() {
        for (EditText playerEditText : playerEditTexts) {
            if (playerEditText.getText().toString().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> getPlayerNames() {
        ArrayList<String> playerNames = new ArrayList<>();
        for (EditText playerEditText : playerEditTexts) {
            playerNames.add(playerEditText.getText().toString().trim());
        }
        return playerNames;
    }

}