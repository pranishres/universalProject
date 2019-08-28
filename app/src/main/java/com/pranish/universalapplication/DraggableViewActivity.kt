package com.pranish.universalapplication

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_draggable_view.*


class DraggableViewActivity : AppCompatActivity(), View.OnTouchListener {
    var dX: Float = 0.toFloat()
    var dY: Float = 0.toFloat()
    var params: Float = 0F;
    var y: Float = 0F;
    var bottomY: Float = 0F;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draggable_view)
        init()
    }

    private fun init() {
        frmDraggable.setOnTouchListener(this)
        params = frmDraggable?.layoutParams?.height!!.toFloat()
    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        if (y == 0.0F)
            y = frmDraggable?.y!!
        if (bottomY == 0.0F)
            bottomY = y + frmDraggable?.height!!

        if (params == 0.0F)
            params = frmDraggable?.layoutParams?.height!!.toFloat()
        when (event?.getActionMasked()) {
            MotionEvent.ACTION_DOWN -> {
                dX = view?.getX()?.minus(event.getRawX())!!
                dY = view.getY().minus(event.getRawY())
                if ((frmDraggable?.y?.toFloat()!!.minus(bottomY)) <= 250)
                    view?.y = bottomY - 50
            }
            MotionEvent.ACTION_MOVE -> {
                if (event.getRawY() + dY < y)
                    return true
                else if (event.getRawY().plus(dY).minus(params) <= (500))
                    return true



                if (dY >= params) {
                    Log.d("dragging", "height excedded : param" + params + " : scroll " + dY)
                    view?.y = params.toFloat()
                } else {
                    view?.setY(event.getRawY() + dY)
                    Log.d("dragging", "height not excedded : param" + params + " : scroll " + dY)
                }
//                view?.setX(event.getRawX() + dX)
            }

            MotionEvent.ACTION_UP -> {
                event.rawY
                Toast.makeText(this@DraggableViewActivity, "Clicked!", Toast.LENGTH_SHORT).show()
            }

            else -> return false
        }
        return true
    }
}