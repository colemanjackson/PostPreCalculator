package com.example.coleman.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
    private Boolean usePostFixParsing = false;
    private Boolean usePreFixParsing = false;
    private Boolean useInFixParsing = true;

    private Button btnAdd, btnSub;
    private Button btnMult, btnDiv;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnCancel;
    private Button btnNine, btnEnter;
    private CheckBox prefixCheckbox, postfixCheckbox;
    private EditText disp;
    private String optr = "";
    private String parseValue = "";
    int op1;
    int op2;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareScreen();
    }

    public void inFixOperation() {
        if (optr.equals("+")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 + op2;
            disp.setText("Result : " + Integer.toString(op1));
        } else if (optr.equals("-")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 - op2;
            disp.setText("Result : " + Integer.toString(op1));
        } else if (optr.equals("*")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 * op2;
            disp.setText("Result : " + Integer.toString(op1));
        } else if (optr.equals("/")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 / op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
    }


    @Override
    public void onClick(View arg0) {
        Editable str = disp.getText();

        if (!usePreFixParsing) {
            inFixCalculator(arg0, str);
        }
    }

    public void inFixCalculator(View arg0, Editable str){
        switch (arg0.getId()) {
            case R.id.btnOne:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnOne.getText());
                disp.setText(str);
                break;
            case R.id.btnTwo:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnTwo.getText());
                disp.setText(str);
                break;
            case R.id.btnThree:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnThree.getText());
                disp.setText(str);
                break;
            case R.id.btnFour:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnFour.getText());
                disp.setText(str);
                break;
            case R.id.btnFive:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnFive.getText());
                disp.setText(str);
                break;
            case R.id.btnSix:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnSix.getText());
                disp.setText(str);
                break;
            case R.id.btnSeven:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnSeven.getText());
                disp.setText(str);
                break;
            case R.id.btnEight:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnEight.getText());
                disp.setText(str);

                break;
            case R.id.btnNine:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(btnNine.getText());
                disp.setText(str);

                break;
            case R.id.cancel:
                op1 = 0;
                op2 = 0;
                disp.setText("");
                disp.setHint("Perform Operation :)");

                break;
            case R.id.btnAdd:
                optr = "+";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 + op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.btnSub:
                optr = "-";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 - op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.btnMult:
                optr = "*";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 * op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.btnDiv:
                optr = "/";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 / op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.btnEnter:
                if (!optr.equals(null)) {
                    if (op2 != 0) {
                        if (optr.equals("+")) {
                            disp.setText("");
                            op1 = op1 + op2;
                            disp.setText("Result : " + Integer.toString(op1));
                        } else if (optr.equals("-")) {
                            disp.setText("");
                            op1 = op1 - op2;
                            disp.setText("Result : " + Integer.toString(op1));
                        } else if (optr.equals("*")) {
                            disp.setText("");
                            op1 = op1 * op2;
                            disp.setText("Result : " + Integer.toString(op1));
                        } else if (optr.equals("/")) {
                            disp.setText("");
                            op1 = op1 / op2;
                            disp.setText("Result : " + Integer.toString(op1));
                        }
                    } else {
                        inFixOperation();
                    }
                }
                break;
        }
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


    public float prefixParser(String evalString) {
        return 0;
    }

    public float postfixParser(String evalString) {
        return 0;
    }

    public void prepareScreen() {
        //Set variable definitions
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        disp = (EditText) findViewById(R.id.tvResult);
        prefixCheckbox = (CheckBox) findViewById(R.id.prefix_checkbox);
        postfixCheckbox = (CheckBox) findViewById(R.id.postfix_checkbox);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnCancel = (Button) findViewById(R.id.cancel);
        // set a listener for all open buttons, since this is pretty easy, we will put them all on the same click listener
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

}
