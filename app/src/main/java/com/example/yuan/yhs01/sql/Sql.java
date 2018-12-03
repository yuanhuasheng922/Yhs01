package com.example.yuan.yhs01.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Sql extends SQLiteOpenHelper {
    private static String name="User.db";
    private static int version=1;
    public Sql(@Nullable Context context ) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table users(id integer primary key autoincrement," +
              "coutent text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
