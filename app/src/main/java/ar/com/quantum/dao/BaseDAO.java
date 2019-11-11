package ar.com.quantum.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDAO <T> {

    protected Context context;
    protected AdminSQLiteOpenHelper dbManager;
    protected  SQLiteDatabase db;

    public BaseDAO(Context context){
        this.context = context;
        this.dbManager = new AdminSQLiteOpenHelper(context);
        this.db = this.dbManager.getWritableDatabase();
    }

    protected  void closeDatabase(){
        this.db.close();
    }
}
