package ar.com.quantum.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
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

    public static AppDatabase getDatabase(Context context) {
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
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public static void init( Context context ){

        List<Equipment> equipmentList  = new ArrayList<Equipment>();

        Equipment qfit = new Equipment("Quantum Fit", "Android Nougat - Memoria RAM de 1GB - Memoria interna de 16GB", R.drawable.q_fit);
        Equipment qM = new Equipment("Quantum M", "Android Nougat - Memoria RAM de 1GB - Memoria interna de 16GB", R.drawable.q_m);
        Equipment qMini = new Equipment("Quantum Mini", "Android Oreo - Memoria RAM de 512MB - Memoria interna de 8GB", R.drawable.q_mini);
        Equipment qV = new Equipment("Quantum V", "Android Nougat - Memoria RAM de 4GB - Memoria interna de 64GB", R.drawable.q_m);
        Equipment qYou = new Equipment("Quantum You", "Android Nougat - Memoria RAM de 3GB - Memoria interna de 32GB", R.drawable.q_you);

        equipmentList.add(qfit);
        equipmentList.add(qM);
        equipmentList.add(qMini);
        equipmentList.add(qV);
        equipmentList.add(qYou);

        AppDatabase database =  AppDatabase.getDatabase(context);

        for (Equipment e: equipmentList){
            database.equipmentDao().insertEquipment(e);
        }


        List<Equipment> nEquipmentList  = database.equipmentDao().getAll();

        for (Equipment nE : nEquipmentList){
            System.out.println(" Este equipment viene de la BD: " + nE.getName());
        }



    }

}
