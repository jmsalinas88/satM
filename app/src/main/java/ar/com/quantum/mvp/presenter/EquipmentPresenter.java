package ar.com.quantum.mvp.presenter;

import android.content.Context;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.mvp.model.EquipmentModel;
import ar.com.quantum.mvp.interfaces.IEquipment;

public class EquipmentPresenter extends  BasePresenter implements IEquipment.Presenter {

    private IEquipment.Model model;
    private IEquipment.View view;

    public EquipmentPresenter(IEquipment.View view, Context context){
        this.mContext = context;
        this.view = view;
        this.model = new EquipmentModel(this, context);
    }


    @Override
    public void showEquipments(List<Equipment> equipmentList) {
        if(!equipmentList.isEmpty()){
            this.view.showEquipments(equipmentList);
        }
    }

    @Override
    public void showEquipments() {
            this.model.showEquipments();
    }

}
