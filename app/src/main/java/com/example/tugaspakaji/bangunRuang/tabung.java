package com.example.tugaspakaji.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugaspakaji.R;

public class tabung extends AppCompatActivity {
    EditText editTextTinggi,editTextJariJari;
    TextView textViewHasil;
    Button buttonHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabung);
        editTextTinggi = findViewById(R.id.tinggi_Tabung);
        editTextJariJari = findViewById(R.id.jariJari);
        buttonHasil = findViewById(R.id.btnhitung);
        textViewHasil = findViewById(R.id.tvhasil);

        buttonHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinggiText = editTextTinggi.getText().toString().trim();
                String jariJariText = editTextJariJari.getText().toString().trim();

                if (tinggiText.isEmpty() ||  jariJariText.isEmpty()) {
                    Toast.makeText(tabung.this, "isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                float tinggi = Float.parseFloat(tinggiText);
                float jariJari = Float.parseFloat(jariJariText);

                float hasil = 2 * Math.round(Math.PI * jariJari * (jariJari + tinggi));
                textViewHasil.setText(String.valueOf(hasil));
            }
        });
    }
}
