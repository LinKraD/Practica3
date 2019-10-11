package net.iesseveroochoa.gabrielvidal.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int maxLetra;

    TextView tvTexto;
    TextView tvTamanyoFuente;

    Switch swNegrita;
    CheckBox cbCursiva;
    RadioGroup rgbFuente;
    SeekBar sbTamanyo;

    Button btColorTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxLetra=getResources().getInteger(R.integer.maximoletra);

        tvTexto=findViewById(R.id.tv_Texto);
        swNegrita=findViewById(R.id.sw_Negrita);
        cbCursiva=findViewById(R.id.cb_Cursiva);
        rgbFuente=findViewById(R.id.rgb_Fuentes);
        sbTamanyo=findViewById(R.id.sb_Tamanyo);
        tvTamanyoFuente=findViewById(R.id.tv_TamanyoFuente);
        btColorTexto=findViewById(R.id.bt_ColorTexto);

        Integer maxLetra=getResources().getInteger(R.integer.maximoletra);
        sbTamanyo.setProgress(maxLetra/2);
        sbTamanyo.setMax(maxLetra);
        tvTamanyoFuente.setText(String.valueOf(sbTamanyo.getProgress()));


        swNegrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (swNegrita.isChecked()) {
                    if (cbCursiva.isChecked()){
                        tvTexto.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        tvTexto.setTypeface(null, Typeface.BOLD);
                    }
                } else{
                    if (cbCursiva.isChecked()){
                        tvTexto.setTypeface(null, Typeface.ITALIC);
                    }else {
                        tvTexto.setTypeface(null,Typeface.NORMAL);
                    }
                }
            }
        });

        cbCursiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbCursiva.isChecked()) {
                    if (swNegrita.isChecked()){
                        tvTexto.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        tvTexto.setTypeface(null, Typeface.ITALIC);
                    }
                } else{
                    if (swNegrita.isChecked()){
                        tvTexto.setTypeface(null, Typeface.BOLD);
                    }else {
                        tvTexto.setTypeface(null,Typeface.NORMAL);
                    }
                }
            }
        });

        rgbFuente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case (R.id.rb_Sans):
                        if (swNegrita.isChecked()) {
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                            }
                        } else{
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.SANS_SERIF);
                            }
                        }
                        break;
                    case (R.id.rb_Serif):
                        if (swNegrita.isChecked()) {
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.SERIF, Typeface.BOLD);
                            }
                        } else{
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.SERIF, Typeface.ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.SERIF);
                            }
                        }
                        break;
                    case (R.id.rb_Monospace):
                        if (swNegrita.isChecked()) {
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                            }
                        } else{
                            if (cbCursiva.isChecked()){
                                tvTexto.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
                            }else {
                                tvTexto.setTypeface(Typeface.MONOSPACE);
                            }
                        }
                        break;
                }
            }
        });

        sbTamanyo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvTamanyoFuente.setText(String.valueOf(i));
                tvTexto.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btColorTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ColorActivity.class);
                startActivity(intent);
            }
        });



    }
}

