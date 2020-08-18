package com.test.mastermindgame

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_random_alpha.view.*

class EditTextValidate @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = R.attr.editTextStyle) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs, defStyleAttr) {

    private val matchedText = ContextCompat.getDrawable(context, R.drawable.editext_box_green)
    private val unmatchedText = ContextCompat.getDrawable(context, R.drawable.editext_box_orange)
    private val wrongText = ContextCompat.getDrawable(context, R.drawable.editext_box_red)

    fun checkEditText(i: Int) {
        when(i){
            0->  { background = matchedText}
            1->  { background = unmatchedText}
            2->  { background=wrongText}
        }
    }

}