package ar.com.quantum.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDao<T> {

    protected Context context;
    protected AdminSQLiteOpenHelper dbManager;
    protected  SQLiteDatabase db;

    public BaseDao(Context context){
        this.context = context;
        this.dbManager = new AdminSQLiteOpenHelper(context);
        this.db = this.dbManager.getWritableDatabase();
    }
}
