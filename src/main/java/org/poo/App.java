package org.poo;

import org.poo.Cidade.Cidade;
import org.poo.Cidade.CidadesStatic;
import org.poo.ContaPlayer.ContaJogador;
import org.poo.ContaPlayer.CriarConta;
import org.poo.Personagem.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int fase = 1;
        String cidade;

        switch (fase){
            case 1:
                cidade = "São Paulo";
                break;
            case 2:
                cidade = "Rio de Janeiro";
                break;
            case 3:
                cidade = "Belo Horizonte";
                break;
            default:
                cidade = "São Paulo";
                break;
        }

        menuJogo(cidade, fase);
        // menuJogo("São Paulo", 1);
    }

    public static void initGame(){

    }

    public static void menuInicial(){
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

    public static void menuJogo(String cityMapa, int fase){
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("[1] - Mapa | [2] - Personagem | [3] - Mochila | [0] - Sair");
            int opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    switch (fase){
                        case 1:
                            mapa(cityMapa, new Personagem());
                            break;
                        case 2:
                            mapa(cityMapa, new Personagem());
                            break;
                        case 3:
                            mapa(cityMapa, new Personagem());
                            break;
                        default:
                            System.out.println("Fase não encontrada");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Personagem");
                    break;
                case 3:
                    mochila();
                    break;
                case 4:
                    System.out.println("Loja");
                    break;
                case 5:
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

    public static void mochila(){
        Personagem personagem = new Personagem();
        personagem.mochila();
    }

    public static void mapa(String nameCidade, Personagem personagem){
        CidadesStatic cidades = new CidadesStatic();
        Cidade cidade = new Cidade();
        System.out.println("Mapa");

        cidade.setNome(nameCidade);
        cidade.setPopulacao(100);
        cidade.setTamanho(1000);
        cidade.setQntdItens(0);
        cidade.adicionarItem(10);

        List<Double> coordenadas = personagem.getCoordenadas();
        List<Double> coordenadasList = new ArrayList<>();
        for (double coord : coordenadas){
            coordenadasList.add(coord);
        }

        cidade.getLocalizacaoPersonagens().addAll(coordenadasList);

        System.out.println("Descrição da cidade");
        System.out.printf("Cidade em que você está: %s\n", cidades.getCidades().contains(nameCidade) ? nameCidade : "Cidade não encontrada");
        System.out.printf("População: %d\n", cidade.getPopulacao());
        System.out.printf("Tamanho: %.2f\n", cidade.getTamanho());
        System.out.printf("Quantidade de itens: %d\n", cidade.getQntdItens());
        cidade.mostrarItens();
        cidade.mostrarPersonagem();
    }

}