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
        String messageValidations = this.messageValidations(equipment);

        if(messageValidations == null)
        {
           this.sinInmodel.addEquipmentUser(equipment);
        }
        else
        {
           this.sinInview.loginValidations(messageValidations);

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
        String out = null;

        if(TextUtils.isEmpty(equipment.getImei()) &&
           TextUtils.isEmpty(user.getName()) &&
           TextUtils.isEmpty(user.getSurname()) &&
           TextUtils.isEmpty(user.getEmail()) &&
           TextUtils.isEmpty(user.getPhoneNumber())
        )
        {
            out = "Ingrese:\n IMEI, Nombre, Apellido, Email y Teléfono";
        }
        else
            {
                String aux = "";

                if (TextUtils.isEmpty(equipment.getImei())){
                    aux += " IMEI\n";
                }else{

                        if(!Utils.isValidIMEI(Long.valueOf(equipment.getImei())))
                        {
                            aux += " IMEI (debe ser uno válido)\n";
                        }
                }
                if (TextUtils.isEmpty(user.getName())) {
                    aux += " Nombre\n";
                }
                if (TextUtils.isEmpty(user.getSurname())) {
                    aux += " Apellido\n";
                }
                if (TextUtils.isEmpty(user.getEmail())) {
                    aux += " Email\n";
                }
                else
                    {
                        if(!Utils.isValidEmail(user.getEmail()))
                        {
                            aux +=  " Email (debe ser uno válido)\n";
                        }
                    }
                if (TextUtils.isEmpty(user.getPhoneNumber())) {
                    aux += " Teléfono\n";
                }

                if(!"".equals(aux))
                {
                    out = "Ingrese:\n" + aux;
                }
        }



        return out;
    }
}
