package com.test.mastermindgame

import android.app.Application
import android.text.TextUtils
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.test.movies.utils.Util
import kotlin.coroutines.coroutineContext

class RandomAlphaViewModel(application: Application) : AndroidViewModel(application) {

    private var mListener: ValidateCallback? = null
    private lateinit var utilIntance: Util
    var edtZero: ObservableField<String>? = null
    var edtOne: ObservableField<String>? = null
    var edtTwo: ObservableField<String>? = null
    var edtThree: ObservableField<String>? = null

    init {
        edtZero = ObservableField("")
        edtOne = ObservableField("")
        edtTwo = ObservableField("")
        edtThree = ObservableField("")

        utilIntance = Util()
    }

    fun setViewListener(listener: ValidateCallback) {
        this.mListener = listener
    }

    fun updateResult(pos:Int,string: String): Int {
        return utilIntance.compareResult(pos,string)
    }


    fun validateEditText(edtNumber0: String, edtNumber1: String,edtNumber2: String, edtNumber3: String): Boolean {
        utilIntance = Util()
        val flag: Boolean
        if (TextUtils.isEmpty(edtNumber0) || TextUtils.isEmpty(edtNumber1) || TextUtils.isEmpty(edtNumber2) || TextUtils.isEmpty(edtNumber3)) {
            flag = false
            mListener?.onError(getApplication<Application>().resources.getString(R.string.isEmptyMsg))
        } else {
            mListener?.onSuccess("")
            flag = true
        }
        return flag
    }
}