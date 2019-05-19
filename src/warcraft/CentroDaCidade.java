/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import static warcraft.Humano.noCapacidadeHumano;
import static warcraft.Humano.noHumano;
import static warcraft.Orc.noCapacidadeOrc;
import static warcraft.Orc.noOrc;


/**
 *
 * @author Lenon
 */
public class CentroDaCidade extends Construcoes implements ConstrucoesQueAtacam {

    int ataque;
    Raca dono;

    public CentroDaCidade(Raca obj, Campones camp) {
        if (obj.getMadeira() > 200) {
            this.pontosVitais = 500;
            this.ataque = 50;
            this.alcance = 8;
            this.existente = true;
            System.out.println("Centro da cidade gerado");
            this.posX = camp.getPosX();
            this.posY = camp.getPosY();
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            this.dono = obj;
            obj.setMadeira(obj.getMadeira() - 200);
            obj.construcoes.add(this);
            if (obj instanceof Humano) {
                noCapacidadeHumano += 10;
            }else{
                noCapacidadeOrc += 10;
            }
            
        } else {
            System.out.println("Sem recursos para construir");
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

    public void gerarCampones() {
        Campones camp = new Campones(this.dono, this.posX, this.posY);
    }
}
