package dio.one.gftbootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente usuario = new Cliente();
        Conta cc = new ContaCorrente(usuario);
        Conta poupanca = new ContaPoupanca(usuario);

        Banco banco = new Banco();
        banco.setNome("Banco OldWest");

        System.out.println("================================");
        System.out.println("== Bem-vindo ao "+banco.getNome()+" ==");
        System.out.println("================================");
        System.out.println("Você já é nosso cliente? [S/N/Sair]");
        System.out.println(">> Opção: ");

        String opt = sc.next(); // Opção S, N ou Sair

        while (!opt.equalsIgnoreCase("S") && !opt.equalsIgnoreCase("N") && !opt.equalsIgnoreCase("Sair"))
        {
            System.out.println("Opção Inválida!");
            opt = sc.next();
        }

        if(opt.equalsIgnoreCase("N")) { // Opção N > Criar conta
            System.out.println("Vamos criar uma conta.");
            cc.CriarConta();

            System.out.println("=========================");

            System.out.print(">> Faça um depósito inicial: R$");
            double deposito = sc.nextDouble();
            cc.depositar(deposito);
            System.out.println(String.format("Saldo: R$%.2f", cc.getSaldo()));
        }

        else if(opt.equalsIgnoreCase("S")) { // Digitar senha

            usuario.setNome("Charley");

            // cc.depositar(100); // Deposito
            // cc.transferir(50, poupanca); // Transferência

            cc.imprimirExtrato();
            poupanca.imprimirExtrato();
        }

        else if(opt.equalsIgnoreCase("SAIR")) {
            System.out.println("Encerrando...");
            System.out.println("Até a próxima.");
        }


        /*else {
            System.out.println("Não é uma opção válida!");
        }*/
    }

}
