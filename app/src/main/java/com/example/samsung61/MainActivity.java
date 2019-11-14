package com.example.samsung61;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void solveEquation(View view) {
        // ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);

        if (a == 0) {
            if (b != 0) {
                if (c == 0) {
                    result.setText("" + String.valueOf(0));
                }
                else {
                    result.setText("" + String.valueOf(c * -1 / b));
                }
            }
            else {
                if (c == 0) {
                    result.setText("" + String.valueOf("x ∈ R"));
                }
                else {
                    result.setText("" + String.valueOf("∅"));
                }
            }
        }
        else {
            if (b*b - 4*a*c > 0) {
                result.setText("" + String.valueOf((-b + Math.sqrt(b*b - 4*a*c))/ (2*a) + " " + ((-b - Math.sqrt(b*b - 4*a*c)))/ (2*a)));
            }
            else if (b*b - 4*a*c  == 0) {
                result.setText("" + String.valueOf((-b / 2*a)));
            }
            else if (b*b - 4*a*c < 0) {
                result.setText("" + String.valueOf("∅"));
            }
        }
    }
}