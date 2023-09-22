package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class List implements Screen {

     FlappyDemo game;
    Texture img;
    Texture img2;
    Texture iplay;
    TextureRegion play;
   // Texture top;
    static int a =0;


    public List(final FlappyDemo game) {
        this.game = game;
    }
    @Override
    public void show() {
        img = new Texture("bg.png");
        img2 = new Texture("game.jpg");
        iplay = new Texture("spi.png");
        play= new TextureRegion(iplay,0,110,142,77);
       // top = new Texture("toptube.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        game.batch.draw(img2,Gdx.graphics.getWidth()/2,0, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        game.batch.draw(play,Gdx.graphics.getWidth()/4-Gdx.graphics.getWidth()*6/32,Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getWidth()*6/16,Gdx.graphics.getHeight()/8);
        game.batch.draw(play,Gdx.graphics.getWidth()*3/4-Gdx.graphics.getWidth()*6/32,Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getWidth()*6/16,Gdx.graphics.getHeight()/8);
        //game.batch.draw(top,0,0);
        //game.batch.draw(top,top.getWidth(),Gdx.graphics.getHeight()/2);
        if(Gdx.input.getX() > 0
                && Gdx.input.getX() <Gdx.graphics.getWidth()/2
               ){
            if(Gdx.input.justTouched()){
                game.setScreen(new MainGameScreen(game));
                a = 1;
            }
        }else if(Gdx.input.getX() > Gdx.graphics.getWidth()/2
                && Gdx.input.getX() <Gdx.graphics.getWidth()
                ){
            if(Gdx.input.justTouched()){
                game.setScreen(new MainGameScreen(game));
                a = 2;
            }
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
