package bsuir.command;

import bsuir.db.SeaportHelper;
import bsuir.entity.Model;
import bsuir.entity.Ship;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class DeleteShip implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String shipId = request.getParameter("id");
        SeaportHelper.getInstance().deleteShip(shipId);

        Collection<Ship> ships = SeaportHelper.getInstance().getShips();
        Collection<Model> models = SeaportHelper.getInstance().getModels();

        request.setAttribute("ships", ships);
        request.setAttribute("models", models);
        request.getRequestDispatcher("/jsp/ships.jsp").forward(request, response);
    }
}
