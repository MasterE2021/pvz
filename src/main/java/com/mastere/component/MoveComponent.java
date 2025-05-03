package com.mastere.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.LocalTimer;
import com.mastere.enums.Dir;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:38
 */
public class MoveComponent extends Component {

    // 横向变化
    private int deltaX = 0;

    // 纵向变化
    private int deltaY = 0;

    private final LocalTimer shootTimer = FXGL.newLocalTimer();

    private final Dir moveDir = Dir.RIGHT;

    @Override
    public void onUpdate(double tpf) {
        if (deltaX != 0d) {
            // 计算出该速度在x轴上每次刷新移动后的坐标
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 360).mulLocal(deltaX);
            // 改变实体的坐标
            entity.translate(dir);
        }
        if (deltaY != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 90).mulLocal(deltaY);
            entity.translate(dir);
        }
    }


    public void up() {
        deltaY = 10;
    }

    public void left() {
        deltaX = -10;
    }

    public void right() {
        deltaX = 10;
    }

    public void down() {
        deltaY = -10;
    }

    public void stop() {
        deltaX = 0;
        deltaY = 0;
    }

    public void shoot() {
        if (!shootTimer.elapsed(Duration.seconds(0.3))) {
            return;
        }
        spawn("bullet", new SpawnData(getEntity().getCenter().add(-4, -4.5))
                .put("direction", moveDir.getVector())
                .put("owner", entity));
        shootTimer.capture();
    }
}
