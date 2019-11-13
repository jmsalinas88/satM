package ar.com.quantum.mvp.interfaces;

import java.util.List;
import ar.com.quantum.entity.Feature;

public interface IFeature {

    interface  Model{
            void showEquipmentFeatureList(Integer equipmentId);
    }

    interface View{
        void showEquipmentFeatureList(List<Feature> featureList);
    }

    interface  Presenter{
        void showEquipmentFeatureList(List<Feature> featureList);
        void showEquipmentFeatureList(Integer equipmentId);

    }

}
