package bsuir.command;

import bsuir.db.SeaportHelper;
import bsuir.entity.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToUpdateModelPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int modelId = Integer.parseInt(request.getParameter("id"));

        Model model = SeaportHelper.getInstance().getModelById(modelId);

        request.setAttribute("model", model);
        request.getRequestDispatcher("/jsp/update_model.jsp").forward(request, response);
    }
}
