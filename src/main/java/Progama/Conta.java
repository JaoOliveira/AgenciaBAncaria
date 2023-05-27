package Progama;

import Progama.utilitarios.Utils;

import javax.swing.*;

public class Conta {

    private static int contadorDeConta = 1;
    private Integer numeroConta;
    private  Pessoa pessoa;
    private Double saldo = 0.00;

    public Conta(Pessoa pessoa) {
        this.numeroConta = Conta.contadorDeConta;
        this.pessoa = pessoa;
        this.saldo();
        Conta.contadorDeConta += 1;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void saldo() {
        this.saldo = this.getSaldo();
    }

    public String toString(){
        return "\nNumeoro da conta: " + this.getNumeroConta()+
        "\nNome: " + this.pessoa.getNome() +
        "\nCPF: " + this.pessoa.getCpf() +
        "\nEmail: " + this.pessoa.getEmail() +
        "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
        "\n";
    }
    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu deposito foi realizado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar o depósito!");
        }
    }

    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Tranferência realizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar a ranferência!");
        }
    }

}

