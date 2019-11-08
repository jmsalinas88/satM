package ar.com.quantum.model;

import android.view.View;

import java.util.List;

import ar.com.quantum.entity.Province;
import ar.com.quantum.entity.User;

public interface ISingIn {


    interface Model {
        void showProvinces();
    }

    interface View extends android.view.View.OnClickListener{
        void showProvinces(List<String> provincesList);
        void loginValidations(String message);
        void loginSucess();
        void loginError();
    }

    interface Presenter {
        void showProvinces(List<String> provincesList);
        void showProvinces();
        void performLogin(User user);
    }


}
