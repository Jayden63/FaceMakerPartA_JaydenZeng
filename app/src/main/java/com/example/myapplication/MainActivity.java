//@author Jayden Zeng
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.SeekBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the seekbars and text views
        SeekBar redSeekBar;
        SeekBar greenSeekBar;
        SeekBar blueSeekBar;
        TextView redNum;
        TextView greenNum;
        TextView blueNum;
        //referencing the red seekbar
        redSeekBar = findViewById(R.id.redSeekBar);
        //referencing the green seekbar
        greenSeekBar = findViewById(R.id.greenSeekBar);
        //referencing the blue seekbar
        blueSeekBar = findViewById(R.id.blueSeekBar);

        //referencing the red text view
        redNum = findViewById(R.id.redText);
        //referencing the green text view
        greenNum = findViewById(R.id.greenText);
        //referencing the blue text view
        blueNum = findViewById(R.id.blueText);
        //the seekbar progress for red seek bar
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int numProgress, boolean b) {
                redNum.setVisibility(View.VISIBLE);
                //changes the text based on the value of progress
                redNum.setText("Red: "+ numProgress +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //the seekbar progress for green seek bar
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int numProgress, boolean b) {
                greenNum.setVisibility(View.VISIBLE);

                greenNum.setText("Green: "+ numProgress +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //the seekbar progress for blue seek bar
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int numProgress, boolean b) {
                blueNum.setVisibility(View.VISIBLE);

                blueNum.setText("Blue: "+ numProgress +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setup of spinner for hairstyles
        Spinner spinner = findViewById(R.id.hairStyleSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,"Selected Item: "+item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //contains all hairstyle options for spinner within the arraylist
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Bowl Cut");
        arrayList.add("Homer Hair");
        arrayList.add("Marge Hair");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
        }
    }
