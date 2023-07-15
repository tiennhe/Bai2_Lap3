package com.example.bai2_lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1  , btn2 ;
    TextView txthienthi ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btnArrRequest);
        btn2 = findViewById(R.id.btnObjRequest);
        txthienthi = findViewById(R.id.txtResponse);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppControler appControler = new AppControler();
                appControler.getStringVolley(MainActivity.this , txthienthi);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppControler appControler = new AppControler();
                appControler.getStringObject(MainActivity.this , txthienthi);
            }
        });
    }
}