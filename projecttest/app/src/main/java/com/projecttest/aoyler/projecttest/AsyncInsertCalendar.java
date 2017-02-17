package com.projecttest.aoyler.projecttest;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public class AsyncInsertCalendar extends CalendarAsyncTask {


    //    private final Calendar entry;
    _Model name;

    public AsyncInsertCalendar(MainActivity calendarSample, _Model name) {
        super(calendarSample);
//        this.entry = entry;
        this.name = name;

    }


    @Override
    protected void doInBackground() throws IOException {

        String result = name.getResult();
        try {
            if(result.equals("END")){
                EndDate();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            StartDate();
            StartDate1();
            StartDate2();
            StartDate3();
            StartDate4();
            StartDate5();
            StartDate6();
        }



}


    String startdate = "เริ่มต้นประจำเดือน";

    public void StartDate() throws IOException {
        Event Start_Date = new Event()
                .setSummary(startdate)
                .setDescription("วันเริ่มต้นประจำเดือน");

        String date = name.getdate();
//        String timer = name.gettimer();
//        String t = "T";
//        String a = date+t+timer;
        String startdate = date;
        DateTime startDate = new DateTime(startdate);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setStart(start);

        DateTime endDate = new DateTime(startdate);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setEnd(end);
//        String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"}; //วนวันเดิม2ครั้ง
//        Start_Date.setRecurrence(Arrays.asList(recurrence));

//        EventAttendee[] attendees = new EventAttendee[] { //เชิญEmailอื่น
//                new EventAttendee().setEmail("pawarisaclinic58@gmail.com"),
////                new EventAttendee().setEmail("sbrin@example.com"),
//        };
//        Start_Date.setAttendees(Arrays.asList(attendees));

//        EventReminder[] reminderOverrides = new EventReminder[] {
//                new EventReminder().setMethod("email").setMinutes(24 * 60),
//                new EventReminder().setMethod("popup").setMinutes(10),
//        };
//        Event.Reminders reminders = new Event.Reminders()
//                .setUseDefault(false)
//                .setOverrides(Arrays.asList(reminderOverrides));
//        Start_Date.setReminders(reminders);

        Event createdEvent = client.events().insert("primary", Start_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String enddate = "สิ้นสุดประจำเดือน";


    public void EndDate() throws IOException {

        Event End_Date = new Event()
                .setSummary(enddate)
                .setDescription("วันสิ้นสุดประจำเดือน");

        String date = name.getdateend();
//        String timer = name.gettimer();

//        String a = date+t+timer;
        String enddate = date;
        DateTime startDate = new DateTime(enddate);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        End_Date.setStart(start);
        DateTime endDate = new DateTime(enddate);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        End_Date.setEnd(end);

        Event createdEvent = client.events().insert("primary", End_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate1 = "วันไข่ตกและทดสอบการตกไข่";
    public void StartDate1() throws IOException {
        Event Start_Date = new Event()
                .setSummary(startdate1)
                .setDescription("วันไข่ตกและทดสอบการตกไข่");

        String date = name.getdate();

        /*********************************************/


        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 11);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

        /*********************************************/

//        String timer = name.gettimer();
//        String a = date+t+timer;
        String startdate1 = date;
        DateTime startDate = new DateTime(startdate1);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setStart(start);

        DateTime endDate = new DateTime(startdate1);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setEnd(end);
//        String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"}; //วนวันเดิม2ครั้ง
//        Start_Date.setRecurrence(Arrays.asList(recurrence));

//        EventAttendee[] attendees = new EventAttendee[] { //เชิญEmailอื่น
//                new EventAttendee().setEmail("pawarisaclinic58@gmail.com"),
////                new EventAttendee().setEmail("sbrin@example.com"),
//        };
//        Start_Date.setAttendees(Arrays.asList(attendees));

//        EventReminder[] reminderOverrides = new EventReminder[] {
//                new EventReminder().setMethod("email").setMinutes(24 * 60),
//                new EventReminder().setMethod("popup").setMinutes(10),
//        };
//        Event.Reminders reminders = new Event.Reminders()
//                .setUseDefault(false)
//                .setOverrides(Arrays.asList(reminderOverrides));
//        Start_Date.setReminders(reminders);

        Event createdEvent = client.events().insert("primary", Start_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate2 = "วันไข่ตกและทดสอบการตกไข่";
    public void StartDate2() throws IOException {
        Event Start_Date2 = new Event()
                .setSummary(startdate2)
                .setDescription("วันไข่ตกและทดสอบการตกไข่");

        String date = name.getdate();

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 13);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date


        String startdate2 = date;
        DateTime startDate = new DateTime(startdate2);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date2.setStart(start);

        DateTime endDate = new DateTime(startdate2);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date2.setEnd(end);

        Event createdEvent = client.events().insert("primary", Start_Date2).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate3 = "วันไข่ตกและทดสอบการตกไข่";
    public void StartDate3() throws IOException {
        Event Start_Date3 = new Event()
                .setSummary(startdate3)
                .setDescription("วันไข่ตกและทดสอบการตกไข่");

        String date = name.getdate();

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 15);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

        String startdate3 = date;
        DateTime startDate = new DateTime(startdate3);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date3.setStart(start);

        DateTime endDate = new DateTime(startdate3);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date3.setEnd(end);

        Event createdEvent = client.events().insert("primary", Start_Date3).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate4 = "ทดสอบการตกไข่";
    public void StartDate4() throws IOException {
        Event Start_Date4 = new Event()
                .setSummary(startdate4)
                .setDescription("ทดสอบการตกไข่");

        String date = name.getdate();

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 10);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

        String startdate4 = date;
        DateTime startDate = new DateTime(startdate4);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date4.setStart(start);

        DateTime endDate = new DateTime(startdate4);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date4.setEnd(end);

        Event createdEvent = client.events().insert("primary", Start_Date4).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate5 = "ทดสอบการตกไข่";
    public void StartDate5() throws IOException {
        Event Start_Date5 = new Event()
                .setSummary(startdate5)
                .setDescription("ทดสอบการตกไข่");

        String date = name.getdate();

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 12);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

        String startdate5 = date;
        DateTime startDate = new DateTime(startdate5);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date5.setStart(start);

        DateTime endDate = new DateTime(startdate5);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date5.setEnd(end);

        Event createdEvent = client.events().insert("primary", Start_Date5).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate6 = "ทดสอบการตกไข่";
    public void StartDate6() throws IOException {
        Event Start_Date6 = new Event()
                .setSummary(startdate6)
                .setDescription("ทดสอบการตกไข่");

        String date = name.getdate();

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 14);;// number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

//        String t = "T";
//        String startdate6 = date + t;
//        DateTime startDateTime = new DateTime(startdate6 + "23:58:00+07:00");
//        EventDateTime start = new EventDateTime()
//                .setDateTime(startDateTime)
//                .setTimeZone("Asia/Bangkok");
//        Start_Date6.setStart(start);
//
//        DateTime endDateTime = new DateTime(startdate6 + "23:58:00+07:00");
//        EventDateTime end = new EventDateTime()
//                .setDateTime(endDateTime)
//                .setTimeZone("Asia/Bangkok");
//        Start_Date6.setEnd(end);
//                String t = "T";
        String startdate6 = date;
        DateTime startDate = new DateTime(startdate6);
        EventDateTime start = new EventDateTime()
                .setDate(startDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date6.setStart(start);

        DateTime endDate = new DateTime(startdate6);
        EventDateTime end = new EventDateTime()
                .setDate(endDate)
                .setTimeZone("Asia/Bangkok");
        Start_Date6.setEnd(end);

        Event createdEvent = client.events().insert("primary", Start_Date6).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

}



