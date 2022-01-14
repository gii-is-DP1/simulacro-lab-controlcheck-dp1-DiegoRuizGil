package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	private static final String VIEW_PLAYER_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/create")
	public String initCreateForm(ModelMap modelMap) {
		Product product = new Product();
		
		List<ProductType> listPT = productService.getAllProductType();
		Integer selectSize = listPT.size();
		List<String> productTypeNames = listPT.stream().map(pt -> pt.getName()).collect(Collectors.toList());
		
		modelMap.put("product", product);
		modelMap.put("selectSize", selectSize);
		modelMap.put("productTypeNames", productTypeNames);
		return VIEW_PLAYER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		
		if(result.hasErrors())
			return VIEW_PLAYER_CREATE_OR_UPDATE_FORM;
			
		productService.save(product);
		
		return "welcome";
	}
	
}
