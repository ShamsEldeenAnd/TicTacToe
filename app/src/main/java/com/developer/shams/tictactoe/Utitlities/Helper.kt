package com.developer.shams.tictactoe.Utitlities

import android.widget.Button
import com.developer.shams.tictactoe.R
import java.util.*

class Helper {

    fun changeBtncolor_x(btn: Button) {
        btn.setBackgroundResource(R.drawable.btn_x)
        btn.text = "X"
        btn.isEnabled = false
    }

    fun changeBtncolor_O(btn: Button) {
        btn.setBackgroundResource(R.drawable.btn_o)
        btn.text = "O"
        btn.isEnabled = false
    }

    fun enemyPlay(btns: ArrayList<Button>) {
        var counter=0
        while (true) {
            val x = Random().nextInt((9 - 0)) + 0
            counter++
            if (!btns[x].text.equals("O") && !btns[x].text.equals("X")) {
                changeBtncolor_x(btns[x])
                break
            }

        }
    }

    fun cleanBtns(btns: ArrayList<Button>) {
        for (btn in btns) {
            btn.text = ""
            btn.setBackgroundResource(R.drawable.btn_normal)
            btn.isEnabled = true
        }
    }

    fun isDraw(btns: ArrayList<Button>): Boolean {
        for (index in 0..9) {
            if (!btns[index].isEnabled) {
                if (index == 9) {
                    return true
                }
            } else break
        }
        return false
    }
}