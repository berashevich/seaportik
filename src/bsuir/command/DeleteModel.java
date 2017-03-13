package bsuir.command;

import bsuir.db.SeaportHelper;
import bsuir.entity.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class DeleteModel implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int modelId = Integer.parseInt(request.getParameter("id"));
        SeaportHelper.getInstance().deleteModel(modelId);

        Collection<Model> models = SeaportHelper.getInstance().getModels();

        request.setAttribute("models", models);
        request.getRequestDispatcher("/jsp/models.jsp").forward(request, response);
    }
}
