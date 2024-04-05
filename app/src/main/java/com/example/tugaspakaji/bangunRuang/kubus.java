package com.example.tugaspakaji.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugaspakaji.R;

public class kubus extends AppCompatActivity {
    EditText editTextSisi;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kubus);
        editTextSisi = findViewById(R.id.SisiKubus);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sisiText = editTextSisi.getText().toString().trim();

                if (sisiText.isEmpty()) {
                    Toast.makeText(kubus.this, "isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                double sisi = Double.parseDouble(sisiText);

                double hasil = 6 * (sisi * sisi);

                textViewHasil.setText(String.valueOf(hasil));
            }
        });

    }
}
