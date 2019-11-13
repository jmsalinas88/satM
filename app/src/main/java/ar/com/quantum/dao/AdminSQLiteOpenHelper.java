package ar.com.quantum.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    private Context mContex;
    private static final String DATA_BASE_NAME = "q6v";
    private static final Integer DATA_BASE_VERSION = 1;
    private static final String DATA_BASE_ASSET_PATH = "databases/";

    // Tables:
    public static final String EQUIPMENT_TABLE_NAME = "equipment";
    public static final String EQUIPMENT_USER_TABLE_NAME = "equipment_user";
    public static final String PROVINCE_TABLE_NAME = "province";
    public static final String FEATURE_TABLE_NAME = "feature";
    public static final String EQUIPMENT_FEATURE_TABLE_NAME = "equipment_feature";



    public AdminSQLiteOpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        this.mContex = context;
    }


    public static void setDefaultDataBase(Context context) {
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            myInput = context.getAssets().open(DATA_BASE_ASSET_PATH +DATA_BASE_NAME);

            // Path to the just created empty db
            String outFileName = context.getDatabasePath(DATA_BASE_NAME).getPath();
            //Open the empty db as the output stream
            myOutput = new FileOutputStream(outFileName);
            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                myOutput.flush();
                myOutput.close();
                myInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private boolean existsDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(this.mContex.getDatabasePath(DATA_BASE_NAME).getPath(), null, SQLiteDatabase.OPEN_READWRITE);
            if(checkDB!= null){
                checkDB.close();
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(checkDB!= null){

                try{
                    checkDB.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return checkDB != null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        if(!existsDataBase()){
            AdminSQLiteOpenHelper.setDefaultDataBase(this.mContex);
        }
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        if(!existsDataBase()){
            AdminSQLiteOpenHelper.setDefaultDataBase(this.mContex);
        }
        return super.getReadableDatabase();
    }
}
