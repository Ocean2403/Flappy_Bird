package com.mygdx.game;

import static com.mygdx.game.List.a;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class MainGameScreen implements Screen {

    FlappyDemo game;
    SpriteBatch batch;
    Texture background;
    Texture bg;
    Texture ground;
    Texture[] birds;
    TextureRegion[] textureRegion;
    Texture topTube;
    Texture botTube;
    Texture tap;
    Texture ready;
    int flapState = 0;/*cho giá trị ban đầu bằng không*/
    float birdY=0;
    float velocity =0;
    int gameState =0;
    float gravity = 1;
    float gap =400;/*khoảng cách  giữa cột trên và cột dưới*/
    float maximumOffset;
    Random randomcot;
    float tubeVelocity = 10;/*vận tốc ống*/
    int numberOfTubes = 20;/*số lượng ống*/
    //???
    float [] tubeX = new float[numberOfTubes];/*mảng tọa độ X của các ống*/
    //???
    float [] tubeOffset = new float[numberOfTubes];
    //???
    float distanceBottomTubes;
    //????
    //BitmapFont bf;
    ///???
    Circle birdCircle ;
    ShapeRenderer shapeRenderer ;
    Rectangle[] toptubeRectangle;
    Rectangle [] bottubeRectangle;
    Rectangle groundRectangle;
    Rectangle groundRectangle2;
    //???

    int scoreingtube = 0;
    static Texture[] scorei;

    Texture gameOver;
    int k =1;

    //Music music;

    public MainGameScreen(FlappyDemo game) {
        this.game=game;
    }
    @Override
    public void show() {
        //???

        Menusreen.score=0;
        birdCircle = new Circle();
        shapeRenderer = new ShapeRenderer();
        toptubeRectangle = new Rectangle[numberOfTubes];
        bottubeRectangle = new Rectangle[numberOfTubes];
        groundRectangle = new Rectangle();
        groundRectangle2 = new Rectangle();

        batch = new SpriteBatch();

        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        birds = new Texture[2];
        birds[0] = new Texture("bird.png");
        birds[1] = new Texture("bird2.png");/*tạo biến để gán địa chỉ hình con chim*/

        tap = new Texture("tap.png");
        ready = new Texture("ready.png");
        scorei = new Texture[10];
        scorei[0] = new Texture("0.png");
        scorei[1] = new Texture("1.png");
        scorei[2] = new Texture("2.png");
        scorei[3] = new Texture("3.png");
        scorei[4] = new Texture("4.png");
        scorei[5] = new Texture("5.png");
        scorei[6] = new Texture("6.png");
        scorei[7] = new Texture("7.png");
        scorei[8] = new Texture("8.png");
        scorei[9] = new Texture("9.png");

        gameOver = new Texture("gameOver.png");

        birdY= Gdx.graphics.getHeight()/2-birds[flapState].getHeight()/2;


        //??????
        //maximumOffset = Gdx.graphics.getHeight() / 2 -gap / 2 - 100;
        randomcot = new Random();
        //???
        distanceBottomTubes = Gdx.graphics.getWidth() *6/10;/*Khoảng cách giữa các ống */
        //???
        //bf = new BitmapFont();/*ánh xạ viết chữ bằng thư viện libGDx*/

        for (int i = 0; i < numberOfTubes; i++){
            //????
            tubeOffset[i] =(randomcot.nextFloat() -0.5f) * (Gdx.graphics.getHeight()/5 /*- 400 - gap - 200*/);/*randomcot.nextFloat() trả về giá trị random nằm trong khoảng từ 0.0 đến 1.0*/
            //????
            tubeX[i] = Gdx.graphics.getWidth() +i *distanceBottomTubes;/*Vị trí của các cột các nhau 1 khoảng cách , cột đầu tiên sẽ tù bên trái vào*/


            //????
            toptubeRectangle[i] = new Rectangle();
            bottubeRectangle[i] = new Rectangle();
        }

    }

//    public void Startgame()
//    {
//        Menusreen.score =0;
//        scoreingtube = 0;
//        velocity =0;
//        birdY=Gdx.graphics.getHeight()/2-birds[flapState].getHeight()/2;
//        //music = Gdx.audio.newMusic(Gdx.files.internal("t.mp3"));
//
//        for (int i = 0; i < numberOfTubes; i++){
//            //????
//            tubeOffset[i] =(randomcot.nextFloat() -0.5f) * (Gdx.graphics.getHeight() - gap - 100 - gap - 200);/*randomcot.nextFloat() trả về giá trị random nằm trong khoảng từ 0.0 đến 1.0*/
//            //????
//            tubeX[i] = Gdx.graphics.getWidth() +i *distanceBottomTubes;/*Vị trí của các cột các nhau 1 khoảng cách , cột đầu tiên sẽ tù bên trái vào*/
//
//            //????
//            toptubeRectangle[i] = new Rectangle();
//            bottubeRectangle[i] = new Rectangle();/*hàm start này sẽ sử dụng hàm render*/
//
//        }
//    }

    @Override
    public void render(float delta) {

        if(a == 1) {

            if ( Menusreen.score  < 5 || 20< Menusreen.score ) {

                background = new Texture("bg.png");/*tạo để gán địa chỉ biến  hình nền*/

            } else {
                background = new Texture("night.png");/*tạo để gán địa chỉ biến  hình nền*/
                tubeVelocity = (float) (tubeVelocity +0.005);
            }
            topTube = new Texture("toptube.png");
            botTube = new Texture("bottomtube.png");
        }
        else if(a ==2){
            if (Menusreen.score  < 5 || 20< Menusreen.score ) {
                background = new Texture("game.jpg");/*tạo để gán địa chỉ biến  hình nền*/
            } else {
                background = new Texture("night.png");/*tạo để gán địa chỉ biến  hình nền*/
                tubeVelocity = (float) (tubeVelocity +0.005);
            }
            topTube = new Texture("tree2.png");
            botTube = new Texture("tree1.png");
        }

        game.batch.begin();
        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());/* Cái Gdx.graphics.getWidth(), Gdx.graphics.getHeight() giúp background tràn màn hình, vẽ trước mắc công đè lên hình ống thì không thấy ống*/

        if(gameState == 1){
            //Gdx.app.log("loi",String.valueOf(gameState));
            //???
            if(tubeX[scoreingtube] < Gdx.graphics.getWidth()/2){
                Menusreen.score  ++;
               // Gdx.app.log("Score",String.valueOf(Menusreen.score ));
                if(scoreingtube < numberOfTubes-1)
                {
                    scoreingtube ++;
                }else {
                    scoreingtube = 0;
                }
            }

            if(Gdx.input.justTouched())
            {
                velocity=-17;

                if(flapState ==0){
                    flapState =1;
                } else {
                    flapState = 0;
                }
                /*cho giá trị thay đổi luân phiên để như chim đang đập cánh)%cho giá trị thay đổi luân phiên để như chim đang đập cánh*/
            }

            for (int i = 0; i < numberOfTubes; i++){
                //???
                if(tubeX[i] < -topTube.getWidth()){/*bắt điều kiện khi cột di chuyển biến mất bên trái thì nó sẽ được lặp lại sau sỗ cột đã chỉ định*/
                    tubeX[i] +=numberOfTubes * distanceBottomTubes;/*vị trí lúc sau của cột đó là lúc bắt đầu khi các cột ban đầu được thiết lập sẵn chạy xong*/
                } else {
                    //????
                    tubeX[i] = tubeX[i] - tubeVelocity;/*Thay dổi vị trí của các cột bằng cách vị trí ban đầu trừ đi để nó dịch sang trái*/


                }

                {
                    //?????
                    game.batch.draw(topTube,  tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 +tubeOffset[i]);/*vẽ cột trên */
                    game.batch.draw(botTube,  tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - botTube.getHeight() +tubeOffset[i] );/*vẽ cột dưới cho dòng này trước vẽ đất để đất đè lên*/

                    //???
                    toptubeRectangle[i] = new Rectangle(tubeX[i], Gdx.graphics.getHeight() / 2 + gap /2 + tubeOffset[i], topTube.getWidth(), topTube.getHeight());
                    bottubeRectangle[i] = new Rectangle(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - botTube.getHeight() +tubeOffset[i], botTube.getWidth(), botTube.getHeight());
                    groundRectangle= new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/10);
                    groundRectangle2= new Rectangle(0, Gdx.graphics.getHeight() , Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/10);

                }

            }

            if(birdY >0 /*|| velocity < 0*/){

                velocity=velocity + gravity ;
                birdY -= velocity;
            }else {
                gameState = 2;
            }

        }
        else if(gameState == 0) {
            game.batch.draw(tap,Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 ,Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/8 , Gdx.graphics.getWidth()/4 ,Gdx.graphics.getHeight()/4 );/*vẽ cột dưới cho dòng này trước vẽ đất để đất đè lên*/
            game.batch.draw(ready,Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/4  ,Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/6 , Gdx.graphics.getWidth()/2 , Gdx.graphics.getHeight()/20);/*vẽ cột dưới cho dòng này trước vẽ đất để đất đè lên*/

            if (Gdx.input.justTouched()) {

                gameState = 1;

            }
        }
        else if(gameState == 2){
//            game.batch.draw(gameOver,Gdx.graphics.getWidth()/2-gameOver.getWidth()/2, Gdx.graphics.getHeight()/2-gameOver.getHeight()/2);
//
//            if(Gdx.input.getX() > Gdx.graphics.getWidth()/2 - gameOver.getWidth()/2
//                    && Gdx.input.getX() < Gdx.graphics.getWidth()/2+gameOver.getWidth()/2
//                    && Gdx.input.getY() > Gdx.graphics.getHeight()/2 - gameOver.getHeight()/2
//                    && Gdx.input.getY() < Gdx.graphics.getHeight()/2 + gameOver.getHeight()/2){
//                if(Gdx.input.justTouched()){
//
//                    gameState=0;
//                    Startgame();
//                }
//            }
            game.setScreen(new EndGame(game));
        }
//        if(gameState == 0){
//            game.batch.draw(tap,Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 ,Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/8 , Gdx.graphics.getWidth()/4 ,Gdx.graphics.getHeight()/4 );/*vẽ cột dưới cho dòng này trước vẽ đất để đất đè lên*/
//            game.batch.draw(ready,Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/4  ,Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/6 , Gdx.graphics.getWidth()/2 , Gdx.graphics.getHeight()/20);/*vẽ cột dưới cho dòng này trước vẽ đất để đất đè lên*/
//
//        }
        game.batch.draw(ground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/10);
        game.batch.draw(birds[flapState],  Gdx.graphics.getWidth()/2-birds[flapState].getWidth()/2, birdY);/*khai báo để biết hình con chim tại trị trí trục x và y*/

        if (   Menusreen.score <10  ){
            game.batch.draw(scorei[Menusreen.score ],Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()-200);

        }
        else
            if(   Menusreen.score  <100){
            int a = Menusreen.score  / 10;
             int b = Menusreen.score  % 10;
            game.batch.draw(scorei[a],Gdx.graphics.getWidth()/2-scorei[a].getWidth()/2,Gdx.graphics.getHeight()-200);
            game.batch.draw(scorei[b],Gdx.graphics.getWidth()/2+scorei[b].getWidth()/2,Gdx.graphics.getHeight()-200);

        }
        else if(Menusreen.score == 100)
        {
            game.batch.draw(scorei[1],Gdx.graphics.getWidth()/2-scorei[1].getWidth()*7/8,Gdx.graphics.getHeight()-200);
            game.batch.draw(scorei[0],Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()-200);
            game.batch.draw(scorei[0],Gdx.graphics.getWidth()/2+scorei[0].getWidth(),Gdx.graphics.getHeight()-200);
            game.setScreen(new EndGame(game));
        }
        //???
        //bf.draw(batch, "Your text", Gdx.graphics.getWidth()/2-50,Gdx.graphics.getWidth() -300 );
        //bf.getData().setScale(10,10);
        game.batch.end();
        //???
        //shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //shapeRenderer.setColor(Color.BLACK);
        birdCircle.set(Gdx.graphics.getWidth() / 2, birdY +birds[flapState].getHeight()/2, birds[flapState].getWidth()/2);
        //shapeRenderer.circle(birdCircle.x, birdCircle.y, birdCircle.radius);

        for (int i = 0; i < numberOfTubes; i++){
            //shapeRenderer.rect(tubeX[i], Gdx.graphics.getHeight() / 2 + gap /2 + tubeOffset[i], topTube.getWidth(), topTube.getHeight());
            //shapeRenderer.rect(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - botTube.getHeight() +tubeOffset[i], botTube.getWidth(), botTube.getHeight());

            if(Intersector.overlaps(birdCircle, toptubeRectangle[i]) || Intersector.overlaps(birdCircle, bottubeRectangle[i]) || Intersector.overlaps(birdCircle, groundRectangle) || Intersector.overlaps(birdCircle, groundRectangle2) ){
                //Gdx.app.log("loi","Hello");
                //Gdx.app.exit();
                gameState = 2;

            }
        }


        //shapeRenderer.end();

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

        batch.dispose();

    }
}
/*cHỈNH SUA LAI COT VÃN CÒN SAI*/
