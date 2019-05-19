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
public class Campones extends Unidades {

   
    public Campones(Raca obj, int posX, int posY) {
        if (obj.getComida() > 50) {
            this.alcance = 0;
            this.armadura = 0;
            this.ataque = 3;
            this.vivo = true;
            this.pontosVitais = 50;
            this.velocidade = 2.0;
            this.pontosVitaisInicial = 50;
            setPosX(posX);
            setPosY(posY);
            System.out.println("Campones gerado");
            obj.unidades.add(this);
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setComida(obj.getComida() - 50);
            if (obj instanceof Orc) {
                noOrc = noOrc + 1;
            } else {
                noHumano = noHumano + 1;
            }
        } else {
            System.out.println("Sem recursos disponiveis.");
        }
    }

//    public Campones(Raca obj, CentroDaCidade centro) {
//        if (obj.getComida() > 50) {
//            this.alcance = 0;
//            this.armadura = 0;
//            this.ataque = 3;
//            this.estado = true;
//            this.pontosVitais = 50;
//            this.velocidade = 2.0;
//            this.setPosX(centro.getPosX());
//            this.setPosY(centro.getPosY());
//
//            System.out.println("Campones gerado");
//            if (obj instanceof Orc) {
//                noOrc = noOrc + 1;
//                obj.unidades.add(this);
//                System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
//            }
//            if (obj instanceof Humano) {
//                noHumano = noHumano + 1;
//                obj.unidades.add(this);
//                System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
//
//            }
//        } else {
//            System.out.println("Sem recursos disponiveis.");
//        }
//    }
    
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

    public void setMadeira(Raca obj) {
        obj.setMadeira(obj.getMadeira() + 1);
        System.out.println("Sua madeira total agora é " + obj.getMadeira());
    }

    public void setComida(Raca obj) {
        obj.setComida(obj.getComida() + 1);
        System.out.println("Sua comida total agora é " + obj.getComida());
    }

    public void setOuro(Raca obj) {
        obj.setOuro(obj.getOuro() + 1);
        System.out.println("Seu ouro total agora é " + obj.getOuro());
    }

    public void constroi(Raca obj, String tipoConstrucao) {
        if (tipoConstrucao == "Casa") {
            new Casa(obj, this);
        }
        if (tipoConstrucao == "CentroDaCidade") {
            new CentroDaCidade(obj, this);
        }
        if (tipoConstrucao == "Templo") {
            new Templo(obj, this);
        }
        if (tipoConstrucao == "Quartel") {
            new Quartel(obj, this);
        }
//        if (tipoConstrucao == "Torre") {
//            new Torre(obj, this);
//        }

    }

}
