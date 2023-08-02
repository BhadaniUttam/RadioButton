package com.example.radiobutton;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.radiobutton.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public RadioButton rdkotlin,rdpython;
    public CheckBox cbjava,cbkotlin,cbpython;
    public TextView textans1,textans2,textans3,textans4;
    public Button click,clock,date;
    public ArrayList<String> cbresult;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        rdkotlin = binding.rdkotlin;
        rdpython = binding.rdpython;
        textans1 = binding.textans1;
        cbjava = binding.cbjava;
        cbkotlin = binding.cbkotlin;
        cbpython = binding.cbpython;
        textans2 = binding.textans2;
        textans3 = binding.textans3;
        clock = binding.clock;
        date = binding.date;
        textans4 = binding.textans4;

        binding.rdjava.setOnClickListener(new View.OnClickListener() {       // rdjava = binding.rdjava lkhu nathi
            @Override                                                      // binding.rdjava compulsory lkhavu pade
            public void onClick(View view) {
                binding.textans1.setText(""+binding.rdjava.getText().toString());
            }
        });
        rdkotlin.setOnClickListener(new View.OnClickListener() {      // rdkotlin = binding.rdkotlin lkhu che
            @Override                                               // binding.rdkotlin lkhavu jaruri nathi
            public void onClick(View view) {
                textans1.setText(""+rdkotlin.getText().toString());
            }
        });
        rdpython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textans1.setText(""+rdpython.getText().toString());
            }
        });
        cbresult = new ArrayList<>();
        textans2.setEnabled(false);

        cbjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbjava.isChecked()){
                    str=str+" Java";
                    textans2.setText(""+str);
                }
                else if(!cbjava.isChecked()) {
                    str = str.replaceAll(" Java", "");
                    textans2.setText("" + str);
                }
            }
        });
        cbkotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbkotlin.isChecked()){
                    str=str+" Kotlin";
                    textans2.setText(""+str);
                }
                else if(!cbkotlin.isChecked()) {
                    str=str.replaceAll(" Kotlin","");
                    textans2.setText(""+str);
                }
            }
        });
        cbpython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbpython.isChecked()){
                    str=str+" Python";
                    textans2.setText(""+str);
                }
                else if(!cbpython.isChecked()) {
                    str=str.replaceAll(" Python","");
                    textans2.setText(""+str);
                }
            }
        });

        textans2.setText(""+str);

        Calendar calendar=Calendar.getInstance();
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    //Calendar calendar=Calendar.getInstance();
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String am_pm = "";

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        if (calendar.get(Calendar.AM_PM) == Calendar.AM)
                            am_pm = " AM";
                        else if (calendar.get(Calendar.AM_PM) == Calendar.PM)
                            am_pm = " PM";
                        String strHrsToShow = (calendar.get(Calendar.HOUR) == 0) ? "12" : Integer.toString( calendar.get(Calendar.HOUR) );

                        binding.textans3.setText(""+strHrsToShow+" : "+minute+" "+am_pm);
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                dialog.show();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog();
            }
        });
    }
    private void opendialog(){



        Calendar calendar=Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {

                textans4.setText(String.valueOf(dayOfMonth)+"."+String.valueOf(month)+"."+String.valueOf(year));
            }
        }, calendar.get(Calendar .YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();


    }
}