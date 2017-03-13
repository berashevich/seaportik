package bsuir.entity;

public class Ship {
    private String id;
    private Model model;

    public Ship() {}

    public Ship(String id, Model model) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (id != null ? !id.equals(ship.id) : ship.id != null) return false;
        return !(model != null ? !model.equals(ship.model) : ship.model != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
