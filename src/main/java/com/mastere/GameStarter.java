package com.mastere;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import com.almasb.fxgl.core.*;
import com.almasb.fxgl.dsl.FXGL;
import com.mastere.enums.GameEntity;
import com.mastere.factory.GameEntityFactory;

import java.util.Objects;

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
        FXGL.getGameWorld().addEntity(GameEntityFactory.createEntity(GameEntity.plant));
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