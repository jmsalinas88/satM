package ar.com.quantum.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.presenter.BaseModel;
import ar.com.quantum.satm.R;

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
