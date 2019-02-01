package app.web.servlets;

import app.domain.models.views.ProductViewModel;
import app.services.ProductService;
import app.utils.ViewsProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/details")
public class ProductDetailsServlet extends HttpServlet {
    private static final String PRODUCT_DETAILS_HTML_PATH = "F:\\softuni-projects-java\\Java Web\\" +
            "Java Web Basics\\Servlets API\\chushka-app" +
            "\\src\\main\\resources\\views\\details-product.html";

    private final ViewsProvider viewsProvider;
    private final ProductService productService;

    @Inject
    public ProductDetailsServlet(ViewsProvider viewsProvider, ProductService productService) {
        this.viewsProvider = viewsProvider;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String nameToFind = req.getQueryString().split("=")[1];
        ProductViewModel productViewModel = this.productService.getProductByName(nameToFind);
        String htmlContent = this.viewsProvider.view(PRODUCT_DETAILS_HTML_PATH)
                .replace("{{productName}}", productViewModel.getName())
                .replace("{{productDescription}}", productViewModel.getDescription())
                .replace("{{productType}}", productViewModel.getProductType().toString());
       resp.getWriter().println(htmlContent);
    }
}
