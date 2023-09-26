package com.example.rajat_icebreaker_f23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.rajat_icebreaker_f23.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //private lateinit var textView: TextView
    private lateinit var binding : ActivityMainBinding
    //private var sampleText: String = getString(R.string.sample_text)
    private val TAG= "IceBreakerAndroidF23Tag"

    private val gDB=Firebase.firestore
    private var questionBank: MutableList<Questions> = arrayListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"Okayyyy")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))
        //binding.Header0.text= "IceBreaker"
        getQuesFromFirebase()

        binding.buttonGetQuestion.setOnClickListener {// fetching questions on getquestions button click
            Log.d(TAG,"Button pressed")

            binding.resultQues.setText(questionBank?.random().toString())
        }

        binding.buttonSubmit.setOnClickListener { //container for actions on submit click
            Log.d(TAG,"Submit button pressed")
            //vars for input fields binded
            val firstName=binding.inputFirstName
            val lastName=binding.inputLastName
            val prefName=binding.inputPrefName
            val answer=binding.textAnswer

            Log.d(TAG,"Info gathered is ${firstName.text} ,  ${lastName.text},  ${prefName.text},  ${answer.text}")

            writeStudentToFirebase(binding)
            firstName.setText("")
            lastName.setText("")
            prefName.setText("")
            answer.setText("")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //function to fetch questions from firebase
    private fun getQuesFromFirebase(){
        Log.d(TAG,"Fetching questions from DB.")
        gDB.collection("questions")
            .get()
            .addOnSuccessListener { documents ->
                questionBank= mutableListOf()
                for(document in documents){
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val question = document.toObject(Questions::class.java)
                    questionBank!!.add(question) ?: "Empty Database"
                    
                }
                }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }


    private fun writeStudentToFirebase(binding: ActivityMainBinding){

        val firstName=binding.inputFirstName
        val lastName=binding.inputLastName
        val prefName=binding.inputPrefName
        val answer=binding.textAnswer

        val student= hashMapOf("firstname" to firstName.text.toString(),"lastname" to lastName.text.toString(), "prefName" to prefName.text.toString(), "answer" to answer.text.toString())

        gDB.collection("students")
            .add(student)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Docuemnt successfully written with ID ${documentReference.id}")
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }





}




