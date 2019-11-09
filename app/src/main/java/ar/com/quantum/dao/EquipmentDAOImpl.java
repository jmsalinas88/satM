package ar.com.quantum.dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ar.com.quantum.entity.Equipment;
import ar.com.quantum.satm.R;

public class EquipmentDAOImpl extends BaseDAO <Equipment> implements IDAO<Equipment>{

    private static final String CREATE = "create table if not exists equipment (id integer primary key autoincrement, name text, description text, image blob)";
    private static final String TABLE_NAME = "equipment";

    public EquipmentDAOImpl(Context context) {
        super(context, TABLE_NAME);
    }

    @Override
    public boolean insert(Equipment entity) {
        return false;
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


        return equipmentList;
    }
}
