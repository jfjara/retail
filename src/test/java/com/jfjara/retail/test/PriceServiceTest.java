package com.jfjara.retail.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfjara.retail.test.domain.model.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
public class PriceServiceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    private Price getPriceFromMvc(String date, long productId, long brandId) throws Exception {

        Map<String, String> collectionValues = new HashMap<>();
        collectionValues.put("productId", String.valueOf(productId));
        collectionValues.put("brandId", String.valueOf(brandId));
        collectionValues.put("applicationDate", date);

        UriComponents uri = UriComponentsBuilder.newInstance()
                .path("/api/prices/{productId}/{brandId}/{applicationDate}/find").buildAndExpand(collectionValues);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri.toUriString())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String contentResponse = mvcResult.getResponse().getContentAsString();
        return transformToObject(contentResponse, Price.class);
    }


    private <T> T transformToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @Test
    public void test_1() throws Exception {
        Price price = getPriceFromMvc("2020-06-14-10.00.00", 35455, 1);
        Assert.assertEquals(35.50, price.getPrice(), 0D);
        Assert.assertEquals(1, price.getPriceList());
        Assert.assertEquals(35455, price.getProductId());
        Assert.assertEquals(1, price.getBrandId());
    }

    @Test
    public void test_2() throws Exception {
        Price price = getPriceFromMvc("2020-06-14-16.00.00", 35455, 1);
        Assert.assertEquals(25.45, price.getPrice(), 0D);
        Assert.assertEquals(2, price.getPriceList());
        Assert.assertEquals(35455, price.getProductId());
        Assert.assertEquals(1, price.getBrandId());
    }

    @Test
    public void test_3() throws Exception {
        Price price = getPriceFromMvc("2020-06-14-21.00.00", 35455, 1);
        Assert.assertEquals(35.50, price.getPrice(), 0D);
        Assert.assertEquals(1, price.getPriceList());
        Assert.assertEquals(35455, price.getProductId());
        Assert.assertEquals(1, price.getBrandId());
    }

    @Test
    public void test_4() throws Exception {
        Price price = getPriceFromMvc("2020-06-15-10.00.00", 35455, 1);
        Assert.assertEquals(30.50, price.getPrice(), 0D);
        Assert.assertEquals(3, price.getPriceList());
        Assert.assertEquals(35455, price.getProductId());
        Assert.assertEquals(1, price.getBrandId());
    }

    @Test
    public void test_5() throws Exception {
        Price price = getPriceFromMvc("2020-06-15-21.00.00", 35455, 1);
        Assert.assertEquals(38.95, price.getPrice(), 0D);
        Assert.assertEquals(4, price.getPriceList());
        Assert.assertEquals(35455, price.getProductId());
        Assert.assertEquals(1, price.getBrandId());
    }

}
