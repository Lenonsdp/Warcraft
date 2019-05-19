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
public class Torre extends Construcoes implements ConstrucoesQueAtacam {

    int ataque;

    @Override
    public void ataque(Raca obj, Unidades unidadeAtacada) {
        unidadeAtacada.pontosVitais = unidadeAtacada.pontosVitais - ataque;
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
