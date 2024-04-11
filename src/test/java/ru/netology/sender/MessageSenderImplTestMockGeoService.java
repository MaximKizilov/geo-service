package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderImplTestMockGeoService {

    @Test
    void test1WithMockitoRus() {
       GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> keyAndIp = new HashMap<>();
        keyAndIp.put(MessageSenderImpl.IP_ADDRESS_HEADER,"172.1.1.1");
       assertEquals( messageSender.send(keyAndIp), "Добро пожаловать");
    }
    @Test
    void test1WithMockitoEngl() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn( "Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> keyAndIp = new HashMap<>();
        keyAndIp.put(MessageSenderImpl.IP_ADDRESS_HEADER,GeoServiceImpl.NEW_YORK_IP);
        assertEquals( messageSender.send(keyAndIp), "Welcome");
    }
}
