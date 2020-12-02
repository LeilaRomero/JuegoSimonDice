package com.example.juegosimondice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class MyVienModel: ViewModel() {

    val MovimientoSistema = MutableLiveData<MutableList<Int>>()
    val MovimientoJugador = MutableLiveData<MutableList<Int>>()
    val EstadoBoton = MutableLiveData<Boolean>()

    init {
        MovimientoSistema.value= mutableListOf()
        MovimientoJugador.value= mutableListOf()
        EstadoBoton.value=true
    }

    fun <T> MutableLiveData <T>.notifiObserver(){
        this.value=this.value
    }

    fun systemPlays(){
        val pos : Int
        val randInt = Random.nextInt(4)+1
        pos= MovimientoSistema.value!!.size
        MovimientoSistema.value!!.add(pos,randInt)
        MovimientoSistema.notifiObserver()
        EstadoBoton.value=false

    }

    fun fullReset(){
        MovimientoSistema.value!!.clear()
        MovimientoJugador.value!!.clear()
        EstadoBoton.value=true
    }

    fun ResetJugador(){
        MovimientoJugador.value!!.clear()
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
