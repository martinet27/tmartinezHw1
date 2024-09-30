package edu.up.tmartinezHw1;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import edu.up.tmartinezHw1.R;

/**
 * @author Talia Martinez
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // create listeners and find seekbars, step three
        myDrawing drawView = findViewById(R.id.surfaceView);
        ControllerTouch touchControl = new ControllerTouch(drawView);

        drawView.setOnTouchListener(touchControl);

        SeekBar redSeek = findViewById(R.id.red_seek);
        SeekBar greenSeek = findViewById(R.id.green_seek);
        SeekBar blueSeek = findViewById(R.id.blue_seek);

        redSeek.setOnSeekBarChangeListener(touchControl);
        greenSeek.setOnSeekBarChangeListener(touchControl);
        blueSeek.setOnSeekBarChangeListener(touchControl);

        TextView touchedView = findViewById(R.id.tvPressed);
        SeekBar seekRed = findViewById(R.id.red_seek);
        SeekBar seekGreen = findViewById(R.id.green_seek);
        SeekBar seekBlue = findViewById(R.id.blue_seek);
        drawView.setViewRefs(touchedView, seekRed, seekGreen, seekBlue);

    }
}