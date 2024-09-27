package org.poo.ContaPlayer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ContaJogador {
    private List<String> login = new ArrayList<>();
    private List<String> password = new ArrayList<>();

    public void adicionarConta(String login, String password){
        this.login.add(login);
        this.password.add(password);
    }

    public boolean isLoginValid(String login, String password){
        for (int i = 0; i < this.login.size(); i++) {
            if (this.login.get(i).equals(login) && this.password.get(i).equals(password)){
                return true;
            }
        }
        return false;
    }
}