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
    lateinit var userText : String

    fun checkEditText(i: Int) {
        when(i){
            0->  { userText = edt0.text.toString()}
            1->  { userText = edt1.text.toString()}
            2->  { userText = edt2.text.toString()}
            3->  { userText = edt3.text.toString()}
        }
        enableResult(i)
    }

    private fun enableResult(i: Int) {
        var charAtPos : String = strRandomString.get(i).toString()
            if (userText == charAtPos) {
               background = matchedText
            } else if ((strRandomString.contains(userText))) {
                background = unmatchedText
            }else{
                background=wrongText
            }
    }

    private fun disableResult() {
        clearOnTextChangedListener()
    }

}