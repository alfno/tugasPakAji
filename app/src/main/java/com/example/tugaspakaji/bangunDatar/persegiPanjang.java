package com.example.tugaspakaji.bangunDatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugaspakaji.R;

import org.jetbrains.annotations.Nullable;

public class persegiPanjang extends AppCompatActivity {

    EditText editTextPanjang,editTextLebar;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegi_panjang);
        editTextLebar = findViewById(R.id.Lebar_Persegi_panjang);
        editTextPanjang = findViewById(R.id.Panjang_Persegi_panjang);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPanjang = editTextPanjang.getText().toString().trim();
                String strLebar = editTextLebar.getText().toString().trim();

                if (strPanjang.isEmpty() || strLebar.isEmpty()) {
                    Toast.makeText(persegiPanjang.this, "Harap di isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }


                double panjang = Double.parseDouble(strPanjang);
                double lebar = Double.parseDouble(strLebar);


                double hasil = panjang * lebar;


                textViewHasil.setText("luas :" + hasil);
            }
        });
    }
}
