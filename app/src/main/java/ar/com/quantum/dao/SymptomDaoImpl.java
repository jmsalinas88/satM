package ar.com.quantum.dao;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Symptom;

public class SymptomDaoImpl extends BaseDao<Symptom>  implements IDao<Symptom>{


    public SymptomDaoImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Symptom entity) {
        return false;
    }

    @Override
    public Symptom get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Symptom entity) {
        return null;
    }

    @Override
    public Boolean delete(Symptom entity) {
        return null;
    }

    @Override
    public List<Symptom> getAll() {
        return null;
    }


    public List<Symptom> getFeatureSymtomList(Feature feature) {

        List<Symptom> symptomList = new ArrayList<Symptom>();
        try {
            String sql = "SELECT \n" +
                            "\t s.id\n" +
                            "\t,s.description\n" +
                            "FROM feature_symptom fs, symptom s\n" +
                            "WHERE 1 = 1 \n" +
                            "AND fs.feature_id = "+feature.getId()+" \n" +
                            "AND fs.symptom_id = s.id \n" +
                            "ORDER BY s.description\n" +
                            ";";

            Cursor cursor = this.db.rawQuery(sql, null);
            while (cursor.moveToNext()){
                Symptom symptom = new Symptom();
                symptom.setId(cursor.getInt(0));
                symptom.setDescription(cursor.getString(1));
                symptomList.add(symptom);
            }
            this.db.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(this.db != null){
                this.db.close();
            }
        }
        return symptomList;
    }

}
