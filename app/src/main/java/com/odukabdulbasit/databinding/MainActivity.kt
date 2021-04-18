package com.odukabdulbasit.databinding

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.odukabdulbasit.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val myName : MyName = MyName("Abdulbasit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.tamamButton.setOnClickListener{
            addNickName(it)
        }
    }

    fun addNickName(view : View){
        binding.apply {
            myName?.nickname = editTextTextPersonName.text.toString()
            invalidateAll()
            editTextTextPersonName.visibility = View.GONE
            tamamButton.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}