package com.example.CalculadoraIMC;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PesoNormalActivity extends AppCompatActivity {

    private TextView titleMedidas, txtMensagem;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        double peso = bundle.getDouble("peso");
        double altura = bundle.getDouble("altura");
        double IMC = bundle.getDouble("IMC");
        String IMCDecimal = String.format("%.2f",IMC);

        titleMedidas = findViewById(R.id.titleMedidas);
        titleMedidas.setText("Peso: " + peso + "\n"
                +"Altura: " + altura + "\n"
                +"IMC: " + IMCDecimal + "\n"
                +"Classificação: " + "Peso Normal");

        txtMensagem = findViewById(R.id.txtMensagem);
        txtMensagem.setText(R.string.mensagem_pesonormal);

        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view->{
            Intent intentObesidade1 = new Intent(this, MainActivity.class);
            startActivity(intentObesidade1);
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo da Vida","Tela Obesidade 1 - OnStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo da Vida","Tela Obesidade 1- OnResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo da Vida","Tela Obesidade 1 - OnPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo da Vida","Tela Obesidade 1 - OnStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo da Vida","Tela Obesidade 1 - OnDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo da Vida","Tela Obesidade 1 - OnRestart");
    }

}