package ru.aslazarev.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends CalcPreference {
    private static final String KEY_SCREEN_DATA = "calc.screen.data";
    private CalcScreen screenData;
    TextView screen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);








        screenData = new CalcScreen();
        screen = findViewById(R.id.action_screen);

        MaterialButton buttonOne = findViewById(R.id.buttonOne);
        MaterialButton buttonTwo = findViewById(R.id.buttonTwo);
        MaterialButton buttonThree = findViewById(R.id.buttonThree);
        MaterialButton buttonFour = findViewById(R.id.buttonFour);
        MaterialButton buttonFive = findViewById(R.id.buttonFive);
        MaterialButton buttonSix = findViewById(R.id.buttonSix);
        MaterialButton buttonSeven = findViewById(R.id.buttonSeven);
        MaterialButton buttonEight = findViewById(R.id.buttonEight);
        MaterialButton buttonNine = findViewById(R.id.buttonNine);
        MaterialButton buttonZero = findViewById(R.id.buttonZero);
        MaterialButton buttonPoint = findViewById(R.id.buttonPoint);
        MaterialButton buttonBrackets = findViewById(R.id.buttonBrackets);
        MaterialButton buttonPlus = findViewById(R.id.buttonPlus);
        MaterialButton buttonMinus = findViewById(R.id.buttonMinus);
        MaterialButton buttonX = findViewById(R.id.buttonX);
        MaterialButton buttonSplit = findViewById(R.id.buttonSplit);
        MaterialButton buttonC = findViewById(R.id.buttonC);
        MaterialButton buttonBack = findViewById(R.id.buttonBack);
        MaterialButton buttonEqually = findViewById(R.id.buttonEqually);
        MaterialButton buttonPercent = findViewById(R.id.buttonPercent);
        MaterialButton goToSettings = findViewById(R.id.settings_button);


        goToSettings.setOnClickListener(view ->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });


        buttonOne.setOnClickListener(view -> {
            screen.append(buttonOne.getText());
            screenData.setScreen(screen);
        });

        buttonTwo.setOnClickListener(view -> {
            screen.append(buttonTwo.getText());
            screenData.setScreen(screen);
        });

        buttonThree.setOnClickListener(view -> {
            screen.append(buttonThree.getText());
            screenData.setScreen(screen);
        });

        buttonFour.setOnClickListener(view -> {
            screen.append(buttonFour.getText());
            screenData.setScreen(screen);
        });

        buttonFive.setOnClickListener(view -> {
            screen.append(buttonFive.getText());
            screenData.setScreen(screen);
        });

        buttonSix.setOnClickListener(view -> {
            screen.append(buttonSix.getText());
            screenData.setScreen(screen);
        });

        buttonSeven.setOnClickListener(view -> {
            screen.append(buttonSeven.getText());
            screenData.setScreen(screen);
        });

        buttonEight.setOnClickListener(view -> {
            screen.append(buttonEight.getText());
            screenData.setScreen(screen);
        });

        buttonNine.setOnClickListener(view -> {
            screen.append(buttonNine.getText());
            screenData.setScreen(screen);
        });

        buttonZero.setOnClickListener(view -> {
            screen.append(buttonZero.getText());
            screenData.setScreen(screen);
        });

        buttonPoint.setOnClickListener(view -> {
            screen.append(buttonPoint.getText());
            screenData.setScreen(screen);
        });

        buttonBrackets.setOnClickListener(view -> {
            String Bracket = screen.getText().toString();
            if (Bracket.contains("(")){
                screen.append(")");
            } else {
                screen.append("(");
            }
            screenData.setScreen(screen);
        });

        buttonPlus.setOnClickListener(view -> {
            checkSymbol(buttonPlus, screen);

        });

        buttonMinus.setOnClickListener(view -> {
            checkSymbol(buttonMinus, screen);
        });

        buttonX.setOnClickListener(view -> {
            checkSymbol(buttonX, screen);
        });

        buttonSplit.setOnClickListener(view -> {
            checkSymbol(buttonSplit, screen);
        });

        buttonC.setOnClickListener(view -> {
            screen.setText("");
            screenData.setScreen(screen);
        });

        buttonBack.setOnClickListener(view -> {
            StringBuilder screenString = new StringBuilder(screen.getText());
            if (screenString.length() > 0) {
                screenString.deleteCharAt(screenString.length() - 1);
                screen.setText(screenString.toString());
            }
            screenData.setScreen(screen);
        });

        buttonEqually.setOnClickListener(view -> {
            String expression = screen.getText().toString();
            screen.setText(CalcLogic.getResult(expression));
            screenData.setScreen(screen);
        });


    }

    private void checkSymbol(Button btn, TextView text){
        int backSymbol = text.getText().length() - 1;
        if (text.getText().charAt(backSymbol) != 'x' && text.getText().charAt(backSymbol) != '+'
                && text.getText().charAt(backSymbol) != '/' && text.getText().charAt(backSymbol) != '-'){
            text.append(btn.getText());
        }
        screenData.setScreen(text);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(KEY_SCREEN_DATA, screenData);
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        screenData = instanceState.getParcelable(KEY_SCREEN_DATA);
        screen.setText(screenData.getScreen());
    }


}


