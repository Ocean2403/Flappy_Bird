package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EndGame  implements Screen {

    FlappyDemo game;
    Texture state ;
    Texture bronze ;
    Texture gray ;
    Texture silver ;
    Texture gold ;
    Texture gameOver;
    Texture spi;
    TextureRegion play;



    public EndGame(final FlappyDemo game) {

        this.game=game;
    }

    @Override
    public void show() {
        state = new Texture("state.png");
        bronze = new Texture("bronze.png");
        gray = new Texture("gray.png");
        silver = new Texture("silver.png");
        gold = new Texture("gold.png");
        gameOver = new Texture("gameOver.png");
        spi = new Texture("spi.png");
        play= new TextureRegion(spi,0,110,142,77);

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(state,Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()*3/8,Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8 -200, Gdx.graphics.getWidth()*3/4,Gdx.graphics.getHeight()/4);
        game.batch.draw(gameOver,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2+200);
        if(Menusreen.score <= 25){
            game.batch.draw(bronze,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2+120, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2-230,Gdx.graphics.getWidth()*5/32,Gdx.graphics.getHeight()*4/32);
        }
        else if(Menusreen.score <= 50){
            game.batch.draw(gray,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2+120, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2-230,Gdx.graphics.getWidth()*5/32,Gdx.graphics.getHeight()*4/32);
        }
        else if (Menusreen.score <=75){
            game.batch.draw(silver,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2+120, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2-230,Gdx.graphics.getWidth()*5/32,Gdx.graphics.getHeight()*4/32);
        }
        else {
            game.batch.draw(gold,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2+120, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2-230,Gdx.graphics.getWidth()*5/32,Gdx.graphics.getHeight()*4/32);
        }
        game.batch.draw(play,Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()*3/16,Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8 -500,Gdx.graphics.getWidth()*3/8,Gdx.graphics.getHeight()/8);

        if (Menusreen.score  < 10){
            game.batch.draw(MainGameScreen.scorei[Menusreen.score],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4+MainGameScreen.scorei[0].getWidth(),Gdx.graphics.getHeight()/2-170);
        } else if(Menusreen.score  < 100  ){
            int a = Menusreen.score  / 10;
            int b = Menusreen.score  % 10;
            game.batch.draw(MainGameScreen.scorei[a],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/2-170);
            game.batch.draw(MainGameScreen.scorei[b],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4+MainGameScreen.scorei[0].getWidth(),Gdx.graphics.getHeight()/2-170);
        } else if( Menusreen.score ==100)
        {
            game.batch.draw(MainGameScreen.scorei[1],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4-MainGameScreen.scorei[1].getWidth()*7/8,Gdx.graphics.getHeight()/2-170);
            game.batch.draw(MainGameScreen.scorei[0],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/2-170);
            game.batch.draw(MainGameScreen.scorei[0],Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/4+MainGameScreen.scorei[0].getWidth(),Gdx.graphics.getHeight()/2-170);
        }

        game.batch.end();

        if(
                Gdx.input.getX() > Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()*3/16
                        &&
                        Gdx.input.getX() < Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()*3/16
                        &&
                        Gdx.input.getY() > Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8 -500+Gdx.graphics.getHeight()/8-20)
                        &&
                        Gdx.input.getY() < Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/8 -500)
        ) {
            if(Gdx.input.justTouched()){
                game.setScreen(new Menusreen(game));
            }
        }
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
