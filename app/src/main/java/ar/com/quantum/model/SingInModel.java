package ar.com.quantum.model;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.dao.EquipmentDAOImpl;
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
        EquipmentDAOImpl userDAO = new EquipmentDAOImpl(this.mContext);
        result = userDAO.insert(equipment);
        this.presenter.addEquipmentUser(result);
    }

    private List<Province> getAllProvinces(){

        Province p1 = new Province();
        p1.setId(1);
        p1.setDescription("Ciudad de Buenos Aires");
        Province p2 = new Province();
        p2.setId(2);
        p2.setDescription("Tucuman");
        Province p3 = new Province();
        p3.setId(3);
        p3.setDescription("Salta");
        List<Province> provinceList = new ArrayList<Province>();
        provinceList.add(p1);
        provinceList.add(p2);
        provinceList.add(p3);

        return  provinceList;

    }



}
