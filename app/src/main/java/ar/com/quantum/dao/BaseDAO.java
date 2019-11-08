package ar.com.quantum.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDAO <T> {

    protected SQLiteDatabase database;
    protected Context context;
    protected String tableName;
    protected DatabaseManager dbManager;

    public BaseDAO(Context context, String tableName){
        this.context = context;
        this.tableName = tableName;
        this.dbManager = new DatabaseManager(context);
    }

}
