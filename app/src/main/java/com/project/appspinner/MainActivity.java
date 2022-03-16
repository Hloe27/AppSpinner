package com.project.appspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText val1, val2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1= findViewById(R.id.txtVal1);
        val2=findViewById(R.id.txtVal2);
        tv1=findViewById(R.id.txtResultado);
        spinner1=findViewById(R.id.Spinner);

        String []opciones={"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter<String>adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

    }

    //Método del botón

    public void  Calcular(View view){
        String valor_1 = val1.getText().toString();
        String valor_2= val2.getText().toString();

        int valor_int = Integer.parseInt(valor_1);
        int valor_int2= Integer.parseInt(valor_2);

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("Sumar")){
            int suma= valor_int+valor_int2;
            String resultado= String.valueOf(suma);
            tv1.setText(resultado);

        }else if(seleccion.equals("Restar")){
            int resta=valor_int-valor_int2;
            String resultado=String.valueOf(resta);
            tv1.setText(resultado);

        }else if(seleccion.equals("Multiplicar")){
            int multiplicar=valor_int*valor_int2;
            String resultado=String.valueOf(multiplicar);
            tv1.setText(resultado);

        }else  if (seleccion.equals("Dividir")){
            if(valor_int2!=0){
                int div= valor_int/valor_int2;
                String resultado=String.valueOf(div);
                tv1.setText(resultado);
            }else{
                Toast.makeText(this,"No se puede devir entre cero, ingrese el valor correcto",Toast.LENGTH_LONG).show();
            }
        }


    }
}

