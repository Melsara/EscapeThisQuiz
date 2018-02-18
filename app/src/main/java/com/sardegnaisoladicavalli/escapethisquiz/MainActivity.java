package com.sardegnaisoladicavalli.escapethisquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.sardegnaisoladicavalli.escapethisquiz.RightAnswers.name;
import static com.sardegnaisoladicavalli.escapethisquiz.RightAnswers.score;

public class MainActivity extends AppCompatActivity {

    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button quit = (Button) findViewById(R.id.button_quit);
        quit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });
    }

    /*Disabling back button. Displaying a toast, when user tap the button instead.*/

    @Override
    public void onBackPressed() {
        displayToast(getString(R.string.toast_noBack));
        /*super.onBackPressed();*/
    }

    /*Method for moving the focus from EditText*/

    public void onClick(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /*Start quiz. Launch Quiz Card 01*/

    public void startQuiz (View view) {
        EditText insertName = (EditText) findViewById(R.id.edit_text_name);
        String userName = insertName.getText().toString();

        Intent card01 = new Intent(this, QuizCard01.class);
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, userName);
        bundle.putInt(SCORE_KEY, score);
        card01.putExtras(bundle);
        startActivity(card01);
    }

    /*Defining toast to display onBackPressed*/

    public void displayToast(CharSequence toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }
}
