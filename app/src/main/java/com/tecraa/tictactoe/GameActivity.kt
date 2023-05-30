package com.tecraa.tictactoe

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.tecraa.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binnding : ActivityGameBinding
    var clickCount:Int = 1
    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binnding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binnding.root)

        binnding.gameBtn1.setOnClickListener{
            ticTacToe(it,1)
        }
        binnding.gameBtn2.setOnClickListener{
            ticTacToe(it,2)
        }
        binnding.gameBtn3.setOnClickListener{
            ticTacToe(it,3)
        }
        binnding.gameBtn4.setOnClickListener{
            ticTacToe(it,4)
        }
        binnding.gameBtn5.setOnClickListener{
            ticTacToe(it,5)
        }
        binnding.gameBtn6.setOnClickListener{
            ticTacToe(it,6)
        }
        binnding.gameBtn7.setOnClickListener{
            ticTacToe(it,7)
        }
        binnding.gameBtn8.setOnClickListener{
            ticTacToe(it,8)
        }
        binnding.gameBtn9.setOnClickListener{
            ticTacToe(it,9)
        }
    }

    private fun ticTacToe(it: View?, i: Int) {
        if (it != null) {
            it.isEnabled = false
        };
        if (clickCount % 2 ==0) {
            it?.setBackgroundResource(R.drawable.ic_cross)
            playerTwo.add(i)
            winnerPlayerCheck(clickCount,playerTwo)
        }else {
            it?.setBackgroundResource(R.drawable.ic_circle)
            playerOne.add(i)
            winnerPlayerCheck(clickCount,playerOne)
        }
        clickCount += 1

    }

    private fun winnerPlayerCheck(clickCount: Int, playerArray: ArrayList<Int>) {

        //section One
        if (playerArray.contains(1) && playerArray.contains(2) && playerArray.contains(3)){
            callResult()
        }
        else if (playerArray.contains(4) && playerArray.contains(5) && playerArray.contains(6)){
            callResult()
        }
        else if (playerArray.contains(7) && playerArray.contains(8) && playerArray.contains(9)){
            callResult()
        }

        //Section Two
        else if (playerArray.contains(1) && playerArray.contains(4) && playerArray.contains(7)){
            callResult()
        }
        else if (playerArray.contains(2) && playerArray.contains(5) && playerArray.contains(8)){
            callResult()
        }
        else if (playerArray.contains(3) && playerArray.contains(6) && playerArray.contains(9)){
            callResult()
        }

        //Section Three
        else if (playerArray.contains(1) && playerArray.contains(5) && playerArray.contains(9)){
            callResult()
        }
        else if (playerArray.contains(3) && playerArray.contains(5) && playerArray.contains(7)){
            callResult()
        }

        //section Four
        else{
            if (clickCount==9){
                showResult(0)
            }
        }
    }

    private fun callResult() {
        if (clickCount % 2 == 0) {
            showResult(2)
        } else {
            showResult(1)
        }
    }

    private fun showResult(i: Int) {
        val dialogBinding = layoutInflater.inflate(R.layout.dialog_game_result,null)

        val resultIcon = dialogBinding.findViewById<ImageView>(R.id.resultImage)
        val resultMessage = dialogBinding.findViewById<TextView>(R.id.resultShowTV)
        val resultExitBtn = dialogBinding.findViewById<Button>(R.id.resultExitBtn)
        val playAgainBtn = dialogBinding.findViewById<Button>(R.id.resultPlayAgainBtn)

        when (i) {
            1 -> {
                resultIcon.setImageResource(R.drawable.ic_circle)
                resultMessage.text = "Player 1 win the Game"
            }
            2 -> {
                resultIcon.setImageResource(R.drawable.ic_cross)
                resultMessage.text = "Player 2 win the Game"
            }
            else -> {
                resultIcon.setImageResource(R.drawable.ic_app_logo)
                resultMessage.text = "The match has been drawn. play again"
            }
        }

        resultExitBtn.setOnClickListener{
            finishAffinity()
        }

        val myDialog = Dialog(this)
        myDialog.setContentView(dialogBinding)

        myDialog.setCancelable(false)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()

        playAgainBtn.setOnClickListener {
            playAgain(myDialog)
        }

    }

    private fun playAgain(myDialog: Dialog) {
        binnding.gameBtn1.isEnabled = true
        binnding.gameBtn2.isEnabled = true
        binnding.gameBtn3.isEnabled = true
        binnding.gameBtn4.isEnabled = true
        binnding.gameBtn5.isEnabled = true
        binnding.gameBtn6.isEnabled = true
        binnding.gameBtn7.isEnabled = true
        binnding.gameBtn8.isEnabled = true
        binnding.gameBtn9.isEnabled = true
        binnding.gameBtn1.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn2.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn3.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn4.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn5.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn6.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn7.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn8.setBackgroundResource(R.drawable.ic_default)
        binnding.gameBtn9.setBackgroundResource(R.drawable.ic_default)
        clickCount =1
        playerOne.clear()
        playerTwo.clear()
        myDialog.hide()
    }
}