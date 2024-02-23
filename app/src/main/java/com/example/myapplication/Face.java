//@author Jayden Zeng
package com.example.myapplication;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import java.util.Random;







//extends surface view so we can draw on surface view in the class
public class Face extends SurfaceView {
    //defines the color and style properties for face eyes and hair
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    //paint objects for different parts of drawing
    public Paint facePaint = new Paint();
    public Paint hairPaint = new Paint();
    public Paint eyePaint = new Paint();
    public Paint whitePaint = new Paint();
    public Paint blackPaint = new Paint();

    //constructor initializing the view and randomizing the appearance
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false); //allows to draw on surface view
        randomize(); //randomize the appearance properties
        //sets the initial colors based on random values
        facePaint.setColor(skinColor);


        hairPaint.setColor(hairColor);


        eyePaint.setColor(eyeColor);

    }

    //draw eyes on the canvas
    public void drawEyes(Canvas canvas) {

        whitePaint.setColor(Color.WHITE);
        //eye able to change color
        canvas.drawCircle(430.0f, 550.0f, 45.0f, eyePaint);
        canvas.drawCircle(670.0f, 550.0f, 45.0f, eyePaint);
        //white part of the eyes
        canvas.drawCircle(425.0f, 550.0f, 20.0f, whitePaint);
        canvas.drawCircle(675.0f, 550.0f, 20.0f, whitePaint);
        //pupils
        canvas.drawCircle(425.0f, 550.0f, 10.0f, blackPaint);
        canvas.drawCircle(675.0f, 550.0f, 10.0f, blackPaint);


    }

    //draws hair based on whatever hair is selected
    public void drawHair(Canvas canvas) {

        //bowl cut
        if (hairStyle == 0){
            //draws a half circle on top of the head
          canvas.drawArc(200.0f,200.0f,900.0f,600.0f,180,180,false,hairPaint);

        }


        //marge hair
        if (hairStyle== 1 ){
            // Outer loop for stacking
            for (int j = 0; j < 8; j++) {
                float verticalSpacing = 40.0f * j; // This moves each row up on the y-axis
                // Inner loop for drawing the line of ovals
                for (int i = 0; i < 6; i++) {
                    int left = 180 + 120 * i; // horizontal position of the oval
                    int right = left + 130; // right boundary of the oval, making it 130px wide
                    float top = 275.0f - verticalSpacing; // moves up on the y-axis for each stack
                    float bottom = 400.0f - verticalSpacing; // maintains the height of the oval
                    canvas.drawOval(left, top, right, bottom, hairPaint);//draws marge hair
                }
            }
            //draws the sides of marge hair
            for (int i = 0; i < 4; i ++){
                int top = 275 + 100*i;
                int bottom = top + 125;
                canvas.drawOval(180 , top, 330, bottom, hairPaint);
                canvas.drawOval(780 , top, 930, bottom, hairPaint);
            }
        }
//homer hair
        if (hairStyle == 2) {
            //get original stroke and style for paint
            Paint.Style originalStyle = hairPaint.getStyle();
            float originalStrokeWidth = hairPaint.getStrokeWidth();
            //set up hair paint for drawing hair strands
            hairPaint.setStrokeWidth(7.0f);
            hairPaint.setStyle(Paint.Style.STROKE);
            // draw hair strand
            canvas.drawArc(440.0f, 210.0f, 560.0f, 330.0f, 0.0f, -180.0f, false, hairPaint); // Left strand
            canvas.drawArc(510.0f, 210.0f, 630.0f, 330.0f, 0.0f, -180, false, hairPaint);
            //reset stroke width and style for the paint to what it was originally
            hairPaint.setStrokeWidth(originalStrokeWidth);
            hairPaint.setStyle(originalStyle);
        }

    }
    public void onDraw(Canvas canvas) {
        //draws face,hair,eyes,etc
        blackPaint.setColor(Color.BLACK);
        canvas.drawCircle(550.0f, 600.0f, 350.0f, facePaint);
        canvas.drawArc(400.0f,600.0f,700.0f,850.0f,0,180,false,blackPaint);
        drawHair(canvas);
        drawEyes(canvas);

    }




//this randomizes the appearance of the face
    public void randomize() {
        Random rand = new Random();
//randomly generates colors for skin eyes and hair
        skinColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256),
                rand.nextInt(256));
        facePaint.setColor(skinColor);

        eyeColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256),
                rand.nextInt(256));
        eyePaint.setColor(eyeColor);

        hairColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256),
                rand.nextInt(256));
        hairPaint.setColor(hairColor);
        //randomly selects hairstyle
        hairStyle = rand.nextInt(4);

    }



}