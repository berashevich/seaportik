package bsuir.command;

public enum  CommandName {

    TO_MAIN_PAGE(new ToMainPage()),
    TO_SHIPS_PAGE(new ToShipsPage()), TO_UPDATE_SHIP_PAGE(new ToUpdateShipPage()),
    ADD_SHIP(new AddShip()), DELETE_SHIP(new DeleteShip()), UPDATE_SHIP(new UpdateShip()),
    TO_MODELS_PAGE(new ToModelsPage()), TO_UPDATE_MODEL_PAGE(new ToUpdateModelPage()),
    ADD_MODEL(new AddModel()), DELETE_MODEL(new DeleteModel()), UPDATE_MODEL(new UpdateModel()),
    ;

    protected Command command;

    CommandName(Command command) {
        this.command = command;
    }


}
