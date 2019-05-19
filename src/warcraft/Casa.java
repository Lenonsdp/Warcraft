/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

/**
 *
 * @author Lenon
 */
public class Casa extends Construcoes {

    public Casa(Raca obj, Campones camp) {
           if (obj.getMadeira() > 30) {
            this.pontosVitais = 75;
            this.existente = true;
            System.out.println("Casa gerada");
            this.posX = camp.getPosX();
            this.posY = camp.getPosY();
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setMadeira(obj.getMadeira() - 200);
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

}
