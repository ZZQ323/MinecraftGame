package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Paddle{
    float x;
    float y;

    float width;
    float height;
//    正方形的基准点在左下角

    public Paddle(float initialX, float initialY,
                      float width, float height) {
        this.x = initialX;
        this.y = initialY;
        this.width = width;
        this.height = height;
    }

    void update() {
        if( Gdx.input.getX() <= 0){
            x = 0;
        }else if( Gdx.input.getX() +
                    width >= Gdx.graphics.getWidth() ){
            x = Gdx.graphics.getWidth() - width;
        }else{
            x =Gdx.input.getX();
        }

//      Gdx.input.getY() 返回的光标位置是从屏幕顶部开始计算的
        if( (Gdx.graphics.getHeight() -Gdx.input.getY())
                 <= 0){
            y = 0;
        }else if( (Gdx.graphics.getHeight()- Gdx.input.getY() )
                + height >= Gdx.graphics.getWidth() ){
            y = Gdx.graphics.getWidth()-height;
        }else{
            y =(Gdx.graphics.getHeight()- Gdx.input.getY());
        }
//        y = Gdx.graphics.getHeight()- Gdx.input.getY();
    }

    void draw(ShapeRenderer shape) {
        update();
        shape.rect(x, y, width, height);
    }
}
