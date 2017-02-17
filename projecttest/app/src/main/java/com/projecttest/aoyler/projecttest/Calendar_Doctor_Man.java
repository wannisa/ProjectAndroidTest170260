package com.projecttest.aoyler.projecttest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;

/**
 * Created by aoyler on 9/12/2559.
 */

public class Calendar_Doctor_Man extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_doctor_man);

//        final Button btn0 = (Button) findViewById(R.id.calendardoctor);
//        // Perform action on click
//        btn0.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                Intent intent = new Intent(Intent.ACTION_INSERT)
//                        .setType("vnd.android.cursor.item/event")
//                        .putExtra("beginTime", cal.getTimeInMillis())
//                        .putExtra("endTime", cal.getTimeInMillis()+30*30*1000)
//                        .putExtra(CalendarContract.Events.TITLE, "นัดคุณหมอ โดยคุณ <ชื่อ> โทร <เบอร์โทร>")
//                        .putExtra(Intent.EXTRA_EMAIL, "pawarisaclinic58@gmail.com");
//                startActivityForResult(Intent.createChooser(intent
//                        , "กรุณาเลือก Google Calendar ซึ่งจะใช้งานได้ดีกับคุณ"), 0);
//            }
//        });

        final Button btn7 = (Button) findViewById(R.id.showcalendardoctor);
        // Perform action on click
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://calendar.google.com/calendar/selfsched?sstoken=UUprMVdIUmVYOGNVfGRlZmF1bHR8NmM5OTk3ZmU3MTljMGUyNWExYWRmMWEzNmM3MGJlODg\n"); // missing 'http://' will cause crashed
                Intent intent7 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent7);
            }
        });

        final Button btn1 = (Button) findViewById(R.id.canceldoctor);
        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MenuHome_Man.class);
                startActivity(intent1);
            }
        });

        final ImageView btn3 = (ImageView) findViewById(R.id.calendaricon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), CalendarShowEvent.class);
                startActivity(intent1);

            }
        });
        final ImageView btn4 = (ImageView) findViewById(R.id.drugicon);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Main_Notifications_Man.class);
                startActivity(intent1);

            }
        });
        final ImageView btn5 = (ImageView) findViewById(R.id.faqicon);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity_Man.class);
                startActivity(intent1);

            }
        });
        final ImageView btn6 = (ImageView) findViewById(R.id.doctoricon);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), Calendar_Doctor_Man.class);
                startActivity(intent6);
            }
        });
    }

}
