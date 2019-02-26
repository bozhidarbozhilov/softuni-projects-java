package metube.web.servlets;

import metube.domain.models.TubeServiceModel;
import metube.domain.models.binding.TubeBindingModel;
import metube.services.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/create")
public class CreateTubeServlet extends HttpServlet {
    private final ModelMapper mapper;
    private final TubeService tubeService;

    @Inject
    public CreateTubeServlet(ModelMapper mapper, TubeService tubeService) {
        this.mapper = mapper;
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/create-tube.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeBindingModel bindingModel = (TubeBindingModel) req.getAttribute("bindingModel");
        TubeServiceModel serviceModel = this.mapper.map(bindingModel, TubeServiceModel.class);
        this.tubeService.saveTube(serviceModel);


        resp.sendRedirect("/tubes/details?name="+bindingModel.getName());
    }
}
