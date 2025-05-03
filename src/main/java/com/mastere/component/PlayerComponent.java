package com.mastere.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import com.mastere.enums.Dir;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:38
 */
public class PlayerComponent extends Component {
    private final static int PLAYER_SPEED = 100;

    private boolean movedThisFrame = false;

    private double speed = 0;

    private Vec2 velocity = new Vec2();

    private final LocalTimer shootTimer = FXGL.newLocalTimer();

    private Dir moveDir;

    @Override
    public void onUpdate(double tpf) {
        speed = tpf * PLAYER_SPEED;
        movedThisFrame = false;
    }


    public void up() {
        if (movedThisFrame) {
            return;
        }
        movedThisFrame = true;
        moveDir = Dir.UP;
        move();
    }

    public void left() {
        if (movedThisFrame) {
            return;
        }
        movedThisFrame = true;
        moveDir = Dir.LEFT;
        move();
    }

    public void right() {
        if (movedThisFrame) {
            return;
        }
        movedThisFrame = true;
        moveDir = Dir.RIGHT;
        move();
    }

    public void down() {
        if (movedThisFrame) {
            return;
        }
        movedThisFrame = true;
        moveDir = Dir.DOWN;
        move();
    }

    public void shoot() {
        if (!shootTimer.elapsed(Duration.seconds(0.5))) {
            return;
        }
        Point2D point2D = getEntity().getCenter().add(-11, -30);
        SpawnData spawnData = new SpawnData(point2D).put("direction", moveDir.getVector()).put("owner", entity);
        spawn("bullet", spawnData);
        shootTimer.capture();
    }

    private void move() {
        if (!getEntity().isActive()) {
            return;
        }
        Point2D vector = moveDir.getVector();
        float xSpeed = (float) (vector.getX() * speed);
        float ySpeed = (float) (vector.getY() * speed);
        velocity.set(xSpeed, ySpeed);
        velocity.normalizeLocal();
        entity.translate(velocity.x, velocity.y);
    }
}
