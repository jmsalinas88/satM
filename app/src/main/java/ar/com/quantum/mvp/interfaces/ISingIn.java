package ar.com.quantum.mvp.interfaces;

import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;

public interface ISingIn {


    interface Model {
        void showProvinces();
        void addEquipmentUser(Equipment equipment);

    }

    interface View extends android.view.View.OnClickListener{
        void showProvinces(List<Province> provincesList);
        void loginValidations(String message);
        void loginSucess();
        void loginError();
    }

    interface Presenter {
        void showProvinces(List<Province> provincesList);
        void showProvinces();
        void performLogin(Equipment equipment);
        void addEquipmentUser(Boolean addResult);
    }


}
