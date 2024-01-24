package domain;

import exception.SaldoInsuficienteException;

import java.util.logging.Logger;

public class ContaBancaria {
    private double saldo;
    private static final Logger logger = Logger.getLogger(ContaBancaria.class.getName());

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método para realizar um saque na conta
    public void sacar(double quantia) throws SaldoInsuficienteException {
        if (quantia <= 0) {
            // Se a quantia for não positiva, lançamos uma exceção
            logger.warning("A quantia de saque e negativa");
            throw new IllegalArgumentException("A quantia deve ser maior que zero.");
        }

        if (quantia > saldo) {
            // Se a quantia for maior que o saldo, lançamos uma exceção personalizada
            logger.warning("A quantia de saque e maior que o saldo disponivel");
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }

        // Se passou pelas verificações, realizamos o saque
        saldo -= quantia;
        logger.info("Saque realizado com sucesso!!");
        System.out.println("Saque de " + quantia + " realizado com sucesso. Novo saldo: " + getSaldo());
    }

    public double getSaldo() {
        return saldo;
    }
}
