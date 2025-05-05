package com.mastere;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.mastere.action.PlayerAction;
import com.mastere.enums.Action;
import com.mastere.factory.GameEntityFactory;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.spawn;


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
        FXGL.getGameWorld().addEntityFactory(new GameEntityFactory());

        FXGL.getGameWorld().addEntity(spawn("plant", 300, 300));
        FXGL.getGameWorld().addEntity(spawn("zombie", 500, 300));
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new PlayerAction(Action.up), KeyCode.W);
        FXGL.getInput().addAction(new PlayerAction(Action.down), KeyCode.S);
        FXGL.getInput().addAction(new PlayerAction(Action.left), KeyCode.A);
        FXGL.getInput().addAction(new PlayerAction(Action.right), KeyCode.D);
        FXGL.getInput().addAction(new PlayerAction(Action.shoot), KeyCode.SPACE);
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