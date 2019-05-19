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
public class Templo extends Construcoes {
    Raca dono;
    
    public Templo(Raca obj, Campones camp) {
         if (obj.getMadeira() > 250) {
            this.pontosVitais = 350;
            this.existente = true;
            System.out.println("Templo gerado");
            this.posX = camp.getPosX();
            this.posY = camp.getPosY();
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            this.dono = obj;
            obj.setMadeira(obj.getMadeira() - 250);
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
    
    public void geraSacerdote() {
        Sacerdote sacer = new Sacerdote(this.dono, this.posX, this.posY);
    }
     
    public void geraAndarilhoEspiritual(){
        AndarilhoEspiritual aa = new AndarilhoEspiritual(this.dono, this.posX, this.posY);
    }
}
