package com.example.josephbaca.linearregression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText x_text, y_text, print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegressionLine = (Button) findViewById(R.id.btnRegressionLine);
        Button btnSSE = (Button) findViewById(R.id.btnSSE);
        Button btnADD = (Button) findViewById(R.id.btnADD);
        Button btnSubtract = (Button) findViewById(R.id.btnSubtract);
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnDivide = (Button) findViewById(R.id.btnDivide);

         x_text = (EditText) findViewById(R.id.x_text);
         y_text = (EditText) findViewById(R.id.y_text);

         print = (EditText) findViewById(R.id.print);




        btnADD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // If there is no text in the Text fields, print "Please enter details."
                if(x_text.getText().toString().equals("")||y_text.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter details", Toast.LENGTH_SHORT).show();
                }

                else{
                    x_text.getText().toString();
                    y_text.getText().toString();

                try {

                    double x = Double.valueOf(x_text.getText().toString());
                    double y = Double.valueOf(y_text.getText().toString());
                    double answer = x + y;
                    print.setText(String.valueOf(answer));

                }catch(Exception e){
                    print.setText("Error!");
                    }

                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // If there is no text in the Text fields, print "Please enter details."
                if(x_text.getText().toString().equals("")||y_text.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter details", Toast.LENGTH_SHORT).show();
                }

                else{
                    x_text.getText().toString();
                    y_text.getText().toString();

                    try {

                        double x = Double.valueOf(x_text.getText().toString());
                        double y = Double.valueOf(y_text.getText().toString());
                        double answer = x - y;
                        print.setText(String.valueOf(answer));

                    }catch(Exception e){
                        print.setText("Error!");
                    }

                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // If there is no text in the Text fields, print "Please enter details."
                if(x_text.getText().toString().equals("")||y_text.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter details", Toast.LENGTH_SHORT).show();
                }

                else{
                    x_text.getText().toString();
                    y_text.getText().toString();

                    try {

                        double x = Double.valueOf(x_text.getText().toString());
                        double y = Double.valueOf(y_text.getText().toString());
                        double answer = x * y;
                        print.setText(String.valueOf(answer));

                    }catch(Exception e){
                        print.setText("Error!");
                    }

                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // If there is no text in the Text fields, print "Please enter details."
                if(x_text.getText().toString().equals("")||y_text.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter details", Toast.LENGTH_SHORT).show();
                }

                else{
                    x_text.getText().toString();
                    y_text.getText().toString();

                    try {

                        double x = Double.valueOf(x_text.getText().toString());
                        double y = Double.valueOf(y_text.getText().toString());
                        double answer = x / y;
                        print.setText(String.valueOf(answer));

                    }catch(Exception e){
                        print.setText("Error!");
                    }

                }
            }
        });

        btnRegressionLine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View V) {
                if (x_text.getText().toString().equals("") || y_text.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter details", Toast.LENGTH_SHORT).show();
                }
                else {
                //Getting the text from x, y and making them into int arrays; x,y;
                    String xStr = x_text.getText().toString();
                    String yStr = y_text.getText().toString();

                    String[] parseX = xStr.split(", ");
                    String[] parseY = yStr.split(", ");

                    int[] x = new int[parseX.length];
                    int[] y = new int[parseY.length];


                    for(int i =0; i<parseX.length; i++) {
                        x[i] = Integer.parseInt(parseX[i]);
                        y[i] = Integer.parseInt(parseY[i]);
                        }


                    int n = x.length;
                    double sumsOfy = 0;
                    double sumsOfxPow2 = 0;
                    double sumsOfx = 0;
                    double sumsOfXbyY = 0;
                    double nBysumsOfxPow2 = 0;
                    double sumsOfAllxSquared = 0;
                    double nBysumsOfxy = 0;
                    double sumsOfxBySumsOfy = 0;

                    double b = 0;
                    double a = 0;

                    //calculating summation of the variables.
                    for (int i = 0; i < y.length; i++) {

                        sumsOfy += y[i];
                        sumsOfxPow2 += Math.pow(x[i], 2);
                        sumsOfx += x[i];
                        sumsOfXbyY += x[i] * y[i];

                    }
                    nBysumsOfxPow2 = n * (sumsOfxPow2);
                    sumsOfAllxSquared = Math.pow(sumsOfx, 2);
                    nBysumsOfxy = n * (sumsOfXbyY);
                    sumsOfxBySumsOfy = (sumsOfx * sumsOfy);

                    b = (nBysumsOfxy - sumsOfxBySumsOfy) / (nBysumsOfxPow2 - sumsOfAllxSquared);
                    a = (sumsOfy / y.length) - (b * (sumsOfx / x.length));

                    print.setText("y(x) = " + b + "x" + " + " + a);

                }
            }
        });

    }
}
