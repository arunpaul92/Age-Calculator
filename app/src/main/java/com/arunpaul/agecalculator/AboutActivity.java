package com.arunpaul.agecalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;

import com.facebook.ads.*;

public class AboutActivity extends BaseActivity {
    InterstitialAd fbInterstitialAd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AudienceNetworkAds.initialize(this);
        AdView adView = new AdView(this, "1260388214352205_1261332564257770", AdSize.BANNER_HEIGHT_50);
        AdView adView2 = new AdView(this, "1260388214352205_1261333034257723", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        LinearLayout adContainer2 = findViewById(R.id.banner_container2);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        adContainer2.addView(adView2);
        // Request an ad

        adView.loadAd();
        adView2.loadAd();
        initInterFb();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rateApp:
                String url = "https://play.google.com/store/apps/details?id=com.arunpaul.agecalculator";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            case R.id.privacy:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent intent2 = new Intent(AboutActivity.this, PrivacyPolacyActivaty.class);
                    startActivity(intent2);
                } else {
                    String url2 = "http://techstudio.ml/AgeCalculator/privacy_policy.html";
                    Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                    startActivity(intent2);
                }
                return true;
            case R.id.moreApp:
                String url2 = "https://play.google.com/store/search?q=pub%3A%20Arun%20Paul&c=apps";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent3);
                return true;
            case R.id.shareApp:
                String ShareText = "Hey please check this Age Calculator application. https://play.google.com/store/apps/details?id=com.arunpaul.agecalculator";
                try {
                    Intent intent4 = new Intent("android.intent.action.SEND");
                    intent4.setType("text/plain");
                    intent4.putExtra("android.intent.extra.TEXT", ShareText);
                    AboutActivity.this.startActivity(Intent.createChooser(intent4, "Share via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

        }
        return super.onOptionsItemSelected(item);

    }

    private void initInterFb() {
        fbInterstitialAd = new com.facebook.ads.InterstitialAd(this, "1260388214352205_1261333434257683");
        // Set listeners for the Interstitial Ad
        fbInterstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                fbInterstitialAd.loadAd();
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                finish();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
        fbInterstitialAd.loadAd();
    }

    public void onBackPressed() {
        if (fbInterstitialAd != null && fbInterstitialAd.isAdLoaded()) {
            fbInterstitialAd.show();
        } else {
            super.onBackPressed();
        }
    }
}