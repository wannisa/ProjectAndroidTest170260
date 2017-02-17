package com.projecttest.aoyler.projecttest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FeedArticleActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewExample";
    private List<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private FeedArticleRecyclerAdapter adapter;
    boolean showResult = true;
    String keyword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_article);

        System.out.println("Class FeedPatientActivity");

        Bundle b = getIntent().getExtras();
        keyword = b.getString("keyword");
        System.out.println("Keyword: " + keyword);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        TextView txtView = (TextView) findViewById(R.id.textIntro);
//        progressBar.setVisibility(View.VISIBLE);
        //txtView.setText("ไม่พบข้อมูล");
        //txtView.setVisibility(View.VISIBLE);

//        if (!showResult == false) {
//            //txtView.setText("ไม่พบข้อมูล");
//            progressBar.setVisibility(View.GONE);
//        } else {
//            txtView.setVisibility(View.GONE);
//            progressBar.setVisibility(View.VISIBLE);
//        }

        final String url = "http://pawarisaclinic.azurewebsites.net/api/search.php?key="+keyword;
        new AsyncHttpTask().execute(url);

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
                Intent intent1 = new Intent(getApplicationContext(), Main_Notifications.class);
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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedArticleActivity.this);
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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedArticleActivity.this);
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

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

//        @Override
//        protected void onPreExecute() {
//            setProgressBarIndeterminateVisibility(true);
//        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    parseResult(response.toString());
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                    showResult = false;
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
//            progressBar.setVisibility(View.GONE);
            if (result == 1) {
                adapter = new FeedArticleRecyclerAdapter(FeedArticleActivity.this, feedsList);
                mRecyclerView.setAdapter(adapter);
            }
        }
    }

    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("data");
            feedsList = new ArrayList<>();
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                FeedItem item = new FeedItem();
                item.setID(post.optString("id"));
                item.setTitle(post.optString("title"));
                feedsList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent1);
        finish();
    }
}
