/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import model.exception.DomainException;

/**
 *
 * @author Joel Sousa
 */
public class Conta {
    private Integer numConta;
    private String titular;
    private Double saldo;
    private Double limiteSaque; 
    
    public Conta() {
    }
    public Conta(Integer numConta, String titular, Double saldo, Double limiteSaque) throws DomainException {
       
        if(limiteSaque==null){
        throw new DomainException("Digite um limite de saque para o cliente");
        }
        this.numConta = numConta;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque)throws DomainException {
        if(limiteSaque==null){
        throw new DomainException ("Limite de saque nao pode ser zero");
        }
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void deposito(Double deposito) throws DomainException{
        if(deposito==null){
        throw new DomainException ("Digite um valor válido !");
        }
    this.saldo+=deposito;
    }
    public void saque(Double saque) throws DomainException{
       if(saldo<saque){
        throw new DomainException ("saldo insuficiente");
        } if(limiteSaque<saque){
       throw new DomainException("Valor de Saque maior que permitido !");
        }
        
    this.saldo-=saque;
    }
    
    public String ToString (){
    return "Nome: "
            +titular
            +"\nNumero Da Conta: "
            +numConta
            +"\nSALDO: "
            +String.format("%.2f",saldo)
            +"\nLIMITE DE SAQUE : "
            +String.format("%.2f",limiteSaque);
    }

    
    
}
