package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Block {
    int x,y,width,height;
    boolean destoryed=false;
    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(ShapeRenderer shape){
        if( !destoryed){
            shape.rect(x, y, width, height);
        }
    }

}
