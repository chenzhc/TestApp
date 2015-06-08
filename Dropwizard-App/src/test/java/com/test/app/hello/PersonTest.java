package com.test.app.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.app.core.Person;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import static com.test.app.utils.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zc on 2015/6/8.
 */
public class PersonTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Person person = new Person("Luther Blissett", "lb@example.com");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/person.json"), Person.class));

        assertThat(MAPPER.writeValueAsString(person)).isEqualTo(expected);

    }

    @Test
    public void deserializesFromJSON() throws Exception {
        Person person = new Person("Luther Blissett", "lb@example.com");

        System.out.println(fixture("fixtures/person.json"));

        Person person2 = MAPPER.readValue(fixture("fixtures/person.json"), Person.class);

        System.out.println(MAPPER.writeValueAsString(person2));
    }

}
