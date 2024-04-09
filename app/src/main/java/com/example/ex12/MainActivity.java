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
    char action = ' ';
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayNum = findViewById(R.id.displayNum);
        displayNum.setText("");
    }

    public void wrongInput()
    {
        Toast.makeText(this, "illegal action!", Toast.LENGTH_SHORT).show();
        displayNum.setHint(""+num1);
        displayNum.setText("");
    }

    public double doCalc(char action, double num1, double num2)
    {
        switch (action)
        {
            case '+':
                num1 = num1 + num2;
                break;
            case '-':
                num1 = num1 - num2;
                break;
            case '/':
                if (num2 == 0)
                {
                    wrongInput();
                }
                else
                    num1 = num1 / num2;
                break;
            case '*':
                num1 = num1 * num2;
                break;
        }
        return num1;
    }

    public boolean isValidNum(String input)
    {
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
        if (isValidNum(temp))
        {
            if (action == ' ')
            {
                num1 = Double.parseDouble(temp);
            }
            else
            {
                num2 = Double.parseDouble(temp);
                num1 = doCalc(action, num1, num2);
            }
            displayNum.setHint(""+num1);
            displayNum.setText("");
            action = '+';
        }
        else
        {
            wrongInput();
        }
    }

    public void clickedMinus(View view)
    {
        temp = displayNum.getText().toString();
        if (isValidNum(temp))
        {
            if (action == ' ')
            {
                num1 = Double.parseDouble(temp);
            }
            else
            {
                num2 = Double.parseDouble(temp);
                num1 = doCalc(action, num1, num2);
            }
            displayNum.setHint(""+num1);
            displayNum.setText("");
            action = '-';
        }
        else
        {
            wrongInput();
        }
    }

    public void clickedMulti(View view)
    {
        temp = displayNum.getText().toString();
        if (isValidNum(temp))
        {
            if (action == ' ')
            {
                num1 = Double.parseDouble(temp);
            }
            else
            {
                num2 = Double.parseDouble(temp);
                num1 = doCalc(action, num1, num2);
            }
            displayNum.setHint(""+num1);
            displayNum.setText("");
            action = '*';
        }
        else
        {
            wrongInput();
        }
    }

    public void clickedDivision(View view)
        {
            temp = displayNum.getText().toString();
            if (isValidNum(temp))
            {
                if (action == ' ')
                {
                    num1 = Double.parseDouble(temp);
                }
                else
                {
                    num2 = Double.parseDouble(temp);
                    num1 = doCalc(action, num1, num2);
                }
                displayNum.setHint(""+num1);
                displayNum.setText("");
                action = '/';
            }
            else
            {
                wrongInput();
            }
        }

    public void clickedSolve(View view) {
        temp = displayNum.getText().toString();
        if (isValidNum(temp))
        {
            if (action == ' ')
            {
                num1 = Double.parseDouble(temp);
            }
            else
            {
                num2 = Double.parseDouble(temp);
                num1 = doCalc(action, num1, num2);
            }
            displayNum.setHint("");
            displayNum.setText(""+num1);
            action = ' ';
        }
        else
        {
            Toast.makeText(this, "illegal action!", Toast.LENGTH_SHORT).show();
            displayNum.setHint(""+num1);
            displayNum.setText("");
        }
    }

    public void clickedDelete(View view) {
        num1 = 0;
        action = ' ';
        displayNum.setHint("");
        displayNum.setText("");
    }

    public void clickedCredits(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(num1));
        startActivity(intent);
    }
}