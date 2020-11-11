package com.example.juegosimondice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sec: MutableList<Int> = mutableListOf<Int>()
        var user_sec: MutableList<Int> = mutableListOf<Int>()
        var finished = false
        val botonrojo: Button = findViewById(R.id.redButton)
        val botonamarillo: Button = findViewById(R.id.yellowButton)
        val botonazul: Button = findViewById(R.id.blueButton)
        val botonverde: Button = findViewById(R.id.greenButton)
        val botonstar: Button = findViewById(R.id.startButton)
        val botonreset: Button = findViewById(R.id.resetButton)


        botonstar.setOnClickListener {
            finished = false
            reset(sec, user_sec)
            addToSecu(sec)

        }

        botonreset.setOnClickListener {
            if (finished == false) {
                if (checkSec(sec, user_sec)) {
                    addToSecu(sec)
                    user_sec.clear()

                } else {
                    finished = true

                }
            }
        }
        botonrojo.setOnClickListener {
            addUserSec(user_sec, 1)
        }
        botonamarillo.setOnClickListener {
            addUserSec(user_sec, 3)
        }
        botonazul.setOnClickListener {
            addUserSec(user_sec, 4)
        }
        botonverde.setOnClickListener {
            addUserSec(user_sec, 2)
        }
        //showSec(sec)

    }

    fun addToSecu(sec: MutableList<Int>) {
        val numb = Random.nextInt(4) + 1
        sec.add(numb)
    }

    fun checkSec(sec: MutableList<Int>, secUsr: MutableList<Int>): Boolean {
        return sec == secUsr
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>) {
        sec.clear()
        secUsr.clear()
    }

    fun addUserSec(secUsr: MutableList<Int>, color: Int) {
        when (color) {
            1 -> secUsr.add(1)
            2 -> secUsr.add(2)
            3 -> secUsr.add(3)
            else -> secUsr.add(4)
        }
    }
}