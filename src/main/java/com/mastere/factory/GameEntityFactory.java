package com.mastere.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;


/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:24
 */
public class GameEntityFactory {

    public static Entity createEntity(GameEntity type) {
        if (type == null) {
            return null;
        }

        if (GameEntity.PLANT == type) {
            Entity entity = FXGL.entityBuilder().view("shooterOfPea_04.png").with(new MoveComponent()).build();
            entity.setType(GameEntity.PLANT);
            return entity;
        }
        return null;
    }
}
