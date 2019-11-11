package ar.com.quantum.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Image;
import ar.com.quantum.entity.User;


public class EquipmentDAOImpl extends BaseDAO <Equipment> implements IDAO<Equipment>{


    public EquipmentDAOImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Equipment entity) {

        User user = entity.getUser();

        ContentValues registro = new ContentValues();
        registro.put("name", user.getName());
        registro.put("surname", user.getSurname());
        registro.put("email", user.getEmail());
        registro.put("phone_number", user.getPhoneNumber());
        registro.put("emei", entity.getImei());
        registro.put("equipment_id", entity.getId());
        registro.put("province_id", user.getProvince().getId());

        this.db.insert(AdminSQLiteOpenHelper.EQUIPMENT_USER_TABLE_NAME, null, registro);

        List<Equipment> equipmentList  = new ArrayList<Equipment>();
        String sql = "SELECT *  FROM " + AdminSQLiteOpenHelper.EQUIPMENT_USER_TABLE_NAME + ";";

        System.out.println(sql);

        Cursor cursor = this.db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getInt(0));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(1));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(2));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(3));
            // s System.out.println(" -------------> Trajo algo de la BD " + cursor.getInt(4));


        }
        this.closeDatabase();

        return true;
    }

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

        ContentValues registro = new ContentValues();
        registro.put("id", 2);
        registro.put("name", "Probando, probando");
        registro.put("description", "Esta es la descripcion");
        registro.put("id_image", 10);

        this.db.insert(AdminSQLiteOpenHelper.EQUIPMENT_TABLE_NAME, null, registro);

        List<Equipment> equipmentList  = new ArrayList<Equipment>();
        String sql = "SELECT id , name, description, id_image  FROM " + AdminSQLiteOpenHelper.EQUIPMENT_TABLE_NAME + ";";

        System.out.println(sql );

        Cursor cursor = this.db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Equipment e = new Equipment();
            e.setId(cursor.getInt(0));
            e.setName(cursor.getString(1));
            e.setDescription(cursor.getString(2));
            Image image = new Image();
            image.setId(cursor.getInt(3));
            equipmentList.add(e);

            System.out.println(" -------------> Trajo algo de la BD " + cursor.getInt(0));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(1));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(2));
            System.out.println(" -------------> Trajo algo de la BD " + cursor.getString(3));
           // s System.out.println(" -------------> Trajo algo de la BD " + cursor.getInt(4));


        }
        this.closeDatabase();

        return equipmentList;
    }
}
