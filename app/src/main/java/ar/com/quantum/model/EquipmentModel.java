package ar.com.quantum.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ar.com.quantum.dao.EquipmentDAOImpl;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.presenter.BaseModel;


public class EquipmentModel extends BaseModel implements IEquipment.Model {

    private IEquipment.Presenter presenter;

    public EquipmentModel(IEquipment.Presenter presenter, Context context){
        this.mContext = context;
        this.presenter = presenter;
    }

    @Override
    public void showEquipments() {
        List<Equipment> equipmentList = this.getAllEquipments();
        this.presenter.showEquipments(equipmentList);
    }

    private List<Equipment> getAllEquipments(){

        List<Equipment> equipmentList  = new ArrayList<Equipment>();

        Equipment qfit = new Equipment();
        qfit.setName("Quantum Fit");
        qfit.setDescription("Android Nougat - Memoria RAM de 1GB - Memoria interna de 16GB");

        Equipment qM = new Equipment();
        qM.setName("Quantum M");
        qM.setDescription("Android Oreo - Memoria RAM de 2GB - Memoria interna de 16GB");

        Equipment qMini = new Equipment();
        qMini.setName("Quantum Mini");
        qMini.setDescription("Android Oreo - Memoria RAM de 512MB - Memoria interna de 8GB");

        Equipment qV = new Equipment();
        qV.setName("Quantum V");
        qV.setDescription("Android Nougat - Memoria RAM de 4GB - Memoria interna de 64GB");

        Equipment qYou = new Equipment();
        qYou.setName("Quantum You");
        qYou.setDescription("Android Nougat - Memoria RAM de 3GB - Memoria interna de 32GB");

        equipmentList.add(qfit);
        equipmentList.add(qM);
        equipmentList.add(qMini);
        equipmentList.add(qV);
        equipmentList.add(qYou);

        EquipmentDAOImpl daoE = new EquipmentDAOImpl(this.mContext);
        equipmentList = daoE.getAll();


        // return equipmentList;

        return equipmentList;
    }
}
