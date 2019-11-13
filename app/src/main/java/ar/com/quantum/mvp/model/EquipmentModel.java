package ar.com.quantum.mvp.model;

import android.content.Context;
import java.util.List;
import ar.com.quantum.dao.EquipmentDaoImpl;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.mvp.interfaces.IEquipment;


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
        EquipmentDaoImpl daoE = new EquipmentDaoImpl(this.mContext);
        List<Equipment> equipmentList = daoE.getAll();
        return equipmentList;
    }
}
