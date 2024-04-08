package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double num = 0;
    double result = 0;
    String action = "+";
    EditText displayNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNum = findViewById(R.id.displayNum);
    }
    public void calcResult(){
        if (isValidNum()){
            if (action != "=")
            {
                num = Double.parseDouble(displayNum.getText().toString());
            }
            else
            {
                num = 0;
            }
            if (action == "+")
            {
                result = result + num;
            }
            if (action == "-"){
                result = result - num;
            }
            if (action == "*"){
                result = result * num;
            }
            if (action == "/" )
            {
                if (num != 0)
                {
                    result = result / num;
                }
                else
                {
                    Toast.makeText(this, "illegal input", Toast.LENGTH_SHORT).show();
                    result = 0;
                    action = "+";
                }
            }
        }
        else
        {
            Toast.makeText(this, "illegal input", Toast.LENGTH_SHORT).show();
            result = 0;
            num = 0;
            action = "+";
        }
    }

    public boolean isValidNum()
    {
        String input = displayNum.getText().toString();

        return !((input == "") ||
                (input == "-") ||
                (input == ".") ||
                (input == "+") ||
                (input == "-."));
    }

    public void clickedPlus(View view)
    {
        if (!displayNum.getText().toString().isEmpty())
        {
            calcResult();
            displayNum.setText("");
        }
        action="+";
    }

    public void clickedMinus(View view)
    {
        if (!displayNum.getText().toString().isEmpty())
        {
            calcResult();
            displayNum.setText("");
        }
        action = "-";
    }

    public void clickedMulti(View view)
    {
        if (!displayNum.getText().toString().isEmpty())
        {
            calcResult();
            displayNum.setText("");
        }
        action = "*";
    }

    public void clickedDivision(View view) {
        if (!displayNum.getText().toString().isEmpty()) {
            calcResult();
            displayNum.setText("");
        }
        action= "/";
    }

    public void clickedDelete(View view) {
        result = 0;
        num = 0;
        action = "+";
        displayNum.setText("");
    }

    public void clickedSolve(View view) {
        if (!displayNum.getText().toString().isEmpty()) {
            num = Double.parseDouble(displayNum.getText().toString());
            calcResult();
        }
        displayNum.setText(String.valueOf(result));
        action = "=";
    }

    public void clickedCredits(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}