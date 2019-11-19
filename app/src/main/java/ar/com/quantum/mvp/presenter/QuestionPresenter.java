package ar.com.quantum.mvp.presenter;

import android.content.Context;
import ar.com.quantum.entity.Diagnostic;
import ar.com.quantum.entity.Question;
import ar.com.quantum.entity.Suggestion;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.entity.Tutorial;
import ar.com.quantum.mvp.interfaces.IQuestion;
import ar.com.quantum.mvp.model.QuestionModel;

public class QuestionPresenter extends  BasePresenter implements IQuestion.Presenter {


    private IQuestion.Model questionModel;
    private IQuestion.View questionView;


    public QuestionPresenter(IQuestion.View view, Context context){
        this.mContext = context;
        this.questionView = view;
        this.questionModel = new QuestionModel(this, context);
    }


    @Override
    public void showQuestion(Symptom symptom) {
        this.questionModel.showQuestion(symptom);
    }

    @Override
    public void showQuestion(Question question) {
        this.questionView.showQuestion(question);
    }

    @Override
    public void performAnswer(Question question) {

        String responseType = "";
        switch (question.getAnswer()){

            case "S":
                responseType = question.getYes();
                break;


            case  "N":
                responseType = question.getNo();
                break;

        }

        switch (responseType){

            case "P":
                this.questionModel.performAnswer(question);
                break;

            case "R":

                break;

            case "T":

                break;

            case "D":

                break;
        }


    }

    @Override
    public void showSugesstion(Suggestion suggestion) {
        this.questionView.showSugesstion(new Suggestion());
    }

    @Override
    public void showTutorial(Tutorial tutorial) {
        this.questionView.showTutorial(new Tutorial());
    }

    @Override
    public void showDiagnostic(Diagnostic diagnostic) {
        this.questionView.showDiagnostic(new Diagnostic());
    }
}
