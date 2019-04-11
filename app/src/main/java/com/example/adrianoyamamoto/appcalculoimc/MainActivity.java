package com.example.adrianoyamamoto.appcalculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private float peso;
    private float altura;
    private String CPF;
    private float imc;
    IMCRepository respository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        respository = new IMCRepository(getApplicationContext());
    }

    public void Carregar(View v) {
        EditText etCPF = findViewById(R.id.etCPF);
        CPF = etCPF.getText().toString();

        IMC dadosImc = new IMC();

        dadosImc = respository.listarPorCPF(CPF);

        if(dadosImc != null) {

            EditText etPeso = findViewById(R.id.etPeso);
            etPeso.setText(String.valueOf(dadosImc.getPeso()));

            EditText etAltura = findViewById(R.id.etAltura);
            etAltura.setText(String.valueOf(dadosImc.getAltura()));

            EditText etResultado = findViewById(R.id.etResultado);
            etResultado.setText(String.valueOf(dadosImc.getImc()));
        }

    }

    public void Gravar (View v) {
        IMC dadosImc = new IMC();

        dadosImc.setAltura(altura);
        dadosImc.setCPF(CPF);
        dadosImc.setPeso(peso);
        dadosImc.setImc(imc);

        respository.salvar(dadosImc);
        limparCampos();
    }

    public void Calcular (View v) {
        EditText etCPF = findViewById(R.id.etCPF);
        CPF = etCPF.getText().toString();

        EditText etPeso = findViewById(R.id.etPeso);
        peso = Float.parseFloat(etPeso.getText().toString());

        EditText etAltura = findViewById(R.id.etAltura);
        altura = Float.parseFloat(etAltura.getText().toString());

        imc = (peso / (altura * altura));

        EditText etResultado = findViewById(R.id.etResultado);

        etResultado.setText(String.valueOf(imc));

    }

    private void limparCampos() {
        EditText etPeso = findViewById(R.id.etPeso);
        etPeso.setText("");

        EditText etAltura = findViewById(R.id.etAltura);
        etAltura.setText("");

        EditText etResultado = findViewById(R.id.etResultado);
        etResultado.setText("");

        EditText etCPF = findViewById(R.id.etCPF);
        etCPF.setText("");
    }

}
