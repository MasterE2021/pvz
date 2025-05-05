package com.mastere.action;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.mastere.component.PlayerComponent;
import com.mastere.factory.GameEntityFactory;

import java.util.List;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 21:00
 */
public class PlayerAction extends UserAction {

    public enum Action {
        up, down, left, right, shoot;
    }

    public PlayerAction(PlayerAction.Action action) {
        super(action.name());
    }

    @Override
    protected void onAction() {
        super.onAction();
        List<Entity> entitiesByType = FXGL.getGameWorld().getEntitiesByType(GameEntityFactory.GameEntity.plant);
        String name = super.getName();
        Entity entity = entitiesByType.get(0);
        PlayerComponent component = entity.getComponent(PlayerComponent.class);

        // 添加一个标志位来判断是否已经是镜像状态
        boolean isMirrored = entity.getScaleX() < 0;

        if (PlayerAction.Action.up.name().equals(name)) {
            component.up();
        }
        if (PlayerAction.Action.down.name().equals(name)) {
            component.down();
        }
        if (PlayerAction.Action.left.name().equals(name)) {
            if (!isMirrored) {
                entity.setScaleX(-entity.getScaleX());
            }
            component.left();
        }
        if (PlayerAction.Action.right.name().equals(name)) {
            if (isMirrored) {
                entity.setScaleX(-entity.getScaleX());
            }
            component.right();
        }
        if (PlayerAction.Action.shoot.name().equals(name)) {
            component.shoot();
        }
    }
}
