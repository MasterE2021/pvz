package com.mastere.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import com.mastere.enums.Dir;
import com.mastere.factory.GameEntityFactory;
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


    private double speed = 0;

    private final Vec2 velocity = new Vec2();

    private final LocalTimer shootTimer = FXGL.newLocalTimer();

    private Dir moveDir = Dir.RIGHT;

    @Override
    public void onUpdate(double tpf) {
        speed = tpf * PLAYER_SPEED;
    }

    public void up() {
        moveDir = Dir.UP;
        move();
    }

    public void left() {
        moveDir = Dir.LEFT;
        move();
    }

    public void right() {
        moveDir = Dir.RIGHT;
        move();
    }

    public void down() {
        moveDir = Dir.DOWN;
        move();
    }

    public void shoot() {
        if (!shootTimer.elapsed(Duration.seconds(0.5))) {
            return;
        }
        Point2D vector = moveDir.getVector();
        Point2D shootLine = getEntity().getCenter().add(0, -30);
        Point2D point2D = shootLine.add(vector.getX() > 0 ? -11 : -49, 0);
        SpawnData spawnData = new SpawnData(point2D).put("direction", vector).put("owner", entity);
        spawn(GameEntityFactory.GameEntity.pea.name(), spawnData);
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
