package backend.mantenimiento.services;


import backend.mantenimiento.Dto.NewStockDto;
import backend.mantenimiento.entity.Stock;

public interface StockService {
    Iterable<Stock> listStock();
    Stock newStock(NewStockDto newStockDto);
    Stock reduceStock(NewStockDto newStockDto);
}
