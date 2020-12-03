package com.example.login_signup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {
    public DbManager(Context context) {
        super(context, "DB_ShopUser", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableDatabase = "CREATE TABLE T_User (Id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "UserName VARCHAR (30)," +
                "Password VARCHAR (25));";
        db.execSQL(createTableDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addPerson(People person) {
        try {
            String insertPerson = "INSERT INTO T_User (UserName,Password) VALUES ('" + person.getUserName() + "','" + person.getPassword() + "')";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(insertPerson);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public People searchUser(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM T_User WHERE UserName='" + userName + "'", null);
        People user = null;
        if (cursor.moveToFirst())
            user = new People(cursor.getString(1), cursor.getString(2));
        db.close();
        cursor.close();
        return user;
    }
}
