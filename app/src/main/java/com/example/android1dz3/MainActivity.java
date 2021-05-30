package com.example.android1dz3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int DANNIECODE = 6;
    private ImageView imageView1;
    private TextView textView1;
    private Button buttonsms;
    private Button buttongmail;
     private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.image_viewxml1);
        textView1 = findViewById(R.id.text_viewxml1);
        buttonsms = findViewById(R.id.buttonsms);
        buttongmail = findViewById(R.id.buttongmail);

        buttongmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"one love");
                intent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(intent,"choose app too send"));
            }
        });

    buttonsms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivityForResult(intent, DANNIECODE);

        }});}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == DANNIECODE && resultCode == RESULT_OK){
          String image = data.getStringExtra(MainActivity2.KEY1);
          text = data.getStringExtra(MainActivity2.KEY2);
          textView1.setText(text);
          imageView1.setImageURI(Uri.parse(image));

        }
}}

/*
        Домашнее задание:
        Создаете два экрана, в первом экране должна быть ImageView,
        TextView и две кнопки , во втором экране создаете ImageView,
        EditText и одна кнопка

        Флоу задания:

        При нажатии на кнопку в первом экране,
        идет переход во второй экран,

        в первом экране отображете результат + кликаете по второй кнопке
        и должен быть переход в gmail с полученными вами текстом*/