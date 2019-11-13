package ar.com.quantum.model;

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
