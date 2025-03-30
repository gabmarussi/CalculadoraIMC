package com.example.CalculadoraIMC;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculadoraImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);  // Define o layout da Activity, associando-a ao arquivo XML de layout

        Log.i("Ciclo de Vida", "Tela1 - Start");  // Log para indicar que a Activity foi iniciada

        btnCalculadoraImc = findViewById(R.id.btnCalculadoraImc);  // Obtém o botão do layout por ID
        btnCalculadoraImc.setOnClickListener(view -> {
            // Cria uma nova Intent para abrir a próxima Activity (CalculoIMCActivity)
            Intent intent = new Intent(this, CalculoIMCActivity.class);
            startActivity(intent);  // Inicia a nova Activity
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela1 - Start"); // Activity visível mas não interagível
    }

    @Override
    protected void onResume(){
        super.onResume();Log.i("Ciclo de Vida", "Tela1 - Resume"); // Começou a interagir com o usuário

    }

    @Override
    protected void onPause(){
        super.onPause();Log.i("Ciclo de Vida", "Tela1 - Pause"); // Activity  interrompida mas não parada

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela1 - Restart"); // Reiniciada após estar em segundo plano
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela1 - Stop"); // Completamente parada e não está mais visível
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela1 - Stop"); // Quando estiver sendo destruída
    }
}