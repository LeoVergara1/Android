package com.example.makingdevs.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import groovy.transform.CompileStatic

import java.util.Random
@CompileStatic
public class MainActivity extends AppCompatActivity {

     ImageView mImageView
     TextView mTextView
     Button mButtonFalse
     Button mButtonTrue
     List<String> names = ["Las del Crepusculo", "La de las lesbis","La de gray", "la de potter","Robot","Android 7"]
     List<Integer> photos = [R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.an7,R.drawable.robot ]
     Integer currentName = 0
     Integer currentPhoto = 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImageView = (ImageView) findViewById(R.id.photo)
        mTextView = (TextView) findViewById(R.id.photoName)
        mButtonFalse = (Button) findViewById(R.id.button_false)
        mButtonTrue = (Button) findViewById(R.id.button_true)


        updatePhoto()

        mButtonFalse.onClickListener={
                println("Hola k ase")

                Toast.makeText(this, "Este es el mensaje...", Toast.LENGTH_SHORT).show()
            updatePhoto()

        }

        mButtonTrue.onClickListener={
                println("Hola no ase ")
                updatePhoto()

        }

    }
     void updatePhoto(){
         Integer randomPhoto = new Random().nextInt(6)
         Integer randomName = new Random().nextInt(6)
        mImageView.setImageResource(photos[randomPhoto])
        mTextView.setText(names[randomName])
    }
}
