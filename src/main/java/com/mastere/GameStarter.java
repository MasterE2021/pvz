package com.mastere;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import com.almasb.fxgl.dsl.FXGL;
import com.mastere.action.PlayerAction;
import com.mastere.enums.GameEntity;
import com.mastere.enums.PlayerDire;
import com.mastere.factory.GameEntityFactory;
import javafx.scene.input.KeyCode;


/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 12:37
 */
public class GameStarter extends GameApplication {

    public static void main(String[] args) {
        GameStarter.launch(args);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntity(GameEntityFactory.createEntity(GameEntity.PLANT));

        FXGL.getInput().addAction(new PlayerAction(PlayerDire.UP), KeyCode.W);
        FXGL.getInput().addAction(new PlayerAction(PlayerDire.DOWN), KeyCode.S);
        FXGL.getInput().addAction(new PlayerAction(PlayerDire.LEFT), KeyCode.A);
        FXGL.getInput().addAction(new PlayerAction(PlayerDire.RIGHT), KeyCode.D);


        FXGL.getGameWorld().addEntity(GameEntityFactory.createEntity(GameEntity.ZOMBIE));
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(28 * 24 + 6 * 24);
        settings.setHeight(28 * 24);
        settings.setTitle("植物大战僵尸");
        settings.setAppIcon("logo.png");
        settings.setVersion("0.1");
    }
}