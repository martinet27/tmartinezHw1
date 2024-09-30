package edu.up.tmartinezHw1;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

/**
 * author: @Talia Martinez
 */

public class ControllerTouch implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    // instance vars for myDrawing (view) and DrawingModel (model)
    private myDrawing drawView;
    private DrawingModel drawModel;

    public ControllerTouch (myDrawing initDrawing) {
        this.drawView = initDrawing;
        this.drawModel = initDrawing.getDrawModel();
    }
    /**
     * when the user touches the canvas, change the color and move the seekbars accordingly as well
     * as noting the change
     *
     * @return 'true' if works
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // find out where the touch occurred (x, y)
        float xLocation = motionEvent.getX();
        float yLocation = motionEvent.getY();

        //save those coordinates
        drawModel.xLoc = xLocation;
        drawModel.yLoc = yLocation;

        // if an area w/ a connected event on the screen is touched, change the corresponding
        // model variable to true
        if (xLocation >= 250 && xLocation <= 550 && yLocation >= 250 && yLocation <= 350) {
            drawModel.fishOneTouched = true;
        }
        else if (xLocation >= 1000 && xLocation <= 1100 && yLocation >= 300 && yLocation <= 400) {
            drawModel.bubbleOneTouched = true;
        }
        else if (xLocation >= 300 && xLocation <= 500 && yLocation >= 500 && yLocation <= 600) {
            drawModel.fishTwoTouched = true;
        }
        else if (xLocation >= 1500 && xLocation <= 1700 && yLocation >= 700 && yLocation <= 800) {
            drawModel.fishThreeTouched = true;
        }
        else if (xLocation >= 900 && xLocation <= 1000 && yLocation >= 50 && yLocation <= 150) {
            drawModel.sunTouched = true;
        }
        else if (xLocation >= 850 && xLocation <= 950 && yLocation >= 550 && yLocation <= 650) {
            drawModel.bubbleTwoTouched = true;
        }

        // invalidate to redraw
        drawView.invalidate();
        return true;
    }

    /**
     *
     * find int of the last touched drawing, get progress of the moved seekbars, and assign
     * color of the last touched drawing with the ints of the moved seekbars (use draw.rgb to get
     * the combined value)
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Find out which fish/thing is the current one
        int lastTouched = drawModel.lastTouched;

        //Extract the progress from each of the red, green, blue seekbars
        int redProgress = drawView.seekRed.getProgress();
        int greenProgress = drawView.seekGreen.getProgress();
        int blueProgress = drawView.seekBlue.getProgress();

        //use Color.rgb() to calculate the current color
        int newColor = Color.rgb(redProgress, greenProgress, blueProgress);

        //set the color of the current fish to this new color
        if (lastTouched == 1) {
            drawView.greenFish.setColor(newColor);
        }
        else if (lastTouched == 2) {
            drawView.blueFish.setColor(newColor);
        }
        else if (lastTouched == 3) {
            drawView.redFish.setColor(newColor);
        }
        else if (lastTouched == 4) {
            drawView.sun.setColor(newColor);
        }
        else if (lastTouched == 5) {
            drawView.bubble1.setColor(newColor);
        }
        else if (lastTouched == 6){
            drawView.bubble2.setColor(newColor);
        }
        drawView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { // do nothing
    }
}
