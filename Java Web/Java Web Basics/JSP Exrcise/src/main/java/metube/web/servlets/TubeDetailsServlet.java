package metube.web.servlets;

import metube.domain.models.TubeServiceModel;
import metube.domain.models.view.TubeViewModel;
import metube.services.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/details")
public class TubeDetailsServlet extends HttpServlet {
    private final TubeService tubeService;
    private final ModelMapper mapper;

    @Inject
    public TubeDetailsServlet(TubeService tubeService, ModelMapper mapper) {
        this.tubeService = tubeService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getQueryString().split("=")[1].trim();
        TubeServiceModel tubeServiceModel = this.tubeService.getTubeByName(name);
        TubeViewModel viewModel = null;
        if(tubeServiceModel != null){
             viewModel=mapper.map(tubeServiceModel, TubeViewModel.class);
        }

        req.setAttribute("viewModel", viewModel);
        req.getRequestDispatcher("/jsps/details-tube.jsp").forward(req, resp);
    }
}
