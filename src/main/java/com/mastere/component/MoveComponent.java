package com.mastere.component;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;

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

}
