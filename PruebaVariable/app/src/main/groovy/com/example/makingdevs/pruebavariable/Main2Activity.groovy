package com.example.makingdevs.pruebavariable

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import groovy.transform.CompileStatic;
@CompileStatic
public class Main2Activity extends AppCompatActivity {
    Button mButtonR
    TextView mText1
    Button mButtonS
    TextView mtxtS
    String dato

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButtonR = (Button) findViewById(R.id.btn_return)
        mButtonS = (Button) findViewById(R.id.btn_suma)
        mText1 = (TextView) findViewById(R.id.txt_suma)
        mtxtS = (TextView) findViewById(R.id.txt_suma)
        SumActivity obj = new SumActivity()
        Bundle bundle = getIntent().getExtras() // Objeto de una clase importada para recibir la informacio
        dato = bundle.getString("info") // Se asigna la informacion por medio de la llave (key)
        mText1.setText(bundle.getString("info")) // otra forma de asignar la infromacion directo al Campo de texto
        Intent return1 = new Intent(this, MainActivity.class)
        return1.putExtra("infoR",dato)

        mButtonR.onClickListener = {

            return1.putExtra("infoR",dato)
            startActivity(return1)
            Toast.makeText(this, "Regreso A ventana", 3).show()



        }
        mButtonS.onClickListener = {
            obj.a = dato.toFloat()
            obj.a+=5
            dato = obj.a
            mText1.setText(dato)

        }
    }

}
