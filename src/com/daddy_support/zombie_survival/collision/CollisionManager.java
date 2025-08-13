package com.daddy_support.zombie_survival.collision;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionManager {

    private List<CollisionShape> collisionShapes;
    private CollisionShape currentShape;
    private boolean isEditMode;

    public CollisionManager() {
        collisionShapes = new ArrayList<>();
        isEditMode = false;
    }

    public void toggleEditMode() {
        isEditMode = !isEditMode;
    }

    public boolean isEditMode() {
        return isEditMode;
    }

    //start new shape
    public void startNewShape() {
        if (currentShape != null && !currentShape.isActive()) {
            currentShape = null;
        }

        if (currentShape == null) {
            currentShape = new CollisionShape();
            collisionShapes.add(currentShape);
        }
    }

    public void closeCurrentShape() {
        if (currentShape != null) {
            currentShape.closeShape();
            currentShape = null;
        }
    }

    //add new point to current shape
    public void addVertexToCurrentShape(int x, int y) {
        if (currentShape != null) {
            currentShape.addVertex(x, y);
        }
    }

    public void render(Graphics g, float cameraX, float cameraY) {
        if (!isEditMode) return;

        for (CollisionShape shape : collisionShapes) {
            shape.render(g, cameraX, cameraY);
        }
    }

    public void clearAll() {
        collisionShapes.clear();
        currentShape = null;
    }

    public void removeLastShape() {
        if (!collisionShapes.isEmpty()) {
            collisionShapes.remove(collisionShapes.size() - 1);
        }
    }

    public void snapShotMap(String mapName) {
        saveMap(mapName);
    }

    private void saveMap(String mapName) {
        CollisionSerializer.saveCollisionData(mapName, collisionShapes);
    }

    public void loadMap(String mapName) {
        collisionShapes = CollisionSerializer.loadCollisionData(mapName);
        currentShape = null;
    }

    public boolean checkCollisions(Rectangle playerHitbox) {
        for (CollisionShape shape : collisionShapes) {
            if (shape.isActive() && shape.isClosed()) {
                Rectangle bounds = shape.getBoundingBox();
                if(bounds.intersects(playerHitbox)) {
                    Polygon polygon = shape.getPolygon();
                    if(polygonIntersectsRectangle(polygon, playerHitbox)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean polygonIntersectsRectangle(Polygon polygon , Rectangle playerHitbox) {
        if(polygon.intersects(playerHitbox)) {return true;}

        int[] xPoints = polygon.xpoints;
        int[] yPoints = polygon.ypoints;
        for(int i = 0; i < polygon.npoints; i++) {
            if(playerHitbox.contains(xPoints[i], yPoints[i])) {
                return true;
            }
        }

        return false;
    }

}
