package dio.one.gftbootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente usuario = new Cliente();
        Conta cc = new ContaCorrente(usuario);
        Conta poupanca = new ContaPoupanca(usuario);

        boolean clienteOn = false;

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
            System.out.println("Opção Inválida!\nOpção: ");
            opt = sc.next();
        }

        if(opt.equalsIgnoreCase("N")) { // Opção N > Criar conta
            System.out.println("Vamos criar uma conta.");
            cc.CriarConta();

            System.out.println("=========================");

            clienteOn = true;

            do{
                System.out.println("================================");
                System.out.println("== "+banco.getNome()+" ==");
                System.out.println("================================");
                System.out.println("1 - sacar 2 - depositar 3 - transferir 4 - sair");
                int menuOpt = sc.nextInt();
                double valor;
                switch (menuOpt) {
                    case 1: // saque
                        System.out.println("== Saque ==\nValor: ");
                        valor = sc.nextDouble();
                        if (valor < cc.saldo && valor > 0) cc.sacar(valor);
                            else System.out.println("Saldo indisponível.");
                        System.out.println(String.format("Saldo: R$%.2f", cc.getSaldo()));
                        break;
                    case 2: // deposito
                        System.out.println("== Depôsito ==\nValor: ");
                        valor = sc.nextDouble();
                        if (valor > 0) cc.depositar(valor);
                            else System.out.println("Valor invalido!");
                        System.out.println(String.format("Saldo: R$%.2f", cc.getSaldo()));
                        break;
                    case 3: // transferência
                        System.out.println("Indisponível...");
                        break;
                    case 4: // sair
                        clienteOn = false;
                        System.out.println("Saindo...\nAté a próxima!");
                        break;

                }

            }while (clienteOn == true);

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
