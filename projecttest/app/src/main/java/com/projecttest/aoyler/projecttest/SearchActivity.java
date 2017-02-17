package com.projecttest.aoyler.projecttest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView button = (ImageView) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.searchTextbox);
                String _val = editText.getText().toString();
                if (_val.equals("")) {
                    Toast.makeText(getApplicationContext(), "กรุณาพิมพ์บทความที่ต้องการค้นหา", Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println("_val: " + _val);

                Bundle bundle = new Bundle();
                bundle.putString("keyword", _val);
                v.getContext().startActivity(new Intent(v.getContext(), FeedArticleActivity.class).putExtras(bundle));
            }
        });
        Button button1 = (Button) findViewById(R.id.button6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.searchTextbox);
                String _val = editText.getText().toString();
                System.out.println("_val: " + _val);

                Bundle bundle = new Bundle();
                bundle.putString("keyword", _val);
                v.getContext().startActivity(new Intent(v.getContext(), FeedArticleActivity.class).putExtras(bundle));
            }
        });

        final ImageView btn2 = (ImageView) findViewById(R.id.calendaricon);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn3 = (ImageView) findViewById(R.id.drugicon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Main_Notifications.class);
                startActivity(intent1);

            }
        });
        final ImageView btn4 = (ImageView) findViewById(R.id.faqicon);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn5 = (ImageView) findViewById(R.id.doctoricon);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchActivity.this);
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
                                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });
        final ImageView btn7 = (ImageView) findViewById(R.id.googlecalendaricon);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchActivity.this);
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
                                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });

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
//        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
        startActivity(intent1);
        finish();
    }
}
