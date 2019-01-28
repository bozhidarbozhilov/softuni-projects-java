package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.utils.HtmlReader;
import fdmc.utils.HtmlReaderImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cats/create")
public class CreateServlet extends HttpServlet {
    public static final String CREATE_FILE_PATH = "F:\\SoftUni Main\\Java Web\\Java Web Development Basics\\04. Introduction to Java EE" +
            "\\Exercises\\fdmc\\src\\main\\resources\\views\\cats\\create.html";

    private HtmlReader reader;

    @Inject
    public CreateServlet(HtmlReader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileContent = this.reader.readHtmlFile(CREATE_FILE_PATH);
        PrintWriter writer = resp.getWriter();
        writer.println(fileContent);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = new Cat();
        cat.setName(req.getParameter("name"));
        cat.setBreed(req.getParameter("breed"));
        cat.setColour(req.getParameter("color"));
        cat.setAge(Integer.parseInt(req.getParameter("age")));

        if(req.getServletContext().getAttribute("cats")==null){
            req.getServletContext().setAttribute("cats", new LinkedHashMap<>());
        }
        ((Map<String, Cat>)req.getServletContext().getAttribute("cats")).putIfAbsent(cat.getName(), cat);

        resp.sendRedirect(String.format("/cats/profile?catName=%s", cat.getName()));

    }
}
