/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import warcraft.Raca;
import warcraft.Unidades;
import warcraft.Construcoes;
import static warcraft.Humano.noCapacidadeHumano;
import static warcraft.Orc.noCapacidadeOrc;
import static warcraft.Humano.noHumano;
import static warcraft.Orc.noOrc;

/**
 *
 * @author lenon.060194
 */
public class Warcraft {

    /**
     * @param args the command line arguments
     */
    public static Orc oo;
    public static Humano hh;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int n = 99, z, x, y;
        String humano, orc, name;

        System.out.println("Digite o nome da sua raça Humano");
        humano = ler.next();
        System.out.println("///////////////////////////////////////////////");
        if (humano != "") {
            System.out.println("Sua Raça Humano se chama " + humano);
        }
        hh = new Humano();
        Campones hc1 = new Campones(hh, 5, 5);
        Campones hc2 = new Campones(hh, 5, 5);
        Campones hc3 = new Campones(hh, 5, 5);
        CentroDaCidade hc4 = new CentroDaCidade(hh, hc1);
        System.out.println("///////////////////////////////////////////////");

        System.out.println("Digite o nome da sua raça Orc");
        orc = ler.next();
        while (orc == null ? humano == null : orc.equals(humano)) {
            System.out.println("Digite um nome diferente");
            orc = ler.next();
        }
        System.out.println("///////////////////////////////////////////////");
        System.out.println("Sua Raça Orc se chama " + orc);
        oo = new Orc();
        Campones oc1 = new Campones(oo, 1, 1);
        Campones oc2 = new Campones(oo, 1, 1);
        Campones oc3 = new Campones(oo, 1, 1);
        CentroDaCidade oc4 = new CentroDaCidade(oo, oc1);
        System.out.println("///////////////////////////////////////////////");

        while (n != 3) {
            System.out.println("Quem deseja Começar, escolha a opção");
            System.out.println("1- " + humano);
            System.out.println("2- " + orc);
            System.out.println("3- Sair");

            n = ler.nextInt();

            switch (n) {
                case 1:
                    if (hh.extinta == false) {
                        System.out.println("Sua Raça" + humano);
                        System.out.println("Escolhe uma opção");
                        System.out.println("1- Construçoes");
                        System.out.println("2- Unidades");
                        System.out.println("4- Retornar");

                        z = ler.nextInt();

                        switch (z) {
                            case 1:
                                System.out.println("Escolha uma das opçoes");
                                hh.consultarContrucoes();

                                x = ler.nextInt();
                                name = hh.construcoes.get(x).getClass().getSimpleName();
                                System.out.println(name + " Selecionado");

                                if ("CentroDaCidade".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Camponês");
                                    System.out.println("2- Atacar");
                                    int acao = ler.nextInt();
                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeHumano > noHumano) {
                                                CentroDaCidade centro = (CentroDaCidade) hh.construcoes.get(x);
                                                centro.gerarCampones();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }

                                            break;
                                        case 2:

                                            ConstrucoesQueAtacam centroAtaque = (ConstrucoesQueAtacam) hh.construcoes.get(x);
                                            ArrayList<Objeto> lista = centroAtaque.verificarObjProximo(oo, hh.construcoes.get(x));
                                            int o = lista.size();

                                            if (o == 0) {
                                                System.out.println("Não a oque atacar");
                                            } else {
                                                System.out.println("Objetos para atacar.");
                                                for (int i = 0; i < o; i++) {
                                                    System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                                }
                                                y = ler.nextInt();
                                                centroAtaque.ataque(oo, (Unidades) lista.get(y));
                                            }

                                            break;
                                    }
                                }
                                if ("Casa".equals(name)) {
                                    System.out.println("Lar doce lar");
                                }
                                if ("Templo".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Sacerdote");
                                    System.out.println("2- Gerar Andarilho espiritual");
                                    System.out.println("3- Retornar");

                                    int acao = ler.nextInt();
                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeHumano > noHumano) {
                                                Templo templo = (Templo) hh.construcoes.get(x);
                                                templo.geraSacerdote();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Sua Raça não permite criar Andarilhos.");
                                        case 3:

                                            continue;
                                    }
                                }

                                if ("Quartel".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Guerreiro");
                                    System.out.println("2- Gerar Cavalheiro");
                                    System.out.println("3- Gerar Arqueiro");
                                    System.out.println("4- Gerar Grifo");
                                    System.out.println("5- Retornar");

                                    int acao = ler.nextInt();

                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeHumano > noHumano) {
                                                Quartel qu = (Quartel) hh.construcoes.get(x);
                                                qu.geraGuerreiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 2:
                                            if (noCapacidadeHumano > noHumano) {
                                                Quartel qua = (Quartel) hh.construcoes.get(x);
                                                qua.geraCavaleiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 3:
                                            if (noCapacidadeHumano > noHumano) {
                                                Quartel quar = (Quartel) hh.construcoes.get(x);
                                                quar.geraArqueiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 4:
                                            if (noCapacidadeHumano > noHumano) {
                                                Quartel quart = (Quartel) hh.construcoes.get(x);
                                                quart.geraGrifo();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 5:

                                            continue;
                                    }
                                }

                                continue;
                            case 2:
                                System.out.println("Escolha uma das opçoes");
                                hh.consultarUnidades();

                                x = ler.nextInt();
                                String name2 = hh.unidades.get(x).getClass().getSimpleName();
                                System.out.println(name2 + " Selecionado");

                                if ("Campones".equals(name2)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Constroe");
                                    System.out.println("2- Colhe");
                                    System.out.println("3- Corta");
                                    System.out.println("4- Mineira");
                                    System.out.println("5- Mover");
                                    System.out.println("6- Retornar");
                                    int acao = ler.nextInt();

                                    switch (acao) {
                                        case 1:
                                            System.out.println("Oque deseja construir?");
                                            System.out.println("1- Casa");
                                            System.out.println("2- Centro Da Cidade");
                                            System.out.println("3- Templo");
                                            System.out.println("4- Quartel");
                                            System.out.println("5- Torre");
                                            int opcao;
                                            opcao = ler.nextInt();
                                            switch (opcao) {
                                                case 1:
                                                    hc1.constroi(hh, "Casa");
                                                    break;
                                                case 2:
                                                    hc1.constroi(hh, "CentroDaCidade");
                                                    break;
                                                case 3:
                                                    hc1.constroi(hh, "Templo");
                                                    break;
                                                case 4:
                                                    hc1.constroi(hh, "Quartel");
                                                    break;
                                                case 5:

                                                    break;
                                                case 6:

                                                    continue;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Colhendo");
                                            Campones trabalho1 = (Campones) hh.unidades.get(x);
                                            trabalho1.setComida(hh);
                                            break;
                                        case 3:
                                            System.out.println("Cortando");
                                            Campones trabalho2 = (Campones) hh.unidades.get(x);
                                            trabalho2.setMadeira(hh);
                                            break;
                                        case 4:
                                            System.out.println("Mineirando");
                                            Campones trabalho3 = (Campones) hh.unidades.get(x);
                                            trabalho3.setOuro(hh);
                                            break;
                                        case 5:
                                            System.out.println("em que sentido qur ir?");
                                            System.out.println("1- Norte");
                                            System.out.println("2- Sul");
                                            System.out.println("3- Leste");
                                            System.out.println("4- Oeste");
                                            System.out.println("5- Retornar");
                                            int direcao;
                                            direcao = ler.nextInt();
                                            switch (direcao) {
                                                case 1:
                                                    hc1.mover("NORTE");
                                                    break;
                                                case 2:
                                                    hc1.mover("SUL");
                                                    break;
                                                case 3:
                                                    hc1.mover("LESTE");
                                                    break;
                                                case 4:
                                                    hc1.mover("OESTE");
                                                    break;
                                                case 5:
                                                    continue;
                                            }

                                            break;
                                        case 6:
                                            continue;
                                    }
                                }

                                if ("Sacerdote".equals(name2)) {
                                    System.out.println("1- Curar");
                                    System.out.println("2- Rezar");
                                    System.out.println("3- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Sacerdote sacer = (Sacerdote) hh.unidades.get(x);
                                        ArrayList<Unidades> lista = sacer.verificarCura(hh, hh.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque curar");
                                        } else {
                                            System.out.println("Objetos para curar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            sacer.curar((Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Sacerdote sacer = (Sacerdote) hh.unidades.get(x);
                                        sacer.reza();
                                    }
                                    if (h == 3) {
                                        Sacerdote sacer = (Sacerdote) hh.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                sacer.mover("NORTE");
                                                break;
                                            case 2:
                                                sacer.mover("SUL");
                                                break;
                                            case 3:
                                                sacer.mover("LESTE");
                                                break;
                                            case 4:
                                                sacer.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;
                                    }

                                }
                                if ("Guerreiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Guerreiro gue = (Guerreiro) hh.unidades.get(x);
                                        ArrayList<Objeto> lista = gue.verificarObjProximo(oo, hh.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            gue.ataque(oo, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Guerreiro gue = (Guerreiro) hh.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                gue.mover("NORTE");
                                                break;
                                            case 2:
                                                gue.mover("SUL");
                                                break;
                                            case 3:
                                                gue.mover("LESTE");
                                                break;
                                            case 4:
                                                gue.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("Cavaleiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Cavaleiro cav = (Cavaleiro) hh.unidades.get(x);
                                        ArrayList<Objeto> lista = cav.verificarObjProximo(oo, hh.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            cav.ataque(oo, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Cavaleiro cav = (Cavaleiro) hh.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                cav.mover("NORTE");
                                                break;
                                            case 2:
                                                cav.mover("SUL");
                                                break;
                                            case 3:
                                                cav.mover("LESTE");
                                                break;
                                            case 4:
                                                cav.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("Arqueiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Arqueiro arq = (Arqueiro) hh.unidades.get(x);
                                        ArrayList<Objeto> lista = arq.verificarObjProximo(oo, hh.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            arq.ataque(oo, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Arqueiro arq = (Arqueiro) hh.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                arq.mover("NORTE");
                                                break;
                                            case 2:
                                                arq.mover("SUL");
                                                break;
                                            case 3:
                                                arq.mover("LESTE");
                                                break;
                                            case 4:
                                                arq.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("Grifo".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Grifo grif = (Grifo) hh.unidades.get(x);
                                        ArrayList<Objeto> lista = grif.verificarObjProximo(oo, hh.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            grif.ataque(oo, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Grifo grif = (Grifo) hh.unidades.get(x);
                                        System.out.println("em que sentido quer voar?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                grif.mover("NORTE");
                                                break;
                                            case 2:
                                                grif.mover("SUL");
                                                break;
                                            case 3:
                                                grif.mover("LESTE");
                                                break;
                                            case 4:
                                                grif.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                continue;

                            case 4:
                                continue;
                        }

                    } else {
                        System.out.println("Raca extinta, nada pode ser feito.");
                    }

                case 2:
                    if (oo.extinta == false) {
                        System.out.println("Sua Raça " + orc);
                        System.out.println("Escolhe uma opção");
                        System.out.println("1- Construçoes");
                        System.out.println("2- Unidades");
                        System.out.println("4- Retornar");

                        z = ler.nextInt();

                        switch (z) {
                            case 1:
                                System.out.println("Escolha uma das opçoes");
                                oo.consultarContrucoes();

                                x = ler.nextInt();
                                name = oo.construcoes.get(x).getClass().getSimpleName();
                                System.out.println(name + " Selecionado");

                                if ("CentroDaCidade".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Camponês");
                                    System.out.println("2- Atacar");
                                    int acao = ler.nextInt();
                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeOrc > noOrc) {
                                                CentroDaCidade centro = (CentroDaCidade) oo.construcoes.get(x);
                                                centro.gerarCampones();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 2:

                                            ConstrucoesQueAtacam centroAtaque = (ConstrucoesQueAtacam) oo.construcoes.get(x);
                                            ArrayList<Objeto> lista = centroAtaque.verificarObjProximo(hh, oo.construcoes.get(x));
                                            int o = lista.size();
                                            System.out.println("Objetos para atacar.");
                                            if (o == 0) {
                                                System.out.println("Não a oque atacar");
                                            } else {
                                                for (int i = 0; i < o; i++) {
                                                    System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                                }
                                                y = ler.nextInt();
                                                centroAtaque.ataque(hh, (Unidades) lista.get(y));
                                            }

                                            break;
                                    }
                                }
                                if ("Casa".equals(name)) {
                                    System.out.println("Nada a fazer");
                                }
                                if ("Templo".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Sacerdote");
                                    System.out.println("2- Gerar Andarilho espiritual");
                                    System.out.println("3- Retornar");

                                    int acao = ler.nextInt();
                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeHumano > noOrc) {
                                                Templo templo = (Templo) oo.construcoes.get(x);
                                                templo.geraSacerdote();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 2:
                                            if (noCapacidadeHumano > noOrc) {
                                                Templo templo = (Templo) oo.construcoes.get(x);
                                                templo.geraAndarilhoEspiritual();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                        case 3:

                                            continue;
                                    }
                                }

                                if ("Quartel".equals(name)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Gerar Guerreiro");
                                    System.out.println("2- Gerar Cavalheiro");
                                    System.out.println("3- Gerar Arqueiro");
                                    System.out.println("4- Gerar Grifo");
                                    System.out.println("5- Retornar");
                                    int acao = ler.nextInt();

                                    switch (acao) {
                                        case 1:
                                            if (noCapacidadeOrc > noOrc) {
                                                Quartel quartel = (Quartel) oo.construcoes.get(x);
                                                quartel.geraGuerreiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 2:
                                            if (noCapacidadeOrc > noOrc) {
                                                Quartel quartel = (Quartel) oo.construcoes.get(x);
                                                quartel.geraCavaleiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 3:
                                            if (noCapacidadeOrc > noOrc) {
                                                Quartel quartel = (Quartel) oo.construcoes.get(x);
                                                quartel.geraArqueiro();
                                            } else {
                                                System.out.println("Poupulação maxima atingida, construa mais casas ou novos centros de cidade");
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Sua Raça não permite gerar Grifo.");
                                            break;
                                        case 5:

                                            continue;
                                    }
                                }
                                continue;
                            case 2:
                                System.out.println("Escolha uma das opçoes");
                                oo.consultarUnidades();

                                x = ler.nextInt();
                                String name2 = oo.unidades.get(x).getClass().getSimpleName();
                                System.out.println(name2 + " Selecionado");

                                if ("Campones".equals(name2)) {
                                    System.out.println("Escolhe uma ação");
                                    System.out.println("1- Constroe");
                                    System.out.println("2- Colhe");
                                    System.out.println("3- Corta");
                                    System.out.println("4- Mineira");
                                    System.out.println("5- Mover");
                                    System.out.println("6- Retornar");
                                    int acao = ler.nextInt();

                                    switch (acao) {
                                        case 1:
                                            System.out.println("Oque deseja construir?");
                                            System.out.println("1- Casa");
                                            System.out.println("2- Centro Da Cidade");
                                            System.out.println("3- Templo");
                                            System.out.println("4- Quartel");
                                            System.out.println("5- Torre");
                                            int opcao;
                                            opcao = ler.nextInt();
                                            switch (opcao) {
                                                case 1:
                                                    oc1.constroi(oo, "Casa");
                                                    break;
                                                case 2:
                                                    oc1.constroi(oo, "CentroDaCidade");
                                                    break;
                                                case 3:
                                                    oc1.constroi(oo, "Templo");
                                                    break;
                                                case 4:
                                                    oc1.constroi(oo, "Quartel");
                                                    break;
                                                case 5:

                                                    break;
                                                case 6:

                                                    continue;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Colhendo");
                                            Campones trabalho1 = (Campones) oo.unidades.get(x);
                                            trabalho1.setComida(oo);
                                            break;
                                        case 3:
                                            System.out.println("Cortando");
                                            Campones trabalho2 = (Campones) oo.unidades.get(x);
                                            trabalho2.setMadeira(oo);
                                            break;
                                        case 4:
                                            System.out.println("Mineirando");
                                            Campones trabalho3 = (Campones) oo.unidades.get(x);
                                            trabalho3.setOuro(oo);
                                            break;
                                        case 5:
                                            System.out.println("em que sentido qur ir?");
                                            System.out.println("1- Norte");
                                            System.out.println("2- Sul");
                                            System.out.println("3- Leste");
                                            System.out.println("4- Oeste");
                                            System.out.println("5- Retornar");
                                            int direcao;
                                            direcao = ler.nextInt();
                                            switch (direcao) {
                                                case 1:
                                                    oc1.mover("NORTE");
                                                    break;
                                                case 2:
                                                    oc1.mover("SUL");
                                                    break;
                                                case 3:
                                                    oc1.mover("LESTE");
                                                    break;
                                                case 4:
                                                    oc1.mover("OESTE");
                                                    break;
                                                case 5:
                                                    continue;
                                            }

                                            break;
                                        case 6:
                                            continue;
                                    }
                                }

                                if ("Sacerdote".equals(name2)) {
                                    System.out.println("1- Curar");
                                    System.out.println("2- Rezar");
                                    System.out.println("3- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Sacerdote sacer = (Sacerdote) oo.unidades.get(x);
                                        ArrayList<Unidades> lista = sacer.verificarCura(oo, oo.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque curar");
                                        } else {
                                            System.out.println("Objetos para curar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            sacer.curar((Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Sacerdote sacer = (Sacerdote) oo.unidades.get(x);
                                        sacer.reza();
                                    }
                                    if (h == 3) {
                                        Sacerdote sacer = (Sacerdote) oo.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                sacer.mover("NORTE");
                                                break;
                                            case 2:
                                                sacer.mover("SUL");
                                                break;
                                            case 3:
                                                sacer.mover("LESTE");
                                                break;
                                            case 4:
                                                sacer.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;
                                    }

                                }
                                if ("Guerreiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Guerreiro gue = (Guerreiro) oo.unidades.get(x);
                                        ArrayList<Objeto> lista = gue.verificarObjProximo(hh, oo.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            gue.ataque(hh, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Guerreiro gue = (Guerreiro) oo.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                gue.mover("NORTE");
                                                break;
                                            case 2:
                                                gue.mover("SUL");
                                                break;
                                            case 3:
                                                gue.mover("LESTE");
                                                break;
                                            case 4:
                                                gue.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("Cavaleiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Cavaleiro cav = (Cavaleiro) oo.unidades.get(x);
                                        ArrayList<Objeto> lista = cav.verificarObjProximo(hh, oo.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            cav.ataque(hh, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Cavaleiro cav = (Cavaleiro) oo.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                cav.mover("NORTE");
                                                break;
                                            case 2:
                                                cav.mover("SUL");
                                                break;
                                            case 3:
                                                cav.mover("LESTE");
                                                break;
                                            case 4:
                                                cav.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("Arqueiro".equals(name2)) {
                                    System.out.println("1- Atacar");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        Arqueiro arq = (Arqueiro) oo.unidades.get(x);
                                        ArrayList<Objeto> lista = arq.verificarObjProximo(hh, oo.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque atacar");
                                        } else {
                                            System.out.println("Objetos para atacar.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            arq.ataque(hh, (Unidades) lista.get(y));
                                        }

                                    }
                                    if (h == 2) {
                                        Arqueiro arq = (Arqueiro) oo.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                arq.mover("NORTE");
                                                break;
                                            case 2:
                                                arq.mover("SUL");
                                                break;
                                            case 3:
                                                arq.mover("LESTE");
                                                break;
                                            case 4:
                                                arq.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                if ("AndarilhoEspiritual".equals(name2)) {
                                    System.out.println("1- Revive");
                                    System.out.println("2- Mover");
                                    int h = ler.nextInt();
                                    if (h == 1) {
                                        AndarilhoEspiritual anda = (AndarilhoEspiritual) oo.unidades.get(x);
                                        ArrayList<Objeto> lista = anda.verificarObjMorto(oo.unidades.get(x));
                                        int o = lista.size();

                                        if (o == 0) {
                                            System.out.println("Não à oque reviver");
                                        } else {
                                            System.out.println("Objetos para reviver.");
                                            for (int i = 0; i < o; i++) {
                                                System.out.printf("Posição %d- %s\n ", i, lista.get(i).getClass().getSimpleName());
                                            }
                                            y = ler.nextInt();
                                            String nomeDefunto = lista.get(y).getClass().getSimpleName();
                                            anda.revive(oo, hh, (Unidades) lista.get(y), nomeDefunto);
                                        }

                                    }
                                    if (h == 2) {
                                        AndarilhoEspiritual anda = (AndarilhoEspiritual) oo.unidades.get(x);
                                        System.out.println("em que sentido quer ir?");
                                        System.out.println("1- Norte");
                                        System.out.println("2- Sul");
                                        System.out.println("3- Leste");
                                        System.out.println("4- Oeste");
                                        System.out.println("5- Retornar");
                                        int direcao;
                                        direcao = ler.nextInt();
                                        switch (direcao) {
                                            case 1:
                                                anda.mover("NORTE");
                                                break;
                                            case 2:
                                                anda.mover("SUL");
                                                break;
                                            case 3:
                                                anda.mover("LESTE");
                                                break;
                                            case 4:
                                                anda.mover("OESTE");
                                                break;
                                            case 5:
                                                continue;
                                        }

                                        break;

                                    }

                                }
                                continue;

                            case 4:
                                continue;
                        }

                    } else {
                        System.out.println("Raça extinta. nada pode ser feito");
                    }
                case 3:
                    System.out.println("Jogo Finalizado");
                    break;
            }
        }
    }

}
