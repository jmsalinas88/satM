package ar.com.quantum.dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Province;

public class ProvinceDAOImpl extends BaseDAO<Province> implements  IDAO<Province>{

    private  static  final String CREATE = "create table if not exists province (id integer primary key autoincrement, iso_id text, description text)";
    private static final String TABLE_NAME = "province";

    public ProvinceDAOImpl(Context context) {
        super(context, TABLE_NAME);
        super.dbManager.getWritableDatabase().execSQL(CREATE);
        super.database = super.dbManager.getWritableDatabase();
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
        return null;
    }


    public List<String> getAllStr() {

        List<String> provinceList = new ArrayList<String>();
        provinceList.add(new Province("Ciudad Autónoma de Buenos Aires").getDescription());
        provinceList.add(new Province("Misiones").getDescription());
        provinceList.add(new Province("San Luis").getDescription());
        provinceList.add(new Province("San Juan").getDescription());
        provinceList.add(new Province("Entre Ríos").getDescription());
        provinceList.add(new Province("Santa Cruz").getDescription());
        provinceList.add(new Province("Río Negro").getDescription());
        provinceList.add(new Province("Chubut").getDescription());
        provinceList.add(new Province("Córdoba").getDescription());
        provinceList.add(new Province("Mendoza").getDescription());
        provinceList.add(new Province("La Rioja").getDescription());
        provinceList.add(new Province("Catamarca").getDescription());
        provinceList.add(new Province("La Pampa").getDescription());
        provinceList.add(new Province("Santiago del Estero").getDescription());
        provinceList.add(new Province("Corrientes").getDescription());
        provinceList.add(new Province("Santa Fe").getDescription());
        provinceList.add(new Province("Tucumán").getDescription());
        provinceList.add(new Province("Neuquén").getDescription());
        provinceList.add(new Province("Salta").getDescription());
        provinceList.add(new Province("Salta").getDescription());
        provinceList.add(new Province("Formosa").getDescription());
        provinceList.add(new Province("Jujuy").getDescription());
        provinceList.add(new Province("Buenos Aires").getDescription());
        provinceList.add(new Province("Tierra del Fuego").getDescription());

       /*for (String p: provinceList) {
            Province prov = new Province(p);
            prov.save();
        }*/
        

        return provinceList;
    }
}
