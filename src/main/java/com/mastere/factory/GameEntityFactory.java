package com.mastere.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.mastere.component.MoveComponent;
import com.mastere.enums.GameEntity;
import javafx.geometry.Point2D;


/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:24
 */
public class GameEntityFactory implements EntityFactory {

    public static Entity createEntity(GameEntity type) {
        if (type == null) {
            return null;
        }

        if (GameEntity.PLANT == type) {
            Entity entity = FXGL.entityBuilder().bbox(BoundingShape.box(71, 71)).view("shooterOfPea_04.png").with(new MoveComponent()).build();
            entity.setRotationOrigin(new Point2D(30.5, 30.5));
            entity.setType(GameEntity.PLANT);
            return entity;
        }

        if (GameEntity.ZOMBIE == type) {
            Entity entity = FXGL.entityBuilder().view("zombie_01.gif").with(new MoveComponent()).build();
            entity.setType(GameEntity.ZOMBIE);
            return entity;
        }

        return null;
    }


    @Spawns("bullet")
    public Entity newBullet(SpawnData data) {
        return FXGL.entityBuilder(data).type(GameEntity.PEA).viewWithBBox("pea_01.png").with(new ProjectileComponent(data.get("direction"), 420)).build();
    }
}
