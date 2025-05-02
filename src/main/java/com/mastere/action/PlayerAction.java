package com.mastere.action;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;
import com.mastere.enums.PlayerDire;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 21:00
 */
public class PlayerAction extends UserAction {

    public PlayerAction(PlayerDire dir) {
        super(dir.getName());
    }

    @Override
    protected void onAction() {
        super.onAction();
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.plant);
        String name = super.getName();
        MoveComponent component = entitiesByType.get(0).getComponent(MoveComponent.class);

        if ("up".equals(name)) {
            component.up();
        }
        if ("down".equals(name)) {
            component.down();
        }
        if ("left".equals(name)) {
            component.left();
        }
        if ("right".equals(name)) {
            component.right();
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
