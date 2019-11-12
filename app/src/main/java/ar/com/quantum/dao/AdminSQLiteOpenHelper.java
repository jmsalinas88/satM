package ar.com.quantum.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "q5";
    private static final Integer DATA_BASE_VERSION = 1;

    // Tables:
    public static final String EQUIPMENT_TABLE_NAME = "equipment";
    public static final String EQUIPMENT_USER_TABLE_NAME = "equipment_user";
    public static final String PROVINCE_TABLE_NAME = "province";



    public AdminSQLiteOpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {


            db.execSQL(
               "CREATE TABLE IF NOT EXISTS " + EQUIPMENT_TABLE_NAME + "(id INTEGER PRIMARY KEY, name TEXT ,description TEXT,id_image INTEGER)"
            );

            db.execSQL("CREATE TABLE IF NOT EXISTS "+PROVINCE_TABLE_NAME+" (\n" +
                    "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"description\"\tTEXT\n" +
                    ")");

            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS "+ EQUIPMENT_USER_TABLE_NAME +" (\n" +
                            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t\"name\"\tTEXT,\n" +
                            "\t\"surname\"\tTEXT,\n" +
                            "\t\"email\"\tTEXT,\n" +
                            "\t\"phone_number\"\tTEXT,\n" +
                            "\t\"emei\"\tTEXT,\n" +
                            "\t\"equipment_id\"\tINTEGER,\n" +
                            "\t\"province_id\"\tINTEGER\n" +
                            ");"
            );


        } catch (SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + EQUIPMENT_TABLE_NAME);
       db.execSQL("DROP TABLE IF EXISTS " + EQUIPMENT_USER_TABLE_NAME);
       onCreate(db);
    }

    public SQLiteDatabase getDatabase(){
        return this.getWritableDatabase();
    }
}
