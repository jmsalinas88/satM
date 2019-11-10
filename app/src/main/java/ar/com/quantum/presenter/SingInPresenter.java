package ar.com.quantum.presenter;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import ar.com.quantum.entity.User;
import ar.com.quantum.model.ISingIn;
import ar.com.quantum.model.SingInModel;
import ar.com.quantum.util.Utils;

public class SingInPresenter extends BasePresenter implements ISingIn.Presenter{

    private ISingIn.Model sinInmodel;
    private ISingIn.View sinInview;

    public SingInPresenter(ISingIn.View view, Context context){
        this.sinInview = view;
        this.mContext = context;
        this.sinInmodel = new SingInModel(this, context);
    }

    @Override
    public void showProvinces(List<String> provincesList) {
        if(!provincesList.isEmpty()){
            this.sinInview.showProvinces(provincesList);
        }
    }

    @Override
    public void showProvinces() {
        this.sinInmodel.showProvinces();
    }

    @Override
    public void performLogin(User user) {

        this.sinInview.loginSucess();

        if(TextUtils.isEmpty(user.getEmei()) ||
           TextUtils.isEmpty(user.getNamne()) ||
           TextUtils.isEmpty(user.getSurname()) ||
           TextUtils.isEmpty(user.getEmail()) ||
           TextUtils.isEmpty(user.getPhoneNumber())
         )
        {
         this.sinInview.loginValidations(this.messageValidations(user));
        }
        else
        {
            try {
                 this.sinInview.loginSucess();
            }catch (Exception e){
                  this.sinInview.loginError();
            }
        }

    }

    private String messageValidations(User user){
        String out = "Ingrese:\n";

        if(TextUtils.isEmpty(user.getEmei()) &&
           TextUtils.isEmpty(user.getNamne()) &&
           TextUtils.isEmpty(user.getSurname()) &&
           TextUtils.isEmpty(user.getEmail()) &&
           TextUtils.isEmpty(user.getPhoneNumber())
        )
        {
            out += " IMEI, Nombre, Apellido, Email y Teléfono";
        }
        else
            {
            if (TextUtils.isEmpty(user.getEmei())) {
                out += " IMEI\n";
            }else{
                out += Utils.isValidIMEI(Long.valueOf(user.getEmei())) ? "": " IMEI (debe ser uno valido)\n";
            }
            if (TextUtils.isEmpty(user.getNamne())) {
                out += " Nombre\n";
            }
            if (TextUtils.isEmpty(user.getSurname())) {
                out += " Apellido\n";
            }
            if (TextUtils.isEmpty(user.getEmail())) {
                out += " Email\n";
            }
            else
                {
                    out += Utils.isValidEmail(user.getEmail()) ? "": " Email (debe ser uno valido)\n";
                }
            if (TextUtils.isEmpty(user.getPhoneNumber())) {
                out += " Teléfono\n";
            }
        }
        return out;
    }
}
