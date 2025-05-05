package com.mastere.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.mastere.component.PlayerComponent;
import com.mastere.enums.GameEntity;
import javafx.geometry.Point2D;


/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:24
 */
public class GameEntityFactory implements EntityFactory {

    @Spawns("plant")
    public Entity plant(SpawnData data) {
        return FXGL.entityBuilder(data)
                   .type(GameEntity.plant)
                   .bbox(BoundingShape.box(71, 71))
                   .view("shooterOfPea_04.png")
                   .with(new PlayerComponent())
                   .rotationOrigin(new Point2D(30.5, 30.5))
                   .build();
    }

    @Spawns("zombie")
    public Entity zombie(SpawnData data) {
        return FXGL.entityBuilder(data).type(GameEntity.zombie).view("zombie_01.gif").build();
    }

    @Spawns("pea")
    public Entity pea(SpawnData data) {
        return FXGL.entityBuilder(data)
                   .type(GameEntity.pea)
                   .viewWithBBox("pea_01.png")
                   .with(new ProjectileComponent(data.get("direction"), 420))
                   .build();
    }
}
