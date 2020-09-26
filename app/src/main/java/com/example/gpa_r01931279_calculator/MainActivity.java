package com.example.gpa_r01931279_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String KEY1="key1";
    private final String KEY2="key2";
    private final String KEY3="key3";

    EditText eT1, eT2, eT3, eT4, eT5;
    TextView result;
    Button button;

    View mV;
    /*View view = findViewById(R.id.mainView);


   // View someView = findViewById(R.id.randomViewInMainLayout);// get Any child View

    // Find the root view
    View root = view.getRootView();

    // Set the color*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT1 = findViewById(R.id.math);
        eT2 = findViewById(R.id.biology);
        eT3 = findViewById(R.id.socialStudies);
        eT4 = findViewById(R.id.physicalEducation);
        eT5 = findViewById(R.id.lunch);

        result = findViewById(R.id.result);

        mV = findViewById(R.id.mainView);
        //view = this.getWindow().getDecorView();

        button = findViewById(R.id.mybutton);
        button.setOnClickListener(mButtonClickListener);


        if (savedInstanceState != null){
            result.setText(savedInstanceState.getString(KEY1));
            button.setText(savedInstanceState.getString(KEY2));
            mV.setBackgroundColor(savedInstanceState.getInt(KEY3));
        }
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (eT1.getText().toString().equals("")|| eT2.getText().toString().equals("") || eT3.getText().toString().equals("") || eT4.getText().toString().equals("") || eT5.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Do not leave grades blank", Toast.LENGTH_LONG).show();
            } else {

                if (button.getText().equals("Compute")) {
                    Double gpa = (Double.parseDouble(eT1.getText().toString()) + Double.parseDouble(eT2.getText().toString()) +
                            Double.parseDouble(eT3.getText().toString()) + Double.parseDouble(eT4.getText().toString()) +
                            Double.parseDouble(eT5.getText().toString())) / 5.00;

                    result.setText(gpa.toString());
                    button.setText("Clear");

                    if (gpa <= 60) {
                        mV.setBackgroundColor(getResources().getColor(R.color.red));
                    } else if (gpa > 60 && gpa < 80) {
                        mV.setBackgroundColor(getResources().getColor(R.color.yellow));
                    } else {
                        mV.setBackgroundColor(getResources().getColor(R.color.green));
                    }

                    Toast.makeText(MainActivity.this, gpa.toString(), Toast.LENGTH_LONG).show();
                } else {
                    mV.setBackgroundColor(getResources().getColor(R.color.white));
                    eT1.getText().clear();
                    eT2.getText().clear();
                    eT3.getText().clear();
                    eT4.getText().clear();
                    eT5.getText().clear();

                    result.setText("");

                    button.setText("Compute");
                }
            }
        }
    };

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY1, result.getText().toString());
        outState.putString(KEY2, button.getText().toString());
        outState.putInt(KEY3, ((ColorDrawable)mV.getBackground()).getColor());
    }


}