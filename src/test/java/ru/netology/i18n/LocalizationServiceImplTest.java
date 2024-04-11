package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locale() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String x =service.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать",x);

    }
}