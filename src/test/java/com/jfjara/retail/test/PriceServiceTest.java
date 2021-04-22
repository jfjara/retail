package com.jfjara.retail.test;

import com.jfjara.retail.test.application.service.price.PriceService;
import com.jfjara.retail.test.domain.exceptions.AbstractCustomException;
import com.jfjara.retail.test.domain.model.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTest {

    @Autowired
    private PriceService service;

    @Test
    public void test_1() throws AbstractCustomException {
        Optional<Price> price = service.find("2020-06-14-10.00.00", 35455, 1);
        Assert.assertEquals(35.50, price.get().getPrice(), 0D);
        Assert.assertEquals(1, price.get().getPriceList());
    }

    @Test
    public void test_2() throws AbstractCustomException {
        Optional<Price> price = service.find("2020-06-14-16.00.00", 35455, 1);
        Assert.assertEquals(25.45, price.get().getPrice(), 0D);
        Assert.assertEquals(2, price.get().getPriceList());
    }

    @Test
    public void test_3() throws AbstractCustomException {
        Optional<Price> price = service.find("2020-06-14-21.00.00", 35455, 1);
        Assert.assertEquals(35.50, price.get().getPrice(), 0D);
        Assert.assertEquals(1, price.get().getPriceList());
    }

    @Test
    public void test_4() throws AbstractCustomException {
        Optional<Price> price = service.find("2020-06-15-10.00.00", 35455, 1);
        Assert.assertEquals(30.50, price.get().getPrice(), 0D);
        Assert.assertEquals(3, price.get().getPriceList());
    }

    @Test
    public void test_5() throws AbstractCustomException {
        Optional<Price> price = service.find("2020-06-15-21.00.00", 35455, 1);
        Assert.assertEquals(38.95, price.get().getPrice(), 0D);
        Assert.assertEquals(4, price.get().getPriceList());
    }

}
