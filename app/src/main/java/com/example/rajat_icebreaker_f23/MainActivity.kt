package com.example.rajat_icebreaker_f23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rajat_icebreaker_f23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var textView: TextView
    private lateinit var binding : ActivityMainBinding
    //private var sampleText: String = getString(R.string.sample_text)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView=findViewById(R.id.welcomeText)
        //textView.setText("Testing Variable Overload with Hardcoded string")


        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))
        binding.welcomeText.text= "Crashes on using string from strings.xml"
    }
}

