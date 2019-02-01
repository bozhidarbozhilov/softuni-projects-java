package app.web.servlets;

import app.domain.models.service.ProductServiceModel;
import app.services.ProductService;
import app.utils.ViewsProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private static final String INDEX_HTML_PATH = "F:\\softuni-projects-java\\Java Web\\Java Web Basics\\Servlets API" +
            "\\chushka-app\\src\\main\\resources\\views\\index.html";
    private final ViewsProvider viewsProvider;
    private final ProductService productService;

    @Inject
    public IndexServlet(ViewsProvider viewsProvider, ProductService productService) {
        this.viewsProvider = viewsProvider;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductServiceModel> products = this.productService.getAllProducts();
        StringBuilder productsList = new StringBuilder();
                products.stream()
                .map(product->String.format("<li><a href=\"/products/details?name=%s\">%s</a></li>",
                        product.getName(),product.getName()))
                .forEach(li->productsList.append(li).append(System.lineSeparator()));

        String indexFile = this.viewsProvider.view(INDEX_HTML_PATH)
                .replace("{{allProductsList}}", productsList.toString());

        resp.getWriter().println(indexFile);
    }
}
