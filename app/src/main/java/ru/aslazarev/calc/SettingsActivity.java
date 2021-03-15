package ru.aslazarev.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends CalcPreference {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //initThemeChooser();

        MaterialButton backToMainButton = findViewById(R.id.back_to_main);
        backToMainButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        MaterialRadioButton classic = findViewById(R.id.materialRadioClassic);
        MaterialRadioButton white = findViewById(R.id.materialRadioWhite);
        MaterialRadioButton dark = findViewById(R.id.materialRadioDark);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle())).setChecked(true);
        classic.setOnClickListener(view -> {
            setAppTheme(ClassicThemeStyle);
            recreate();
        });
        white.setOnClickListener(view -> {
            setAppTheme(WhiteThemeStyle);
            recreate();
        });
        dark.setOnClickListener(view -> {
            setAppTheme(DarkThemeStyle);
            recreate();
        });




    }

}