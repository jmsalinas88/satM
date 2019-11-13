package ar.com.quantum.mvp.model;

import android.content.Context;
import java.util.List;
import ar.com.quantum.dao.EquipmentUserDaoImpl;
import ar.com.quantum.dao.ProvinceDaoImpl;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;
import ar.com.quantum.mvp.interfaces.ISingIn;
import ar.com.quantum.mvp.presenter.BaseModel;

public class SingInModel extends BaseModel implements ISingIn.Model {

    private ISingIn.Presenter presenter;

    public SingInModel(ISingIn.Presenter presenter, Context context){
        this.mContext = context;
        this.presenter = presenter;
    }


    @Override
    public void showProvinces() {
        List<Province> provinceList = this.getAllProvinces();
        this.presenter.showProvinces(provinceList);
    }

    @Override
    public void addEquipmentUser(Equipment equipment){
        Boolean result = false;
        EquipmentUserDaoImpl equipmentUserDAO  = new EquipmentUserDaoImpl(this.mContext);
        result = equipmentUserDAO.insert(equipment);
        this.presenter.addEquipmentUser(result);
    }

    private List<Province> getAllProvinces(){
        ProvinceDaoImpl provinceDAO = new ProvinceDaoImpl(this.mContext);
        List<Province> provinceList = provinceDAO.getAll();
        return  provinceList;
    }
}
