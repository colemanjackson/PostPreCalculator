package com.example.coleman.calculator;

import java.util.*;

import android.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.lang.Exception;

public class MainActivity extends Activity implements OnClickListener {
    private static final String TAG = "MainActivity";
    private Boolean usePostFixParsing = false;
    private Boolean usePreFixParsing = false;
    private Boolean useInFixParsing = true;
    public static final String CHARACTER = "\\+|\\-|\\*|\\/";
    //formula for Unsigned Double credit goes to Cate Sheller
    public static final String UNSIGNED_DOUBLE = "((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?";
    private Button btnAdd, btnSub;
    private Button btnMult, btnDiv;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnCancel;
    private Button btnNine, btnEnter;
    private CheckBox prefixCheckbox, postfixCheckbox;
    private EditText disp;
    private String optr = "";
    private String parseValue = "";
    int mainOpOne;
    int mainOpTwo;
    private Stack<Double> preFixStack;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.preFixStack = new Stack<>();
        prepareScreen();
    }

    public void inFixOperation() {
        if (optr.equals("+")) {
            mainOpTwo = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            mainOpOne = mainOpOne + mainOpTwo;
            disp.setText("Result : " + Integer.toString(mainOpOne));
        } else if (optr.equals("-")) {
            mainOpTwo = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            mainOpOne = mainOpOne - mainOpTwo;
            disp.setText("Result : " + Integer.toString(mainOpOne));
        } else if (optr.equals("*")) {
            mainOpTwo = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            mainOpOne = mainOpOne * mainOpTwo;
            disp.setText("Result : " + Integer.toString(mainOpOne));
        } else if (optr.equals("/")) {
            mainOpTwo = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            mainOpOne = mainOpOne / mainOpTwo;
            disp.setText("Result : " + Integer.toString(mainOpOne));
        }
    }


    @Override
    public void onClick(View arg0) {
        Editable str = disp.getText();

        if (!usePreFixParsing) {
            inFixCalculator(arg0, str);
        } else {
            prefixCalculator(arg0, str);
        }

    }

    public void inFixCalculator(View arg0, Editable str) {
        switch (arg0.getId()) {
            case R.id.btnZero:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");

                }
                str = str.append(btnZero.getText());

                disp.setText(str);
            case R.id.btnOne:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;

                    disp.setText("");
                }


                str = str.append(btnOne.getText());
                disp.setText(str);

                break;

            case R.id.btnTwo:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnTwo.getText());
                disp.setText(str);
                break;

            case R.id.btnThree:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnThree.getText());
                disp.setText(str);
                break;

            case R.id.btnFour:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnFour.getText());
                disp.setText(str);
                break;

            case R.id.btnFive:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnFive.getText());
                disp.setText(str);
                break;

            case R.id.btnSix:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnSix.getText());
                disp.setText(str);
                break;

            case R.id.btnSeven:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnSeven.getText());
                disp.setText(str);
                break;

            case R.id.btnEight:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnEight.getText());
                disp.setText(str);

                break;

            case R.id.btnNine:
                if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                }
                str = str.append(btnNine.getText());
                disp.setText(str);

                break;

            case R.id.cancel:
                mainOpOne = 0;
                mainOpTwo = 0;
                disp.setText("");
                disp.setHint("Perform Operation :)");

                break;

            case R.id.btnAdd:
                optr = "+";
                if (mainOpOne == 0) {
                    mainOpOne = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                } else {
                    mainOpTwo = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    mainOpOne = mainOpOne + mainOpTwo;
                    disp.setText("Result : " + Integer.toString(mainOpOne));
                }
                break;

            case R.id.btnSub:
                optr = "-";
                if (mainOpOne == 0) {
                    mainOpOne = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                } else {
                    mainOpTwo = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    mainOpOne = mainOpOne - mainOpTwo;
                    disp.setText("Result : " + Integer.toString(mainOpOne));
                }
                break;

            case R.id.btnMult:
                optr = "*";
                if (mainOpOne == 0) {
                    mainOpOne = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                } else {
                    mainOpTwo = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    mainOpOne = mainOpOne * mainOpTwo;
                    disp.setText("Result : " + Integer.toString(mainOpOne));
                }
                break;

            case R.id.btnDiv:
                optr = "/";
                if (mainOpOne == 0) {
                    mainOpOne = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (mainOpTwo != 0) {
                    mainOpTwo = 0;
                    disp.setText("");
                } else {
                    mainOpTwo = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    mainOpOne = mainOpOne / mainOpTwo;
                    disp.setText("Result : " + Integer.toString(mainOpOne));
                }
                break;

            case R.id.btnEnter:
                if (!optr.equals(null)) {
                    if (mainOpTwo != 0) {
                        if (optr.equals("+")) {
                            disp.setText("");
                            mainOpOne = mainOpOne + mainOpTwo;
                            disp.setText("Result : " + Integer.toString(mainOpOne));
                        } else if (optr.equals("-")) {
                            disp.setText("");
                            mainOpOne = mainOpOne - mainOpTwo;
                            disp.setText("Result : " + Integer.toString(mainOpOne));
                        } else if (optr.equals("*")) {
                            disp.setText("");
                            mainOpOne = mainOpOne * mainOpTwo;
                            disp.setText("Result : " + Integer.toString(mainOpOne));
                        } else if (optr.equals("/")) {
                            disp.setText("");
                            mainOpOne = mainOpOne / mainOpTwo;
                            disp.setText("Result : " + Integer.toString(mainOpOne));
                        }
                    } else {
                        inFixOperation();
                    }
                }
                break;
        }
    }

    public void prefixCalculator(View arg0, Editable str) {
        Log.v(TAG, "prefixOperation(): string currently equals: " + str);

        switch (arg0.getId()) {

            case R.id.btnZero:
                str = str.append(btnZero.getText());
                disp.setText(str);
                break;

            case R.id.btnOne:
                str = str.append(btnOne.getText());
                disp.setText(str);
                break;

            case R.id.btnTwo:
                str = str.append(btnTwo.getText());
                disp.setText(str);
                break;

            case R.id.btnThree:

                str = str.append(btnThree.getText());
                disp.setText(str);
                break;

            case R.id.btnFour:
                str = str.append(btnFour.getText());
                disp.setText(str);
                break;
            case R.id.btnFive:

                str = str.append(btnFive.getText());
                disp.setText(str);
                break;

            case R.id.btnSix:

                str = str.append(btnSix.getText());
                disp.setText(str);
                break;

            case R.id.btnSeven:
                str = str.append(btnSeven.getText());
                disp.setText(str);
                break;

            case R.id.btnEight:
                str = str.append(btnEight.getText());
                disp.setText(str);

                break;

            case R.id.btnNine:
                str = str.append(btnNine.getText());
                disp.setText(str);

                break;

            case R.id.cancel: //stays the same as in other function
                mainOpOne = 0;
                mainOpTwo = 0;
                disp.setText("");
                disp.setHint("Perform Operation :)");

                break;

            case R.id.btnAdd:
                str = str.append(btnAdd.getText());
                disp.setText(str);
                break;

            case R.id.btnSub:
                str = str.append(btnSub.getText());
                disp.setText(str);
                break;

            case R.id.btnMult:
                str = str.append(btnMult.getText());
                disp.setText(str);
                break;

            case R.id.btnDiv:
                str = str.append(btnDiv.getText());
                disp.setText(str);

                break;

            case R.id.btnEnter:
                try {
                    Log.v(TAG, "Attempting to call prefixOperation: Display is: " + disp.getText().toString());
                    prefixOperation(disp.getText().toString());
                    double preFixResult = preFixStack.pop();
                    mainOpOne = 0;
                    mainOpTwo = 0;
                    disp.setText("");
                    disp.setText("Result : " + Double.toString(preFixResult));
                } catch (Exception e) {
                    mainOpOne = 0;
                    mainOpTwo = 0;
                    disp.setText("");
                    disp.setHint("Error in parsing, press C to Clear.");
                }
                break;
        }
    }

    public void prefixOperation(String expression) throws Exception {
        Log.v(TAG, "prefixOperation(): expression:" + expression);

        if (expression.length() == 0) {
            Log.v(TAG, "prefixOperation(): Expression Length is zero. Error.)");
            throw new IllegalArgumentException("Expression is null");
        }

        String expArray[] = expression.split("");
        //create an array by splitting the String on whitespace

        for (int index = (expArray.length - 1); index >= 0; index--) {
            //working from the end of the array forward
            if (expArray[index].matches(UNSIGNED_DOUBLE)) {
                preFixStack.push(new Double(expArray[index]));
                //if the value at expArray[x] is a double, push it to the stack
            }
            if (expArray[index].matches(CHARACTER)) {
                calculatePreFixExpression(expArray[index]);
                //if the value at expArray[x] is an operator, calculate
            }
        }//end for loop
    }


    public void calculatePreFixExpression(String n) throws Exception {
        Log.v(TAG, "calculatePreFixExpression(), n: " + n);

        if (preFixStack.size() < 2)
            throw new IllegalArgumentException("Input expression is invalid");

        Double op1 = preFixStack.pop();
        Double op2 = preFixStack.pop();

        char op = n.charAt(0);
        switch (op) {

            case '+':
                preFixStack.push(op1 + op2);
                break;

            case '-':
                preFixStack.push(op1 - op2);
                break;

            case '*':
                preFixStack.push(op1 * op2);
                break;

            case '/':
                preFixStack.push(op1 / op2);
                break;

            default:
                throw new IllegalArgumentException("Something went wrong in parsing");

        }
    }

    public void prefixClicked(View v) {
        if (prefixCheckbox.isChecked()) // if the box is click to be checked, meaning prefix notation is going to be used...
        {
            useInFixParsing = false;
            usePostFixParsing = false;
            usePreFixParsing = true;

        } else //prefix is being unchecked, set defaults back to infix
        {
            useInFixParsing = true;
            usePostFixParsing = false;
            usePreFixParsing = false;
        }
    }

    public void prepareScreen() {
        //Set variable definitions
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        disp = (EditText) findViewById(R.id.tvResult);
        prefixCheckbox = (CheckBox) findViewById(R.id.prefix_checkbox);
        btnZero = (Button) findViewById(R.id.btnZero);
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
        btnZero.setOnClickListener(this);
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