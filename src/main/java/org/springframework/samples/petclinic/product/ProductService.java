package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }
    
    public ProductType getProductType(String typeName) {
        return productRepo.findByTypeName(typeName);
    }
    
    public List<ProductType> getAllProductType(){
    	return productRepo.findAllProductTypes();
    }

    public Product save(Product p){
        return productRepo.save(p);       
    }

    
}
