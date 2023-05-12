package com.example.labprogramtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
// use less line

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bP, bMi, bMu, bD, bEq, bAC;
    Button back, decimal,plusMinus;
    TextView result;
    static boolean add = false, sub = false, mul = false, div = false;
    float num1 = 0;
    float num2 = 0;
    int count=0;
    int count2=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------findings-----------------//
        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);

        bP = findViewById(R.id.btnPlus);
        bMi = findViewById(R.id.btnMinus);
        bMu = findViewById(R.id.btnMul);
        bD = findViewById(R.id.btnDiv);
        bEq = findViewById(R.id.btnEq);
        bAC = findViewById(R.id.btnAc);

        back = findViewById(R.id.back);
        decimal = findViewById(R.id.decimal);
        plusMinus=findViewById(R.id.plusMinus);

        result = findViewById(R.id.result);
        //--------------------------//
        //------numerical buttons----//
        {
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + ".");
            }
        });
    }
        //------Arithmetic operations-----//
        //----add----//
        bP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else{
                    if(count2==0) {
                        num1 = Float.parseFloat(result.getText() + "");
                        count2++;
                        result.setText("");
                        add = true;
                    }else{
                        num2 = Float.parseFloat(result.getText() + "");
                        count2--;
                        add=true;
                        setResult(num1,num2);
                    }
                }
            }
        });

        //----subtract----//
        bMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else{
                    if(count2==0) {
                        num1 = Float.parseFloat(result.getText() + "");
                        result.setText("");
                        count2++;
                        sub = true;
                    }else {
                        num2 = Float.parseFloat(result.getText() + "");
                        count2--;
                        sub = true;
                        setResult(num1,num2);
                    }
                }
            }
        });
        //----Multiply----//
        bMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else{
                    if(count2==0) {
                        num1 = Float.parseFloat(result.getText() + "");
                        result.setText("");
                        count2++;
                        mul = true;
                    }else{
                        num2 = Float.parseFloat(result.getText() + "");
                        count2--;
                        add=true;
                        setResult(num1,num2);
                    }
                }
            }
        });
        //----Divide----//
        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else{
                    if(count2==0) {
                        num1 = Float.parseFloat(result.getText() + "");
                        result.setText("");
                        div = true;
                        count2++;
                    }
                    else {
                        num2 = Float.parseFloat(result.getText() + "");
                        count2--;
                        add=true;
                        setResult(num1,num2);
                    }
                }
            }
        });
//-------------minus button--------//
        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString().equals("")){
                    result.setText("");
                }
                else {
                    if(count<=0&&result.getText().toString().charAt(0)!='-') {
                        result.setText("-" + result.getText().toString());
                        count++;
                    }
                }
            }
        });
        //---------equals-to-button----//
        bEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else {
                    num2=Float.parseFloat(result.getText()+"");
                    setResult(num1,num2);
                }
            }
        });

        //----all clear----//
        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                num1=0;
                num2=0;
            }
        });

        //----clear/back----//
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().equals("")){
                    result.setText("");
                }else
                {
                    String sub=result.getText().toString().substring(0,result.getText().toString().length()-1);
                    result.setText(sub);
                }
            }
        });

    }

    private void setResult(float num1, float num2) {
        if(add){
            float sum=num1+num2;
            count--;
            add=false;
            result.setText(sum+"");
        }
        if(sub){
            float sum=num1-num2;
            count--;
            sub=false;
            result.setText(sum+"");
        }
        if(mul){
            float sum=num1*num2;
            count--;
            mul=false;
            result.setText(sum+"");
        }
        if(div){
            if(num2==0) {
                Toast.makeText(this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
            }
            else{
                float sum = num1 / num2;
                count--;
                div = false;
                result.setText(sum + "");
            }
        }
    }
}
