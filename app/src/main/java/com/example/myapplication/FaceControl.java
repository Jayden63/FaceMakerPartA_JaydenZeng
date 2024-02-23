//@author Jayden Zeng
package com.example.myapplication;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.graphics.Color;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;

//face control class implementing multiple listener interfaces to handle user interactions
public class FaceControl implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener
{
    //referencing to main activity and the face view for interaction
    public final MainActivity mainactivity;
    public final Face face;
    //constructor initializing the controller with references to face view and main activity
    public FaceControl(Face face, MainActivity mainactivity){
        this.face = face;
        this.mainactivity = mainactivity;
    }
    //handling selection events on spinner for choosing hair styles
    public void onItemSelected(AdapterView<?> spinner, View view,
                               int pos, long id) {

        //make current position the hairstyle
        face.hairStyle = pos;
        face.invalidate();
    }
    // handling the change in checked radio button within group(hairstyles)
    public void onCheckedChanged(RadioGroup group, int checkedId){

        //get the button that's been checked
        RadioButton checkedButton = group.findViewById(checkedId);
        boolean ifChecked = checkedButton.isChecked();
        if (ifChecked)
        {
            //update seek bars to match color of selected feature
            if (checkedButton.getId() == R.id.hairRadioButton){
                changeSeekBars(face.hairColor);
            }
            else if (checkedButton.getId() == R.id.eyesRadioButton){
                changeSeekBars(face.eyeColor);
            }
            else if (checkedButton.getId() == R.id.skinRadioButton){
                changeSeekBars(face.skinColor);
            }
            face.invalidate();//redraws the face view

        }

    }
    //updates the seek bars to reflect the values of the current features color
    public void changeSeekBars(int color){
        changeSeekBar(R.id.redSeekBar, getRed(color));
        changeSeekBar(R.id.greenSeekBar, getGreen(color));
        changeSeekBar(R.id.blueSeekBar, getBlue(color));
    }
    //updates a specific seek bar to match the rgb value
    public void changeSeekBar(int id, int rgb_comp){
        SeekBar seekbar = mainactivity.findViewById(id);
        seekbar.setProgress(rgb_comp);
    }
    //handles progress change events on the seek bars
    public void onProgressChanged(SeekBar seekbar, int progress,
                                  boolean fromUser){
        //get the radio group
        RadioGroup faceParts = mainactivity.findViewById(R.id.faceparts);

        //get id of current radio button checked (hair, skin, or eyes)
        int checkedId = faceParts.getCheckedRadioButtonId();
        //get id of seekbar that has moved
        int seekBarId = seekbar.getId();

        //update color of selected feature based on seek bars progress
        if (checkedId == R.id.hairRadioButton){
            face.hairColor = multiColor(seekBarId, progress, face.hairColor);
            face.hairPaint.setColor(face.hairColor);
        }
        else if (checkedId == R.id.eyesRadioButton){
            face.eyeColor = multiColor(seekBarId, progress, face.eyeColor);
            face.eyePaint.setColor(face.eyeColor);
        }
        else if (checkedId == R.id.skinRadioButton){
            face.skinColor = multiColor(seekBarId, progress, face.skinColor);
            face.facePaint.setColor(face.skinColor);
        }

        face.invalidate();//redraw face

    }
    //handling click events
    public void onClick(View v){
        face.randomize(); //randomizing face appearance

        //find the radio group
        RadioGroup faceParts = mainactivity.findViewById(R.id.faceparts);
        //get id of current radio button checked
        int checkedId = faceParts.getCheckedRadioButtonId();
        //updates the status of the bars based on checked button
        onCheckedChanged(faceParts, checkedId);

        //update the spinner selection
        Spinner spinner = mainactivity.findViewById(R.id.hairStyleSpinner);
        spinner.setSelection(face.hairStyle);

        face.invalidate();//redraw face

    }
    //helper methods to extract rgb components from color integer
    public int getRed(int color){
        return  (color >> 16) & 255;
    }

    public int getGreen(int color){
        return  (color >> 8) & 255;
    }

    public int getBlue(int color){
        return color & 255;
    }
    //adjusts color by changing the rgb values to a new value
    public int multiColor(int seekBarId, int progress, int color){
        //determines which color component to update based on seek bar id
        if (seekBarId == R.id.redSeekBar){
            return Color.argb(255, progress, getGreen(color), getBlue(color));
        }
        else if (seekBarId == R.id.greenSeekBar){
            return Color.argb(255,  getRed(color), progress, getBlue(color));
        }
        else if (seekBarId == R.id.blueSeekBar){
            return Color.argb(255,  getRed(color), getGreen(color), progress);
        }

        //returns the input color if seekbar id does not match
        return color;

    }


    public void onNothingSelected(AdapterView<?> parent) {
    //not used spinner method
    }


    public void onStartTrackingTouch(SeekBar seekBar){
    //not used seekbar method
    }


    public void onStopTrackingTouch(SeekBar seekBar){
    //not used seekbar method
    }

}