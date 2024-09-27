package org.poo.ContaPlayer;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CriarConta {
    private String login;
    private String password;
    private ContaJogador contaJogador;

    public CriarConta(){
        this.contaJogador = new ContaJogador();
    }

    public boolean AdicionarConta(String login, String password){
        this.login = login;
        this.password = password;

        contaJogador.adicionarConta(login, password);
        return true;
    }
}