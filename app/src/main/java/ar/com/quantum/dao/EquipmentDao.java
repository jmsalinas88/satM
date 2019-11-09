package ar.com.quantum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import ar.com.quantum.entity.Equipment;

@Dao
public interface EquipmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEquipment(Equipment e);

    @Query("select * from equipment")
    List<Equipment> getAll();

}
