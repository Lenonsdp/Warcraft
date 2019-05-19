/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import javafx.geometry.Insets;

/**
 *
 * @author lenon.060194
 */
interface ConstrucoesQueAtacam {

    public abstract void ataque(Raca obj, Unidades unidadeAtacada);

    public default ArrayList<Objeto> verificarObjProximo(Raca raca, Objeto obj) {
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
