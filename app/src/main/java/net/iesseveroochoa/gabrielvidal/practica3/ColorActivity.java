package net.iesseveroochoa.gabrielvidal.practica3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    SeekBar sbR;
    SeekBar sbG;
    SeekBar sbB;

    TextView tvColores;

    Button btAceptar;
    Button btCancelar;

    int[] colores;

    int Rojo;
    int Verde;
    int Azul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        sbR = findViewById(R.id.sb_Rojo);
        sbG = findViewById(R.id.sb_Verde);
        sbB = findViewById(R.id.sb_Azul);

        btAceptar=findViewById(R.id.bt_Aceptar);
        btCancelar=findViewById(R.id.bt_Cancelar);

        tvColores = findViewById(R.id.tv_Colores);

        colores=new int[3];


        Integer maxColor=getResources().getInteger(R.integer.maximocolor);
        sbR.setMax(maxColor);
        sbG.setMax(maxColor);
        sbB.setMax(maxColor);
        sbR.setProgress(0);
        sbG.setProgress(0);
        sbB.setProgress(0);


        SeekBar.OnSeekBarChangeListener sbcl=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                Rojo=sbR.getProgress();
                Verde=sbG.getProgress();
                Azul=sbB.getProgress();

                colores[0]=Rojo;
                colores[1]=Verde;
                colores[2]=Azul;

                tvColores.setBackgroundColor(Color.argb(255,Rojo,Verde,Azul));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sbR.setOnSeekBarChangeListener(sbcl);
        sbG.setOnSeekBarChangeListener(sbcl);
        sbB.setOnSeekBarChangeListener(sbcl);

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=getIntent();

                i.putExtra("colores",colores);



                setResult(RESULT_OK, i);
                finish();            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}

