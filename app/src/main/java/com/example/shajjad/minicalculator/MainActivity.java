package com.example.shajjad.minicalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    //Declaring variable

    Button btnClear;
    TextView tvProcessor,tvResult;

    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero;
    String processor;
    Boolean isSmallBracketOpen;
    Button btnMultiply,btnMinus,btnPlus,btnDivide,btnDecimal,btnBackSpace,btnSmallBracket,btnEqual,btnPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variable

        isSmallBracketOpen = false;

        btnClear = findViewById(R.id.buttonDelete);
        tvProcessor = findViewById(R.id.tv_process);
        tvResult = findViewById(R.id.tv_result);

        tvProcessor.setText("");
        tvResult.setText("");

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnZero = findViewById(R.id.buttonZero);

        btnMultiply = findViewById(R.id.buttonMultiplication);
        btnMinus = findViewById(R.id.buttonSubtract);
        btnPlus = findViewById(R.id.buttonAddition);
        btnDivide = findViewById(R.id.buttonDivide);
        btnDecimal = findViewById(R.id.buttonDot);
        btnBackSpace = findViewById(R.id.buttonBack);
        btnSmallBracket = findViewById(R.id.buttonSmallBracket);
        btnEqual = findViewById(R.id.buttonEqual);
        btnPercentage = findViewById(R.id.buttonPercentage);
/**
        number button on-click
 **/
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvProcessor.setText("");
                tvResult.setText("");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "9");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "0");
            }
        });

        /**
         functional button on-click
         **/

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "*");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "-");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "+");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "/");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + ".");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "%");
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();
                if(processor.length()>0){
                    processor = processor.substring(0,processor.length()-1);
                    tvProcessor.setText(processor);
                }
            }
        });

        btnSmallBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSmallBracketOpen) {
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + ")");
                    isSmallBracketOpen = false;
                }
                else {
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + "(");
                    isSmallBracketOpen=true;
                }
            }
        });



        /**
         equal button on-click
         **/

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processor = tvProcessor.getText().toString();

                processor = processor.replaceAll("%","/100");

                org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";
                try{
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope,processor,"JavaScript",1,null).toString();
            }catch (Exception e){
                    result = "Error";
                }
                tvResult.setText(result);
            }
        });

    }
}
