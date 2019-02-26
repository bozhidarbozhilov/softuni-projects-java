package metube.web.filters;

import metube.domain.models.binding.TubeBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter("/tubes/create")
public class CreateTubeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getMethod().equalsIgnoreCase("post")){
            TubeBindingModel bindingModel = new TubeBindingModel();
            bindingModel.setName(request.getParameter("name"));
            bindingModel.setDescription(request.getParameter("description"));
            bindingModel.setYouTubeLink(request.getParameter("youTubeLink"));
            bindingModel.setUploader(request.getParameter("uploader"));

            request.setAttribute("bindingModel", bindingModel);
        }
        filterChain.doFilter(request, response);

    }
}
