package com.example.app_bar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        ImageView left=findViewById(R.id.left_icon);
        ImageView right=findViewById(R.id.right_icon);
        TextView txt=findViewById(R.id.toolbar);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"you clicked menu",Toast.LENGTH_SHORT).show();
            }
        });

       right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"you clicked share button",Toast.LENGTH_SHORT).show();

                Intent sendd=new Intent();
                sendd.setAction(Intent.ACTION_SEND);
                sendd.putExtra(Intent.EXTRA_TEXT,"hi,i have selected share button from my AppBar");
                sendd.setType("text/plain");
                Intent sharee=Intent.createChooser(sendd,null);
                startActivity(sharee);
            }
        });
       txt.setText("My App bar");
    }
}