package com.mara.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mara.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private ClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());
        handlers = new  ClickHandlers(this);
        activityMainBinding.setClick(handlers);
    }

    private Student getCurrentStudent(){
        Student student = new Student();
        student.setName("Mandisi");
        student.setEmail("mandisikuse@gmail.com");
        return student;
    }

    public class ClickHandlers {
        Context context;

        public ClickHandlers(Context context) {
            this.context = context;
        }

        public void onEnrollButtonClicked(View view){
            Toast.makeText(context,"Enroll clicked", Toast.LENGTH_LONG).show();
        }

        public void onCancelButtonClicked(View view){
            Toast.makeText(context,"Cancel clicked", Toast.LENGTH_LONG).show();
        }
    }
}
