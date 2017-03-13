package bsuir.db;

import bsuir.entity.Model;
import bsuir.entity.Ship;

import java.util.Collection;

public interface ISeaportHelper {
    void addModel(String name, int seats);
    Collection<Model> getModels();
    Model getModelById(int id);
    void updateModel(int id, String name, int seats);
    void deleteModel(int id);

    void addShip(String id, int idModel);
    Collection<Ship> getShips();
    Ship getShipById(String id);
    void updateShip(String id, int idModel);
    void deleteShip(String id);
}
