package com.example.greenearth;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class sql_helper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "login";
    public static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_FULL_NAME = "Fullname";
    private static final String COLUMN_USER_NAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_EMAIL = "Email";

    public sql_helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =

                "CREATE table " + TABLE_NAME + "(" +

                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FULL_NAME + " TEXT, " +
                        COLUMN_USER_NAME + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT, " +
                        COLUMN_EMAIL + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void adduser(String fullname, String username, String password, String email) {

        SQLiteDatabase data = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FULL_NAME, fullname);
        values.put(COLUMN_USER_NAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_EMAIL, email);
        long result = data.insert(TABLE_NAME, null, values);

        if (result == -1) {

            Toast.makeText(context, "unsuccessful :(", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(context, "successful :)", Toast.LENGTH_SHORT).show();
        }
    }

    void updateuser(String name, String old,String pass){


        SQLiteDatabase ds = this.getWritableDatabase();


        String query = "UPDATE " + TABLE_NAME +
                " SET " + COLUMN_PASSWORD + " = '" + pass + "'" +
                " WHERE " + COLUMN_USER_NAME + " = '" + name + "'"+
                " and " + COLUMN_PASSWORD + " = '" + old + "'";
        try {
            ds.execSQL(query);

            Toast.makeText(context,"Password has been updated", Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void verifyUser(String name, String pass, Context context) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_USER_NAME + " = '" + name + "'"+
                " and " + COLUMN_PASSWORD + " = '" + pass + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            int storedPassword = cursor.getColumnIndex(COLUMN_PASSWORD);
            if (storedPassword !=-1) {
                // Password matches, authentication successful
                cursor.close();
               Toast.makeText(context, "Account recognised", Toast.LENGTH_SHORT).show();
                Intent m = new Intent(context, fragies.class);
              context.startActivity(m);
            }

            else {
           Toast.makeText(context, "invalid username or password", Toast.LENGTH_SHORT).show();

            }
        }

    }


}