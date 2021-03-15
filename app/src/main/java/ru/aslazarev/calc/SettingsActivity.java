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
        initThemeChooser();

        MaterialButton backToMainButton = findViewById(R.id.back_to_main);
        backToMainButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.materialRadioClassic),ClassicThemeStyle);
        initRadioButton(findViewById(R.id.materialRadioDark), DarkThemeStyle);
        initRadioButton(findViewById(R.id.materialRadioWhite),WhiteThemeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(ClassicThemeStyle))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(view -> {
                setAppTheme(codeStyle);
                recreate();
        });
    }

}