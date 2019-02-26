package metube.web.servlets;

import metube.domain.models.TubeServiceModel;
import metube.domain.models.view.AllTubesViewModel;
import metube.services.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/tubes/all")
public class TubeAllServlet extends HttpServlet {
    private final TubeService tubeService;
    private final ModelMapper mapper;

    @Inject
    public TubeAllServlet(TubeService tubeService, ModelMapper mapper) {
        this.tubeService = tubeService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeServiceModel> allTubes = this.tubeService.getAllTubes();
        List<AllTubesViewModel> allTubesViewModels = allTubes.stream()
                .map(tube->this.mapper.map(tube, AllTubesViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("allTubes", allTubesViewModels);
        req.getRequestDispatcher("/jsps/all-tubes.jsp").forward(req,resp);

    }
}
