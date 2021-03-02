package ru.aslazarev.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView screen = findViewById(R.id.action_screen);

        Button buttonOne = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        Button buttonThree = findViewById(R.id.buttonThree);
        Button buttonFour = findViewById(R.id.buttonFour);
        Button buttonFive = findViewById(R.id.buttonFive);
        Button buttonSix = findViewById(R.id.buttonSix);
        Button buttonSeven = findViewById(R.id.buttonSeven);
        Button buttonEight = findViewById(R.id.buttonEight);
        Button buttonNine = findViewById(R.id.buttonNine);
        Button buttonZero = findViewById(R.id.buttonZero);
        Button buttonPoint = findViewById(R.id.buttonPoint);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonX = findViewById(R.id.buttonX);
        Button buttonSplit = findViewById(R.id.buttonSplit);

        Button buttonC = findViewById(R.id.buttonC);
        Button buttonBack = findViewById(R.id.buttonBack);


        buttonOne.setOnClickListener(view -> {
            screen.append(buttonOne.getText());
        });

        buttonTwo.setOnClickListener(view -> {
            screen.append(buttonTwo.getText());
        });

        buttonThree.setOnClickListener(view -> {
            screen.append(buttonThree.getText());
        });

        buttonFour.setOnClickListener(view -> {
            screen.append(buttonFour.getText());
        });

        buttonFive.setOnClickListener(view -> {
            screen.append(buttonFive.getText());
        });

        buttonSix.setOnClickListener(view -> {
            screen.append(buttonSix.getText());
        });

        buttonSeven.setOnClickListener(view -> {
            screen.append(buttonSeven.getText());
        });

        buttonEight.setOnClickListener(view -> {
            screen.append(buttonEight.getText());
        });

        buttonNine.setOnClickListener(view -> {
            screen.append(buttonNine.getText());
        });

        buttonZero.setOnClickListener(view -> {
            screen.append(buttonZero.getText());
        });

        buttonPoint.setOnClickListener(view -> {
            screen.append(buttonPoint.getText());
        });

        buttonPlus.setOnClickListener(view -> {
            screen.append(buttonPlus.getText());
        });

        buttonMinus.setOnClickListener(view -> {
            screen.append(buttonMinus.getText());
        });

        buttonX.setOnClickListener(view -> {
            screen.append(buttonX.getText());
        });

        buttonSplit.setOnClickListener(view -> {
            screen.append(buttonSplit.getText());
        });

        buttonC.setOnClickListener(view -> {
            screen.setText("");
        });

        buttonBack.setOnClickListener(view -> {
            StringBuilder screenString = new StringBuilder(screen.getText());
            screenString.deleteCharAt(screenString.length() - 1);
            screen.setText(screenString.toString());
        });
    }
}

