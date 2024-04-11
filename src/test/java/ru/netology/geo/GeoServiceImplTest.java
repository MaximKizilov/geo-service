package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIp() {
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoServiceImpl service = new GeoServiceImpl();
        Location actual = service.byIp("172.0.32.11");
        Assertions.assertEquals(location,actual);
    }
}