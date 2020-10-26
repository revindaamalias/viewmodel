package com.example.view_model.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.view_model.R;
import com.example.view_model.databinding.FragmentCounterBinding;
import com.example.view_model.models.Score;

public class CounterFragment extends Fragment {

    public Score score;

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCounterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_counter, container, false);
        score = new Score(0,0);
        binding.setScore(score);

        //home
//bedanya dengan binding yang sebelumnya adalah kita tidak menggunakan findview
        binding.btnThreePointHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setHomeScore(score.getHomeScore()+3);
                Log.d("Home Score :", String.valueOf(score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(score.getHomeScore()));
            }
        });

        binding.btnTwoPointHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setHomeScore(score.getHomeScore()+2);
                Log.d("Home Score :", String.valueOf(score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(score.getHomeScore()));
            }
        });

        binding.btnFreeThrowHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setHomeScore(score.getHomeScore()+1);
                Log.d("Home Score :", String.valueOf(score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(score.getHomeScore()));
            }
        });

        //away
        binding.btnFreeThrowAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setAwayScore(score.getAwayScore()+1);
                Log.d("Away Score :", String.valueOf(score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(score.getAwayScore()));
            }
        });

        binding.btnTwoPointAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setAwayScore(score.getAwayScore()+2);
                Log.d("Away Score :", String.valueOf(score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(score.getAwayScore()));
            }
        });

        binding.btnThreePointAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setAwayScore(score.getAwayScore()+3);
                Log.d("Away Score :", String.valueOf(score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(score.getAwayScore()));
            }
        });

//        untuk reset datanya away score dan home scoe
        binding.btnResetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score.setAwayScore(0);
                score.setHomeScore(0);
//                gunanya baris dibawah ini adalah untuk mengembalikan nilai menjadi 0 kembali
                binding.txtScoreAway.setText(Integer.toString(score.getAwayScore()));
                binding.txtScoreHome.setText(Integer.toString(score.getHomeScore()));
            }
        });

        return binding.getRoot();
    }
}
// kita perlu menggunakan live data agar ketika kita melakukan rotate dihp, datanya tidak hilang atau kembali ke awal
// kita perlu menggunakan configuration change agar ketika keluar ke halaman awal, datanya tidak hilang