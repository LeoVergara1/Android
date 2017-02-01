package com.example.makingdevs.pruebavariable

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import groovy.transform.CompileStatic;
@CompileStatic
public class MainActivity extends AppCompatActivity {
    Button mButton
    Button mButtonC
    Button mButtonRe
    TextView mText1
    String texto
    String reInfo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn1)
        mButtonC = (Button) findViewById(R.id.button)
        mButtonRe = (Button) findViewById(R.id.btn_recu)
        mText1 = (TextView) findViewById(R.id.text1)
        Bundle bundle = getIntent().getExtras()
        SumActivity obj = new SumActivity()
        Intent open = new Intent(this,Main2Activity.class)
        open.putExtra("info",texto)


        mButtonC.onClickListener = {
            open.putExtra("info",texto)
            startActivity(open)
            Toast.makeText(this, "Cambiando de ventana", 3).show()

        }
        mButton.onClickListener = {
            obj.a+=2
            texto = obj.a
            mText1.setText(texto)

        }

        mButtonRe.onClickListener = {
            reInfo = bundle.getString("infoR")
            obj.a = reInfo.toFloat()
            texto = obj.a
            mText1.setText(texto)
        }



    }



}
