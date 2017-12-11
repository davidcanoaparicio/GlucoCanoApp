package com.example.canod.glucocanoapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    public int pes;
    public double dosiInsulinaTotal;
    public int dosiInsulinaPincharCho;
    public int dosiInsulinaPincharGlu;
    public int dosiInsulinaPinchar;
    public int cho;
    public int glucemia;
    public double relacioCho;
    public int correccio;
    public int diferenciaGluc;
    CheckBox chDeju;
    CheckBox chDinar;
    CheckBox chEsmorzar;
    CheckBox chBerenar;
    CheckBox chSopar;
    CheckBox chActivitatFisica;
    Button bttCalcular;
    Button bttSeleccioCho;
    TextView contadorChoIngerits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chDeju = (CheckBox)findViewById(R.id.chDeju);
        chEsmorzar = (CheckBox)findViewById(R.id.chEsmorzar);
        chDinar = (CheckBox) findViewById(R.id.chDinar);
        chBerenar = (CheckBox) findViewById(R.id.chBerenar);
        chSopar = (CheckBox) findViewById(R.id.chSopar);
        chActivitatFisica = (CheckBox) findViewById(R.id.chActivitatFisica);
        bttCalcular = (Button) findViewById(R.id.bttCalcular);
        bttSeleccioCho = (Button)findViewById(R.id.bttSeleccionCho);

        contadorChoIngerits = (TextView)findViewById(R.id.contadorChoIngerits);

        Intent i =getIntent();
        Bundle extras = i.getExtras();
        if(extras!=null){
            int choDonatUsuari = extras.getInt("dadacho");
            contadorChoIngerits.setText("" +choDonatUsuari);
            cho = choDonatUsuari;
        }

    }


    public void canviarActivitat(View vista){
        Intent intent = new Intent(MainActivity.this, AlimentActivity.class);
        startActivity(intent);
    }

    public void setPes(View vista) {
        EditText pesDonatUsuari = (EditText)findViewById(R.id.PesUsuari);
        pes = Integer.parseInt(pesDonatUsuari.getText().toString());
    }
    public void setGlucemia (View vista){
        EditText glucemiaUsuari = (EditText)findViewById(R.id.glucUsuari);
        glucemia = Integer.parseInt(glucemiaUsuari.getText().toString());
    }

    public void getDosiInsulinaPinchar(View vista) {
        setPes(vista);
        setGlucemia(vista);
        dosiInsulinaTotal = (int) (pes * 0.55);
        relacioCho = 500 / dosiInsulinaTotal;
        if (chActivitatFisica.isChecked()){
            relacioCho = (relacioCho - (relacioCho*0.025));
        }
        if (chDeju.isChecked()){
            relacioCho = (relacioCho - 2);
        }
        if (chDinar.isChecked()){
            relacioCho = (relacioCho +5);
        }
        if (chSopar.isChecked()){
            relacioCho = (relacioCho +2);
        }
        dosiInsulinaPincharCho = (int) (cho / relacioCho);

        correccio = (int) (1800 / dosiInsulinaTotal);
        diferenciaGluc = glucemia - 100;

        dosiInsulinaPincharGlu = diferenciaGluc / correccio;

        dosiInsulinaPinchar = dosiInsulinaPincharCho+dosiInsulinaPincharGlu;

        TextView insulinaDadaPinchar = (TextView) findViewById(R.id.insulinaDadaPinchar);
        insulinaDadaPinchar.setText(""+ dosiInsulinaPinchar);
    }

}
