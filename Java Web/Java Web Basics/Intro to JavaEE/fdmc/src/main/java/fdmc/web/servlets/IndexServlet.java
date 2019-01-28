package fdmc.web.servlets;

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

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private static final String INDEX_FILE_PATH = "F:\\SoftUni Main\\Java Web\\Java Web Development Basics\\04. Introduction to Java EE" +
            "\\Exercises\\fdmc\\src\\main\\resources\\views\\index.html";
    private HtmlReader reader;

    @Inject
    public IndexServlet(HtmlReader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileContent = this.reader.readHtmlFile(INDEX_FILE_PATH);
        PrintWriter writer = resp.getWriter();
        writer.println(fileContent);
    }
}
