package com.test.mastermindgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.test.movies.utils.Util
import kotlinx.android.synthetic.main.activity_random_alpha.*
import java.util.*

var strRandomString : String = ""
private lateinit var utilIntance: Util


lateinit var randomAlphaViewModel: RandomAlphaViewModel

class RandomAlphaActivity : AppCompatActivity() , ValidateCallback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_alpha)
        supportActionBar?.hide()
        randomAlphaViewModel = ViewModelProvider(this).get(RandomAlphaViewModel::class.java)
        utilIntance = Util()
        strRandomString = utilIntance.getRandomString()
        addingTextChangeListener()
        onSubmit()
        println(resources.getString(R.string.console_random_string) +strRandomString)
    }

    private fun addingTextChangeListener() {

        edt0.addTextChangedListener {
            if ((edt0).text.toString().length == 1) {
                (edt0).clearFocus()
                (edt1).requestFocus()
                ((edt1) as EditText).isCursorVisible = true
            }
        }

        edt1.addTextChangedListener {
            if ((edt1).text.toString().length == 1) {
                (edt1).clearFocus()
                (edt2).requestFocus()
                ((edt2) as EditText).isCursorVisible = true
            }
        }

        edt2.addTextChangedListener {
            if ((edt2).text.toString().length == 1) {
                (edt2).clearFocus()
                (edt3).requestFocus()
                ((edt3) as EditText).isCursorVisible = true
            }
        }
    }

    private fun onSubmit(){
        cbxSubmit.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                validateEditext()
            }

        }
        if (cbxSubmit.isChecked)
            getUserEnteredText()
    }

    private fun validateEditext() {

        randomAlphaViewModel.setViewListener(this@RandomAlphaActivity)
        if(randomAlphaViewModel.validateEditText(edt0.text.toString(),edt1.text.toString(),
                                                edt2.text.toString(),edt3.text.toString())){
            compareResult()
        }
    }

    private fun compareResult() {
        for (pos in 0..3) {
            var edtString: String = ""
            var edt = findViewById<EditText>(R.id.edt0)
            when (pos) {
                0 -> {
                    edtString = edt0.text.toString()
                    edt = findViewById(R.id.edt0)
                }
                1 -> {
                    edtString = edt1.text.toString()
                    edt = findViewById(R.id.edt1)
                }
                2 -> {
                    edtString = edt2.text.toString()
                    edt = findViewById(R.id.edt2)
                }
                3 -> {
                    edtString = edt3.text.toString()
                    edt = findViewById(R.id.edt3)
                }
            }
            var charAtPos : String = strRandomString.get(pos).toString()
            if (edtString == charAtPos) {
                edt.setBackgroundResource(R.drawable.editext_box_green)
            } else if ((strRandomString.contains(edt.text.toString()))) {
                edt.setBackgroundResource(R.drawable.editext_box_orange)
            } else {
                edt.setBackgroundResource(R.drawable.editext_box_red)
            }
        }
        textResult.setText(resources.getString(R.string.random_alpha) + strRandomString);
        showReset()
    }

    private fun showReset(){
        reset.visibility = View.VISIBLE
        reset.setOnClickListener {
            finish()
            startActivity(getIntent())
        }
    }

    private fun getUserEnteredText(): String {
        val randomAlphaViewModel: RandomAlphaViewModel by viewModels()
        return randomAlphaViewModel.edtZero.toString() + randomAlphaViewModel.edtZero.toString()+ randomAlphaViewModel.edtZero.toString() + randomAlphaViewModel.edtZero.toString()
    }

    override fun onSuccess(s: String?) {
    }

    override fun onError(s: String?) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }

}