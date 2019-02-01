package app.web.servlets;

import app.domain.models.service.ProductServiceModel;
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
import java.util.Map;

@WebServlet("/products/create")
public class CreateProductServlet extends HttpServlet {
    private static final String CREATE_PRODUCT_HTML_PATH = "F:\\softuni-projects-java\\Java Web" +
            "\\Java Web Basics\\Servlets API\\chushka-app" +
            "\\src\\main\\resources\\views\\create-product.html";

    private final ViewsProvider viewsProvider;
    private final ProductService productService;

    @Inject
    public CreateProductServlet(ViewsProvider viewsProvider, ProductService productService) {
        this.viewsProvider = viewsProvider;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.viewsProvider.view(CREATE_PRODUCT_HTML_PATH));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        String productDescription = req.getParameter("description");
        String productType = req.getParameter("product-type");
        ProductServiceModel productModel = new ProductServiceModel();
        productModel.setName(productName);
        productModel.setDescription(productDescription);
        productModel.setProductType(productType);
        this.productService.saveProduct(productModel);

        resp.sendRedirect("/");
    }
}
