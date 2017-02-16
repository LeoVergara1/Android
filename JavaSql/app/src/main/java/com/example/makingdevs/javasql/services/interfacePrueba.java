package com.example.makingdevs.javasql.services;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by makingdevs on 15/02/17.
 */

public interface interfacePrueba { // Inplementación de la interface con sus metodos necesarios
    Integer getTotal(); // Obtener el total de la base de datos en un arrayList
    void databaseAdd();
    void dataDelete();
    void dataEdit();
}
