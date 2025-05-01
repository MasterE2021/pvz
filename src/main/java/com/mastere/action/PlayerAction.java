package com.mastere.action;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 21:00
 */
public class PlayerAction extends UserAction {

    public PlayerAction(String dir) {
        super(dir);
    }

    @Override
    protected void onAction() {
        super.onAction();
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
        if ("up".equals(super.getName())) {
            entitiesByType.get(0).getComponent(MoveComponent.class).up();
        }
        if ("down".equals(super.getName())) {
            entitiesByType.get(0).getComponent(MoveComponent.class).down();
        }
        if ("left".equals(super.getName())) {
            entitiesByType.get(0).getComponent(MoveComponent.class).left();
        }
        if ("right".equals(super.getName())) {
            entitiesByType.get(0).getComponent(MoveComponent.class).right();
        }
    }

    @Override
    protected void onActionBegin() {

    }

    @Override
    protected void onActionEnd() {
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
        entitiesByType.get(0).getComponent(MoveComponent.class).stop();
    }
}
