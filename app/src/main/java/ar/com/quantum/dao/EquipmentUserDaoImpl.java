package ar.com.quantum.dao;

import android.content.ContentValues;
import android.content.Context;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.User;

public class EquipmentUserDaoImpl extends BaseDao<Equipment> implements IDao<Equipment> {

    public EquipmentUserDaoImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Equipment entity) {
        try{
            User user = entity.getUser();
            ContentValues record = new ContentValues();
            record.put("name", user.getName());
            record.put("surname", user.getSurname());
            record.put("email", user.getEmail());
            record.put("phone_number", user.getPhoneNumber());
            record.put("province_id", user.getProvince().getId());
            record.put("equipment_id",entity.getId());
            record.put("emei",entity.getImei());
            this.db.insert(AdminSQLiteOpenHelper.EQUIPMENT_USER_TABLE_NAME, null, record);
            this.db.close();
        }catch (Exception e){
           e.printStackTrace();
        }
        return true;
    }

    @Override
    public Equipment get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Equipment entity) {
        return null;
    }

    @Override
    public Boolean delete(Equipment entity) {
        return null;
    }

    @Override
    public List<Equipment> getAll() {
        return null;
    }
}
