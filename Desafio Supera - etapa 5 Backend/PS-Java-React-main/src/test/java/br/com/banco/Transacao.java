package br.com.banco;

import java.time.LocalDateTime;

public class Transacao {
	private int id;
	private int valor;
    private LocalDateTime data;
	private String tipo;
    private String operador;
    private int idConta;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdConta() {
        return idConta;
    }
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public LocalDateTime getTransacaoData() {
        return data;
    }
    public void setTransacaoData(LocalDateTime data) {
        this.data = data;
    }
}
