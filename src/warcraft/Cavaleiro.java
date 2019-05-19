/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import static warcraft.Humano.noHumano;
import static warcraft.Orc.noOrc;

/**
 *
 * @author Lenon
 */
public class Cavaleiro extends Unidades {

    public Cavaleiro(Raca obj, int posX, int posY) {
        if (obj.getComida() > 70 && obj.getOuro() > 80) {

            this.alcance = 0;
            this.armadura = 3;
            this.ataque = 12;
            this.vivo = true;
            this.pontosVitais = 180;
            this.velocidade = 4.0;
            this.pontosVitaisInicial = 180;
            setPosX(posX);
            setPosY(posY);
            System.out.println("Cavaleiro gerado");
            obj.unidades.add(this);
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setComida(obj.getComida() - 70);
            obj.setOuro(obj.getOuro() - 80);
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

    @Override
    public void setPosX(int novaposX) {
        this.posX = novaposX;
    }

    @Override
    public void setPosY(int novaposY) {
        this.posY = novaposY;
    }
}
