package com.example.view_model.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.view_model.models.Score;

public class CounterViewModels extends ViewModel {
//    data yang biasanya ada di fragment pindah kesini.
    public Score score = new Score(0,0);
//    karena kita menggunakan public jadi kita bisa
}

//Note
//Data sekarang sendiri tidak dengan UI Controller.