package com.example.canod.glucocanoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class AlimentActivity extends AppCompatActivity implements View.OnClickListener {

    public int choCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliment);


        ImageButton btt1macarrons = (ImageButton) findViewById(R.id.btt1macarrons);
        btt1macarrons.setOnClickListener(this);

        ImageButton btt2espaguetis = (ImageButton) findViewById(R.id.btt2espaguetis);
        btt2espaguetis.setOnClickListener(this);

        ImageButton btt3arros = (ImageButton) findViewById(R.id.btt1macarrons);
        btt3arros.setOnClickListener(this);

        ImageButton btt4cigrons = (ImageButton) findViewById(R.id.btt4cigrons);
        btt4cigrons.setOnClickListener(this);

        ImageButton btt5patatesfregides = (ImageButton) findViewById(R.id.btt5patatesfregides);
        btt5patatesfregides.setOnClickListener(this);

        ImageButton btt6patatabullida = (ImageButton) findViewById(R.id.btt6patatabullida);
        btt5patatesfregides.setOnClickListener(this);

        ImageButton btt7mongetes = (ImageButton) findViewById(R.id.btt7mongetes);
        btt7mongetes.setOnClickListener(this);

        ImageButton btt8llenties = (ImageButton) findViewById(R.id.btt8llenties);
        btt8llenties.setOnClickListener(this);

        ImageButton btt9bastonets = (ImageButton) findViewById(R.id.btt9bastonets);
        btt9bastonets.setOnClickListener(this);
    }

    public void sumarcho(){

    }



    @Override
    public void onClick(View view) {
        TextView contadorCho = (TextView)findViewById(R.id.contadorCho);
        int seleccio = view.getId();

        switch(seleccio){
            case R.id.btt1macarrons:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
            break;
            case R.id.btt2espaguetis:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt3arros:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt4cigrons:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt5patatesfregides:
                choCuenta = choCuenta + 40;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt6patatabullida:
                choCuenta = choCuenta + 40;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt7mongetes:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt8llenties:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
            case R.id.btt9bastonets:
                choCuenta = choCuenta + 60;
                contadorCho.setText("" + choCuenta);
                break;
        }
    }
    public void tornarCalculador(View vista){
        Intent intent = new Intent(AlimentActivity.this, MainActivity.class);
        intent.putExtra("dadacho", choCuenta);
        startActivity(intent);
    }
}
