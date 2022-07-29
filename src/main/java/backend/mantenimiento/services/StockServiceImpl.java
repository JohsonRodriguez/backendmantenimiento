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
        return stockRepository.findAll();
    }

    @Override
    public Stock newStock(NewStockDto newStockDto) {
        Stock stock = new Stock();
        Product product = productRepository.findByNameAndBrand(newStockDto.getProductName(),newStockDto.getProductBrand());
        Stock checkStock=stockRepository.findByProduct(product);
        try {
            if (checkStock==null) {
                stock.setProduct(product);
                stock.setStock(newStockDto.getAmount());
            }else{
                float amount = checkStock.getStock();
                stock.setId(checkStock.getId());
                stock.setProduct(product);
                stock.setStock(amount+newStockDto.getAmount());
            }
            return stockRepository.save(stock);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public Stock reduceStock(NewStockDto newStockDto) {
        Stock lessStock = new Stock();
        Product product = productRepository.findByNameAndBrand(newStockDto.getProductName(),newStockDto.getProductBrand());
        Stock checkStock=stockRepository.findByProduct(product);
        if (checkStock.getStock()< newStockDto.getAmount()) {
            throw new NotFoundException("No hay Stock suficiente");
        }
        try {
            float amount = checkStock.getStock();
            lessStock.setId(checkStock.getId());
            lessStock.setProduct(product);
            lessStock.setStock(amount-newStockDto.getAmount());
            return stockRepository.save(lessStock);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

    }


}
