package com.example.verisaklamason

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.verisaklamason.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sharedPreferences: SharedPreferences? =null
    var kayitYeri :Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharePreferences =this.getSharedPreferences("com.example.verisaklamason", MODE_PRIVATE)

        kayitYeri= sharedPreferences?.getInt("age",-1)
        if(kayitYeri==-1){
            binding.textView.text= "Your Age:"
        }else{
            binding.textView.text= "$kayitYeri"
        }

    }
    fun save (view:View){

        val yas=binding.editTextTextPersonName.text.toString().toIntOrNull()
        if (yas!=null){
            binding.textView.text= "Your Age:$yas"
            var sharePreferences = null
            sharePreferences.edit().putInt("age",yas).apply()
        }



    }
    fun delete(view:View){
        kayitYeri= sharedPreferences?.getInt("age",-1)

    }
}