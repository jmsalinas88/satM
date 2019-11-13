package ar.com.quantum.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;
import ar.com.quantum.entity.User;
import ar.com.quantum.mvp.interfaces.ISingIn;
import ar.com.quantum.mvp.model.SingInModel;
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
    public void showProvinces(List<Province> provincesList) {
        if(!provincesList.isEmpty()){
            this.sinInview.showProvinces(provincesList);
        }
    }

    @Override
    public void showProvinces() {
        this.sinInmodel.showProvinces();
    }

    @Override
    public void performLogin(Equipment equipment) {

        User user = equipment.getUser();

        if(TextUtils.isEmpty(equipment.getImei()) ||
           TextUtils.isEmpty(user.getName()) ||
           TextUtils.isEmpty(user.getSurname()) ||
           TextUtils.isEmpty(user.getEmail()) ||
           TextUtils.isEmpty(user.getPhoneNumber())
         )
        {
         this.sinInview.loginValidations(this.messageValidations(equipment));
        }
        else
        {
            this.sinInmodel.addEquipmentUser(equipment);
        }

    }

    @Override
    public void addEquipmentUser(Boolean addResult) {
        if(addResult)
        {
            this.sinInview.loginSucess();
        }
        else
            {
            this.sinInview.loginError();
        }
    }

    private String messageValidations(Equipment equipment){

        User user = equipment.getUser();
        String out = "Ingrese:\n";

        if(TextUtils.isEmpty(equipment.getImei()) &&
           TextUtils.isEmpty(user.getName()) &&
           TextUtils.isEmpty(user.getSurname()) &&
           TextUtils.isEmpty(user.getEmail()) &&
           TextUtils.isEmpty(user.getPhoneNumber())
        )
        {
            out += " IMEI, Nombre, Apellido, Email y Teléfono";
        }
        else
            {
            if (TextUtils.isEmpty(equipment.getImei())){
                out += " IMEI\n";
            }else{
                //out += Utils.isValidIMEI(Long.valueOf(user.getEmei())) ? "": " IMEI (debe ser uno valido)\n";
            }
            if (TextUtils.isEmpty(user.getName())) {
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
