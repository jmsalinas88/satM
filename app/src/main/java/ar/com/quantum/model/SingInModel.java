package ar.com.quantum.model;

import android.content.Context;
import java.util.List;
import ar.com.quantum.dao.EquipmentUserDAOImpl;
import ar.com.quantum.dao.ProvinceDAOImpl;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;
import ar.com.quantum.presenter.BaseModel;

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
        EquipmentUserDAOImpl equipmentUserDAO  = new EquipmentUserDAOImpl(this.mContext);
        result = equipmentUserDAO.insert(equipment);
        this.presenter.addEquipmentUser(result);
    }

    private List<Province> getAllProvinces(){
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl(this.mContext);
        List<Province> provinceList = provinceDAO.getAll();
        return  provinceList;
    }
}
