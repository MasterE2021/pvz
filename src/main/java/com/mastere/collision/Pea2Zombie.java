package com.mastere.collision;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.mastere.factory.GameEntityFactory;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-05 23:30
 */
public class Pea2Zombie extends CollisionHandler {

    public Pea2Zombie() {
        super(GameEntityFactory.GameEntity.pea, GameEntityFactory.GameEntity.zombie);
    }

    protected void onCollisionBegin(Entity pea, Entity zombie) {
        pea.removeFromWorld();
        zombie.removeFromWorld();
    }
}
