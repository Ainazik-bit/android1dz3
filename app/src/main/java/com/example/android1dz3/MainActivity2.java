package com.example.android1dz3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity2 extends AppCompatActivity {

    private static final int PHOTOCODE = 5;
    public static final String KEY2 = "soljak";
    public static final String KEY1 = "onjak" ;
    private ImageView imageView2;
    private EditText editText2;
    private Button buttonmain2;
    private String stringuri ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView2 = findViewById(R.id.image_viewxml2);
        editText2 = findViewById(R.id.edit_textxml2);
        buttonmain2 = findViewById(R.id.buttonmain2);



        buttonmain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra(KEY1,stringuri);
            intent.putExtra( KEY2, editText2.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
            }});

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,PHOTOCODE);

            }}); }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == PHOTOCODE && resultCode == RESULT_OK){
          Uri uri = data.getData();
          stringuri=uri.toString();
          imageView2.setImageURI(uri);
        }
    }
}
/*во втором экране вы заполняете Editext ,
        далее кликаете по иконке и при нажатии на иконку должен быть переход в галерею,
        выбираете из галереи фото, возвращаетесь в экран и отправляете результат в первый экран*/