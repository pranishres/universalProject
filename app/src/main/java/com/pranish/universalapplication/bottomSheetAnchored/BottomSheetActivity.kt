package com.pranish.universalapplication.bottomSheetAnchored

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.pranish.universalapplication.R
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_main_menu.*

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
        fragmentMap.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            if (BottomSheetBehavior.from(nsvMainMenu).state == BottomSheetBehavior.STATE_COLLAPSED) {
                BottomSheetBehavior.from(nsvMainMenu).state = BottomSheetBehavior.STATE_EXPANDED
                SlideViewAnimation.expand(nsvMainMenuMain)
            } else {
                BottomSheetBehavior.from(nsvMainMenu).state = BottomSheetBehavior.STATE_COLLAPSED
                SlideViewAnimation.collapse(nsvMainMenuMain)
            }
        }
    }
}