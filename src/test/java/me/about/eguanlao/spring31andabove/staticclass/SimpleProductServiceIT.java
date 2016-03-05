package me.about.eguanlao.spring31andabove.staticclass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.apache.commons.lang3.reflect.FieldUtils.readField;
import static org.apache.commons.lang3.reflect.FieldUtils.readStaticField;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SimpleProductServiceIT {

    @Configuration
    @ComponentScan("me.about.eguanlao.spring31andabove.staticclass")
    static class Config {
    }

    @Autowired
    private ProductService productService;

    @Test
    public void should_have_a_null_value_for_foo() throws IllegalAccessException {
        final String foo = (String) readStaticField(SimpleProductService.class, "foo", true);

        assertThat(foo, is(nullValue()));
    }

    @Test
    public void should_have_a_non_null_value_for_bar() throws IllegalAccessException {
        final String bar = (String) readField(productService, "bar", true);

        assertThat(bar, is("default"));
    }

}
