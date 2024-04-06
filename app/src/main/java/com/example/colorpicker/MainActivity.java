package com.example.colorpicker;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private TextView redTextView, greenTextView, blueTextView;
    private FrameLayout frameLayout;
    private Button changeColorButton;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // legarea obiectelor

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar=findViewById(R.id.greenSeekBar);
        blueSeekBar=findViewById(R.id.blueSeekBar);

        redTextView=findViewById(R.id.redTextView);
        greenTextView=findViewById(R.id.greenTextView);
        blueTextView=findViewById(R.id.blueTextView);

        frameLayout=findViewById(R.id.frameLayout);
        changeColorButton=findViewById(R.id.button);

        // setarea actiunilor butonului de schimbare a culorii

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = Integer.parseInt(redTextView.getText().toString());
                int green = Integer.parseInt(greenTextView.getText().toString());
                int blue = Integer.parseInt(blueTextView.getText().toString());

                int color =  Color.rgb(red, green, blue);
                frameLayout.setBackgroundColor(color);

            }
        });

        // setare actiuni bara glisare pentru fiecare culoare

        redSeekBar.setOnSeekBarChangeListener(getSeekBarChangeListener(redTextView));
        greenSeekBar.setOnSeekBarChangeListener(getSeekBarChangeListener(greenTextView));
        blueSeekBar.setOnSeekBarChangeListener(getSeekBarChangeListener(blueTextView));
    }

    private SeekBar.OnSeekBarChangeListener getSeekBarChangeListener(TextView textView){
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }
}
