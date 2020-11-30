package com.example.juegosimondice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MyVienModel: ViewModel() {

    val systemMoves = MutableLiveData<MutableList<Int>>()
    val playerMoves = MutableLiveData<MutableList<Int>>()

    init {
        systemMoves.value= mutableListOf()
        playerMoves.value= mutableListOf()
    }

    fun <T> MutableLiveData <T>.notifiObserver(){
        this.value=this.value
    }

    fun systemPlays(){
        val pos : Int
        val randInt = Random.nextInt(4)+1
        pos= systemMoves.value!!.size
        this.systemMoves.value!!.add(pos,randInt)
        //forces the variable update calling the observer
        systemMoves.notifiObserver()
        Log.d("FuncionSystem",systemMoves.value.toString())
    }

    fun fullReset(){
        systemMoves.value!!.clear()
        playerMoves.value!!.clear()
    }

    fun playerReset(){
        playerMoves.value!!.clear()
    }

    fun addPlayerMove(playerMoves: MutableLiveData<MutableList<Int>>, number: Int ){
        when (number) {
            1 -> playerMoves.value!!.add(1)
            2 -> playerMoves.value!!.add(2)
            3 -> playerMoves.value!!.add(3)
            else -> playerMoves.value!!.add(4)
        }

        playerMoves.notifiObserver()
    }

    fun checkMoves(system: MutableLiveData<MutableList<Int>>, player: MutableLiveData<MutableList<Int>>): Boolean{
        return system==player
    }

}
