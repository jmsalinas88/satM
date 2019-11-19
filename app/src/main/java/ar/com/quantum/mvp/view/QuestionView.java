package ar.com.quantum.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import ar.com.quantum.entity.Diagnostic;
import ar.com.quantum.entity.Question;
import ar.com.quantum.entity.Suggestion;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.entity.Tutorial;
import ar.com.quantum.mvp.interfaces.IQuestion;
import ar.com.quantum.mvp.presenter.QuestionPresenter;
import ar.com.quantum.satm.R;

public class QuestionView extends BaseView implements IQuestion.View {

    private IQuestion.Presenter presenter;
    private TextView text;
    private Button btnYes;
    private Button btnNo;
    LinearLayout loading;

    private static long ANSWER_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_view);
        this.text = (TextView)findViewById(R.id.questionTextView);
        this.btnYes = (Button)findViewById(R.id.btnQuestionYes);
        this.btnYes.setOnClickListener(this);
        this.btnNo =  (Button)findViewById(R.id.btnQuestionNo);
        this.btnNo.setOnClickListener(this);
        this.loading = (LinearLayout)findViewById(R.id.llProgressBar);
        this.presenter = new QuestionPresenter(this, this);
        this.presenter.showQuestion(new Symptom());

    }


    @Override
    public void onClick(View v) {

            switch (v.getId()){

                case R.id.btnQuestionYes:
                    this.loading.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loading.setVisibility(View.GONE);
                            Question question = (Question)btnYes.getTag();
                            presenter.performAnswer(question);
                        }
                    },  ANSWER_TIMEOUT);
                    break;

                case R.id.btnQuestionNo:
                    this.loading.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loading.setVisibility(View.GONE);
                            Question question = (Question)btnNo.getTag();
                            presenter.performAnswer(question);
                        }
                    },  ANSWER_TIMEOUT);
                    break;

                default:
                    break;
            }
    }

    @Override
    public void showQuestion(Question question) {
        this.text.setText(question.getText());
        question.setAnswer("S");
        this.btnYes.setTag(question);
        question.setAnswer("N");
        this.btnNo.setTag(question);
    }

    @Override
    public void showSugesstion(Suggestion suggestion) {
        Intent suggestionView = new Intent(QuestionView.this, SuggestionView.class);
        suggestionView.putExtra("SUGGESTION", suggestion);
        startActivity(suggestionView);
        finish();
    }

    @Override
    public void showTutorial(Tutorial tutorial) {

        Intent tutoprialView = new Intent(QuestionView.this, TutorialView.class);
        tutoprialView.putExtra("TUTORIAL", tutorial);
        startActivity(tutoprialView);
        finish();

    }

    @Override
    public void showDiagnostic(Diagnostic diagnostic) {

        Intent diagnosticView = new Intent(QuestionView.this, TutorialView.class);
        startActivity(diagnosticView);
        finish();

    }
}
