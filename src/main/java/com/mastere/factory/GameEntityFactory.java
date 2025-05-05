package com.mastere.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.mastere.component.PlayerComponent;
import javafx.geometry.Point2D;


/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:24
 */
public class GameEntityFactory implements EntityFactory {

    public enum GameEntity {
        plant, zombie, pea
    }

    @Spawns("plant")
    public Entity plant(SpawnData data) {
        return FXGL.entityBuilder(data)
                   .type(GameEntityFactory.GameEntity.plant)
                   .view("shooterOfPea_04.gif")
                   .with(new PlayerComponent())
                   .bbox(BoundingShape.box(71, 71))
                   .rotationOrigin(new Point2D(30.5, 30.5))
                   .collidable()
                   .build();
    }

    @Spawns("zombie")
    public Entity zombie(SpawnData data) {
        return FXGL.entityBuilder(data)
                   .type(GameEntityFactory.GameEntity.zombie)
                   .bbox(BoundingShape.box(81, 120))
                   .rotationOrigin(new Point2D(40.5, 60))
                   .view("zombie_01.gif")
                   .collidable()
                   .build();
    }

    @Spawns("pea")
    public Entity pea(SpawnData data) {
        return FXGL.entityBuilder(data)
                   .type(GameEntityFactory.GameEntity.pea)
                   .bbox(new HitBox(new Point2D(0, 0), BoundingShape.circle(12)))
                   .rotationOrigin(new Point2D(0, 0))
                   .view("pea_01.png")
                   .with(new ProjectileComponent(data.get("direction"), 420))
                   .collidable()
                   .build();
    }
}
