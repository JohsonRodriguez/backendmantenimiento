package backend.mantenimiento.services;

import backend.mantenimiento.Dto.NewStockDto;
import backend.mantenimiento.entity.Product;
import backend.mantenimiento.entity.Stock;
import backend.mantenimiento.exception.NotFoundException;
import backend.mantenimiento.repository.ProductRepository;
import backend.mantenimiento.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;
    private ProductRepository productRepository;


    public StockServiceImpl(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Stock> listStock() {
        return stockRepository.findAllByOrderByStockDesc();
    }

    @Override
    public Stock newStock(Stock stock) {
        Stock newStock = new Stock();
        Stock checkStock=stockRepository.findByProductAndBrand(stock.getProduct(),stock.getBrand());

        try {
            if (checkStock==null) {
                newStock.setProduct(stock.getProduct());
                newStock.setBrand(stock.getBrand());
                newStock.setStock(stock.getStock());
            }else{
                float amount = checkStock.getStock();
                newStock.setId(checkStock.getId());
                newStock.setProduct(stock.getProduct());
                newStock.setBrand(stock.getBrand());
                newStock.setStock(amount+stock.getStock());
            }
            return stockRepository.save(newStock);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public Stock reduceStock(Stock stock) {
        Stock lessStock = new Stock();
        Stock checkStock=stockRepository.findByProductAndBrand(stock.getProduct(),stock.getBrand());
        if (checkStock.getStock()< stock.getStock()) {
            throw new NotFoundException("No hay Stock suficiente, solo tiene :" +checkStock.getStock() );
        }
        try {
            float amount = checkStock.getStock();
            lessStock.setId(checkStock.getId());
            lessStock.setProduct(stock.getProduct());
            lessStock.setBrand(stock.getBrand());
            lessStock.setStock(amount-stock.getStock());
            return stockRepository.save(lessStock);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

    }


}
