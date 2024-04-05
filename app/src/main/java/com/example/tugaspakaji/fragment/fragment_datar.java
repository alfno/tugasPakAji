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
import com.example.tugaspakaji.bangunDatar.lingkaran;
import com.example.tugaspakaji.bangunDatar.persegi;
import com.example.tugaspakaji.bangunDatar.persegiPanjang;
import com.example.tugaspakaji.bangunDatar.segitiga;
import com.example.tugaspakaji.modelBangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_datar extends Fragment implements AdapterBangun.ItemClickListener {
    RecyclerView rvBangunDatar;
    List<modelBangun> listDataBangunDatar;
    AdapterBangun adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View oncCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunDatar = view.findViewById(R.id.rvBangun);
        listDataBangunDatar = new ArrayList<>();

        modelBangun persegi = new modelBangun();
        persegi.setNamaBangun("Persegi");
        persegi.setDesc("S x S ");
        persegi.setImageBangun(R.drawable.persegi);
        listDataBangunDatar.add(persegi);

        modelBangun segitiga = new modelBangun();
        segitiga.setNamaBangun("Segitiga");
        segitiga.setDesc("L = 1/2 x a x t");
        segitiga.setImageBangun(R.drawable.segitiga);
        listDataBangunDatar.add(segitiga);

        modelBangun PersegiPanjang = new modelBangun();
        PersegiPanjang.setNamaBangun("Persegi Panjang");
        PersegiPanjang.setDesc("P x L x T");
        PersegiPanjang.setImageBangun(R.drawable.persegi_panjang);
        listDataBangunDatar.add(PersegiPanjang);

        modelBangun lingkaran = new modelBangun();
        lingkaran.setNamaBangun("Lingkaran");
        lingkaran.setDesc("Phi x r x r");
        lingkaran.setImageBangun(R.drawable.lingkaran);
        listDataBangunDatar.add(lingkaran);

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterBangun(listDataBangunDatar, getContext());
        rvBangunDatar.setAdapter(adapter);
        adapter.setClickListener(this);
    }



    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position).getNamaBangun().equals("lingkaran")) {
            Intent intent = new Intent(getActivity(), lingkaran.class);
            startActivity(intent);
        } else if (adapter.getItem(position).getNamaBangun().equals("persegi")) {
            Intent intent = new Intent(getActivity(), persegi.class);
            startActivity(intent);
        } else if (adapter.getItem(position).getNamaBangun().equals("persegi panjang")) {
            Intent intent = new Intent(getActivity(), persegiPanjang.class);
            startActivity(intent);
        } else if (adapter.getItem(position).getNamaBangun().equals("segitiga")) {
            Intent intent = new Intent(getActivity(), segitiga.class);
            startActivity(intent);
        }
    }
}
