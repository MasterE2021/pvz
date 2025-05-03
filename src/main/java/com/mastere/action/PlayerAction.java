package com.mastere.action;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;
import com.mastere.enums.PlayerDire;

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
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.PLANT);
        String name = super.getName();
        Entity entity = entitiesByType.get(0);
        MoveComponent component = entity.getComponent(MoveComponent.class);

        // 添加一个标志位来判断是否已经是镜像状态
        boolean isMirrored = entity.getScaleX() < 0;

        if ("up".equals(name)) {
            component.up();
        }
        if ("down".equals(name)) {
            component.down();
        }
        if ("left".equals(name)) {
            if (!isMirrored) {
                entity.setScaleX(-entity.getScaleX());
            }
            component.left();
        }
        if ("right".equals(name)) {
            if (isMirrored) {
                entity.setScaleX(-entity.getScaleX());
            }
            component.right();
        }
    }

    @Override
    protected void onActionBegin() {

    }

    @Override
    protected void onActionEnd() {
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntity.PLANT);
        entitiesByType.get(0).getComponent(MoveComponent.class).stop();
    }
}
