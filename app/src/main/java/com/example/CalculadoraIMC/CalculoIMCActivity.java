package com.example.CalculadoraIMC;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    private Button btnCalcularImc, btnLimpar, btnFechar;
    private EditText edtAltura, edtPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imcactivity); // Define o layout da activity

        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnCreate");

        // Inicializa os campos de texto e botões
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnLimpar = findViewById(R.id.btnLimpar);

        // Limpa os campos de peso e altura com o botão Limpar
        btnLimpar.setOnClickListener(view -> {
            edtPeso.setText("");
            edtAltura.setText("");
        });

        //
        btnCalcularImc = findViewById(R.id.btnCalcularImc);
        btnCalcularImc.setOnClickListener(view -> {
            // Converte as vírgulas para ponto nos valores inseridos (caso o usuário use vírgula)
            String alturaStr = edtAltura.getText().toString().replace(",", ".");
            String pesoStr = edtPeso.getText().toString().replace(",", ".");

            boolean hasError = false; // Variável que irá verificar se há erro

            // Verifica se os campos de peso ou altura estão vazios
            if (alturaStr.isEmpty()) {
                edtAltura.setError("Digite um valor para a altura");
                hasError = true;
            }
            if (pesoStr.isEmpty()) {
                edtPeso.setError("Digite um valor para o peso");
                hasError = true;
            }
            if (hasError) return;

            try {
                // Converte as strings para double
                double DoublePeso = Double.parseDouble(pesoStr);
                double DoubleAltura = Double.parseDouble(alturaStr);

                // Verifica se o peso ou a altura são valores negativos
                if (DoublePeso <= 0) {
                    edtPeso.setError("O peso deve ser um número positivo");
                    hasError = true;
                }
                if (DoubleAltura <= 0) {
                    edtAltura.setError("A altura deve ser um número positivo");
                    hasError = true;
                }
                if (hasError) return;

                // Cálculo do IMC
                double IMC = DoublePeso / (DoubleAltura * DoubleAltura);

                // Intent para redirecionar o usuário para a activity de resultado
                Intent intent;
                Bundle bundle = new Bundle();
                // Passa os dados para a próxima tela
                bundle.putDouble("peso", DoublePeso);
                bundle.putDouble("altura", DoubleAltura);
                bundle.putDouble("IMC", IMC);

                // Determina em qual activity o usuário será redirecionado de acordo com o IMC
                if (IMC < 18.5) {
                    intent = new Intent(this, AbaixoDoPesoActivity.class);
                } else if (IMC < 25) {
                    intent = new Intent(this, PesoNormalActivity.class);
                } else if (IMC < 30) {
                    intent = new Intent(this, SobrepesoActivity.class);
                } else if (IMC < 35) {
                    intent = new Intent(this, Obesidade1Activity.class);
                } else if (IMC < 40) {
                    intent = new Intent(this, Obesidade2Activity.class);
                } else {
                    intent = new Intent(this, Obesidade3Activity.class);
                }

                // Passa os dados para a nova activity e inicia a transição
                intent.putExtras(bundle);
                startActivity(intent);

                // Verifica se o peso e altura é válida e exibe separadamente
            } catch (NumberFormatException e) {
                if (!pesoStr.matches("\\d+(\\.\\d+)?")) {
                    edtPeso.setError("Digite um valor válido para o peso");
                }
                if (!alturaStr.matches("\\d+(\\.\\d+)?")) {
                    edtAltura.setError("Digite um valor válido para a altura");
                }
            }
        });

        // Inicaliza o botão Fechar
        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view -> {
            // Redireciona o usuário de volta para a tela principal
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo da Vida", "Tela Calculadora IMC - OnRestart");
    }
}
