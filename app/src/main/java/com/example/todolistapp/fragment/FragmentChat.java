package com.example.todolistapp.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.todolistapp.MainActivity;
import com.example.todolistapp.R;

@SuppressLint("ValidFragment")
public class FragmentChat extends Fragment {

    private AppCompatActivity activity;
    private Context context;
    private LinearLayout isi;
    private LayoutInflater inf;

    public FragmentChat(AppCompatActivity activity, Context context) {
        this.context = context;
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        isi = view.findViewById(R.id.isi);
        inf = inflater;
        for (int i=0;i<10;i++){
            BuatCard();
        }
        return view;
    }

    private void BuatCard() {
        View v = inf.inflate(R.layout.card_chat, null);
        isi.addView(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).TampilPesan();
            }
        });
    }
}