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
public abstract class Objeto {
    int pontosVitaisInicial;
    int pontosVitais;
    String imagem;
    protected int posX;
    protected int posY;
    public int alcance = 0; 
    protected boolean vivo;
    
    public abstract int getPosX();

    public abstract int getPosY();
}
