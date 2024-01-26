package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class FlappyBirdGame extends ApplicationAdapter {
    SpriteBatch spriteBatch;
    Texture backgroundTexture, flappyBirdTexture, bottomTubeTexture, topTubeTexture, gameOverTexture;
    Texture[] birdMotion;

    int flapState = 0, gameState = 0, totalTubes = 10;
    float velocity = 0, birdYposition, gap = 500, distanceBetweenTubes;
    float[] tubeOffset = new float[totalTubes],
            tubeX = new float[totalTubes];
    Random randomGenerator;
    Circle birdCircle;
    Rectangle[] topTubeRectangles, bottomTubeRectangles;
    ShapeRenderer shapeRenderer;


    @Override
    public void create() {
//      Establece el fondo
        spriteBatch = new SpriteBatch();
        backgroundTexture = new Texture("background.png");
//      Mensaje GameOver
        gameOverTexture = new Texture("gameover.png");

//      Animacion Sprites FlappyBird
        birdMotion = new Texture[2];
        birdMotion[0] = new Texture("flappybirdup.png");
        birdMotion[1] = new Texture("flappybirddown.png");
//      Establece a Flappy en la posicion inicial del eje Y
        birdYposition = Gdx.graphics.getHeight() / 2 - birdMotion[0].getHeight() / 2;
//      Sprites tubos
        topTubeTexture = new Texture("toptube.png");
        bottomTubeTexture = new Texture("bottomtube.png");
//      Generador aleatorio de tuberias
        randomGenerator = new Random();
/*
      Para movimiento horizontal tuberias este fragmento se encargará de generar las distancias verticales y horizontales de todas las tuberías que tenemos, en nuestro caso: 10.
*/
        distanceBetweenTubes = Gdx.graphics.getWidth() / 1.75f;

        for (int i = 0; i < totalTubes; i++) {
            tubeOffset[i] = (randomGenerator.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - gap - 940);
            tubeX[i] = Gdx.graphics.getWidth() / 2
                    - topTubeTexture.getWidth() / 2
                    + Gdx.graphics.getWidth()
                    + i
                    * distanceBetweenTubes;
        }

//        Hitbox Flappy
        birdCircle = new Circle();
        shapeRenderer = new ShapeRenderer();

//        Hitbox tuberias
        topTubeRectangles = new Rectangle[totalTubes];
        bottomTubeRectangles = new Rectangle[totalTubes];

        for (int i = 0; i < totalTubes; i++) {
            tubeOffset[i] = (randomGenerator.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - gap - 940);
            tubeX[i] = Gdx.graphics.getWidth() / 2
                    - topTubeTexture.getWidth() / 2
                    + Gdx.graphics.getWidth()
                    + i
                    * distanceBetweenTubes;

            topTubeRectangles[i] = new Rectangle();
            bottomTubeRectangles[i] = new Rectangle();
        }


    }

    public void StartGame() {

        birdYposition = Gdx.graphics.getHeight() / 2 - birdMotion[0].getHeight() / 2;

        for (int i = 0; i < totalTubes; i++) {

            tubeOffset[i] = (randomGenerator.nextFloat() - 0.5f)
                    * (Gdx.graphics.getHeight() - gap - 200);

            tubeX[i] = Gdx.graphics.getWidth() / 2
                    - topTubeTexture.getWidth() / 2
                    + Gdx.graphics.getWidth()
                    + i
                    * distanceBetweenTubes;

            topTubeRectangles[i] = new Rectangle();
            bottomTubeRectangles[i] = new Rectangle();

        }

    }

    @Override
    public void render() {

        spriteBatch.begin();
        spriteBatch.draw(backgroundTexture,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());

        if (gameState == 1) {
            if (Gdx.input.justTouched()) {
                velocity = -30;
            }
            for (int i = 0; i < totalTubes; i++) {
                if (tubeX[i] <- topTubeTexture.getWidth()) {
                    tubeX[i] += totalTubes * distanceBetweenTubes;
                    tubeOffset[i] = (randomGenerator.nextFloat() - 0.5f)
                            * (Gdx.graphics.getHeight() - gap - 940);
                } else {
                    tubeX[i] -= 4*1.5;
                }

                spriteBatch.draw(topTubeTexture,
                        tubeX[i],
                        Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i]);

                spriteBatch.draw(bottomTubeTexture,
                        tubeX[i],
                        Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTubeTexture.getHeight() + tubeOffset[i]);

                topTubeRectangles[i] = new Rectangle(
                        tubeX[i],
                        Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],
                        topTubeTexture.getWidth(),
                        topTubeTexture.getHeight());

                bottomTubeRectangles[i] = new Rectangle(
                        tubeX[i],
                        Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTubeTexture.getHeight() + tubeOffset[i],

                        bottomTubeTexture.getWidth(),
                        bottomTubeTexture.getHeight());

            }
            if (birdYposition > 0){
                velocity += 2;
                birdYposition -= velocity;
            } else {
                gameState = 2;
            }
        } else if (gameState == 0) {
            if (Gdx.input.justTouched()) {
                gameState = 1;
                StartGame();
            }
        } else if (gameState == 2) {

            spriteBatch.draw(gameOverTexture,
                    Gdx.graphics.getWidth() / 2 - gameOverTexture.getWidth() / 2,
                    Gdx.graphics.getHeight() / 2);

            if (Gdx.input.justTouched()) {

                gameState = 1;
                velocity = 1;
                StartGame();
            }
        }

        if (flapState == 0) {
            flapState = 1;
        } else {
            flapState = 0;
        }

        spriteBatch.draw(birdMotion[flapState],
                Gdx.graphics.getWidth() / 2 - birdMotion[flapState].getWidth() / 2,
                birdYposition);

        birdCircle.set(
                Gdx.graphics.getWidth() / 2,
                birdYposition + birdMotion[flapState].getHeight() / 2.1f,
                birdMotion[flapState].getWidth() / 2.1f);


         shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
         shapeRenderer.setColor(Color.BLUE);
         shapeRenderer.circle(birdCircle.x, birdCircle.y, birdCircle.radius);

        for (int i = 0; i < totalTubes; i++) {

            shapeRenderer.rect(
            		tubeX[i],
            		Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],
            		topTubeTexture.getWidth(),
            		topTubeTexture.getHeight());

             shapeRenderer.rect(
            		tubeX[i],
            		Gdx.graphics.getHeight() / 2 - gap / 2- bottomTubeTexture.getHeight() + tubeOffset[i],
            		bottomTubeTexture.getWidth(),
            		bottomTubeTexture.getHeight());

            if (Intersector.overlaps(birdCircle, topTubeRectangles[i])
                    || Intersector.overlaps(birdCircle, bottomTubeRectangles[i])) {
                gameState = 2;
            }
        }
        shapeRenderer.end();
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        backgroundTexture.dispose();
        flappyBirdTexture.dispose();


    }
}
