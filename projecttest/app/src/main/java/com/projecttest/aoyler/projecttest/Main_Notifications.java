package com.projecttest.aoyler.projecttest;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import com.google.api.services.calendar.CalendarScopes;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_Notifications extends Activity {

    private static final Level LOGGING_LEVEL = Level.OFF;
    private static final String PREF_ACCOUNT_NAME = "pawarisaclinic58@gmail.com";
    //    static final String TAG = "Main_Notiications";
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 0;
    static final int REQUEST_AUTHORIZATION = 1;
    static final int REQUEST_ACCOUNT_PICKER = 2;
    private final static int ADD_OR_EDIT_CALENDAR_REQUEST = 3;
    final HttpTransport transport = AndroidHttp.newCompatibleTransport();
    final JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    GoogleAccountCredential credential;
    com.google.api.services.calendar.Calendar client;
    int numAsyncTasks;
    Button button;
    Button calendar;
    String idsting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        // enable logging
        Logger.getLogger("com.google.api.client").setLevel(LOGGING_LEVEL);

        // Google AccountsAppSupermarathon
        credential = GoogleAccountCredential.usingOAuth2(this, Collections.singleton(CalendarScopes.CALENDAR));
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        credential.setSelectedAccountName(settings.getString(PREF_ACCOUNT_NAME, null));
        // Calendar client
        client = new com.google.api.services.calendar.Calendar.Builder(
                transport, jsonFactory, credential).setApplicationName("AppSupermarathon")
                .build();

        button = (Button)findViewById(R.id.adddrugs);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startAddOrEditCalendarActivity(null);
            }
        });

        calendar = (Button)findViewById(R.id.calendardrug);
        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
                startActivity(intent1);
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            _Model model = new _Model();
            model.setname("test");

            model.setdate(bundle.getString("textdate"));
            model.settimer(bundle.getString("texttimer"));
            model.settimernoon(bundle.getString("texttimernoon"));
            model.settimerevening(bundle.getString("texttimerevening"));
            model.settimerbefore(bundle.getString("texttimerbefore"));
            model.setdateend(bundle.getString("textdateend"));

//            try {
//                model.setResult(bundle.getString("Resultmorning"));
//                model.setResult(bundle.getString("Resultnoon"));
//                model.setResult(bundle.getString("Resultevening"));
//                model.setResult(bundle.getString("Resultbefore"));
//            } catch (NullPointerException e) {
//
//            }

            if (idsting == null) {
                new AsyncInsertCalendar_Notifications(this,  model).execute();
            } else{
                calendar.setId(Integer.parseInt(idsting));
            }
        }


        final ImageView btn3 = (ImageView) findViewById(R.id.calendaricon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn4 = (ImageView) findViewById(R.id.drugicon);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
                startActivity(intent1);

            }
        });
        final ImageView btn5 = (ImageView) findViewById(R.id.faqicon);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);

            }
        });
        final ImageView btn6 = (ImageView) findViewById(R.id.doctoricon);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main_Notifications.this);
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
                                Intent intent1 = new Intent(getApplicationContext(), Main_Notifications.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });
        final ImageView btn7 = (ImageView) findViewById(R.id.googlecalendaricon);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main_Notifications.this);
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
                                Intent intent1 = new Intent(getApplicationContext(), Main_Notifications.class);
                                startActivity(intent1);
                            }
                        });
                alertDialog.show();
            }
        });
    }
    void showGooglePlayServicesAvailabilityErrorDialog(final int connectionStatusCode) {
        runOnUiThread(new Runnable() {
            public void run() {
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(connectionStatusCode, Main_Notifications.this, REQUEST_GOOGLE_PLAY_SERVICES);
                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (checkGooglePlayServicesAvailable()) {
            haveGooglePlayServices();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        idsting = data.getStringExtra("id");
        switch (requestCode) {
            case REQUEST_GOOGLE_PLAY_SERVICES:
                if (resultCode == Activity.RESULT_OK) {
                    haveGooglePlayServices();
                } else {
                    checkGooglePlayServicesAvailable();
                }
                break;
            case REQUEST_AUTHORIZATION:
                if (resultCode == Activity.RESULT_OK) {

                } else {
                    chooseAccount();
                }
                break;
            case REQUEST_ACCOUNT_PICKER:
                if (resultCode == Activity.RESULT_OK && data != null && data.getExtras() != null) {
                    String accountName = data.getExtras().getString(AccountManager.KEY_ACCOUNT_NAME);
                    if (accountName != null) {
                        credential.setSelectedAccountName(accountName);
                        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString(PREF_ACCOUNT_NAME, accountName);
                        editor.commit();
                    }
                }
//                break;
//            case ADD_OR_EDIT_CALENDAR_REQUEST:
//                if (resultCode == Activity.RESULT_OK) {
//                    _Model model = new _Model();
//                    Calendar calendar = new Calendar();
////                    calendar.setSummary(data.getStringExtra("summary"));
////                    calendar.setLocation(data.getStringExtra("location"));
//                    model.setname(data.getStringExtra("modle"));
//                    model.setname("ปะวิ่ง");
//                    String id = data.getStringExtra("id");
//                    if (id == null) {
//                        new AsyncInsertCalendar(this, calendar, model).execute();
//
//                    } else {
//                        calendar.setId(id);
//                    }
//                }
                break;
        }
    }



    /** Check that Google Play services APK is installed and up to date. */
    private boolean checkGooglePlayServicesAvailable() {
        final int connectionStatusCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (GooglePlayServicesUtil.isUserRecoverableError(connectionStatusCode)) {
            showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
            return false;
        }
        return true;
    }

    private void haveGooglePlayServices() {
        // check if there is already an account selected
        if (credential.getSelectedAccountName() == null) {
            // ask user to choose account
            chooseAccount();
        } else {
            // load calendars
        }
    }

    private void chooseAccount() {
        startActivityForResult(credential.newChooseAccountIntent(), REQUEST_ACCOUNT_PICKER);
    }

    private void startAddOrEditCalendarActivity(CalendarInfo calendarInfo) {
        Intent intent = new Intent(this, AddOrEditCalendarActivity_Notifications.class);
        if (calendarInfo != null) {

            intent.putExtra("id", calendarInfo.id);
            intent.putExtra("summary", calendarInfo.summary);
        }
        startActivityForResult(intent, ADD_OR_EDIT_CALENDAR_REQUEST);
    }

    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(), Menu_Home.class);
        startActivity(intent1);
        finish();
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

}
