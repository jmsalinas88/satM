package ar.com.quantum.mvp.presenter;

import android.content.Context;
import java.util.List;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.mvp.interfaces.IFeature;
import ar.com.quantum.mvp.model.FeatureModel;

public class FeaturePresenter extends BasePresenter implements  IFeature.Presenter{

    private IFeature.Model featureModel;
    private IFeature.View featureView;

    public FeaturePresenter(IFeature.View view, Context context) {
        this.mContext = context;
        this.featureView = view;
        this.featureModel = new FeatureModel(this, context);

    }

    @Override
    public void showEquipmentFeatureList(List<Feature> featureList) {
        this.featureView.showEquipmentFeatureList(featureList);
    }

    @Override
    public void showEquipmentFeatureList(Integer equipmentId) {
        this.featureModel.showEquipmentFeatureList(equipmentId);
    }
}
