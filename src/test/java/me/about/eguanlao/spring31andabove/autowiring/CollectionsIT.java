package me.about.eguanlao.spring31andabove.autowiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CollectionsIT {

    @Configuration
    static class Config {

        @Bean
        public SearchService keywordSearchService() {
            return new KeywordSearchService();
        }

        @Bean
        public SearchService categorySearchService() {
            return new CategorySearchService();
        }

        @Bean
        public SearchService locationSearchService() {
            return new LocationSearchService();
        }

    }

    @Autowired
    private Collection<SearchService> searchServices;

    @Autowired
    private Set<SearchService> searchServiceSet;

    @Autowired
    private SearchService[] searchServiceArray;

    @Test
    public void should_have_a_collection_of_all_SearchService_implementations() {
        assertThat(searchServices)
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    public void should_have_a_set_of_all_SearchService_implementations() {
        assertThat(searchServiceSet)
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    public void should_have_an_array_of_all_SearchService_implementations() {
        assertThat(searchServiceArray)
                .isNotEmpty()
                .hasSize(3);
    }

}
