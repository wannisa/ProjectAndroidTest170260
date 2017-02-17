package com.projecttest.aoyler.projecttest;


import android.app.Activity;
import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddOrEditCalendarActivity_Notifications extends Activity implements View.OnClickListener {
    private String id;

    Button btn_time, btn_timenoon, btn_timeevening, btn_timebefore;
    private int mHour, mMinute;
    EditText start_date, end_date, in_time, in_timenoon, in_timeevening, in_timebefore;

    private Calendar cal;
    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog fromDatePickerDialogEnd;
    private TimePicker.OnTimeChangedListener fromTimePickerDialog;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat dateFormatterend;
    private SimpleDateFormat timeFormatter;
    private SimpleDateFormat timeFormatternoon;
    private SimpleDateFormat timeFormatterevening;
    private SimpleDateFormat timeFormatterbefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.addcalendar);
        setContentView(R.layout.addrugs_notification);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        dateFormatterend = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        timeFormatter = new SimpleDateFormat("H:mm", Locale.US);
        timeFormatternoon = new SimpleDateFormat("H:mm", Locale.US);
        timeFormatterevening = new SimpleDateFormat("H:mm", Locale.US);
        timeFormatterbefore = new SimpleDateFormat("H:mm", Locale.US);

        datefindViewsById();
        datefindViewsByIdEnd();
        setDateTimeField();
        setDateTimeFieldEnd();
        timefindViewsById();
        timefindViewsByIdnoon();
        timefindViewsByIdevening();
        timefindViewsByIdbefore();


        btn_time = (Button) findViewById(R.id.btn_time);
        btn_timenoon = (Button) findViewById(R.id.btn_timenoon);
        btn_timeevening = (Button) findViewById(R.id.btn_timeevening);
        btn_timebefore = (Button) findViewById(R.id.btn_timebefore);


        cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        in_time = (EditText) findViewById(R.id.in_time);
        in_timenoon = (EditText) findViewById(R.id.in_timenoon);
        in_timeevening = (EditText) findViewById(R.id.in_timeevening);
        in_timebefore = (EditText) findViewById(R.id.in_timebefore);

        btn_time.setOnClickListener(this);
        btn_timenoon.setOnClickListener(this);
        btn_timeevening.setOnClickListener(this);
        btn_timebefore.setOnClickListener(this);

        in_time.setOnClickListener(this);
        in_timenoon.setOnClickListener(this);
        in_timeevening.setOnClickListener(this);
        in_timebefore.setOnClickListener(this);

        id = getIntent().getStringExtra("id");
        if (id != null) {
            start_date.setText(getIntent().getStringExtra("date"));
            end_date.setText(getIntent().getStringExtra("dateend"));
            in_time.setText(getIntent().getStringExtra("timer"));
            in_timenoon.setText(getIntent().getStringExtra("timernoon"));
            in_timeevening.setText(getIntent().getStringExtra("timerevening"));
            in_timebefore.setText(getIntent().getStringExtra("timerbefore"));
        } else {

        }
    }

    public void onSave(View view) {

        String textdate = start_date.getText().toString();
        if (textdate.equals("")) {
            Toast.makeText(this, "กรุณาเลือกวันเริ่มต้นกินยา", Toast.LENGTH_SHORT).show();
            return;
        }
        String textdateend = end_date.getText().toString();
        if (textdateend.equals("")) {
            Toast.makeText(this, "กรุณาเลือกวันสิ้นสุดกินยา", Toast.LENGTH_SHORT).show();
            return;
        }
        String texttimer = in_time.getText().toString();
//        if (texttimer.equals("")) {
//            Toast.makeText(this, "กรุณาตั้งเวลากินยาตอนเช้า", Toast.LENGTH_SHORT).show();
//            return;
//        }
        String texttimernoon = in_timenoon.getText().toString();
//        if (texttimernoon.equals("")) {
//            Toast.makeText(this, "กรุณาตั้งเวลากินยาตอนเที่ยง", Toast.LENGTH_SHORT).show();
//            return;
//        }
        String texttimerevening = in_timeevening.getText().toString();
//        if (texttimerevening.equals("")) {
//            Toast.makeText(this, "กรุณาตั้งเวลากินยาตอนเย็น", Toast.LENGTH_SHORT).show();
//            return;
//        }
        String texttimerbefore = in_timebefore.getText().toString();
//        if (texttimerbefore.equals("")) {
//            Toast.makeText(this, "กรุณาตั้งเวลากินยาก่อนนอน", Toast.LENGTH_SHORT).show();
//            return;
//        }
        Intent t = new Intent(AddOrEditCalendarActivity_Notifications.this, Main_Notifications.class);
        if (id != null) {
            t.putExtra("id", id);
        }

            t.putExtra("textdate", textdate);
            t.putExtra("textdateend", textdateend);
            t.putExtra("texttimer", texttimer);
            t.putExtra("texttimernoon", texttimernoon);
            t.putExtra("texttimerevening", texttimerevening);
            t.putExtra("texttimerbefore", texttimerbefore);

//            t.putExtra("Resultmorning", "MORNING");
//            t.putExtra("Resultnoon", "NOON");

//        t.putExtra("Resultevening", "EVENING");
//        t.putExtra("Resultbefore", "BEFORE");
//        t.putExtra("texttimer", "MORNING");
//        t.putExtra("texttimernoon", "NOON");

        Toast.makeText(this, "ัวันที่เริ่มแจ้งเตือนการกินยา " + textdate + "วันที่สิ้นสุดการแจ้งเตือนการกินยา " + textdateend + "เวลาเช้า " + texttimer + "เวลากลางวัน " + texttimernoon + "เวลาเย็น " + texttimerevening + "เวลาก่อนนอน " + texttimerbefore, Toast.LENGTH_LONG).show();
//        Toast.makeText(this, "วันที่เริ่มต้นประจำเดือน "+textdate  , Toast.LENGTH_LONG).show();

        startActivity(t);

        finish();
    }


    public void onCancel(View view) {

        Intent intent = new Intent(AddOrEditCalendarActivity_Notifications.this, Main_Notifications.class);
        startActivity(intent);
    }

    private void datefindViewsById() {
        start_date = (EditText) findViewById(R.id.startdatedrugs);
        start_date.setInputType(InputType.TYPE_NULL);
        start_date.requestFocus();
    }

    private void datefindViewsByIdEnd() {
        end_date = (EditText) findViewById(R.id.enddatedrugs);
        end_date.setInputType(InputType.TYPE_NULL);
        end_date.requestFocus();
    }

    private void setDateTimeField() {
        start_date.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                start_date.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setDateTimeFieldEnd() {
        end_date.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialogEnd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                end_date.setText(dateFormatterend.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void timefindViewsById() {
        in_time = (EditText) findViewById(R.id.in_time);
        in_time.setInputType(InputType.TYPE_NULL);
        in_time.requestFocus();
    }

    private void timefindViewsByIdnoon() {
        in_timenoon = (EditText) findViewById(R.id.in_timenoon);
        in_timenoon.setInputType(InputType.TYPE_NULL);
        in_timenoon.requestFocus();
    }

    private void timefindViewsByIdevening() {
        in_timeevening = (EditText) findViewById(R.id.in_timeevening);
        in_timeevening.setInputType(InputType.TYPE_NULL);
        in_timeevening.requestFocus();
    }

    private void timefindViewsByIdbefore() {
        in_timebefore = (EditText) findViewById(R.id.in_timebefore);
        in_timebefore.setInputType(InputType.TYPE_NULL);
        in_timebefore.requestFocus();
    }


    @Override
    public void onClick(final View v) {
        if (v == start_date) {
            fromDatePickerDialog.show();
        } else if (v == end_date) {
            fromDatePickerDialogEnd.show();
        }
        if (v == start_date) {
            fromDatePickerDialog.show();
        } else if (v == btn_time || v == in_time || v == in_timenoon || v == in_timeevening || v == in_timebefore) {
// Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            if(v == btn_time || v == in_time){
                                if (hourOfDay < 10 && minute < 10) {
                                    in_time.setText("0" + hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay > 10 && minute < 10) {
                                    in_time.setText(hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay < 10 && minute > 10) {
                                    in_time.setText("0" + hourOfDay + ":" + minute);
                                } else {
                                    in_time.setText(hourOfDay + ":" + minute);
                                }
                            } else if (v == in_timenoon) {
                                if (hourOfDay < 10 && minute < 10) {
                                    in_timenoon.setText("0" + hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay > 10 && minute < 10) {
                                    in_timenoon.setText(hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay < 10 && minute > 10) {
                                    in_timenoon.setText("0" + hourOfDay + ":" + minute);
                                } else {
                                    in_timenoon.setText(hourOfDay + ":" + minute);
                                }
                            } else if (v == in_timeevening) {
                                if (hourOfDay < 10 && minute < 10) {
                                    in_timeevening.setText("0" + hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay > 10 && minute < 10) {
                                    in_timeevening.setText(hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay < 10 && minute > 10) {
                                    in_timeevening.setText("0" + hourOfDay + ":" + minute);
                                } else {
                                    in_timeevening.setText(hourOfDay + ":" + minute);
                                }
                            } else if (v == in_timebefore) {
                                if (hourOfDay < 10 && minute < 10) {
                                    in_timebefore.setText("0" + hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay > 10 && minute < 10) {
                                    in_timebefore.setText(hourOfDay + ":" + "0" + minute);
                                } else if (hourOfDay < 10 && minute > 10) {
                                    in_timebefore.setText("0" + hourOfDay + ":" + minute);
                                } else {
                                    in_timebefore.setText(hourOfDay + ":" + minute);
                                }
                            }



                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

// Get Current Time

    }

    public void onBackPressed() {

        Intent intent1 = new Intent(getApplicationContext(), Main_Notifications.class);
        startActivity(intent1);
        finish();


    }
}
