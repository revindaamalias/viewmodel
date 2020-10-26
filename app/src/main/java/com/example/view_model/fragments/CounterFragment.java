package com.example.view_model.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
        binding.setLifecycleOwner(this);
        binding.setCounterViewModel(mViewModels);
        mViewModels.scoreMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Score>() {
//            kita bisa mengobserve nilai scoreMutableLiveData
            @Override
            public void onChanged(Score score) {
//                ketika ada perubahan, langsung berubah.
                binding.txtScoreHome.setText(Integer.toString(score.getHomeScore()));
                binding.txtScoreAway.setText(Integer.toString(score.getAwayScore()));
            }
        });
        return binding.getRoot();
    }
}
// kita perlu menggunakan live data agar ketika kita melakukan rotate dihp, datanya tidak hilang atau kembali ke awal
// kita perlu menggunakan configuration change agar ketika keluar ke halaman awal, datanya tidak hilang

//step 4 : live data adalah kita bisa update UI tanpa harus update kodingan .