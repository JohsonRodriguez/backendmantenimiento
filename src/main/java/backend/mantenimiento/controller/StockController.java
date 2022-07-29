package backend.mantenimiento.controller;

import backend.mantenimiento.Dto.NewStockDto;
import backend.mantenimiento.entity.Product;
import backend.mantenimiento.entity.Stock;
import backend.mantenimiento.services.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/all")
    public Iterable<Stock> getAllStocks(){
        return stockService.listStock();
    }

    @PostMapping("/add")
    public void addStock(@RequestBody NewStockDto newStockDto){
        stockService.newStock(newStockDto);
    }
}
