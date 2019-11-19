package ar.com.quantum.mvp.interfaces;

import ar.com.quantum.entity.Diagnostic;
import ar.com.quantum.entity.Question;
import ar.com.quantum.entity.Suggestion;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.entity.Tutorial;

public interface IQuestion {


    interface  Model {
        void showQuestion(Symptom symptom);
        void performAnswer(Question question);
    }

    interface  View  extends android.view.View.OnClickListener {
        void showQuestion(Question question);
        void showSugesstion(Suggestion suggestion);
        void showTutorial(Tutorial tutorial);
        void showDiagnostic(Diagnostic diagnostic);

    }

    interface  Presenter{
        void showQuestion(Symptom symptom);
        void showQuestion(Question question);
        void performAnswer(Question question);
        void showSugesstion(Suggestion suggestion);
        void showTutorial(Tutorial tutorial);
        void showDiagnostic(Diagnostic diagnostic);
    }

}
