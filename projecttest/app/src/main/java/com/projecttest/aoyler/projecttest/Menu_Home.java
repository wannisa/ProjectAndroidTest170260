package com.projecttest.aoyler.projecttest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Menu_Home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_home);
        final Button btn1 = (Button) findViewById(R.id.calendarbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);

//                Intent intent1 = new Intent(getApplicationContext(), AddEvent_MainActivity.class);
//                startActivity(intent1);


                // String packageName = "com.google.android.calendar";
                // startApp(packageName);
               /* Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                Calendar cal = Calendar.getInstance();
                long startTime = cal.getTimeInMillis();
                long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                intent.putExtra(CalendarContract.Events.TITLE, "ประจำเดือน");

                startActivity(intent);*/


//                intent.setType("vnd.android.cursor.item/event");
//               / intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, endTime);
//                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);

//                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, endTime);
//                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
//                intent.putExtra(CalendarContract.Events.TITLE, "ตกไข่");
//                startActivity(intent);
            }
        });

        final Button btn2 = (Button) findViewById(R.id.notificationbutton);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Main_Notifications.class);
                startActivity(intent2);

            }
        });
        final Button btn3 = (Button) findViewById(R.id.faqbutton);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent3);

            }
        });
        final Button btn4 = (Button) findViewById(R.id.doctorbutton);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Uri uri = Uri.parse("https://calendar.google.com/calendar/selfsched?sstoken=UUprMVdIUmVYOGNVfGRlZmF1bHR8NmM5OTk3ZmU3MTljMGUyNWExYWRmMWEzNmM3MGJlODg\n"); // missing 'http://' will cause crashed
//                Intent intent7 = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent7);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Menu_Home.this);
                alertDialog.setMessage("กรุณาใส่ชื่อและเบอร์โทรศัพท์ของท่านตรงช่องคำอธิบาย");
                //alertDialog.setIcon(R.drawable.bgblood);

                alertDialog.setPositiveButton("ตกลง",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse("https://calendar.google.com/calendar/selfsched?sstoken=UUprMVdIUmVYOGNVfGRlZmF1bHR8NmM5OTk3ZmU3MTljMGUyNWExYWRmMWEzNmM3MGJlODg\n"); // missing 'http://' will cause crashed
                                Intent intent7 = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent7);
                            }
                        });
                alertDialog.setNegativeButton("ยกเลิก",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });
        final Button btn5 = (Button) findViewById(R.id.googlecalendar);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Menu_Home.this);
                alertDialog.setMessage("ผู้ใช้สามารถดูปฎิทิน แก้ไข และลบ event ได้");
                //alertDialog.setIcon(R.drawable.bgblood);

                alertDialog.setPositiveButton("ตกลง",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String packageName = "com.google.android.calendar";
                                startApp(packageName);

                            }
                        });
                alertDialog.setNegativeButton("ยกเลิก",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });
        /*final Button btn1 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                startActivity(intent);

            }


        });*/
    }
    public void startApp(String packageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(intent);
        } catch (NullPointerException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(intent);
        }
    }

    public void onBackPressed() {

        Intent intent1 = new Intent(getApplicationContext(), Main_MainActivity.class);
        startActivity(intent1);
        finish();


    }
}
