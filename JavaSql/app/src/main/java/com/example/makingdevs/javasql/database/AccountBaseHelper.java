package com.example.makingdevs.javasql.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.AccessControlContext;


public class AccountBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "account_base.db";
    private static final int VERSION = 1;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AccountDbSchema.AccountTable.NAME + " (" +
                    "_id integer primary key autoincrement," +
                    AccountDbSchema.AccountTable.Column.NAME + " TEXT" + ","+ // Por un mendigo espacio :(
                    AccountDbSchema.AccountTable.Column.ACCOUNT_NUMBER + " TEXT" + " )";

    private static final String segundo = "CREATE TABLE OTRA("+
                                            "_id integer primary key autoincrement,"+
                                                 "NAME CHAR(40) NOT NULL,"+
                                                 "ACCOUNT CHAR(20) NOT NULL)";




    public AccountBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AccountDbSchema.AccountTable.NAME);
        onCreate(db);
    }
    public void insert(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AccountDbSchema.AccountTable.Column.NAME, "BrandsFerres");
        values.put(AccountDbSchema.AccountTable.Column.ACCOUNT_NUMBER, "823734874844");
        long newRowId = db.insert(AccountDbSchema.AccountTable.NAME, null, values);
        System.out.println("Insertado");
    }
    public void insert2(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", "BrandsFerres");
        values.put("ACCOUNT", "823734874844");
        long newRowId = db.insert("OTRA", null, values);
        System.out.println("Insertado");
        System.out.println(AccountDbSchema.AccountTable.Column.ACCOUNT_NUMBER);
    }
    public void read(){
        SQLiteDatabase db = getWritableDatabase();
        // Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {

                AccountDbSchema.AccountTable.Column.NAME,
                AccountDbSchema.AccountTable.Column.ACCOUNT_NUMBER
        };

// Filter results WHERE "title" = 'My Title'
        String selection = AccountDbSchema.AccountTable.Column.NAME + " = ?";
        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                "OTRA" + " DESC";

        Cursor c = db.query(
                "ACCOUNT",                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        System.out.println(Cursor.FIELD_TYPE_STRING);
        System.out.println("Leeido");

    }
    public void insertManual(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO accounts Values('25','Brandon','837387484874433');";
        //String sql = "INSERT INTO accounts Values(5,'Brandon','837387484874433');";
        db.execSQL(sql);
        db.close();
        System.out.println("INSERTADO");

    }
    public String readManual(){
        SQLiteDatabase db = getWritableDatabase();


        Cursor c = db.rawQuery("SELECT username FROM accounts", null);

        c.moveToNext();
        String query = c.getString(0);
        db.close();
        c.close();
        return query;


    }
    public int readManual1(){
        SQLiteDatabase db = getWritableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM accounts", null);
        c.moveToNext();

        int query = c.getCount();
        db.close();
        c.close();
        return query;


    }
}
