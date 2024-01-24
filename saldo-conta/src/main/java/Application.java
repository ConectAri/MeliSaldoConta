import domain.ContaBancaria;
import exception.SaldoInsuficienteException;

import java.util.logging.Logger;


public class Application {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);
        Logger logger = Logger.getLogger(Application.class.getName());


        try {
            // Tentativa de saque
            logger.info("Realizando o saque");
            conta.sacar(1800);
        } catch (SaldoInsuficienteException e) {
            // Capturando a exceção personalizada
            System.out.println("Erro1: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Capturando a exceção de argumento ilegal
            System.out.println("Erro2: " + e.getMessage());
        }
    }
}

