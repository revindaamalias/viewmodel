package com.example.view_model.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.view_model.models.Score;

public class CounterViewModels extends ViewModel {

    public MutableLiveData<Score> scoreMutableLiveData = new MutableLiveData<>();
    public Score score = new Score();

    public LiveData<Score> getScore(){
        return scoreMutableLiveData;
    }

    public void addPointHome(int point){
        score.setHomeScore(score.getHomeScore()+point);
        scoreMutableLiveData.setValue(score);
        Log.d("Point Home : ", String.valueOf(score.getHomeScore()));
    }

    public void addPointAway(int point){
        score.setAwayScore(score.getAwayScore()+point);
        scoreMutableLiveData.setValue(score);
        Log.d("Point Away : ", String.valueOf(score.getAwayScore()));
    }

    public void resetScore(){
        score.setHomeScore(0);
        score.setAwayScore(0);
        scoreMutableLiveData.setValue(score);
        Log.d("Reset For Home : ", String.valueOf(score.getHomeScore()));
        Log.d("Reset For Away : ", String.valueOf(score.getAwayScore()));
    }
}

//Note
//Data sekarang sendiri tidak dengan UI Controller.