/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import static warcraft.Humano.noHumano;
import static warcraft.Orc.noOrc;
import static warcraft.Warcraft.oo;

/**
 *
 * @author Lenon
 */
public class AndarilhoEspiritual extends Unidades {

    int pontosVitaisInicial = 0;
    int mana;

    public AndarilhoEspiritual(Raca obj, int posX, int posY) {
        if (obj.getComida() > 170 && obj.getOuro() > 40) {
            this.setMana(10);
            this.alcance = 10;
            this.armadura = 2;
            this.ataque = 2;
            this.vivo = true;
            this.pontosVitais = 100;
            this.velocidade = 1.0;
            setPosX(posX);
            setPosY(posY);
            System.out.println("Andarilho Espiritual gerado");
            obj.unidades.add(this);
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setComida(obj.getComida() - 170);
            obj.setOuro(obj.getOuro() - 40);
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

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public ArrayList<Objeto> verificarObjMorto(Objeto obj) {
        ArrayList<Objeto> possoReviver = new ArrayList<Objeto>();

        for (Objeto item : Warcraft.oo.unidadesMortas) {
            if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                    && (obj.getPosY() - item.getPosY()) <= obj.alcance) {
                possoReviver.add(item);
            }
        }

        for (Objeto item : Warcraft.hh.unidadesMortas) {
            if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                    && (obj.getPosY() - item.getPosY()) <= obj.alcance) {

                possoReviver.add(item);
            }

        }

        return possoReviver;

    }

    public void revive(Raca orc, Raca humano, Unidades morta, String nome) {
        orc.unidadesMortas.remove(morta);
        humano.unidadesMortas.remove(morta);

        switch (nome) {
            case "Campones":
                if (this.getMana() > 5) {
                    Campones dd = new Campones(oo, this.posX, this.posY);
                    System.out.println("Campones Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;
            case "Guerreiro":
                if (this.getMana() > 5) {
                    Guerreiro gurrr = new Guerreiro(oo, this.posX, this.posY);
                    System.out.println("Guerreiro Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;
            case "Arqueiro":
                if (this.getMana() > 5) {
                    Arqueiro arqq = new Arqueiro(oo, this.posX, this.posY);
                    System.out.println("Arqueiro Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;
            case "Sacerdote":
                if (this.getMana() > 5) {
                    Sacerdote sacc = new Sacerdote(oo, this.posX, this.posY);
                    System.out.println("Sacerdote Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;
            case "AndarilhoEspiritual":
                if (this.getMana() > 5) {
                    AndarilhoEspiritual aaanda = new AndarilhoEspiritual(oo, this.posX, this.posY);
                    System.out.println("AndarilhoEspiritual Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;
            case "Grifo":
                if (this.getMana() > 5) {
                    Grifo voa = new Grifo(oo, this.posX, this.posY);
                    System.out.println("Grifo Ressucitado");
                    this.setMana(this.getMana() - 5);
                    System.out.println("Gasto 5 de mana.");
                } else {
                    System.out.println("Sem mana suficiente");
                }

                break;

        }
    }

}
