package ar.com.quantum.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;

public class ProvinceDAOImpl extends BaseDAO<Province> implements  IDAO<Province>{

    public ProvinceDAOImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Province entity) {
        return false;
    }

    @Override
    public Province get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Province entity) {
        return false;
    }

    @Override
    public Boolean delete(Province entity) {
        return false;
    }

    @Override
    public List<Province> getAll() {
        List<Province> provinceList  = new ArrayList<Province>();
        try {
            String sql = "SELECT id, description FROM " + AdminSQLiteOpenHelper.PROVINCE_TABLE_NAME + " ORDER BY description ;";
            Cursor cursor = this.db.rawQuery(sql, null);
            while (cursor.moveToNext()){
                Province province = new Province();
                province.setId(cursor.getInt(0));
                province.setDescription(cursor.getString(1));
                provinceList.add(province);
            }
            this.db.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(this.db != null){
                this.db.close();
            }
        }
        return provinceList;
    }

}
