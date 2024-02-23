//@author Jayden Zeng
package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Spinner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;



public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set ui layout for the activity
        setContentView(R.layout.activity_main);

        //initializing the face view by finding it in the layout
        Face faceView = findViewById(R.id.faceDisplaySurfaceView);
        //creates a controller for face view passing in face view and the current activity
        FaceControl faceController = new FaceControl(faceView, this);

        //initializing the seekbar for red component
        SeekBar redseekBar= findViewById(R.id.redSeekBar);
        //attaching face controller as listener to handle changes in seekbar
        redseekBar.setOnSeekBarChangeListener(faceController);
        //initializing the seekbar for green component
        SeekBar greenseekBar= findViewById(R.id.greenSeekBar);
        //attaching face controller as listener to handle changes in seekbar
        greenseekBar.setOnSeekBarChangeListener(faceController);
        //initializing the seekbar for blue component
        SeekBar blueseekBar= findViewById(R.id.blueSeekBar);
        //attaching face controller as listener to handle changes in seekbar
        blueseekBar.setOnSeekBarChangeListener(faceController);

        //initializes the spinner for selecting hair styles
        Spinner spinner = findViewById(R.id.hairStyleSpinner);
        //attaches the face controller as a listener to handle selection events
        spinner.setOnItemSelectedListener(faceController);

        //initializing the radio group for selecting different face parts
        RadioGroup faceParts = findViewById(R.id.faceparts);
        //attaching the face controller as a listener to handle checked change events
        faceParts.setOnCheckedChangeListener(faceController);
        //set default checked radio button to hair option
        faceParts.check(R.id.hairRadioButton);

        //Random Button initialization
        Button randomFace = findViewById(R.id.randomFaceButton);
        //attach controller as onclick listener to handle button presses
        randomFace.setOnClickListener(faceController);



    }

}