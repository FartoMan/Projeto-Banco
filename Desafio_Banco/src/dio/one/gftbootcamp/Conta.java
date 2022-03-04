package dio.one.gftbootcamp;

import java.util.Scanner;

public abstract class Conta implements IConta {
    Scanner sc = new Scanner(System.in);

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia; // atributo
    protected int numero; // atributo
    protected double saldo; // atributo
    protected Cliente cliente; // Esse atributo busca a Classe cliente

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    // Os metodos são implementos da interface, seguindo o contrato estabelecido por ela
    @Override
    public void sacar(double valor) {

        if(valor > saldo) {
            System.out.println("Você não possui essa quantia em conta.");
        }
        else if(valor < 0) {
            System.out.println(">> Impossível sacar esse valor! <<");
        }
        else {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {

        if(valor < 0) {
            System.out.println(">> Impossível depositar esse valor! <<");
        }
        else {
            saldo += valor;
            System.out.println(">> Depósito efetuado com sucesso! <<");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void menu(int opcao) {



    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void CriarConta() {

        //Cliente usuario = new Cliente(); // Por aqui eu gero acesso às variáveis e métodos, ou seja, atributos
        Conta cc = new ContaCorrente(cliente);

        System.out.println("== Criar conta ==");
        System.out.println("=================");

        System.out.print("Nome: ");
        String user = sc.nextLine();
        cliente.setNome(user);

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        cliente.setEndereco(endereco);

        System.out.print("CPF: ");
        String c = sc.nextLine();
        cliente.setCpf(c);

        System.out.print("E-mail: ");
        String em = sc.nextLine();
        cliente.setEmail(em);

        System.out.print("Senha: ");
        String senha =sc.nextLine();
        cliente.setSenha(senha);

        System.out.println("=== Seu cadastro foi efetuado com sucesso! ===");

        Extrato();
    }

    protected void ImprimirInfosConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Endereço: %s", this.cliente.getEndereco()));
        System.out.println(String.format("E-mail: %s", this.cliente.getEmail()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
    }

    protected void Extrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Endereço: %s", this.cliente.getEndereco()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }



}
