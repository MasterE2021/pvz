package com.mastere.enums;

import javafx.geometry.Point2D;

/**
 * @author 0pascal
 * @description 方向枚举
 * @date 2025-05-01 12:37
 */
public enum Dir {
    UP(new Point2D(0, -1)),

    RIGHT(new Point2D(1, 0)),

    DOWN(new Point2D(0, 1)),

    LEFT(new Point2D(-1, 0));

    public final Point2D vector;

    Dir(Point2D vector) {
        this.vector = vector;
    }

    public Point2D getVector() {
        return vector;
    }

}
