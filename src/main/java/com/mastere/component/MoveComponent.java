package com.mastere.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;

/**
 * @author 0pascal
 * @description
 * @date 2025-05-01 16:38
 */
public class MoveComponent extends Component {
    private double speedX = 0d;
    private double speedY = 0d;
    private double maxSpeed = 4d;

    @Override
    public void onUpdate(double tpf) {
        if (speedX != 0d) {
            // 计算出该速度在x轴上每次刷新移动后的坐标
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 360).mulLocal(speedX);
            // 改变实体的坐标
            entity.translate(dir);
        }
        if (speedY != 0d) {
            Vec2 dir = Vec2.fromAngle(entity.getRotation() - 90).mulLocal(speedY);
            entity.translate(dir);
        }
    }


    public void up() {
        speedY = maxSpeed;
    }

    public void left() {
        speedX = -maxSpeed;
    }

    public void right() {
        speedX = maxSpeed;
    }

    public void down() {
        speedY = -maxSpeed;
    }

    public void stop() {
        speedX = 0d;
        speedY = 0d;
    }

}
