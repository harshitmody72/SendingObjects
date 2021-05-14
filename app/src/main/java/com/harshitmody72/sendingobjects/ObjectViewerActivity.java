package com.harshitmody72.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.harshitmody72.sendingobjects.Models.Student;
import com.harshitmody72.sendingobjects.databinding.ActivityObjectViewingBinding;

public class ObjectViewerActivity extends AppCompatActivity {
    ActivityObjectViewingBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityObjectViewingBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //Getting data through the intents
        getData();
    }

    /**
     * Receive data from ObjectSenderActivity
     */
    private void getData() {
        //Validate student object which is coming through the intent
        Student student = getIntent().getExtras().getParcelable(Constants.STUDENT_KEY);

        //Checking that the student is not null
        if(student == null){
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
            return;
        }

        //Showing data in text fields
        bind.showNameTextField.getEditText().setText(student.getName());
        bind.showGenderTextField.getEditText().setText(student.getGender());
        bind.showRollNumberTextField.getEditText().setText(student.getRollNumber());
        bind.showMobileNumberTextField.getEditText().setText(student.getMobileNumber());
    }
}