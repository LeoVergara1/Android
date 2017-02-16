package com.example.makingdevs.javasql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.makingdevs.javasql.services.ManejaInterface;
import com.example.makingdevs.javasql.services.interfacePrueba;

import com.example.makingdevs.javasql.database.AccountBaseHelper;
import com.example.makingdevs.javasql.database.AccountDbSchema;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    public Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mContext = getApplicationContext();
        interfacePrueba interfacePrueba1 = ManejaInterface.getInstance(mContext);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AccountBaseHelper db = new AccountBaseHelper(this);

        interfacePrueba1.databaseAdd();


       /* String query = db.readManual();
        System.out.println(query);
*/
        int query1 = db.readManual1();
        System.out.println(query1);

    }
}
