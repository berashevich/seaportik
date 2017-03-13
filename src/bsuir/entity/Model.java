package bsuir.entity;

public class Model {

    private int id;
    private String name;
    private int cargoSeats;

    public Model() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCargoSeats() {
        return cargoSeats;
    }

    public void setCargoSeats(int cargoSeats) {
        this.cargoSeats = cargoSeats;
    }

    public static Builder newBuilder() {
        return new Model().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (cargoSeats != model.cargoSeats) return false;
        return !(name != null ? !name.equals(model.name) : model.name != null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + cargoSeats;
        return result;
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Model.this.name = name;

            return this;
        }

        public Builder setCargoSeats(int cargoSeats) {
            Model.this.cargoSeats = cargoSeats;

            return this;
        }

        public Model build() {
            return Model.this;
        }
    }
}
