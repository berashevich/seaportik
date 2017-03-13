package bsuir.command;

import bsuir.db.SeaportHelper;
import bsuir.entity.Model;
import bsuir.entity.Ship;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class ToUpdateShipPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String shipId = request.getParameter("id");

        Ship ship = SeaportHelper.getInstance().getShipById(shipId);
        Collection<Model> models = SeaportHelper.getInstance().getModels();

        request.setAttribute("shipId", shipId);
        request.setAttribute("ship", ship);
        request.setAttribute("models", models);
        request.getRequestDispatcher("/jsp/update_ship.jsp").forward(request, response);
    }
}
