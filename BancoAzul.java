/*
    Deposito:
- Deve aceitar apenas valores positivos.
- Todos os depósitos devem ser armazenados em memória.
- Os depósitos devem aparecer no extrato

    Saque:
- Permitir **no máximo 3 saques diários**.
- Cada saque pode ter o valor **máximo de R$ 500,00**.
- O sistema deve bloquear saques se o usuário não tiver saldo suficiente, exibindo mensagem:
    `Saldo insuficiente para saque.`
- Os saques devem ser armazenados e aparecer no extrato.

    Extrato:
- Listar todas as **movimentações** (depósitos e saques) feitas.
- No final da listagem, mostrar o **saldo atual**.
- Formatar os valores no padrão brasileiro:
    Ex: `R$ 1500.45`
- Se não houver movimentações, mostrar:
    `Não foram realizadas movimentações.`
*/

import java.util.Scanner;

public class BancoAzul{
   public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    double saldo = 0;
    String extrato = "";
    int numeroSaques = 0;
    int limiteSaques = 3;
    double limiteValor= 500;

    while(true) {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("");
        System.out.println("Selecione uma opção:");
        System.out.println("[d] - Depósito");
        System.out.println("[s] - Saque");
        System.out.println("[e] - Extrato");
        System.out.println("[q] - Sair");
        System.out.println("");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");

        String menu = scanner.nextLine();
        if(menu.equals("d")) {
            System.out.println("Informe o valor do depósito: R$");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            if(valor > 0) {
                saldo += valor;
                extrato += String.format("Depósito de R$ %.2f realizado  \n", valor);
                System.out.printf("Depósito de R$ %.2f realizado com sucesso \n", valor);
            } else{
                System.out.println("Operação falhou! o valor informado é invalido");
            }
        } else if (menu.equals("s")) {
        System.out.println("Informe o valor de saque: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        boolean excedeuSaque = numeroSaques >= limiteSaques;
        boolean excedeuLimiteValor = valor > limiteValor;
        boolean excedeuSaldo = valor > saldo;

        if(excedeuSaldo) {
            System.out.println("Operação falhou! Você não tem saldo suficiente!");
        } else if(excedeuSaque){
            System.out.println("Operação falhou! O número máximo de saques foi excedido!");
        } else if(excedeuLimiteValor){
            System.out.println("Operação falhou! O valor do saques foi excedido");
        } else if(valor > 0){
            saldo -= valor;
            extrato += String.format ("Saque de R$ %.2f realizado com sucesso \n", valor); //
                                
            numeroSaques++;
        } else {
            System.out.println("Operação falhou! O valor informado é inválido");
        }

    } else if (menu.equals("e")){
        String mensagem = extrato.equals("") ? "Não foram realizadas movimentações" : extrato;
        System.out.println("");
        System.out.println("*-*-*-*--*-*Extrato*-*-*-*-*-*-*");
        System.out.println(mensagem);
        System.out.printf("Saldo: %.2f \n", saldo); 
        System.out.println("*-*-*-*-*-*-*-*-*-*-*"); 
        System.out.println("");     
    } else if(menu.equals("q")){
        System.out.println("Obrigado pela preferência!");
        break;
    } else{
        System.out.println("Opção inválida, por favor selecione uma operação correta!");
    }  
    }
    scanner.close();
   }
}