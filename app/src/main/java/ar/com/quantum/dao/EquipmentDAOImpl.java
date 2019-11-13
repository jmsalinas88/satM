package ar.com.quantum.dao;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;


public class EquipmentDAOImpl extends BaseDAO <Equipment> implements IDAO<Equipment>{

    public EquipmentDAOImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Equipment entity) { return false; }

    @Override
    public Equipment get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Equipment entity) {
        return false;
    }

    @Override
    public Boolean delete(Equipment entity) {
        return false;
    }

    @Override
    public List<Equipment> getAll() {
        List<Equipment> equipmentList  = new ArrayList<Equipment>();
        try {
            String sql = "SELECT id, name, description, image  FROM " + AdminSQLiteOpenHelper.EQUIPMENT_TABLE_NAME + ";";
            Cursor cursor = this.db.rawQuery(sql, null);
            while (cursor.moveToNext()){
                Equipment e = new Equipment();
                e.setId(cursor.getInt(0));
                e.setName(cursor.getString(1));
                e.setDescription(cursor.getString(2));
                e.setImage(cursor.getString(3));
                equipmentList.add(e);
            }
            this.db.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(this.db != null){
                this.db.close();
            }
        }

        return equipmentList;
    }
}
