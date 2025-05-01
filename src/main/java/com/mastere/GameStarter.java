package com.mastere;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;
import com.mastere.factory.GameEntityFactory;
import javafx.scene.input.KeyCode;

import java.util.List;

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

        FXGL.getInput().addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).up();
            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).down();

            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.S);

        FXGL.getInput().addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).left();

            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.A);


        FXGL.getInput().addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                super.onAction();
            }

            @Override
            protected void onActionBegin() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).right();

            }

            @Override
            protected void onActionEnd() {
                List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
                entitiesByType.get(0).getComponent(MoveComponent.class).stop();
            }
        }, KeyCode.D);
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