package com.arunpaul.agecalculator;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    EditText etToDay1, etToDay2, etToDay3, etBirth1, etBirth2, etBirth3;
    TextView tvTodayName, tvBirthdayName, tvAgeYears, tvAgeMonths, tvAgeDays, tvTotalYears, tvTotalMonths, tvTotalWeeks, tvTotalDays, tvTotalHours, tvTotalMinutes, tvTotalSeconds, tvMonthsNextBirth, tvDaysNextBirth, tvZodiac;
    TextView tvNextDate1, tvNextDate2, tvNextDate3, tvNextDate4, tvNextDate5, tvNextDate6, tvNextDate7, tvNextDate8, tvNextDate9, tvNextDate10;
    TextView tvNextDay1, tvNextDay2, tvNextDay3, tvNextDay4, tvNextDay5, tvNextDay6, tvNextDay7, tvNextDay8, tvNextDay9, tvNextDay10;
    Button btnCalculate, btnClear;
    String currentMonth, currentDay, currentYear, dayOfWeek;
    int f7277z0 = 0;
    ImageView ivDatePicker1, ivDatePicker2;
    ConstraintLayout layoutUpcoming;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupCurrentDate();

        AudienceNetworkAds.initialize(this);
        AdView adView = new AdView(this, "1260388214352205_1260437877680572", AdSize.BANNER_HEIGHT_50);
        AdView adView2 = new AdView(this, "1260388214352205_1260438071013886", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        LinearLayout adContainer2 = findViewById(R.id.banner_container2);
        adContainer.addView(adView);
        adContainer2.addView(adView2);
        adView.loadAd();
        adView2.loadAd();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //init view
        layoutUpcoming = findViewById(R.id.layout_upcoming);
        layoutUpcoming.setVisibility(View.GONE);
        etToDay1 = findViewById(R.id.today1);
        etToDay2 = findViewById(R.id.today2);
        etToDay3 = findViewById(R.id.today3);
        etBirth1 = findViewById(R.id.birth1);
        etBirth2 = findViewById(R.id.birth2);
        etBirth3 = findViewById(R.id.birth3);
        tvBirthdayName = findViewById(R.id.birth_date_name);
        tvTodayName = findViewById(R.id.today_date_name);
        tvAgeYears = findViewById(R.id.age_years);
        tvAgeMonths = findViewById(R.id.age_months);
        tvAgeDays = findViewById(R.id.age_days);
        tvTotalYears = findViewById(R.id.total_years);
        tvTotalMonths = findViewById(R.id.total_months);
        tvTotalWeeks = findViewById(R.id.total_weeks);
        tvTotalDays = findViewById(R.id.total_days);
        tvTotalHours = findViewById(R.id.total_hours);
        tvTotalMinutes = findViewById(R.id.total_minutes);
        tvTotalSeconds = findViewById(R.id.total_seconds);
        tvZodiac = findViewById(R.id.tv_zodiac);
        tvNextDate1 = findViewById(R.id.tv_NextDate1);
        tvNextDate2 = findViewById(R.id.tv_NextDate2);
        tvNextDate3 = findViewById(R.id.tv_NextDate3);
        tvNextDate4 = findViewById(R.id.tv_NextDate4);
        tvNextDate5 = findViewById(R.id.tv_NextDate5);
        tvNextDate6 = findViewById(R.id.tv_NextDate6);
        tvNextDate7 = findViewById(R.id.tv_NextDate7);
        tvNextDate8 = findViewById(R.id.tv_NextDate8);
        tvNextDate9 = findViewById(R.id.tv_NextDate9);
        tvNextDate10 = findViewById(R.id.tv_NextDate10);
        tvNextDay1 = findViewById(R.id.tv_NextDay1);
        tvNextDay2 = findViewById(R.id.tv_NextDay2);
        tvNextDay3 = findViewById(R.id.tv_NextDay3);
        tvNextDay4 = findViewById(R.id.tv_NextDay4);
        tvNextDay5 = findViewById(R.id.tv_NextDay5);
        tvNextDay6 = findViewById(R.id.tv_NextDay6);
        tvNextDay7 = findViewById(R.id.tv_NextDay7);
        tvNextDay8 = findViewById(R.id.tv_NextDay8);
        tvNextDay9 = findViewById(R.id.tv_NextDay9);
        tvNextDay10 = findViewById(R.id.tv_NextDay10);
        tvDaysNextBirth = findViewById(R.id.days_next_birth);
        tvMonthsNextBirth = findViewById(R.id.months_next_birth);
        ivDatePicker1 = findViewById(R.id.picker_date_button);
        ivDatePicker2 = findViewById(R.id.picker_date_birth_button);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.clear_button);

        ivDatePicker1.setOnClickListener(this);
        ivDatePicker2.setOnClickListener(this);


        etToDay1.setHint("dd");
        etToDay2.setHint("MM");
        etToDay3.setHint("yyyy");

        etToDay1.setText(currentDay);
        etToDay2.setText(currentMonth);
        etToDay3.setText(currentYear);
        tvTodayName.setText(dayOfWeek);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zero = "00";
                etBirth1.setText("");
                etBirth2.setText("");
                etBirth3.setText("");
                tvAgeYears.setText(zero);
                tvAgeMonths.setText(zero);
                tvAgeDays.setText(zero);
                tvDaysNextBirth.setText(zero);
                tvMonthsNextBirth.setText(zero);
                tvZodiac.setText("-");
                tvTotalDays.setText("");
                tvTotalHours.setText("");
                tvTotalMinutes.setText("");
                tvTotalMonths.setText("");
                tvTotalSeconds.setText("");
                tvTotalWeeks.setText("");
                tvTotalYears.setText("");
                layoutUpcoming.setVisibility(View.GONE);
            }
        });


        etToDay1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if ((f7277z0 % 3 == 2 && editable.length() >= 4) || ((f7277z0 % 3 != 2 && editable.length() >= 2) || ((f7277z0 % 3 == 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 1) || (f7277z0 % 3 == 0 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3)))) {
                        findViewById(R.id.today2).requestFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        etToDay2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if (editable.length() >= 2 || ((f7277z0 % 3 == 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3) || (f7277z0 % 3 != 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 1))) {
                        findViewById(R.id.today3).requestFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        etToDay3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if ((f7277z0 % 3 == 2 && editable.length() >= 2) || ((f7277z0 % 3 != 2 && editable.length() >= 4) || (f7277z0 % 3 == 2 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3))) {
                        findViewById(R.id.birth1).requestFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        etBirth1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if ((f7277z0 % 3 == 2 && editable.length() >= 4) || ((f7277z0 % 3 != 2 && editable.length() >= 2) || ((f7277z0 % 3 == 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 1) || (f7277z0 % 3 == 0 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3)))) {
                        findViewById(R.id.birth2).requestFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        etBirth2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if (editable.length() >= 2 || ((f7277z0 % 3 == 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3) || (f7277z0 % 3 != 1 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 1))) {
                        findViewById(R.id.birth3).requestFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        etBirth3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if ((f7277z0 % 3 == 2 && editable.length() >= 2) || ((f7277z0 % 3 != 2 && editable.length() >= 4) || (f7277z0 % 3 == 2 && Integer.parseInt(editable.subSequence(0, 1).toString()) > 3))) {
                        etBirth3.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i1, i2, i3;
                i1 = 0;
                i2 = 0;
                i3 = 0;


                String S1 = etBirth1.getText().toString();
                String S2 = etBirth2.getText().toString();
                String S3 = etBirth3.getText().toString();
                if (!S1.equals("")) {
                    i1 = Integer.parseInt(etBirth1.getText().toString());
                }
                if (!S2.equals("")) {
                    i2 = Integer.parseInt(etBirth2.getText().toString());
                }
                if (!S3.equals("")) {
                    i3 = Integer.parseInt(etBirth3.getText().toString());
                }
                if (S1.isEmpty() || S2.isEmpty() || S3.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Date", Toast.LENGTH_LONG).show();
                } else if (i1 == 0 || i2 == 0 || i3 == 0 || i2 > 12 || i1 > 31) {
                    Toast.makeText(getApplicationContext(), "Enter Valid Date", Toast.LENGTH_LONG).show();
                } else {
                    calculateAge();
                    layoutUpcoming.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void onClick(View view) {
        if (view.getId() == R.id.picker_date_birth_button) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    etBirth1.setText(addZero(dayOfMonth));
                    etBirth2.setText(addZero(monthOfYear + 1));
                    etBirth3.setText(String.valueOf(year));
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (view.getId() == R.id.picker_date_button) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    etToDay1.setText(addZero(dayOfMonth));
                    etToDay2.setText(addZero(monthOfYear + 1));
                    etToDay3.setText(String.valueOf(year));
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public void calculateAge() {
        int currentDay = Integer.parseInt(etToDay1.getText().toString());
        int currentMonth = Integer.parseInt(etToDay2.getText().toString());
        int currentYear = Integer.parseInt(etToDay3.getText().toString());
        int birthDay = Integer.parseInt(etBirth1.getText().toString());
        int birthMonth = Integer.parseInt(etBirth2.getText().toString());
        int birthYear = Integer.parseInt(etBirth3.getText().toString());

        tvZodiac.setText(getZodiac(birthDay, birthMonth));

        int currentMonths = currentMonth - 1;
        int birthMonths = birthMonth - 1;
        Date now = new Date(currentYear, currentMonths, currentDay);
        Date dob = new Date(birthYear, birthMonths, birthDay);

        //calculation next birthday
        Calendar current = Calendar.getInstance();
        current.set(currentYear, currentMonth, currentDay);
        Calendar birthday = Calendar.getInstance();
        birthday.set(birthYear, birthMonth, birthDay);
        long difference = birthday.getTimeInMillis() - current.getTimeInMillis();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(difference);


        if (dob.after(now)) {
            Toast.makeText(getApplicationContext(), "Birthday can't in future", Toast.LENGTH_LONG).show();
            return;
        }
        int month[] = {31, 28, 31, 30, 31, 30, 31,
                31, 30, 31, 30, 31};

        if (birthDay > currentDay) {
            currentDay = currentDay + month[birthMonth - 1];
            currentMonth = currentMonth - 1;
        }

        if (birthMonth > currentMonth) {
            currentYear = currentYear - 1;
            currentMonth = currentMonth + 12;
        }

        // calculate date, month, year
        int calculated_date = currentDay - birthDay;
        int calculated_month = currentMonth - birthMonth;
        int calculated_year = currentYear - birthYear;
        int total_months = (calculated_year * 12) + calculated_month;

        int i4 = 12 - calculated_month;
        if (i4 > 0) {
            int i5 = i4 - 1;
            int actualMaximum2 = new GregorianCalendar(currentYear, currentMonth, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
            int i6 = actualMaximum2 - calculated_date;
            if (i6 == actualMaximum2) {
                i5++;
                i6 = 0;
            }
            String sb4 = " " +
                    i5;
            tvMonthsNextBirth.setText(sb4);

            String sb5 = " " +
                    i6;
            tvDaysNextBirth.setText(sb5);

        }

        tvAgeDays.setText(String.valueOf(calculated_date));
        tvAgeMonths.setText(String.valueOf(calculated_month));
        tvAgeYears.setText(String.valueOf(calculated_year));
        tvTotalYears.setText(String.valueOf(calculated_year));
        tvTotalMonths.setText(String.valueOf(total_months));


        Date date2000 = new Date(2000, 03, 01);
        if (dob.before(date2000)) {
            long dif = now.getTime() - dob.getTime();
            long diff = dif + 86400000;
            int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
            int hours = (int) (diff / (1000 * 60 * 60));
            int minutes = (int) (diff / (1000 * 60));
            int seconds = (int) (hours * 36);
            tvTotalDays.setText(String.valueOf(numOfDays));
            tvTotalHours.setText(String.valueOf(hours));
            tvTotalMinutes.setText(String.valueOf(minutes));
            StringBuilder sbSecond = new StringBuilder();
            sbSecond.append(seconds);
            sbSecond.append("00");
            tvTotalSeconds.setText(sbSecond);
            tvTotalWeeks.setText(String.valueOf(numOfDays / 7));
        } else {
            long diff = now.getTime() - dob.getTime();
            int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
            int hours = (int) (diff / (1000 * 60 * 60));
            int minutes = (int) (diff / (1000 * 60));
            int seconds = (int) (hours * 36);
            tvTotalDays.setText(String.valueOf(numOfDays));
            tvTotalHours.setText(String.valueOf(hours));
            tvTotalMinutes.setText(String.valueOf(minutes));
            StringBuilder sbSecond = new StringBuilder();
            sbSecond.append(seconds);
            sbSecond.append("00");
            tvTotalSeconds.setText(sbSecond);
            tvTotalWeeks.setText(String.valueOf(numOfDays / 7));
        }
        int birthYear1 = currentYear - 1899;
        Date dob1 = new Date(birthYear1, birthMonths, birthDay);
        upComingBirthdays(dob1);
    }


    private void setupCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        currentDay = (addZero(calendar.get(Calendar.DAY_OF_MONTH)));
        currentMonth = (addZero(calendar.get(Calendar.MONTH) + 1));
        currentYear = (String.valueOf(calendar.get(Calendar.YEAR)));

        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
        Date date = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1);
        dayOfWeek = simpledateformat.format(date);
    }

    private void birthDateName(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
        String birthDayName = simpledateformat.format(date);
        tvBirthdayName.setText(birthDayName);
    }


    private String addZero(int number) {
        String n;
        if (number < 10) {
            n = "0" + number;
        } else {
            n = String.valueOf(number);
        }
        return n;
    }

    private void upComingBirthdays(Date date) {

        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            try {
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                instance.add(Calendar.YEAR, i);
                Date date2 = new Date(instance.getTimeInMillis());
                arrayList.add(new SimpleDateFormat("dd MMM yyyy").format(date2));
                arrayList2.add((String) DateFormat.format("EEEE", date2));
            } catch (Exception unused) {
            }
        }
        tvNextDate1.setText((CharSequence) arrayList.get(0));
        tvNextDate2.setText((CharSequence) arrayList.get(1));
        tvNextDate3.setText((CharSequence) arrayList.get(2));
        tvNextDate4.setText((CharSequence) arrayList.get(3));
        tvNextDate5.setText((CharSequence) arrayList.get(4));
        tvNextDate6.setText((CharSequence) arrayList.get(5));
        tvNextDate7.setText((CharSequence) arrayList.get(6));
        tvNextDate8.setText((CharSequence) arrayList.get(7));
        tvNextDate9.setText((CharSequence) arrayList.get(8));
        tvNextDate10.setText((CharSequence) arrayList.get(9));
        tvNextDay1.setText((CharSequence) arrayList2.get(0));
        tvNextDay2.setText((CharSequence) arrayList2.get(1));
        tvNextDay3.setText((CharSequence) arrayList2.get(2));
        tvNextDay4.setText((CharSequence) arrayList2.get(3));
        tvNextDay5.setText((CharSequence) arrayList2.get(4));
        tvNextDay6.setText((CharSequence) arrayList2.get(5));
        tvNextDay7.setText((CharSequence) arrayList2.get(6));
        tvNextDay8.setText((CharSequence) arrayList2.get(7));
        tvNextDay9.setText((CharSequence) arrayList2.get(8));
        tvNextDay10.setText((CharSequence) arrayList2.get(9));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acti_theme:
                Intent intent = new Intent(MainActivity.this, SelectThemeActivity.class);
                startActivity(intent);
                return true;
            case R.id.aboutApp:
                Intent intent2 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent2);
                return true;
            case R.id.rateApp:
                String url = "https://play.google.com/store/apps/details?id=com.arunpaul.agecalculator";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent3);
                return true;
            case R.id.privacy:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent intent4 = new Intent(MainActivity.this, PrivacyPolacyActivaty.class);
                    startActivity(intent4);
                } else {
                    String url2 = "http://techstudio.ml/AgeCalculator/privacy_policy.html";
                    Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                    startActivity(intent4);
                }
                return true;
            case R.id.moreApp:
                String url2 = "https://play.google.com/store/search?q=pub%3A%20Arun%20Paul&c=apps";
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent5);
                return true;
            case R.id.shareApp:
                String ShareText = "Hey please check this Age Calculator application. https://play.google.com/store/apps/details?id=com.arunpaul.agecalculator";
                try {
                    Intent intent4 = new Intent("android.intent.action.SEND");
                    intent4.setType("text/plain");
                    intent4.putExtra("android.intent.extra.TEXT", ShareText);
                    MainActivity.this.startActivity(Intent.createChooser(intent4, "Share via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public static String getZodiac(int i, int i2) {
        return ((i < 21 || i2 != 3) && (i > 19 || i2 != 4)) ? ((i < 20 || i2 != 4) && (i > 20 || i2 != 5)) ? ((i < 21 || i2 != 5) && (i > 20 || i2 != 6)) ? ((i < 21 || i2 != 6) && (i > 22 || i2 != 7)) ? ((i < 23 || i2 != 7) && (i > 22 || i2 != 8)) ? ((i < 23 || i2 != 8) && (i > 22 || i2 != 9)) ? ((i < 23 || i2 != 9) && (i > 22 || i2 != 10)) ? ((i < 23 || i2 != 10) && (i > 21 || i2 != 11)) ? ((i < 22 || i2 != 11) && (i > 21 || i2 != 12)) ? ((i < 22 || i2 != 12) && (i > 19 || i2 != 1)) ? ((i < 20 || i2 != 1) && (i > 18 || i2 != 2)) ? "Pisces" : "Aquarius" : "Capricorn" : "Sagittarius" : "Scorpio" : "Libra" : "Virgo" : "Leo" : "Cancer" : "Gemini" : "Taurus" : "Aries";
    }

}
