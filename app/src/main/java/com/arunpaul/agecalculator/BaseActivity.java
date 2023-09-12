package com.arunpaul.agecalculator;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    private final static int THEME_RED = 1;
    private final static int THEME_PINK = 2;
    private final static int THEME_PURPLE = 3;
    private final static int THEME_DEEP_PURPLE = 4;
    private final static int THEME_INDIGO = 5;
    private final static int THEME_BLUE = 6;
    private final static int THEME_LIGHT_BLUE = 7;
    private final static int THEME_CYAN = 8;
    private final static int THEME_TEAL = 9;
    private final static int THEME_GREEN = 10;
    private final static int THEME_LIGHT_GREEN = 11;
    private final static int THEME_LIME = 12;
    private final static int THEME_YELLOW = 13;
    private final static int THEME_AMBER = 14;
    private final static int THEME_ORANGE = 15;
    private final static int THEME_DEEP_ORANGE = 16;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();
    }

    public void updateTheme() {
        if (Utility.getTheme(getApplicationContext()) == THEME_RED) {
            setTheme(R.style.AppTheme_Red);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.RedColorPrimaryDark));

            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_PINK) {
            setTheme(R.style.AppTheme_Pink);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.PinkColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_PURPLE) {
            setTheme(R.style.AppTheme_Purple);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.PurpleColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_DEEP_PURPLE) {
            setTheme(R.style.AppTheme_DeepPurple);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.DeepPurpleColorPrimaryDark));
            }
        }
        else if (Utility.getTheme(getApplicationContext()) == THEME_INDIGO) {
            setTheme(R.style.AppTheme_Indigo);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.IndigoColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_BLUE) {
            setTheme(R.style.AppTheme_Blue);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.BlueColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_LIGHT_BLUE) {
            setTheme(R.style.AppTheme_LightBlue);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.LightBlueColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_CYAN) {
            setTheme(R.style.AppTheme_Cyan);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.CyanColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_TEAL) {
            setTheme(R.style.AppTheme_Teal);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.TealColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_GREEN) {
            setTheme(R.style.AppTheme_Green);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.GreenColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_LIGHT_GREEN) {
            setTheme(R.style.AppTheme_LightGreen);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.LightGreenColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_LIME) {
            setTheme(R.style.AppTheme_Lime);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.LimeColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_YELLOW) {
            setTheme(R.style.AppTheme_Yellow);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.YellowColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_AMBER) {
            setTheme(R.style.AppTheme_Amber);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.AmberColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_ORANGE) {
            setTheme(R.style.AppTheme_Orange);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.OrangeColorPrimaryDark));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_DEEP_ORANGE) {
            setTheme(R.style.AppTheme_DeepOrange);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.DeepOrangeColorPrimaryDark));
            }
        }

    }
}
