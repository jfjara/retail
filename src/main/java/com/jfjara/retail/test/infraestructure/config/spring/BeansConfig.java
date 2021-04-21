package com.jfjara.retail.test.infraestructure.config.spring;

import com.jfjara.retail.test.application.interfaces.price.IPriceService;
import com.jfjara.retail.test.application.interfaces.product.IProductService;
import com.jfjara.retail.test.application.service.price.PriceService;
import com.jfjara.retail.test.application.service.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean("productService")
    public IProductService productService() {
        return new ProductService();
    }

    @Bean("priceService")
    public IPriceService priceService() {
        return new PriceService();
    }
}
