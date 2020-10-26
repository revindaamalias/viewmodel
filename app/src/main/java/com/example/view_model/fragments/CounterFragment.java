package com.example.view_model.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.view_model.R;
import com.example.view_model.databinding.FragmentCounterBinding;
import com.example.view_model.models.Score;
import com.example.view_model.viewmodels.CounterViewModels;

public class CounterFragment extends Fragment {

    public CounterViewModels mViewModels;
//    Kita tidak perlu memanggil binding lagi

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCounterBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_counter, container, false);
        mViewModels = new ViewModelProvider(this).get(CounterViewModels.class);

        // line diatas merupakan cara untuk menghubungkan counterFragment dengan counter view models.
//        kita set up
        binding.setCounterViewModel(mViewModels);
        //home

//        sekarang kita mengubah binding.score sekarang menjaddi mViewmodels
        binding.btnThreePointHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setHomeScore(mViewModels.score.getHomeScore()+3);
                Log.d("Home Score :", String.valueOf(mViewModels.score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(mViewModels.score.getHomeScore()));
            }
        });

        binding.btnTwoPointHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setHomeScore(mViewModels.score.getHomeScore()+2);
                Log.d("Home Score :", String.valueOf(mViewModels.score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(mViewModels.score.getHomeScore()));
            }
        });

        binding.btnFreeThrowHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setHomeScore(mViewModels.score.getHomeScore()+1);
                Log.d("Home Score :", String.valueOf(mViewModels.score.getHomeScore()));
                binding.txtScoreHome.setText(Integer.toString(mViewModels.score.getHomeScore()));
            }
        });

        //away
        binding.btnFreeThrowAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setAwayScore(mViewModels.score.getAwayScore()+1);
                Log.d("Away Score :", String.valueOf(mViewModels.score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(mViewModels.score.getAwayScore()));
            }
        });

        binding.btnTwoPointAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setAwayScore(mViewModels.score.getAwayScore()+2);
                Log.d("Away Score :", String.valueOf(mViewModels.score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(mViewModels.score.getAwayScore()));
            }
        });

        binding.btnThreePointAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setAwayScore(mViewModels.score.getAwayScore()+3);
                Log.d("Away Score :", String.valueOf(mViewModels.score.getAwayScore()));
                binding.txtScoreAway.setText(Integer.toString(mViewModels.score.getAwayScore()));
            }
        });

        binding.btnResetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModels.score.setAwayScore(0);
                mViewModels.score.setHomeScore(0);
                binding.txtScoreAway.setText(Integer.toString(mViewModels.score.getAwayScore()));
                binding.txtScoreHome.setText(Integer.toString(mViewModels.score.getHomeScore()));
            }
        });

        return binding.getRoot();
    }
}
// kita perlu menggunakan live data agar ketika kita melakukan rotate dihp, datanya tidak hilang atau kembali ke awal
// kita perlu menggunakan configuration change agar ketika keluar ke halaman awal, datanya tidak hilang