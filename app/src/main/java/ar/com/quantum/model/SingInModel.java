package ar.com.quantum.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ar.com.quantum.dao.ProvinceDAOImpl;
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
        List<String> provinceList = this.getAllProvinces();
        this.presenter.showProvinces(provinceList);
    }

    private List<String> getAllProvinces(){

        List<String> provinceList = new ArrayList<String>();
        provinceList.add("Ciudad Autónoma de Buenos Aires");
        provinceList.add("Misiones");
        provinceList.add("San Luis");
        provinceList.add("San Juan");
        provinceList.add("Entre Ríos");
        provinceList.add("Entre Ríos");
        provinceList.add("Santa Cruz");
        provinceList.add("Río Negro");
        provinceList.add("Chubut");

        return  provinceList;

    }
}
