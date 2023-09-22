package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Menusreen implements Screen {
     FlappyDemo game;
    Texture img;
    Texture spi;
    TextureRegion play;
    TextureRegion exit;
    TextureRegion title;
    float playwidth ;
    float playheight ;
    float playX ;
    float playY ;

    float exitwidth  ;
    float exitheight  ;
    float exitX ;
    float exitY ;
    static int score;


    public Menusreen(final FlappyDemo game) {
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("bg.png");
        spi = new Texture("spi.png");
        play= new TextureRegion(spi,0,110,142,77);
        exit= new TextureRegion(spi,0,275,140,80);
        title = new TextureRegion(spi,1097,0,235,73);

        playwidth = Gdx.graphics.getWidth()*6/16;
        playheight= Gdx.graphics.getHeight()/8;
        playX = Gdx.graphics.getWidth()/4-playwidth/2;
        playY = Gdx.graphics.getHeight()*3/8-playheight/2;

        exitwidth = Gdx.graphics.getWidth()*6/16;
        exitheight = Gdx.graphics.getHeight()/8;
        exitX = Gdx.graphics.getWidth()*3/4-exitwidth/2;
        exitY = Gdx.graphics.getHeight()*3/8-exitheight/2;
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch.draw(play,playX,playY,playwidth,playheight);
        game.batch.draw(exit,exitX,exitY,exitwidth,exitheight);
        game.batch.draw(title,Gdx.graphics.getWidth()/2-title.getRegionWidth()*11/12,Gdx.graphics.getHeight()/2-title.getRegionHeight()/2,exitwidth,exitheight);
//        if(     Gdx.input.getX() > Gdx.graphics.getWidth()/2-play.getRegionWidth()/2 &&
//                Gdx.input.getX() < Gdx.graphics.getWidth()/2+play.getRegionWidth()/2 &&
//                Gdx.input.getY() > Gdx.graphics.getHeight()/2-play.getRegionHeight()/2 &&
//                Gdx.input.getY() < Gdx.graphics.getHeight()/2+play.getRegionHeight()/2
//        ){
//            if(Gdx.input.justTouched()){
//                game.setScreen(new List(game));
//            }
//        }
//
//        if(     Gdx.input.getX() > Gdx.graphics.getWidth()/2-exit.getRegionWidth()/2 &&
//                Gdx.input.getX() < Gdx.graphics.getWidth()/2+exit.getRegionWidth()/2 &&
//                Gdx.input.getY() > Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/2-distance+exit.getRegionHeight()/2) &&
//                Gdx.input.getY() < Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/2-distance-exit.getRegionHeight()/2))
//        {
//            if(Gdx.input.justTouched()){
//                Gdx.app.exit();
//            }
//        }

        if(
                Gdx.input.getX() > playX
                        &&
                        Gdx.input.getX() < playX+ playwidth
                        &&
                        Gdx.input.getY() > Gdx.graphics.getHeight()-(playY+playheight)
                        &&
                        Gdx.input.getY() < Gdx.graphics.getHeight()-(playY)
        ){
            if(Gdx.input.justTouched()){
                game.setScreen(new List(game));
            }
        }

        if(
                Gdx.input.getX() > exitX
                        &&
                        Gdx.input.getX() < exitX+ exitwidth
                        &&
                        Gdx.input.getY() > Gdx.graphics.getHeight()-(exitY+exitheight)
                        &&
                        Gdx.input.getY() < Gdx.graphics.getHeight()-(exitY)
        ) {
            if(Gdx.input.justTouched()){
                Gdx.app.exit();
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
/*Draw thi x0 y0 nằm góc trái dưới
* điều kiện input và cắt hình thì x0 y0 nằm góc trái trên*/