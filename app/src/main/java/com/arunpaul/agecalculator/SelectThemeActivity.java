package com.arunpaul.agecalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import java.util.Objects;

public class SelectThemeActivity extends BaseActivity {

    Button btnRedtheme, btnPinktheme, btnPurpletheme, btnDeepPurpletheme;
    Button btnIndigotheme, btnBluetheme, btnLightBluetheme, btnCyantheme;
    Button btnTealtheme, btnGreentheme, btnLightGreenheme, btnLimeheme;
    Button btnYellowheme, btnAmberheme, btnOrangeheme, btnDeepOrangeheme;


    AdView adView;
    AdView adView2;
    InterstitialAd fbInterstitialAd;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theme);

        AudienceNetworkAds.initialize(this);


        btnRedtheme = findViewById(R.id.btnRedTheme);
        btnPinktheme = findViewById(R.id.btnPinkTheme);
        btnPurpletheme = findViewById(R.id.btnPurpleTheme);
        btnDeepPurpletheme = findViewById(R.id.btnDeepPurpleTheme);
        btnIndigotheme = findViewById(R.id.btnIndigoTheme);
        btnBluetheme = findViewById(R.id.btnBlueTheme);
        btnLightBluetheme = findViewById(R.id.btnLightBlueTheme);
        btnCyantheme = findViewById(R.id.btnCyanTheme);
        btnTealtheme = findViewById(R.id.btnTealTheme);
        btnGreentheme = findViewById(R.id.btnGreenTheme);
        btnLightGreenheme = findViewById(R.id.btnLightGreenTheme);
        btnLimeheme = findViewById(R.id.btnLimeTheme);
        btnYellowheme = findViewById(R.id.btnYellowTheme);
        btnAmberheme = findViewById(R.id.btnAmberTheme);
        btnOrangeheme = findViewById(R.id.btnOrangeTheme);
        btnDeepOrangeheme = findViewById(R.id.btnDeepOrangeTheme);

        checkCurrentTheme();
        initInterFb();

        btnRedtheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 1);
                recreateActivity();
            }
        });
        btnPinktheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 2);
                recreateActivity();
            }
        });
        btnPurpletheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 3);
                recreateActivity();
            }
        });
        btnDeepPurpletheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 4);
                recreateActivity();
            }
        });
        btnIndigotheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 5);
                recreateActivity();
            }
        });
        btnBluetheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 6);
                recreateActivity();
            }
        });
        btnLightBluetheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 7);
                recreateActivity();
            }
        });
        btnCyantheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 8);
                recreateActivity();
            }
        });
        btnTealtheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 9);
                recreateActivity();
            }
        });
        btnGreentheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 10);
                recreateActivity();
            }
        });
        btnLightGreenheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 11);
                recreateActivity();
            }
        });
        btnLimeheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 12);
                recreateActivity();
            }
        });
        btnYellowheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 13);
                recreateActivity();
            }
        });
        btnAmberheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 14);
                recreateActivity();
            }
        });
        btnOrangeheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 15);
                recreateActivity();
            }
        });
        btnDeepOrangeheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.setTheme(getApplicationContext(), 16);
                recreateActivity();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(" Choose Theme");
        toolbar.setLogo(R.drawable.baseline_palette_white_24);

        adView = new AdView(this, "1260388214352205_1260391261018567", AdSize.BANNER_HEIGHT_50);
        adView2 = new AdView(this, "1260388214352205_1260400331017660", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        LinearLayout adContainer2 = findViewById(R.id.banner_container2);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        adContainer2.addView(adView2);
        // Request an ad

        adView.loadAd();
        adView2.loadAd();

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void checkCurrentTheme() {
        if ((Utility.getTheme(getApplicationContext())) == 1) {
            btnRedtheme.setBackground(getResources().getDrawable(R.drawable.btn_red_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 2) {
            btnPinktheme.setBackground(getResources().getDrawable(R.drawable.btn_pink_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 3) {
            btnPurpletheme.setBackground(getResources().getDrawable(R.drawable.btn_purple_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 4) {
            btnDeepPurpletheme.setBackground(getResources().getDrawable(R.drawable.btn_deeppurple_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 5) {
            btnIndigotheme.setBackground(getResources().getDrawable(R.drawable.btn_indigo_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 6) {
            btnBluetheme.setBackground(getResources().getDrawable(R.drawable.btn_blue_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 7) {
            btnLightBluetheme.setBackground(getResources().getDrawable(R.drawable.btn_lightblue_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 8) {
            btnCyantheme.setBackground(getResources().getDrawable(R.drawable.btn_cyan_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 9) {
            btnTealtheme.setBackground(getResources().getDrawable(R.drawable.btn_teal_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 10) {
            btnGreentheme.setBackground(getResources().getDrawable(R.drawable.btn_green_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 11) {
            btnLightGreenheme.setBackground(getResources().getDrawable(R.drawable.btn_lightgreen_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 12) {
            btnLimeheme.setBackground(getResources().getDrawable(R.drawable.btn_lime_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 13) {
            btnYellowheme.setBackground(getResources().getDrawable(R.drawable.btn_yellow_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 14) {
            btnAmberheme.setBackground(getResources().getDrawable(R.drawable.btn_amber_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 15) {
            btnOrangeheme.setBackground(getResources().getDrawable(R.drawable.btn_orange_check));
        }
        if ((Utility.getTheme(getApplicationContext())) == 16) {
            btnDeepOrangeheme.setBackground(getResources().getDrawable(R.drawable.btn_deeporange_check));
        }
    }

    public void recreateActivity() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private void initInterFb() {
        fbInterstitialAd = new com.facebook.ads.InterstitialAd(this, "1260388214352205_1260401037684256");
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
