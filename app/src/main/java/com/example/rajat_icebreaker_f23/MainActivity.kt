package com.example.rajat_icebreaker_f23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.rajat_icebreaker_f23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var textView: TextView
    private lateinit var binding : ActivityMainBinding
    //private var sampleText: String = getString(R.string.sample_text)
    private val TAG= "IceBreakerAndroidF23Tag"


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"Okayyyy")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView=findViewById(R.id.welcomeText)
        //textView.setText("Testing Variable Overload with Hardcoded string")
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))
        //binding.Header0.text= "IceBreaker"

        binding.buttonGetQuestion.setOnClickListener {// fetching questions on getquestions button click
            Log.d(TAG,"Button pressed")
            getQuesFromFirebase()
        }

        binding.buttonSubmit.setOnClickListener { //container for actions on submit click
            Log.d(TAG,"Submit button pressed")
            //vars for input fields binded
            val firstName=binding.inputFirstName
            val lastName=binding.inputLastName
            val prefName=binding.inputPrefName
            val answer=binding.textAnswer

            Log.d(TAG,"Info gathered is ${firstName.text} ,  ${lastName.text},  ${prefName.text},  ${answer.text}")

        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //function to fetch questions from firebase
    private fun getQuesFromFirebase(){
        Log.d(TAG,"Fetching questions from DB.")

    }



}

