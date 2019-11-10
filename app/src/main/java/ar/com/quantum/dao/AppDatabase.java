package ar.com.quantum.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Province;
import ar.com.quantum.entity.User;
import ar.com.quantum.satm.R;


@Database(entities = {User.class, Province.class, Equipment.class, Feature.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract EquipmentDao equipmentDao();

    private static final String DB_NAME = "q";

    /*public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "userdatabase")
                    //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the exercise, allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }*/

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Create the new table
            /*database.execSQL(
                    "CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");

            // Copy the data
            database.execSQL(
                    "INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users");
            // Remove the old table
            database.execSQL("DROP TABLE users");
            // Change the table name to the correct one
            database.execSQL("ALTER TABLE users_new RENAME TO users");*/

        }
    };

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            AppDatabase.class, DB_NAME)
                            .addMigrations(MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }

    public static void init( Context context ){

        List<Equipment> equipmentList  = new ArrayList<Equipment>();

        /*Equipment qfit = new Equipment("Quantum Fit", "Android Nougat - Memoria RAM de 1GB - Memoria interna de 16GB", R.drawable.q_fit);
        Equipment qM = new Equipment("Quantum M", "Android Nougat - Memoria RAM de 1GB - Memoria interna de 16GB", R.drawable.q_m);
        Equipment qMini = new Equipment("Quantum Mini", "Android Oreo - Memoria RAM de 512MB - Memoria interna de 8GB", R.drawable.q_mini);
        Equipment qV = new Equipment("Quantum V", "Android Nougat - Memoria RAM de 4GB - Memoria interna de 64GB", R.drawable.q_m);
        Equipment qYou = new Equipment("Quantum You", "Android Nougat - Memoria RAM de 3GB - Memoria interna de 32GB", R.drawable.q_you);

        equipmentList.add(qfit);
        equipmentList.add(qM);
        equipmentList.add(qMini);
        equipmentList.add(qV);
        equipmentList.add(qYou);*/

        AppDatabase database =  AppDatabase.getDatabase(context);

        for (Equipment e: equipmentList){
            // database.equipmentDao().insertEquipment(e);


            System.out.println("insert into equipment (name, description) values ( '"+e.getName()+"' , '"+e.getDescription()+"'");
        }


        List<Equipment> nEquipmentList  = database.equipmentDao().getAll();

        for (Equipment nE : nEquipmentList){
            System.out.println(" Este equipment viene de la BD: " + nE.getName());
        }



    }

}
