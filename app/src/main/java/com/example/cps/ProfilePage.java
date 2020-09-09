package com.example.cps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private String spName = "com.prabhakar.CPS";

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        this.sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        Intent intent = getIntent();
        String name = sharedPreferences.getString("name", "No Name");
        TextView tv = findViewById(R.id.greetings);
        tv.setText(String.valueOf(name));

        Button button = findViewById(R.id.imgUpload);
        ImageView imageView = findViewById(R.id.profileImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1 , 0);
            }
        });


//        if(intent != null){
//            TextView tv = findViewById(R.id.tv_profile);
//            String msg = intent.getStringExtra(keystore.KEY_MESSAGE);
//
//
//            tv.setText(getString(R.string.welcome_message, msg));
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        String message;
        switch (menuId) {

            case R.id.home:
                Intent intent = new Intent(this, SubjectActivity.class);
                startActivity(intent);
                break;
            case R.id.attendance:
                Intent intent1 = new Intent(this, SubjectActivity.class);
                startActivity(intent1);
                break;
            case R.id.subjects:
                message = "This is Subject activity";
                break;
            default:
                message = "Wrong option selected";
                break;

        }

        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}