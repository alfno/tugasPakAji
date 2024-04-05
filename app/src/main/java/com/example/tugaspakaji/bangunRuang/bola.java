package com.example.tugaspakaji.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugaspakaji.R;

import org.w3c.dom.Text;

public class bola extends AppCompatActivity {
    EditText editTextJarijari;
    TextView textViewHasil;
    Button buttonHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bola);

        editTextJarijari = findViewById(R.id.jariJari);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jariJariText =  editTextJarijari.getText().toString().trim();

                if (jariJariText.isEmpty()) {
                    Toast.makeText(bola.this, "Isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                float jariJari = Float.parseFloat(jariJariText);

                float hasil = (4 * Math.round((Math.PI * jariJari * jariJari)));

                textViewHasil.setText(String.valueOf(hasil));
            }
        });

        }
    }

