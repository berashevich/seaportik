package bsuir.command;

import bsuir.db.SeaportHelper;
import bsuir.entity.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class AddModel implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String model = request.getParameter("model");
        int seats = Integer.parseInt(request.getParameter("seats"));
        SeaportHelper.getInstance().addModel(model, seats);

        Collection<Model> models = SeaportHelper.getInstance().getModels();

        request.setAttribute("models", models);
        request.getRequestDispatcher("/jsp/models.jsp").forward(request, response);
    }
}
