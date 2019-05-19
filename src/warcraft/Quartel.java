/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import static warcraft.Humano.noCapacidadeHumano;
import static warcraft.Orc.noCapacidadeOrc;

/**
 *
 * @author Lenon
 */
public class Quartel extends Construcoes {

    Raca dono;

    public Quartel(Raca obj, Campones camp) {
        if (obj.getMadeira() > 125) {
            this.pontosVitais = 350;
            this.alcance = 8;
            this.existente = true;
            this.dono = obj;
            System.out.println("Quartel Gerado");
            this.posX = camp.getPosX();
            this.posY = camp.getPosY();
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setMadeira(obj.getMadeira() - 125);
            obj.construcoes.add(this);
        } else {
            System.out.println("Sem recursos para construir");
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

    public void geraGuerreiro() {
        Guerreiro guer = new Guerreiro(this.dono, this.posX, this.posY);
    }

    public void geraCavaleiro() {
        Cavaleiro caval = new Cavaleiro(this.dono, this.posX, this.posY);
    }

    public void geraArqueiro() {
        Arqueiro arqu = new Arqueiro(this.dono, this.posX, this.posY);
    }

    public void geraGrifo() {
        Grifo gri = new Grifo(this.dono, this.posX, this.posY);
    }
}
