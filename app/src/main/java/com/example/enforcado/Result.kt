package com.example.enforcado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class Result : AppCompatActivity() {
    private lateinit var imageresult: ImageView
    private lateinit var textresult: TextView
    private lateinit var jogarnovamente: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.imageresult = findViewById(R.id.imageresult)
        this.textresult = findViewById(R.id.textresult)
        this.jogarnovamente = findViewById(R.id.jogarnovamente)

        this.jogarnovamente.text = "Jogar Novamente"

        val main = Intent(this, MainActivity::class.java)

        this.jogarnovamente.setOnClickListener {
            startActivity(main)
        }


        if (intent.hasExtra("Result")) {
            if (intent.getStringExtra("Result") == "Ganhou") {
                this.imageresult.setImageResource(
                    resources.getIdentifier(
                        "ganhou",
                        "drawable",
                        packageName
                    )
                )
                this.textresult.text = intent.getStringExtra("Result")
            } else {
                this.imageresult.setImageResource(
                    resources.getIdentifier(
                        "perdeu",
                        "drawable",
                        packageName
                    )
                )
                this.textresult.text = intent.getStringExtra("Result")
            }
        }

    }

}