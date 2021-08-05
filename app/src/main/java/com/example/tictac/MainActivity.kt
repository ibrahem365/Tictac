package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSelect(view:View){
        // btnChoice contain the button that the user will select
        val btnChoice = view as Button
        // cellId
        var cellId = 0
        // when cases btnChoice to specify the button by his id
        when(btnChoice.id){
            R.id.btn1-> cellId=1
            R.id.btn2-> cellId=2
            R.id.btn3-> cellId=3
            R.id.btn4-> cellId=4
            R.id.btn5-> cellId=5
            R.id.btn6-> cellId=6
            R.id.btn7-> cellId=7
            R.id.btn8-> cellId=8
            R.id.btn9-> cellId=9
        }
        playGame(cellId, btnChoice)
//        Log.d("cellId",cellId.toString())
//        btnChoice.setBackgroundResource(R.color.design_default_color_secondary)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer =1

    fun playGame(cellId:Int , btnChoice:Button){
        if (activePlayer==1){
            btnChoice.text = "X"
            btnChoice.setBackgroundResource(R.color.design_default_color_secondary)
            player1.add(cellId)
            activePlayer=2
        }
        else {
            btnChoice.text = "O"
            btnChoice.setBackgroundResource(R.color.purple_500)
            player2.add(cellId)
            activePlayer=1
        }
        winPlayer(btnChoice)
    }

    fun winPlayer(btnChoice:Button){
        var winner =-1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            winner=1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            winner=1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            winner=2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner=1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) ){
            winner=2
        }

        //colm 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            winner=1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            winner=2
        }

        //colm 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            winner=1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            winner=2
        }

        //colm 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            winner=1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            winner=2
        }

        if (winner!= -1){
            if (winner==1){
                Toast.makeText(this,"Player 1 win",Toast.LENGTH_LONG).show()
                btnChoice.isEnabled= false
            }else{
                Toast.makeText(this,"Player 2 win",Toast.LENGTH_LONG).show()
                btnChoice.isEnabled= false
            }
        }

    }


}