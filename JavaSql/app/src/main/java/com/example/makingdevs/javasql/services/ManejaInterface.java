package com.example.makingdevs.javasql.services;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.makingdevs.javasql.database.AccountBaseHelper;
import com.example.makingdevs.javasql.database.AccountDbSchema;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by makingdevs on 15/02/17.
 */

public class ManejaInterface  implements interfacePrueba  {


    public static interfacePrueba bm;
    public Context mcontext; // Para obtener los contextos de la aplicacion a según la view donde estamos parados
    public   AccountBaseHelper helper; // Encargado de interactuar con nuestra base de datos y asiganar escrituras


    @Override
    public Integer getTotal() {
        return null;
    }
    static public ManejaInterface getInstance(Context context){ // creamos el constructor que recibirá el contesto de la aplicacion  **Muy importante entender que este punto.
        if(bm == null)
            bm = new ManejaInterface(context);
        return (ManejaInterface) bm;
    }

    public ManejaInterface(Context context){
        this.mcontext = context.getApplicationContext(); // Asignamos el contexto de la aplicacion al helper ya que es necesario para no perder el contexto
        this.helper = new AccountBaseHelper(mcontext);
    }

    @Override
    public void databaseAdd() {
        SQLiteDatabase db = helper.getWritableDatabase(); // Indicamos que se va realizar escritura en la base de datos
        ContentValues values = new ContentValues(); // Clase para realizar asignaciones, usado en esta ocación para la base de datos
        values.put(AccountDbSchema.AccountTable.Column.NAME, "BrandsFerres");
        values.put(AccountDbSchema.AccountTable.Column.ACCOUNT_NUMBER, "823734874844");
        long newRowId = db.insert(AccountDbSchema.AccountTable.NAME, null, values); // Enviamos el Insert
        System.out.println("Insertado");

    }

    @Override
    public void dataDelete() {

    }

    @Override
    public void dataEdit() {

    }


}
