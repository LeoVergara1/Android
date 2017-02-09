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
    String texto // vavriable para interactuar en los envios
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
        SumActivity obj = new SumActivity() //Objeto instanciado de la clase suma
        Intent open = new Intent(this,Main2Activity.class) // Se instancia open en la clase Intent de la ventana a abrir
        open.putExtra("info",texto) // Se manda la informacion


        mButtonC.onClickListener = {
            open.putExtra("info",texto) // Se manda la infromacion
            startActivity(open) // Se abre la segunda ventana, metodo de la clase Intent
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
