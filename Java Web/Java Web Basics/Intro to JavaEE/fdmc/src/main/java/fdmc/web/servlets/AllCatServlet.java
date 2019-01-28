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

@WebServlet("/cats/all")
public class AllCatServlet extends HttpServlet {
    private final String ALL_CATS_HTML_PATH = "F:\\SoftUni Main\\Java Web\\Java Web Development Basics\\04. Introduction to Java EE\\Exercises\\fdmc\\src\\main\\resources\\views\\cats\\all-cats.html";
    private final HtmlReader reader;

    @Inject
    public AllCatServlet(HtmlReader reader) {
        this.reader = reader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Cat> cats = (Map<String, Cat>) req.getServletContext().getAttribute("cats");

        String htmlContent = this.reader.readHtmlFile(ALL_CATS_HTML_PATH);
        StringBuilder allCatsList = new StringBuilder();
        if(cats==null || cats.isEmpty()){
            allCatsList.append("<h3>The are no cats <a href=\"/cats/create\"> Create Some</a></h3>");
            resp.getWriter().println(htmlContent.replace("{{allCatsList}}", allCatsList.toString()));
        }else{
            cats.keySet().forEach(cat->
                    allCatsList.append
                            (String.format("<a href=\"/cats/profile?catName=%s\"> %s</a><br/><br/>", cat, cat)));
            resp.getWriter().println(htmlContent.replace("{{allCatsList}}", allCatsList.toString()));
        }
    }
}
