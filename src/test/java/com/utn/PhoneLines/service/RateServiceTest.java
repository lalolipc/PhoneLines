package com.utn.PhoneLines.service;

import com.utn.PhoneLines.exceptions.ResourceNotExistException;
import com.utn.PhoneLines.model.City;
import com.utn.PhoneLines.model.Rate;
import com.utn.PhoneLines.repository.RateRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RateServiceTest {

    @Mock
    RateRepository rateRepository;

    @InjectMocks
    RateService rateService;

    @Before
    public void setUp() {
        initMocks(this);
    }


    private Rate createRate(){
        return Rate.builder()
                .idRate(1)
                .cityFrom(new City())
                .cityTo(new City())
                .costPrice(7)
                .salePrice(10)
                .build();
    }

    @Test
    public void getRatesOkTest(){
        List<Rate> list = new ArrayList<>();
        Rate r = createRate();
        list.add(r);
        when(this.rateRepository.findAll()).thenReturn(list);
        ResponseEntity<List<Rate>> response = this.rateService.getRates();
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

  /*  @Test
    public void getTariffsNoContentTest(){
        List<Tariff> list = new ArrayList<>();
        when(this.rateRepository.findAll()).thenReturn(list);
        ResponseEntity<List<Tariff>> response = this.tariffService.getTariffs();
        Assert.assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
    }
*/
    @Test
    public void getTariffByLocalityFromToOkTest() throws ResourceNotExistException {
        Rate r = createRate();
        Integer icCityFrom = 1;
        Integer idCityTo = 1;
        when(this.rateRepository.getRatesbyCity(icCityFrom,idCityTo)).thenReturn(r);
        Assert.assertEquals(r,this.rateService.getRatesbyCity(icCityFrom,idCityTo));
    }
/*
    @Test(expected = TariffNotExistsException.class)
    public void getTariffByLocalityFromToEmptyTariffTest() throws TariffNotExistsException {
        Integer idLocalityFrom = 1;
        Integer idLocalityTo = 1;
        when(this.rateRepository.getTariffByLocalityFromTo(idLocalityFrom,idLocalityTo)).thenReturn(null);
        this.tariffService.getTariffByLocalityFromTo(idLocalityFrom,idLocalityTo);
    }
*/
}
