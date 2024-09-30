package edu.up.tmartinezHw1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Talia Martinez
 */

public class myDrawing extends SurfaceView {
    private DrawingModel drawModel;

    // all the initial paints
    public Paint oceanBlue;
    public Paint greenFish;
    public Paint blueFish;
    public Paint redFish;
    public Paint bubble1;
    public Paint bubble2;
    public Paint sun;
    private Paint sky;
    private Paint eyes;

    // will be initialized after drawing
    TextView touchedView = null;
    SeekBar seekRed = null;
    SeekBar seekGreen = null;
    SeekBar seekBlue = null;

    public myDrawing (Context context, AttributeSet attrs) {
        super(context, attrs);
        //initialize drawModel
        drawModel = new DrawingModel();

        // tells it to actually draw something
        setWillNotDraw(false);

        // initializing all the paint instance vars
        sky = new Paint();
        sky.setColor(0xFF87CEEB);
        sky.setStyle(Paint.Style.FILL);

        oceanBlue = new Paint();
        oceanBlue.setColor(0xFF4F42B5);
        oceanBlue.setStyle(Paint.Style.FILL);

        sun = new Paint();
        sun.setColor(0xFFFFFF00);
        sun.setStyle(Paint.Style.FILL);

        greenFish = new Paint();
        greenFish.setColor(0xFF2F5233);
        greenFish.setStyle(Paint.Style.FILL);

        redFish = new Paint();
        redFish.setColor(0xFFBF0000);
        redFish.setStyle(Paint.Style.FILL);

        bubble1 = new Paint();
        bubble1.setColor(0xFFFFFFFF);
        bubble1.setStyle(Paint.Style.FILL);

        // so both bubbles dont change when the seekbar changes, but still the same color initially
        bubble2 = new Paint();
        bubble2.setColor(0xFFFFFFFF);
        bubble2.setStyle(Paint.Style.STROKE);

        blueFish = new Paint();
        blueFish.setColor(0xFF008080);
        blueFish.setStyle(Paint.Style.FILL);

        eyes = new Paint();
        eyes.setColor(0xFF000000);
        eyes.setStyle(Paint.Style.FILL);
    }

    // returns the initialized drawing model
    public DrawingModel getDrawModel() {
        return this.drawModel;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // drawing the on the canvas
        canvas.drawRect(0, 0, 2000, 900, oceanBlue);
        canvas.drawRect(0, 0, 2000, 200, sky);
        canvas.drawOval(900, 50, 1000, 150, sun);
        canvas.drawOval(250, 250, 550, 350, greenFish);
        canvas.drawOval(500, 275, 525, 300, eyes);
        canvas.drawOval(1500, 700, 1700, 800, redFish);
        canvas.drawOval(1650, 725, 1675, 750, eyes);
        canvas.drawOval(1000, 400, 1100, 300, bubble1);
        canvas.drawOval(850, 550, 950, 650, bubble2);
        canvas.drawOval(300, 500, 500, 600, blueFish);
        canvas.drawOval(325, 525, 350, 550, eyes);

        // changes the seekbars and textView when a drawing is touched
        // sets the corresponding boolean to false afterward so other drawings will draw
        if (drawModel.fishOneTouched) {
            // green fish
            drawModel.lastTouched = 1;
            touchedView.setText("Fish One");
            seekRed.setProgress(47);
            seekGreen.setProgress(82);
            seekBlue.setProgress(51);
            drawModel.fishOneTouched = false;
        }
        else if (drawModel.fishTwoTouched) {
            // blue fish
            drawModel.lastTouched = 2;
            touchedView.setText("Fish Two");
            seekRed.setProgress(0);
            seekGreen.setProgress(128);
            seekBlue.setProgress(128);
            drawModel.fishTwoTouched = false;
        }
        else if (drawModel.fishThreeTouched) {
            // red fish
            drawModel.lastTouched = 3;
            touchedView.setText("Fish Three");
            seekRed.setProgress(191);
            seekGreen.setProgress(0);
            seekBlue.setProgress(0);
            drawModel.fishThreeTouched = false;
        }
        else if (drawModel.sunTouched) {
            drawModel.lastTouched = 4;
            touchedView.setText("The Sun");
            seekRed.setProgress(255);
            seekGreen.setProgress(255);
            seekBlue.setProgress(0);
            drawModel.sunTouched = false;
        }
        else if (drawModel.bubbleOneTouched) {
             drawModel.lastTouched = 5;
             touchedView.setText("Bubble One");
             seekRed.setProgress(255);
             seekGreen.setProgress(255);
             seekBlue.setProgress(255);
             drawModel.bubbleOneTouched = false;
        }
        else if (drawModel.bubbleTwoTouched) {
            drawModel.lastTouched = 6;
            touchedView.setText("Bubble Two");
            seekRed.setProgress(255);
            seekGreen.setProgress(255);
            seekBlue.setProgress(255);
            drawModel.bubbleTwoTouched = false;
        }
    }

    // initializing the textview and seekbars
    public void setViewRefs(TextView touchedView, SeekBar seekRed, SeekBar seekGreen, SeekBar seekBlue) {
        this.touchedView = touchedView;
        this.seekRed = seekRed;
        this.seekGreen = seekGreen;
        this.seekBlue = seekBlue;
    }
}
