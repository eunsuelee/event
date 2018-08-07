package com.eunsue.luck.event;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener{

    final randomEvent event2 = new randomEvent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setOnEditorActionListener(this);

        Button button1 = (Button)findViewById(R.id.button2);
        Button button2 = (Button)findViewById(R.id.button3);
        Button button3 = (Button)findViewById(R.id.button4);
        Button button4 = (Button)findViewById(R.id.button5);

        if(BuildConfig.IS_DEMO) {
            //데모 버전
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("숫자를 입력하세요(1~4)");
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
        }
        else {
            //풀 버전
            button1.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View view){
                    setEvent(event2,0);
                }
            });

            button2.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View view){
                    setEvent(event2,1);
                }
            });

            button3.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View view){
                    setEvent(event2,2);
                }
            });

            button4.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View view){
                    setEvent(event2,3);
                }
            });
        }
    }

    public void setEvent(randomEvent event, int num){
        String result = event.getResult(num);

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage(result)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        switch(v.getId()){
            case R.id.editText:
                setEvent(event2, Integer.valueOf(v.getText().toString()) - 1);
        }
        return false;
    }
}
