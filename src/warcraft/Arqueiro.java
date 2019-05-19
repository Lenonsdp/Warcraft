/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import static warcraft.Orc.noOrc;
import static warcraft.Humano.noHumano;
import warcraft.Raca;

/**
 *
 * @author lenon.060194
 */
public class Arqueiro extends Unidades {

    public Arqueiro(Raca obj, int posX, int posY) {
        if (obj.getComida() > 40 && obj.getOuro() > 20) {

            this.alcance = 7;
            this.armadura = 0;
            this.ataque = 5;
            this.vivo = true;
            this.pontosVitais = 45;
            this.velocidade = 2.0;
            this.pontosVitaisInicial = 45;
            setPosX(posX);
            setPosY(posY);
            System.out.println("Arqueiro gerado");
            obj.unidades.add(this);
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setComida(obj.getComida() - 40);
            obj.setOuro(obj.getOuro() - 20);
            if (obj instanceof Orc) {
                noOrc = noOrc + 1;
            } else {
                noHumano = noHumano + 1;
            }
        } else {
            System.out.println("Sem recursos disponiveis.");
        }
    }

    @Override
    public void ataque(Raca obj, Unidades unidadeAtacada) {
        if (unidadeAtacada.isVivo()) {
            unidadeAtacada.pontosVitais = unidadeAtacada.pontosVitais - (ataque - unidadeAtacada.armadura);
            System.out.println(unidadeAtacada.pontosVitais);
            if (unidadeAtacada.pontosVitais <= 0) {
                unidadeAtacada.vivo = false;
                if (obj instanceof Orc) {
                    noOrc = noOrc - 1;
                    ((Orc) obj).unidades.remove(unidadeAtacada);
                    ((Orc) obj).unidadesMortas.add(unidadeAtacada);
                    System.out.println(noOrc);
                    if (noOrc == 0 || ((Orc) obj).construcoes.size() == 0) {
                        ((Orc) obj).extinta = true;
                    }
                }
                if (obj instanceof Humano) {
                    noHumano = noHumano - 1;
                    ((Humano) obj).unidades.remove(unidadeAtacada);
                    ((Humano) obj).unidadesMortas.add(unidadeAtacada);
                    if (noHumano == 0 || ((Humano) obj).construcoes.size() == 0) {
                        ((Humano) obj).extinta = true;
                    }
                }
            }
        } else {
            System.out.println("Objeto esta morto");
        }
    }

    @Override
    public int getPosX() {
        return this.posX;
    }

    @Override
    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int novaposicao) {
        this.posY = novaposicao;
    }

    public void setPosX(int novaposicao) {
        this.posX = novaposicao;
    }

}
