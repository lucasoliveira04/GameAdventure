package org.poo;

import org.poo.ContaPlayer.ContaJogador;
import org.poo.ContaPlayer.CriarConta;

import java.util.Scanner;

public class App {
    public final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        CriarConta conta = new CriarConta();
        ContaJogador contaJogador = conta.getContaJogador();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("[1] - Login | [2] - Cadastro | [0] - Sair");
            int opcao = sc.nextInt();
            boolean isLoginValid = false;
            int tentativasLogin = 0;
            final int MAX_TENTATIVAS = 3;

            switch (opcao){
                case 1:
                    do{
                        System.out.println("Login");
                        String login = sc.next();

                        System.out.println("Senha");
                        String senha = sc.next();

                        isLoginValid = contaJogador.isLoginValid(login, senha);

                        if (isLoginValid){
                            System.out.println("Login efetuado com sucesso");
                        } else {
                            System.out.println("Login ou senha inválidos");
                            tentativasLogin++;

                            if (tentativasLogin >= MAX_TENTATIVAS){
                                System.out.println("Número máximo de tentativas atingido");
                                break;
                            }
                        }

                    } while (!isLoginValid && tentativasLogin < MAX_TENTATIVAS);

                    break;
                case 2:
                    System.out.println("Login");
                    String loginRegister = sc.next();

                    System.out.println("Senha");
                    String senhaRegister = sc.next();

                    if(conta.AdicionarConta(loginRegister, senhaRegister)){
                        System.out.println("Conta criada com sucesso");
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Saindo...");
                    running = false;
                    break;
            }
        }
    }
}