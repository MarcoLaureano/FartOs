package com.example.fartos.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartos.Cards.Carta;
import com.example.fartos.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartaViewHolder> {
    private List<Carta> cartas;
    private OnItemClickListener listener;

    public CartasAdapter() {
        List<Carta> barraja = new ArrayList<>();
        // Creamos las 58 cartas principales
        for (int i = 0; i < 28; i++) {
            barraja.add(new Carta("Mover 1 casilla", R.drawable.mover_1_casilla,1));
        }
        for (int i = 0; i < 18; i++) {
            barraja.add(new Carta("Mover 2 casillas", R.drawable.mover_2_casillas,2));
        }
        for (int i = 0; i < 10; i++) {
            barraja.add(new Carta("Mover 3 casillas", R.drawable.mover_3_casillas,3));
        }
        // Creamos las 14 cartas especiales
        barraja.add(new Carta("Teletransporte", R.drawable.teletransporte,4));
        barraja.add(new Carta("Teletransporte", R.drawable.teletransporte,4));
        barraja.add(new Carta("Teletransporte", R.drawable.teletransporte,4));
        barraja.add(new Carta("Zancadilla", R.drawable.zancadilla,5));
        barraja.add(new Carta("Zancadilla", R.drawable.zancadilla,5));
        barraja.add(new Carta("Zancadilla", R.drawable.zancadilla,5));
        barraja.add(new Carta("Zancadilla", R.drawable.zancadilla,5));
        barraja.add(new Carta("Patada", R.drawable.patada,6));
        barraja.add(new Carta("Patada", R.drawable.patada,6));
        barraja.add(new Carta("Patada", R.drawable.patada,6));
        barraja.add(new Carta("Hundimiento", R.drawable.hundimiento,7));
        barraja.add(new Carta("Hundimiento", R.drawable.hundimiento,7));
        barraja.add(new Carta("Broma", R.drawable.broma,8));
        barraja.add(new Carta("Broma", R.drawable.broma,8));

        Collections.shuffle(barraja, new Random(System.nanoTime()));
        cartas = barraja.subList(0, 6);

        listener = null;
    }

    public CartasAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CartaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartaViewHolder holder, int position) {
        Carta carta = cartas.get(position);
        holder.bind(carta, listener);
    }

    @Override
    public int getItemCount() {
        return cartas.size();
    }



    static class CartaViewHolder extends RecyclerView.ViewHolder {
        private ImageButton imagenCarta;

        public CartaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenCarta = itemView.findViewById(R.id.btn_carta);
        }

        public void bind(Carta carta, OnItemClickListener listener) {
            imagenCarta.setImageResource(carta.getImagen());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Carta carta);
    }
}