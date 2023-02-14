package zzabjong.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired HelloRepository helloRepository;
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed() {
        helloRepository.findHello("Spring");
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Spring")).isEqualTo(0);

        helloRepository.increaseCount("Spring");
        assertThat(helloRepository.countOf("Spring")).isEqualTo(1);

        helloRepository.increaseCount("Spring");
        assertThat(helloRepository.countOf("Spring")).isEqualTo(2);
    }
}
