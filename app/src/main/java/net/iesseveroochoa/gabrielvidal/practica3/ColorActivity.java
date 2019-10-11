package net.iesseveroochoa.gabrielvidal.practica3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    SeekBar sbR;
    SeekBar sbG;
    SeekBar sbB;

    TextView tvColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        sbR = findViewById(R.id.sb_Rojo);
        sbG = findViewById(R.id.sb_Verde);
        sbB = findViewById(R.id.sb_Azul);

        tvColores = findViewById(R.id.tv_Colores);


        Integer maxColor=getResources().getInteger(R.integer.maximocolor);
        sbR.setMax(maxColor);
        sbG.setMax(maxColor);
        sbB.setMax(maxColor);
        sbR.setProgress(0);
        sbG.setProgress(0);
        sbB.setProgress(0);


        SeekBar.OnSeekBarChangeListener colores=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int Rojo;
                int Verde;
                int Azul;

                Rojo=sbR.getProgress();
                Verde=sbG.getProgress();
                Azul=sbB.getProgress();

                tvColores.setBackgroundColor(Color.argb(255,Rojo,Verde,Azul));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sbR.setOnSeekBarChangeListener(colores);
        sbG.setOnSeekBarChangeListener(colores);
        sbB.setOnSeekBarChangeListener(colores);
    }
}

