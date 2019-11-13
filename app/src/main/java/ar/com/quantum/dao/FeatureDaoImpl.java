package ar.com.quantum.dao;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Feature;

public class FeatureDaoImpl extends BaseDao implements IDao<Feature> {


    public FeatureDaoImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Feature entity) {
        return false;
    }

    @Override
    public Feature get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Feature entity) {
        return null;
    }

    @Override
    public Boolean delete(Feature entity) {
        return null;
    }

    @Override
    public List<Feature> getAll() {
        return null;
    }

    public List<Feature> equipmentFeatureList(Integer equipmentId) {
        List<Feature> featureList = new ArrayList<>();
        try {
            String sql = "\n" +
                         "SELECT \n" +
                         "f.id, f.description, f.image\n" +
                         "FROM "+AdminSQLiteOpenHelper.FEATURE_TABLE_NAME+" f , "+AdminSQLiteOpenHelper.EQUIPMENT_FEATURE_TABLE_NAME+" ef \n" +
                         "WHERE 1 = 1 \n" +
                         "AND f.id = ef.feature_id \n" +
                         "AND ef.equipment_id = "+equipmentId+" \n" +
                         "ORDER BY f.description ;";

            Cursor cursor = this.db.rawQuery(sql, null);
            while (cursor.moveToNext()){
                Feature feature = new Feature();
                feature.setId(cursor.getInt(0));
                feature.setDescription(cursor.getString(1));
                feature.setImage(cursor.getString(2));
                featureList.add(feature);
            }
            this.db.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(this.db != null){
                this.db.close();
            }
        }
        return featureList;
    }
}
