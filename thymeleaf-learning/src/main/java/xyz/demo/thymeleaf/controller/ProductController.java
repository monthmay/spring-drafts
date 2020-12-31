package xyz.demo.thymeleaf.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.demo.thymeleaf.access.ProductBuilder;
import xyz.demo.thymeleaf.entity.Product;
import xyz.demo.thymeleaf.utils.Formatter;

import java.util.Iterator;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping(path = "/product/list", produces = MediaType.TEXT_HTML_VALUE)
    public String productListPage(
    @RequestParam(name = "s", defaultValue = "30") int size,
    @RequestParam(name = "r", defaultValue = "30") int row,
    Model model) {
        List<Product> products = ProductBuilder.buildProductList(size);
        Iterator<List<Product>> iter = Formatter.groupBy(products, row).iterator();

        model.addAttribute("iter", iter);
        return "list";
    }
}
