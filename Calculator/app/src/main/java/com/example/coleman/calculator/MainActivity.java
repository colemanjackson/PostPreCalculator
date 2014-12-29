package com.example.coleman.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends Activity implements OnClickListener {
    private Boolean usePostFixParsing = false;
    private Boolean usePreFixParsing = false;
    private Boolean useInFixParsing = true;
    EditText etNum1;
    EditText etNum2;
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    CheckBox prefixCheckbox;
    CheckBox postfixCheckbox;
    TextView tvResult;
    String oper = "";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareScreen();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    public void prepareScreen() {
        //Set variable definitions
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        tvResult = (TextView) findViewById(R.id.tvResult);
        prefixCheckbox = (CheckBox) findViewById(R.id.prefix_checkbox);
        postfixCheckbox = (CheckBox) findViewById(R.id.postfix_checkbox);
        // set a listener
        btnAdd.setOnClickListener((OnClickListener) this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    public void prefixClicked(View v) {
        if (prefixCheckbox.isChecked()) // if the box is click to be checked, meaning prefix notation is going to be used...
        {
            useInFixParsing = false;
            usePostFixParsing = false;
            usePreFixParsing = true;
            if (postfixCheckbox.isChecked()) {
                postfixCheckbox.toggle();
            }
        } else //prefix is being unchecked, set defaults back to infix
        {
            useInFixParsing = true;
            usePostFixParsing = false;
            usePreFixParsing = false;
        }
    }

    public void postfixClicked(View v) {
        if (postfixCheckbox.isChecked()) // if the box is click to be checked, meaning postfix notation is going to be used...
        {
            useInFixParsing = false;
            usePostFixParsing = true;
            usePreFixParsing = false;
            if (prefixCheckbox.isChecked()) {
                prefixCheckbox.toggle();
            }
        } else //postfix is being unchecked, set defaults back to infix
        {
            useInFixParsing = true;
            usePostFixParsing = false;
            usePreFixParsing = false;
        }
    }


    public float infixParser(String evalString) {

        return 0;
    }

    public float prefixParser(String evalString) {
        return 0;
    }

    public float postfixParser(String evalString) {
        return 0;
    }
}