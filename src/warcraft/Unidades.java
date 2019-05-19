/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import static warcraft.Humano.noHumano;
import static warcraft.Orc.noOrc;

import warcraft.Raca;

/**
 *
 * @author lenon.060194
 */
abstract class Unidades extends Objeto {

    double velocidade;
    int alcance;
    int armadura;
    int ataque;
    boolean vivo;
    String direcao;

    public abstract void ataque(Raca obj, Unidades unidadeAtacada);

    public int getAlcance() {
        return alcance;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getPontosVitais() {
        return pontosVitais;
    }

    public boolean isVivo() {
        return vivo;
    }

    public double getVelocidade() {
        return velocidade;
    }
    
    public abstract void setPosY(int novaposY);

    public abstract void setPosX(int novaposX);

    public void mover(String direcao) {
        switch (direcao) {
            case "NORTE":
                this.setPosY(this.getPosY() + (int) this.getVelocidade());
                System.out.println("Posição atual é (" + this.getPosX() + "," + this.getPosY() + ")");
                break;
            case "SUL":
                if ((this.getPosY() - (int) this.getVelocidade()) < 0.0) {
                    System.out.println("Posição não pode ficar negativa");
                } else {
                    this.setPosY(this.getPosY() - (int) this.getVelocidade());
                    System.out.println("Posição atual é (" + this.getPosX() + "," + this.getPosY() + ")");
                }
                break;
            case "LESTE":
                this.setPosX(this.getPosX() + (int) this.getVelocidade());
                System.out.println("Posição atual é (" + this.getPosX() + "," + this.getPosY() + ")");
                break;
            case "OESTE":
                if (this.getPosX() - (int) this.getVelocidade() < 0) {
                    System.out.println("Posição não pode ficar negativa");
                } else {
                    this.setPosX(this.getPosX() - (int) this.getVelocidade());
                    System.out.println("Posição atual é (" + this.getPosX() + "," + this.getPosY() + ")");
                }
                break;
            default:
                System.out.println("Posição atual invalida");
                break;
        }
    }

    public ArrayList<Objeto> verificarObjProximo(Raca raca, Objeto obj) {
        ArrayList<Objeto> possoAtacar = new ArrayList<Objeto>();
        if (raca instanceof Orc) {
            for (Objeto item : Warcraft.oo.unidades) {
                if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                        && (obj.getPosY() - item.getPosY()) <= obj.alcance) {
                    possoAtacar.add(item);
                }
            }
        }
        if (raca instanceof Humano) {
            for (Objeto item : Warcraft.hh.unidades) {
                if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                        && (obj.getPosY() - item.getPosY()) <= obj.alcance) {

                    possoAtacar.add(item);
                }

            }
        }

        return possoAtacar;

    }

}
