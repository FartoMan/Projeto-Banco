package dio.one.gftbootcamp;
/* INTERFACE
*
* Este é um contrato de uso.
* A classe que implementar essa interface
* precisa saber usar todos os métodos que há na interface.
*
**/
public interface IConta {

    public void sacar(double valor);

    void depositar (double valor);

    void transferir (double valor, Conta contaDestino);

    void menu(int opcao);

    void imprimirExtrato();
}
