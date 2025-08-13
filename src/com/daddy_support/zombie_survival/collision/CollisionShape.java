package com.daddy_support.zombie_survival.collision;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CollisionShape implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Point> vertices;
    private boolean isClosed;
    private Color drawColor;
    private boolean isActive;

    public CollisionShape(){
        vertices = new ArrayList<>();
        drawColor = new Color(255, 0, 0, 60);
        isActive = true;
    }

    public void addVertex(int x, int y){
        vertices.add(new Point(x, y));
    }

    public void closeShape() {
        if(vertices.size() > 2){
            isClosed = true;
        }
    }

    public void render(Graphics g, float cameraX, float cameraY) {
        if(!isActive || vertices.size() < 2){
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(drawColor);
        g2d.setStroke(new BasicStroke(2));

        Point prevPoint = vertices.getFirst();
        for(int i = 1; i < vertices.size(); i++ ){
            Point currentPoint = vertices.get(i);
            g2d.drawLine((int) (prevPoint.x - cameraX), (int) (prevPoint.y - cameraY),
                    (int) (currentPoint.x - cameraX), (int) (currentPoint.y - cameraY));
            prevPoint = currentPoint;
        }

        if(isClosed && vertices.size() > 2){
            Point firstPoint = vertices.getFirst();
            g2d.drawLine((int) (prevPoint.x - cameraX), (int) (prevPoint.y - cameraY),
                    (int) (firstPoint.x - cameraX), (int) (firstPoint.y - cameraY));
        }

        Polygon polygon = new Polygon();
        for(Point point : vertices){
            polygon.addPoint((int) (point.x - cameraX), (int) (point.y - cameraY));
        }
        g2d.fillPolygon( polygon );

        //draw vertex
        g2d.setColor(Color.YELLOW);
        for(Point point : vertices){
            g2d.fillOval((int) (point.x - cameraX - 3), (int) (point.y - cameraY - 3), 6, 6);
        }

    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isClosed() {
        return isClosed;
    }

    //bounding box smallest x, largest x, smallest y and largest y
    public Rectangle getBoundingBox() {
        if(vertices.isEmpty()){
            return new Rectangle();
        }

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;


        for(Point point : vertices){
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    //polygon
    public Polygon getPolygon() {
        Polygon polygon = new Polygon();
        for(Point point : vertices){
            polygon.addPoint(point.x, point.y);
        }
        return polygon;
    }


}
