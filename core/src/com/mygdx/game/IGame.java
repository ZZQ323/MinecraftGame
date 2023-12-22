package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;


//，ApplicationAdapter 是一个适配器类，实现了 ApplicationListener 接口。
// ApplicationListener 接口定义了游戏应用程序的生命周期方法，
// 包括 create()、render()、resize() 和 dispose()
public class IGame extends ApplicationAdapter {
	ShapeRenderer shape;
//	ArrayList<Ball> balls = new ArrayList<>();
	Ball ball;
	Paddle rect;
	ArrayList<Block> blocks = new ArrayList<>();


// 游戏启动时调用，通常用于初始化资源、设置初始状态等
	@Override
	public void create() {
		shape = new ShapeRenderer();
		rect=new Paddle(0,0,50,5);
		ball=new Ball(0,0,20,5,5);

		int blockWidth = 63;
		int blockHeight = 20;
		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}


// 在每一帧中调用，用于处理游戏逻辑和渲染
	@Override
	public void render()
	{
//		清除屏幕上的颜色缓冲区，通常是在每一帧的开始时执行，用于准备绘制新的帧
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.setColor(Color.WHITE);
//		对象的绘制，指定画出的是为填充形状。
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.checkCollision(rect);
		rect.draw(shape);
		for(Block block:blocks){
			block.draw(shape);
			ball.checkCollision(block);
		}
		ball.draw(shape);
		shape.end();
	}





// 在窗口大小变化时调用，用于处理游戏逻辑和渲染
	@Override
	public void resize(int width, int height) {
	}

// 游戏暂停时调用，例如切换应用到后台
	@Override
	public void pause() {
	}

// 游戏恢复时调用，例如切换回应用
	@Override
	public void resume() {
	}

// 游戏销毁时调用，通常用于释放资源
	@Override
	public void dispose() {
	}



}
