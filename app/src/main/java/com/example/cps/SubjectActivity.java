package com.example.cps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cps.model.StudentDBHelper;

public class SubjectActivity extends AppCompatActivity {

    StudentDBHelper studentDBHelper;
    Button showData = findViewById(R.id.showBtn);
    Button update = findViewById(R.id.updateBtn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        final EditText subject = findViewById(R.id.subject1);
        final EditText marks = findViewById(R.id.marks);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String subjectUpdate = subject.getText().toString();
//                int marksUpdate = Integer.parseInt(marks.getText().toString());
                addData();
                viewData();

            }
        });
    }

    public void addData(){

        EditText subject = findViewById(R.id.subject1);
        EditText marks = findViewById(R.id.marks);
        String subjectUpdate = subject.getText().toString();
        String marksUpdate = marks.getText().toString();

        boolean insertData = studentDBHelper.addData(subjectUpdate,marksUpdate);

        if(insertData){
            Toast.makeText(getApplicationContext(),"Data Inserted Successfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewData(){
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor response= studentDBHelper.viewData();

                StringBuffer buffer = new StringBuffer();
                while(response.moveToNext()){
                    buffer.append("Subbject :"+ response.getString(0)+"\n");
                    buffer.append("Marks :"+ response.getString(1)+"\n");
                }

                Detail("Record",buffer.toString());
            }
        });
    }

    public void Detail(String heading, String msg){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(heading);
        builder.setMessage(msg);
        builder.show();
    }

}