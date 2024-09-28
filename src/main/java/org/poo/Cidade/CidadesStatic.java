package org.poo.Cidade;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CidadesStatic {
   public final List<String> cidades = new ArrayList<>();

    public CidadesStatic(){
         cidades.add("São Paulo");
         cidades.add("Rio de Janeiro");
         cidades.add("Belo Horizonte");
         cidades.add("Curitiba");
         cidades.add("Porto Alegre");
         cidades.add("Salvador");
         cidades.add("Recife");
         cidades.add("Fortaleza");
         cidades.add("Brasília");
         cidades.add("Manaus");
    }
}
