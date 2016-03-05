package me.about.eguanlao.spring31andabove.staticclass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("productService")
public class SimpleProductService implements ProductService {

    private static final String foo = ApplicationProperties.getProperty("foo");

    @Value("${bar}")
    private String bar;

}
