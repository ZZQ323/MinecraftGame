package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Ball {
    int x;
    int y;
    int  r;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int  r, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this. r =  r;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if( x-r <= 0){
            x = r;
            xSpeed=(int)Math.abs(xSpeed);
        }else if( x + r >= Gdx.graphics.getWidth() ){
            x = Gdx.graphics.getWidth() - r;
            xSpeed=-(int)Math.abs(xSpeed);
        }

        if( y-r <= 0){
            y = r;
            ySpeed=(int)Math.abs(ySpeed);
        }else if( y + r >= Gdx.graphics.getHeight() ){
            y = Gdx.graphics.getHeight() - r;
            ySpeed=-(int)Math.abs(ySpeed);
        }
    }
    public void draw(ShapeRenderer shape) {
        update();
        shape.setColor(color);
        shape.circle(x, y, r);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            color = Color.GREEN;
            ySpeed = -ySpeed;
        } else {
            color = Color.WHITE;
        }
    }

    public void checkCollision(Block block) {
        if ( collidesWith(block) && !block.destoryed) {
            ySpeed = -ySpeed;
            block.destoryed=true;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        final double eps=1e-12;
        return Math.abs( paddle.x+paddle.width/2 - this.x) <= (this.r + paddle.width/2)   + eps
                && Math.abs(paddle.y + paddle.height/2 - this.y) <= (this.r + paddle.height/2)  + eps;
    }

    private boolean collidesWith(Block block) {
        final double eps=1e-12;
        return Math.abs( block.x+block.width/2 - this.x) <= (this.r + block.width/2)   + eps
                && Math.abs(block.y + block.height/2 - this.y) <= (this.r + block.height/2)  + eps;
    }
}
