package com.example.scoreapplication
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private var _scoreTeamOne = MutableLiveData<Int>()
    val scoreTeamOne:MutableLiveData<Int> get()=_scoreTeamOne
    private var _scoreTeamTwo = MutableLiveData<Int>()
    val scoreTeamTwo:MutableLiveData<Int> get()=_scoreTeamTwo


    fun incrementTeamOneScore() {
        val currentScore=scoreTeamOne.value ?: 0
        scoreTeamOne.value = currentScore + 1
    }

    fun incrementTeamTwoScore() {
        val currentScore=scoreTeamTwo.value ?: 0
        scoreTeamTwo.value = currentScore + 1
    }
}
