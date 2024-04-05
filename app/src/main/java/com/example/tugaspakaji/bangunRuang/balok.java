package com.example.tugaspakaji.bangunRuang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugaspakaji.R;

public class balok extends AppCompatActivity {
    EditText editTextPanjang,getEditTextLebar,editTextTinggi;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balok);
        editTextTinggi = findViewById(R.id.tinggiBalok);
        getEditTextLebar = findViewById(R.id.lebarBalok);
        editTextPanjang = findViewById(R.id.panjangBalok);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung =  findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjangText = editTextPanjang.getText().toString().trim();
                String lebarText = getEditTextLebar.getText().toString().trim();
                String tinggiText = editTextTinggi.getText().toString().trim();

                if (panjangText.isEmpty() || lebarText.isEmpty() || tinggiText.isEmpty()) {
                    Toast.makeText(balok.this, "Harap di isi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }


                Double panjang = Double.parseDouble(panjangText);
                Double lebar = Double.parseDouble(lebarText);
                Double tinggi = Double.parseDouble(tinggiText);

                double hasil = 2 * ( (panjang * lebar) + (panjang * tinggi) + (lebar * tinggi) );
                textViewHasil.setText("volume : " + hasil);
            }
        });
    }
}
