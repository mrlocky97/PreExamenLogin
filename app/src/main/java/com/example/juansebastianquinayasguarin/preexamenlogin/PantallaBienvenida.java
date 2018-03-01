package com.example.juansebastianquinayasguarin.preexamenlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by juansebastianquinayasguarin on 27/2/18.
 */

public class PantallaBienvenida extends Activity {
    private final int DURACION_SPLASH = 2000;
    ImageView fondo;
    TextView texto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fondo = (ImageView)findViewById(R.id.logo);
        texto = (TextView)findViewById(R.id.texto_splash);

        //Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_animation1);
        //fondo.startAnimation(rotate);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.pantalla_bienvenida);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(PantallaBienvenida.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
