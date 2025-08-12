package com.daddy_support.zombie_survival.collision;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CollisionSerializer {

    //save
    public static void saveCollisionData(String mapName, List<CollisionShape> collisionShapes) {
        String fileName = "resources/collision/" + mapName + ".col";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(collisionShapes);
        }catch (Exception e) {
            System.out.println("Exception while saving collision data" + e.getMessage());
        }
    }

    //load
    public static List<CollisionShape> loadCollisionData(String mapName) {
        String fileName = "resources/collision/" + mapName + ".col";
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<CollisionShape>) in.readObject();
        }catch (Exception e) {
            System.out.println("Exception while loading collision data : " + mapName);
        }
        return new ArrayList<>();
    }
}
