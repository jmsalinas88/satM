package ar.com.quantum.model;

import android.content.Context;
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
        EquipmentDAOImpl daoE = new EquipmentDAOImpl(this.mContext);
        List<Equipment> equipmentList = daoE.getAll();
        return equipmentList;
    }
}
