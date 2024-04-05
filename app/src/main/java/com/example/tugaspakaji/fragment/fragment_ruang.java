package com.example.tugaspakaji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugaspakaji.AdapterBangun;
import com.example.tugaspakaji.R;
import com.example.tugaspakaji.bangunRuang.balok;
import com.example.tugaspakaji.bangunRuang.bola;
import com.example.tugaspakaji.bangunRuang.kubus;
import com.example.tugaspakaji.bangunRuang.tabung;
import com.example.tugaspakaji.modelBangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_ruang extends Fragment implements AdapterBangun.ItemClickListener {

    RecyclerView rvBangun;
    List<modelBangun> modelbangunList;
    AdapterBangun adapterBangun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View oncCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangun = view.findViewById(R.id.rvBangunRuang);
        modelbangunList = new ArrayList<>();

        modelBangun kubus = new modelBangun();
        kubus.setNamaBangun("Kubus");
        kubus.setDesc("6 x s²");
        kubus.setImageBangun(R.drawable.kubus);
        modelbangunList.add(kubus);

        modelBangun bola = new modelBangun();
        bola.setNamaBangun("Bola");
        bola.setDesc("Luas Permukaan Bola = 4 x Luas Lingkaran (π x r²)");
        bola.setImageBangun(R.drawable.bola);
        modelbangunList.add(bola);

        modelBangun tabung = new modelBangun();
        tabung.setNamaBangun("Tabung");
        tabung.setDesc("Luas permukaan tabung = 2 x Luas alas + Luas selimut tabung");
        tabung.setImageBangun(R.drawable.tabung);
        modelbangunList.add(tabung);

        modelBangun balok = new modelBangun();
        balok.setNamaBangun("Balok");
        balok.setDesc("L = 2 x [(p x l) + (p x t) + (l x t)]");
        balok.setImageBangun(R.drawable.balok);
        modelbangunList.add(balok);

        rvBangun.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBangun = new AdapterBangun(modelbangunList, getContext());
        rvBangun.setAdapter(adapterBangun);
        adapterBangun.setClickListener(this);
    }


    @Override
    public void onItemClick(View view, int position) {
        if (adapterBangun.getItem(position).getNamaBangun().equals("kubus")) {
            Intent intent = new Intent(getActivity(), kubus.class);
            startActivity(intent);
        } else if (adapterBangun.getItem(position).getNamaBangun().equals("bola")) {
            Intent intent = new Intent(getActivity(), bola.class);
            startActivity(intent);
        } else if (adapterBangun.getItem(position).getNamaBangun().equals("tabung")) {
            Intent intent = new Intent(getActivity(), tabung.class);
            startActivity(intent);
        } else if (adapterBangun.getItem(position).getNamaBangun().equals("balok")) {
            Intent intent = new Intent(getActivity(), balok.class);
            startActivity(intent);
        }


    }
}
