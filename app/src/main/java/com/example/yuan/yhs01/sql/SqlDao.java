package com.example.yuan.yhs01.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SqlDao  {
    private Context mContext;
    private final SQLiteDatabase database;

    public SqlDao(Context mContext) {
        Sql sql=new Sql(mContext);
        database = sql.getReadableDatabase();
    }
    //添加
    public void add(String strt)
    {
        ContentValues values =new ContentValues();
        values.put("coutent",strt);
        database.insert("users",null,values);
    }

    //删除
    public void delAll()
    {
        database.delete("users",null,null);
    }
}
