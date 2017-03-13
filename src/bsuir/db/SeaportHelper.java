package bsuir.db;

import bsuir.entity.Model;
import bsuir.entity.Ship;

import java.util.Collection;

public class SeaportHelper implements ISeaportHelper {

    private static SeaportHelper instance;

    private SeaportHelper() {}

    public static ISeaportHelper getInstance() {
        if (instance == null) {
            instance = new SeaportHelper();
        }
        return instance;
    }

    @Override
    public void addModel(String name, int seats) {
        HibernateUtil.addModel(name, seats);
    }

    @Override
    public Collection<Model> getModels() {
        return HibernateUtil.getModels();
    }

    @Override
    public Model getModelById(int id) {
        return HibernateUtil.getModelById(id);
    }

    @Override
    public void updateModel(int id, String name, int seats) {
        HibernateUtil.updateModel(id, name, seats);
    }

    @Override
    public void deleteModel(int id) {
        HibernateUtil.deleteModel(id);
    }

    @Override
    public void addShip(String id, int idModel) {
        HibernateUtil.addShip(id, idModel);
    }

    @Override
    public Collection<Ship> getShips() {
        return HibernateUtil.getShips();
    }

    @Override
    public Ship getShipById(String id) {
        return HibernateUtil.getShipById(id);
    }

    @Override
    public void updateShip(String id, int idModel) {
        HibernateUtil.updateShip(id, idModel);
    }

    @Override
    public void deleteShip(String id) {
        HibernateUtil.deleteShip(id);
    }
}
