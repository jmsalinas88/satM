package ar.com.quantum.model;

import android.content.Context;
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
        ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl(this.mContext);
        return provinceDAO.getAllStr();
    }
}
