package me.about.eguanlao.spring31andabove.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class NonProdPropertiesConfigIT {

    static {
        System.setProperty("spring.profiles.active", "nonprod");
    }

    @Configuration
    @ComponentScan("me.about.eguanlao.spring31andabove")
    static class Config {
    }

    @Value("${foo}")
    private String foo;

    @Value("${bar}")
    private String bar;

    @Value("${baz}")
    private String baz;

    @Value("${greeting}")
    private String greeting;

    @Value("${invalid.username}")
    private String invalidUsername;

    @Test
    public void should_set_foo() {
        assertThat(foo, is("nonprod"));
    }

    @Test
    public void should_set_bar() {
        assertThat(bar, is("default"));
    }

    @Test
    public void should_set_baz() {
        assertThat(baz, is("default"));
    }

    @Test
    public void should_set_greeting() {
        assertThat(greeting, is("Hello, world!"));
    }

    @Test
    public void should_set_invalid_username() {
        assertThat(invalidUsername, is("Invalid username"));
    }

}
