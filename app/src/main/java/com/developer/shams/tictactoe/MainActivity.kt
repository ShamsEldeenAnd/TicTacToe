package com.developer.shams.tictactoe

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import com.developer.shams.tictactoe.Utitlities.Helper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score_O = 0
    var score_X = 0

    var myHelper: Helper? = null
    var arr = ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intibtns()
        myHelper = Helper()
        checkWinner()
    }

    fun butSelect(view: View) {
        val but = view as Button
        when (but.id) {
            R.id.cell_1 -> userPlay(but)
            R.id.cell_2 -> userPlay(but)
            R.id.cell_3 -> userPlay(but)
            R.id.cell_4 -> userPlay(but)
            R.id.cell_5 -> userPlay(but)
            R.id.cell_6 -> userPlay(but)
            R.id.cell_7 -> userPlay(but)
            R.id.cell_8 -> userPlay(but)
            R.id.cell_9 -> userPlay(but)
        }
    }

    fun intibtns() {

        arr.add(cell_1)
        arr.add(cell_2)
        arr.add(cell_3)
        arr.add(cell_4)
        arr.add(cell_5)
        arr.add(cell_6)
        arr.add(cell_7)
        arr.add(cell_8)
        arr.add(cell_9)
    }

    fun checkWinner(): Boolean {
        if (cell_1.text.equals("O") && cell_2.text.equals("O") && cell_3.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_1.text.equals("X") && cell_2.text.equals("X") && cell_3.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_4.text.equals("O") && cell_5.text.equals("O") && cell_6.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_4.text.equals("X") && cell_5.text.equals("X") && cell_6.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_7.text.equals("O") && cell_8.text.equals("O") && cell_9.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_7.text.equals("X") && cell_8.text.equals("X") && cell_9.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_1.text.equals("O") && cell_4.text.equals("O") && cell_7.text.equals("O")) {
            displayWinner("O")
        } else if (cell_1.text.equals("X") && cell_4.text.equals("X") && cell_7.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_2.text.equals("O") && cell_5.text.equals("O") && cell_8.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_2.text.equals("X") && cell_5.text.equals("X") && cell_8.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_3.text.equals("O") && cell_6.text.equals("O") && cell_9.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_3.text.equals("X") && cell_6.text.equals("X") && cell_9.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_1.text.equals("O") && cell_5.text.equals("O") && cell_9.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_1.text.equals("X") && cell_5.text.equals("X") && cell_9.text.equals("X")) {
            displayWinner("X")
            return true
        } else if (cell_3.text.equals("O") && cell_5.text.equals("O") && cell_7.text.equals("O")) {
            displayWinner("O")
            return true
        } else if (cell_3.text.equals("X") && cell_5.text.equals("X") && cell_7.text.equals("X")) {
            displayWinner("X")
            return true
        }
        return false

    }

    fun userPlay(but: Button) {

        myHelper!!.changeBtncolor_O(but)
        if (!checkWinner())
            myHelper!!.enemyPlay(arr)
    }

    fun displayWinner(winner: String) {
        if (winner.equals("X")) {
            showAlert(getString(R.string.X_winner))
            score_X++
            x_score.text = getString(R.string.score_x) + score_X
        } else if (winner.equals("O")) {
            showAlert(getString(R.string.O_Winner))
            score_O++
            o_score.text = getString(R.string.score_o) + score_O
        } else if (myHelper!!.isDraw(arr)) {
            showAlert(getString(R.string.draw))
        }
    }

    fun showAlert(msg: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(msg)
        builder.setCancelable(false)
        builder.setNeutralButton(getString(R.string.retry), { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
            myHelper!!.cleanBtns(arr)
        })
        builder.show()
    }

}
