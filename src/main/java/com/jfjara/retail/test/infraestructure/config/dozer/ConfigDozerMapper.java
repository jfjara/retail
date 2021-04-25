package com.jfjara.retail.test.infraestructure.config.dozer;

import com.jfjara.retail.test.domain.utils.Constants;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfigDozerMapper {

    @Bean
    public DozerBeanMapper dozerBeanMapper() throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(Constants.DOZER_FILE_CONFIGURATION);
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        String path = resource.toURI().getPath();
        List<String> mappingFiles = Arrays.asList(Constants.FILE_PROTOCOL_NAME + path);
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

}
