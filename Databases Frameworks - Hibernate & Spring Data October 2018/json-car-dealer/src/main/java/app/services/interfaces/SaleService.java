package app.services.interfaces;

import app.models.dtos.view.SalesDiscountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    void createSale();
    List<SalesDiscountDto> getSalesWithCalcDiscount();
}
