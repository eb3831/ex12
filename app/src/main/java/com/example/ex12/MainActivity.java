package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText displayNum;
    double num1, num2;
    double num = 0;
    double result = 0;
    char action = ' ';
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNum = findViewById(R.id.displayNum);
        displayNum.setText("");
    }
    public void calcResult(){
        if (isValidNum(temp)){
            if (action != '=')
            {
                num = Double.parseDouble(displayNum.getText().toString());
            }
            else
            {
                num = 0;
            }
            if (action == '+')
            {
                result = result + num;
            }
            if (action == '-'){
                result = result - num;
            }
            if (action == '*'){
                result = result * num;
            }
            if (action == '/' )
            {
                if (num != 0)
                {
                    result = result / num;
                }
                else
                {
                    Toast.makeText(this, "illegal input", Toast.LENGTH_SHORT).show();
                    result = 0;
                    action = '+';
                }
            }
        }
        else
        {
            Toast.makeText(this, "illegal input", Toast.LENGTH_SHORT).show();
            result = 0;
            num = 0;
            action = '+';
        }
    }

    public boolean isValidNum(String input)
    {
//        return true;
        return !((input.equals("")) ||
                (input.equals("-")) ||
                (input.equals(".")) ||
                (input.equals("+")) ||
                (input.equals("+.")) ||
                (input.equals("-.")));
    }

    public void clickedPlus(View view)
    {
        temp = displayNum.getText().toString();
        if (isValidNum(temp)) {
            if (action == ' ') {
                num1 = Double.parseDouble(temp);
            } else {
                num2 = Double.parseDouble(temp);
                if (action == '+') {
                    num1 = num1 + num2;
                }
            }
            displayNum.setHint(""+num1);
            displayNum.setText("");
            action = '+';
        } else {
            Toast.makeText(this, "Wrong input !", Toast.LENGTH_SHORT).show();
            displayNum.setHint(""+num1);
            displayNum.setText("");
        }
    }

    public void clickedMinus(View view)
    {
        if (!displayNum.getText().toString().isEmpty())
        {
            calcResult();
            displayNum.setText("");
        }
        action = '-';
    }

    public void clickedMulti(View view)
    {
        if (!displayNum.getText().toString().isEmpty())
        {
            calcResult();
            displayNum.setText("");
        }
        action = '*';
    }

    public void clickedDivision(View view) {
        if (!displayNum.getText().toString().isEmpty()) {
            calcResult();
            displayNum.setText("");
        }
        action= '/';
    }

    public void clickedDelete(View view) {
        result = 0;
        num = 0;
        action = '+';
        displayNum.setText("");
    }

    public void clickedSolve(View view) {
        if (!displayNum.getText().toString().isEmpty() || isValidNum(temp)) {
            num = Double.parseDouble(displayNum.getText().toString());
            calcResult();
        }
        else
        {
            Toast.makeText(this, "illegal input", Toast.LENGTH_SHORT).show();
            result = 0;
            num = 0;
            action = '+';
        }
        displayNum.setText(String.valueOf(result));
        action = '=';
    }

    public void clickedCredits(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}