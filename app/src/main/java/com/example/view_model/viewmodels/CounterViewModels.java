package com.example.view_model.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.view_model.models.Score;

public class CounterViewModels extends ViewModel {
//    data yang biasanya ada di fragment pindah kesini.
    public Score score = new Score(0,0);
//    karena kita menggunakan public jadi kita bisa
//    step 3: jika homeScore : 0 dan awayScore: 0 di observe, dia bisa update otomatis
//    dan tidak menetap pada angka 0.

    public void addPointHome(int point){
        score.setHomeScore(score.getHomeScore()+point);
        Log.d("Point Home : ", String.valueOf(score.getHomeScore()));
    }

    public void addPointAway(int point){
        score.setAwayScore(score.getAwayScore()+point);
        Log.d("Point Away : ", String.valueOf(score.getAwayScore()));
    }
//    step 3: jika di run, nilainya tetap 0 tetapi, jiak kita lihat dilogcat, ada nilainya.
//    karena data bindingnya tidak bisa meng observe pada fragment counter.xml
}

//Note
//Data sekarang sendiri tidak dengan UI Controller.