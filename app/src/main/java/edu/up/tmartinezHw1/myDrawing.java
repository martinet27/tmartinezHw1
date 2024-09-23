package edu.up.tmartinezHw1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * @author Talia Martinez
 */

public class myDrawing extends SurfaceView {

    // setting paint
    private Paint oceanBlue;
    private Paint greenFish;
    private Paint redFish;
    private Paint bubbles;
    private Paint blueFish;
    private Paint sky;
    private Paint sun;
    private Paint eyes;


    public myDrawing (Context context, AttributeSet attrs) {
        super(context, attrs);

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

        bubbles = new Paint();
        bubbles.setColor(0xFFFFFFFF);
        bubbles.setStyle(Paint.Style.STROKE);

        blueFish = new Paint();
        blueFish.setColor(0xFF008080);
        blueFish.setStyle(Paint.Style.FILL);

        eyes = new Paint();
        eyes.setColor(0xFF000000);
        eyes.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // drawing the on the canvas
        canvas.drawRect(0, 0, 2000, 2000, oceanBlue);
        canvas.drawRect(0, 0, 2000, 200, sky);
        canvas.drawOval(900, 50, 1000, 150, sun);
        canvas.drawOval(250, 250, 550, 350, greenFish);
        canvas.drawOval(500, 275, 525, 300, eyes);
        canvas.drawOval(600, 700, 800, 800, redFish);
        canvas.drawOval(750, 725, 775, 750, eyes);
        canvas.drawOval(100, 400, 200, 300, bubbles);
        canvas.drawOval(900, 700, 950, 750, bubbles);
        canvas.drawOval(300, 500, 500, 600, blueFish);
        canvas.drawOval(325, 525, 350, 550, eyes);

    }
}
