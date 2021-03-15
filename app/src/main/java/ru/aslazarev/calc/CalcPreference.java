package ru.aslazarev.calc;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CalcPreference extends AppCompatActivity {

    public static final String appPrefs = "calc.themes.prefs";
    public static final String savedPrefs = "get.saved.theme.toApp";

    protected static final int ClassicThemeStyle = 0;
    protected static final int WhiteThemeStyle = 1;
    protected static final int DarkThemeStyle = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSavedTheme(getCodeStyle());
    }

    protected int getCodeStyle(){
        SharedPreferences sharedPref = getSharedPreferences(appPrefs, MODE_PRIVATE);
        return sharedPref.getInt(savedPrefs, 0);
    }

    protected void setAppTheme(int themeCode) {
        SharedPreferences sharedPref = getSharedPreferences(appPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(savedPrefs, themeCode);
        editor.apply();
    }

    protected void getSavedTheme(int themeCode){
        switch (themeCode){
            case ClassicThemeStyle:
                setTheme(R.style.AppThemeClassic); break;
            case WhiteThemeStyle:
                setTheme(R.style.WhiteTheme); break;
            case DarkThemeStyle:
                setTheme(R.style.DarkTheme); break;
        }
    }


}
