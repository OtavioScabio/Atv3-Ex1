/*
*@author: Otávio Gabriel Ribeiro Scabio - RA 1110482223043
*/

package com.example.abastecacerto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etVlrEtanol;
    private EditText etVlrGasolina;
    private Button btnComparar;
    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etVlrEtanol = findViewById(R.id.etVlrEtanol);
        etVlrGasolina = findViewById(R.id.etVlrGasolina);
        tvRes = findViewById(R.id.tvRes);
        btnComparar = findViewById(R.id.btnComparar);

        btnComparar.setOnClickListener(op -> calc ());


    }

    private void calc (){
       float valorEtanol = Float.parseFloat(etVlrEtanol.getText().toString());
       float valorGasolina = Float.parseFloat(etVlrGasolina.getText().toString());

       if(valorEtanol <= valorGasolina*0.7){
           String res = "Etanol está valendo mais a pena!";
           tvRes.setText(res);
        }else{
           String res = "Gasolina está valendo mais a pena!";
           tvRes.setText(res);
       }

    }

}