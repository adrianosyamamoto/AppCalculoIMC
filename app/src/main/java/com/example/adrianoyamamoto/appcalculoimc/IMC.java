package com.example.adrianoyamamoto.appcalculoimc;

public class IMC {
    private float _peso;
    private float _altura;
    private String _cpf;
    private float _imc;


    public double getPeso() {
        return _peso;
    }

    public void setPeso(float peso) {
        this._peso = peso;
    }

    public float getAltura() {
        return _altura;
    }

    public void setAltura(float altura) {
        this._altura = altura;
    }

    public String getCPF() {
        return _cpf;
    }

    public void setCPF(String cpf) {
        this._cpf = cpf;
    }

    public float getImc() {
        return _imc;
    }

    public void setImc(float imc) {
        this._imc = imc;
    }
}
