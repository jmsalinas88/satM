package ar.com.quantum.mvp.interfaces;

import java.util.List;
import ar.com.quantum.entity.Equipment;

public interface IEquipment {

    interface Model{
        void showEquipments();
    }

    interface View {
        void showEquipments(List<Equipment> equipmentList);
    }

    interface Presenter{
        void showEquipments(List<Equipment> equipmentList);
        void showEquipments();
    }

}
