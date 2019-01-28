package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.utils.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {
    private final String PROFILE_HTML_PATH="F:\\SoftUni Main\\Java Web\\Java Web Development Basics\\04. Introduction to Java EE\\Exercises\\fdmc\\src\\main\\resources\\views\\cats\\cat-profile.html";
    private final String NONEXITENT_HTML_PATH="F:\\SoftUni Main\\Java Web\\Java Web Development Basics\\04. Introduction to Java EE\\Exercises\\fdmc\\src\\main\\resources\\views\\cats\\non-existant-cat-page.html";
    private final HtmlReader reader;

    @Inject
    public CatProfileServlet(HtmlReader reader) {
        this.reader = reader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getQueryString().split("=")[1];
        Cat cat = ((Map<String, Cat>)req.getServletContext().getAttribute("cats")).get(catName);
        String htmlContent = "";
        if(cat == null){
            htmlContent = this.reader.readHtmlFile(NONEXITENT_HTML_PATH);
            resp.getWriter().println(htmlContent.replace("{{catName}}", catName));
        }else{
            htmlContent = this.reader.readHtmlFile(PROFILE_HTML_PATH);
            resp.getWriter().println(htmlContent
                    .replace("{{catName}}", cat.getName())
                    .replace("{{catBreed}}", cat.getBreed())
                    .replace("{{catColor}}", cat.getColour())
                    .replace("{{catAge}}", cat.getAge().toString()));
        }

    }
}
