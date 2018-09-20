package inclass1.group3.group3_inclass01;

import android.content.Intent;
import android.media.Image;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class WelcomeActivity extends AppCompatActivity {
    public String token,userID;
    TextView question;
    int QuestionIndex=0,AnswerIndex;
    String[] Questions = new String[10] ;
    int[] answers= new int[10];
    List<String[]> options = new ArrayList<String[]>();
    public static  apiCalls caller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        caller.activity=WelcomeActivity.this;
        QuestionIndex=0;
        caller=new apiCalls();
        token =getIntent().getExtras().getString(MainActivity.KEY_TOKEN);
      //  userID =getIntent().getExtras().get(MainActivity.KEY_USERID).toString();
addQuestions();
showOptions();
        question = findViewById(R.id.questionText);
        Button finish= findViewById(R.id.btnSubmitResponse);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caller.saveResponse(answers,totalScore());
            }
        });

        //usign the token get the question data from server make an ajax call.
       final RadioGroup rg = findViewById(R.id.radioGroup);
         final ImageButton next=   findViewById(R.id.btnNext);
        next.setVisibility(View.INVISIBLE);
         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 validateAnswer();

                 TranslateAnimation animObj= new TranslateAnimation(0,question.getWidth(), 0, 0);
                 animObj.setDuration(1000);
                 question.startAnimation(animObj);
                 animObj.setAnimationListener(new Animation.AnimationListener(){
                     @Override
                     public void onAnimationStart(Animation arg0) {
                         next.setVisibility(View.INVISIBLE);
                     }
                     @Override
                     public void onAnimationRepeat(Animation arg0) {
                     }
                     @Override
                     public void onAnimationEnd(Animation arg0) {
                         String questionText="some Random text";
                         questionText=Questions[QuestionIndex];
                         showOptions();
                         question.setText(questionText);
                         rg.clearCheck();
                         QuestionIndex++;

                     }
                 });


             }


         });
    }

    private void addQuestions(){
        String[] temp = new String[5]; String[] temp1 = new String[5]; String[] temp2 = new String[5]; String[] temp3 = new String[5]; String[] temp4 = new String[5];
        String[] temp5 = new String[5]; String[] temp6 = new String[5]; String[] temp7 = new String[5]; String[] temp8 = new String[5]; String[] temp9 = new String[5];
      Questions[0]="How often do you have a drink containing alcohol?";
      temp[0]=" Never ";
      temp[1]=" Monthly or less";
      temp[2]=" 2 to 4 times a month";
      temp[3]=" 2 to 3 times a week";
      temp[4]=" 4 or more times a week";
      options.add(temp);


        Questions[1]="How many drinks containing alcohol do you have\n" +
                "on a typical day when you are drinking?";
        temp1[0]=" 1 or 2 ";
        temp1[1]="3 or 4";
        temp1[2]=" 5 or 6";
        temp1[3]=" 7, 8, or 9";
        temp1[4]=" 10 or more";
        options.add(temp1);
        Questions[2]=" How often do you have six or more drinks on one\n" +
                "occasion?";
        temp2[0]="Never";
        temp2[1]="Less than monthly";
        temp2[2]="Monthly";
        temp2[3]="Weekly";
        temp2[4]="Daily or almost daily";
        options.add(temp2);
        Questions[3]=" How often during the last year have you found\n" +
                "that you were not able to stop drinking once you\n" +
                "had started?";
        temp3[0]="Never";
        temp3[1]="Less than monthly";
        temp3[2]="Monthly";
        temp3[3]="Weekly";
        temp3[4]="Daily or almost daily";
        options.add(temp3);
        Questions[4]="How often during the last year have you failed to\n" +
                "do what was normally expected from you\n" +
                "because of drinking?";
        temp4[0]="Never";
        temp4[1]="Less than monthly";
        temp4[2]="Monthly";
        temp4[3]="Weekly";
        temp4[4]="Daily or almost daily";
        options.add(temp4);
        Questions[5]="How often during the last year have you needed\n" +
                "a first drink in the morning to get yourself going\n" +
                "after a heavy drinking session?";
        temp5[0]="Never";
        temp5[1]="Less than monthly";
        temp5[2]="Monthly";
        temp5[3]="Weekly";
        temp5[4]="Daily or almost daily";
        options.add(temp5);
        Questions[6]=" How often during the last year have you had a\n" +
                "feeling of guilt or remorse after drinking?";
        temp6[0]="Never";
        temp6[1]="Less than monthly";
        temp6[2]="Monthly";
        temp6[3]="Weekly";
        temp6[4]="Daily or almost daily";
        options.add(temp6);
        Questions[7]=" How often during the last year have you been\n" +
                "unable to remember what happened the night\n" +
                "before because you had been drinking?";
        temp7[0]="Never";
        temp7[1]="Less than monthly";
        temp7[2]="Monthly";
        temp7[3]="Weekly";
        temp7[4]="Daily or almost daily";
        options.add(temp7);
        Questions[8]="Have you or someone else been injured as a\n" +
                "result of your drinking?";
        temp8[0]="No";
        temp8[1]="";
        temp8[2]="Yes, but not in the last year";
        temp8[3]="";
        temp8[4]="Yes, during the last year";
        options.add(temp8);
        Questions[9]=" Has a relative or friend or a doctor or another\n" +
                "health worker been concerned about your drinking\n" +
                "or suggested you cut down?";
        temp9[0]="No";
        temp9[1]="";
        temp9[2]="Yes, but not in the last year";
        temp9[3]="";
        temp9[4]="Yes, during the last year";
        options.add(temp9);
        question = findViewById(R.id.questionText);
        question.setText(Questions[QuestionIndex]);

    }
    private void showOptions(){

        RadioButton op1=    findViewById(R.id.id_0);
        op1.setText(options.get(QuestionIndex)[0]);
        RadioButton op2=    findViewById(R.id.id_1);
        op2.setText(options.get(QuestionIndex)[1]);
        RadioButton op3=    findViewById(R.id.id_2);
        op3.setText(options.get(QuestionIndex)[2]);
        RadioButton op4=    findViewById(R.id.id_3);
        op4.setText(options.get(QuestionIndex)[3]);
        RadioButton op5=    findViewById(R.id.id_4);
        op5.setText(options.get(QuestionIndex)[4]);
        Log.d("test", "showOptions: "+QuestionIndex);

    }
private int totalScore(){
        int ret=0;
        for ( int i = 0 ; i <10;i++){
            if (  answers[i]!=100  )
            ret=ret+answers[i];
        }
        return   ret ;
}
    private void validateAnswer() {
        int temp =QuestionIndex;
        switch ( temp){
            case 0:
                if ( answers[0] ==0){
                    QuestionIndex=8;
                    answers[1]=100;
                    answers[2]=100;
                    answers[3]=100;answers[4]=100;answers[5]=100;answers[6]=100;answers[7]=100;
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                if (  answers[1]+answers[2]==0) {
                    QuestionIndex = 8;
                    answers[4]=100;answers[5]=100;answers[6]=100;answers[7]=100;
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        ImageButton next = findViewById(R.id.btnNext);
        Button finsish = findViewById(R.id.btnSubmitResponse);
        if (QuestionIndex!=10) {
            next.setVisibility(View.VISIBLE);


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.id_0:
                if (checked)
                    // Pirates are the best
                    answers[QuestionIndex]=0;
                    break;
            case R.id.id_1:
                if (checked)
                    // Ninjas rule
                    answers[QuestionIndex]=1;
                    break;
            case R.id.id_2:
                if (checked)
                    // Ninjas rule
                    answers[QuestionIndex]=2;
                    break;
            case R.id.id_3:
                if (checked)
                    // Ninjas rule
                    answers[QuestionIndex]=3;
                    break;
            case R.id.id_4:
                if (checked)
                    // Ninjas rule
                    answers[QuestionIndex]=4;
                    break;
        }

        }
        else{
            finsish.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout_menu_item:
                Toast.makeText(getApplicationContext(),"You pressed logout",Toast.LENGTH_SHORT).show();
                MainActivity.caller.deleteToken();
                Intent registerIntent = new Intent(this,MainActivity.class);
                startActivity(registerIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
