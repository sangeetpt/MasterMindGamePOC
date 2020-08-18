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


private lateinit var utilInstance: Util


lateinit var randomAlphaViewModel: RandomAlphaViewModel

class RandomAlphaActivity : AppCompatActivity() , ValidateCallback{

    companion object{
        var strRandomString : String = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_alpha)
        supportActionBar?.hide()
        randomAlphaViewModel = ViewModelProvider(this).get(RandomAlphaViewModel::class.java)
        utilInstance = Util()
        strRandomString = utilInstance.getRandomString()
        addingTextFocusChange()
        onSubmit()
        println(resources.getString(R.string.console_random_string) +strRandomString)
        textResult.setText(resources.getString(R.string.random_alpha) + "  "+ strRandomString);
    }

    private fun addingTextFocusChange() {

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
    }

    private fun validateEditext() {
        randomAlphaViewModel.setViewListener(this@RandomAlphaActivity)
        if(randomAlphaViewModel.validateEditText(edt0.text.toString(),edt1.text.toString(),
                                                edt2.text.toString(),edt3.text.toString())){
            testResult()
        }
    }

    private fun testResult(){
        edt0.checkEditText(randomAlphaViewModel.updateResult(0,edt0.text.toString(), strRandomString))
        edt1.checkEditText(randomAlphaViewModel.updateResult(1,edt1.text.toString(), strRandomString))
        edt2.checkEditText(randomAlphaViewModel.updateResult(2,edt2.text.toString(), strRandomString))
        edt3.checkEditText(randomAlphaViewModel.updateResult(3,edt3.text.toString(), strRandomString))
        showReset()
    }

    private fun showReset(){

        reset.visibility = View.VISIBLE
        reset.setOnClickListener {
            finish()
            startActivity(getIntent())
        }
    }

    override fun onSuccess(s: String?) {
        testResult()
    }

    override fun onError(s: String?) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }

}