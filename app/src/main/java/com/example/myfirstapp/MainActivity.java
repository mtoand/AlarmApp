package com.example.myfirstapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends FragmentActivity implements TimePickerDialog.OnTimeSetListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
    public void showTimeSet(View view){
        DialogFragment newFragment = new TimePickerActivity();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int min) {
        String str = String.format(Locale.JAPANESE,"%d:%d",hour,min);
        textView.setText(str);

        //設定された時刻の処理
        SimpleDateFormat df = new SimpleDateFormat("mmss");
        Date date;
        try {
            date = df.parse(String.valueOf(hour)+String.valueOf(min));
        } catch (ParseException e) {
        }


    }

    /*public boolean isSetTime(Date date){
        Date current = new Date();
        SimpleDateFormat df = new SimpleDateFormat("mmss");
    }*/
}
