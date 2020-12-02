package com.example.juegosimondice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simonModel by viewModels<MyVienModel>()
        val greenB:Button=findViewById(R.id.greenButton)
        val redB:Button=findViewById(R.id.redButton)
        val yellowB:Button=findViewById(R.id.yellowButton)
        val blueB:Button=findViewById(R.id.blueButton)
        val startButton: Button = findViewById(R.id.startButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val outputText: TextView = findViewById(R.id.cuadroTexto)

        simonModel.MovimientoSistema.observe(this,
                Observer{ newSystemMove -> outputText.text=newSystemMove.toString()
                    Log.d("FuncionSystem",newSystemMove.size.toString())
                })

        simonModel.MovimientoJugador.observe(this, Observer {
            newPlayerMove -> outputText.text=newPlayerMove.toString()
        })
        simonModel.EstadoBoton.observe(this, Observer { estado ->startButton.isEnabled=estado })

        greenB.setOnClickListener {
            simonModel.addPlayerMove(simonModel.MovimientoJugador,1) }
        redB.setOnClickListener {
            simonModel.addPlayerMove(simonModel.MovimientoJugador,2) }
        yellowB.setOnClickListener {
            simonModel.addPlayerMove(simonModel.MovimientoJugador,3) }
        blueB.setOnClickListener {
            simonModel.addPlayerMove(simonModel.MovimientoJugador,4) }
        startButton.setOnClickListener {
            simonModel.systemPlays()
        }
        resetButton.setOnClickListener {
            simonModel.fullReset()
            outputText.text="Reinicio"

        }

    }

}