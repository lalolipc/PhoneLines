package com.utn.PhoneLines.controller;

import com.utn.PhoneLines.exceptions.ResourceNotExistException;
import com.utn.PhoneLines.model.Call;
import com.utn.PhoneLines.service.CallService;
import com.utn.PhoneLines.session.SessionManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class CallControllerTest {

    CallController controller;
    CallService service;
    SessionManager sessionManagerService;
    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    @Before
    public void setUp() {
        service = mock(CallService.class);
        sessionManagerService = mock(SessionManager.class);
        controller = new CallController(service,sessionManagerService);
    }
/*
    @Test
    public void getAllOk() throws ResourceNotExistException, Exception {
        Call Call = new Call();
        Call.setId(1);
        List<Call> Calls= new ArrayList<>();
        Calls.add(Call);

        when(service.getAll()).thenReturn(Calls);
        ResponseEntity<List<Call>> returnedCalls= controller.getAll("1");

        assertEquals(returnedCalls.getBody().size(), 1);
        assertEquals(returnedCalls.getBody().get(0), Calls.get(0));

        verify(service, times(1)).getAll();
    }

    @Test
    public void getByIdOk() throws ResourceNotExistException, Exception {
        Call Call = new Call();
        Call.setId(1);

        when(service.getById(1)).thenReturn(Call);
        ResponseEntity<Call> returnedCall= controller.getById("1",1);

        assertNotNull(returnedCall);
        assertEquals(returnedCall.getBody(), Call);

        verify(service, times(1)).getById(1);
    }

    @Test
    public void GetByUserIdOk() throws ResourceNotExistException, Exception {
        Call Call = new Call();
        Call.setId(1);
        List<Call> Calls= new ArrayList<>();
        Calls.add(Call);

        when(service.getByUserId(1)).thenReturn(Calls);
        ResponseEntity<List<Call>> returnedCalls= controller.getByUserId("1",1);

        assertNotNull(returnedCalls);
        assertEquals(returnedCalls.getBody().size(), 1);
        assertEquals(returnedCalls.getBody().get(0), Calls.get(0));

        verify(service, times(1)).getByUserId(1);
    }

    @Test
    public void getReportCallsByUserByDateOk() throws ResourceNotExistException, Exception {
        UserType userType = new UserType();
        userType.setName(UserTypes.EMPLOYEE);
        User user = new User();
        user.setId(1);
        user.setFirstName("name");
        user.setLastName("lastName");
        user.setUserType(userType);

        CallsReportFilter callsReportFilter = new CallsReportFilter();
        callsReportFilter.setDateFrom(new Date());
        callsReportFilter.setDateTo(new Date());
        callsReportFilter.setUserId(1);

        List<ReportCallsByUserByDate> reportCallsByUserByDates = new ArrayList();
        ReportCallsByUserByDate reportCallsByUserByDate = factory.createProjection(ReportCallsByUserByDate.class);
        reportCallsByUserByDate.setCiudadDestino("destino");
        reportCallsByUserByDate.setCiudadOrigen("destino");
        reportCallsByUserByDate.setFechaLlamada(new Date());
        reportCallsByUserByDate.setMinDuration(1);
        reportCallsByUserByDate.setNumeroDestino("destino");
        reportCallsByUserByDate.setNumeroOrigen("destino");
        reportCallsByUserByDate.setTotalAmount(1);
        reportCallsByUserByDates.add(reportCallsByUserByDate);


        when(sessionManagerService.getCurrentUser("1")).thenReturn(user);
        when(service.getReportCallsByUserByDate(callsReportFilter)).thenReturn(reportCallsByUserByDates);
        ResponseEntity<List<ReportCallsByUserByDate>> returnedReportCallsByUserByDates= controller.getReportCallsByUserByDate("1",callsReportFilter);

        assertNotNull(returnedReportCallsByUserByDates);
        assertEquals(returnedReportCallsByUserByDates.getBody().size(), 1);
        assertEquals(returnedReportCallsByUserByDates.getBody().get(0), reportCallsByUserByDates.get(0));

        verify(sessionManagerService, times(1)).getCurrentUser("1");
        verify(service, times(1)).getReportCallsByUserByDate(callsReportFilter);
    }

    @Test
    public void getByCurrentUserOk() throws ResourceNotExistException, Exception {
        Call Call = new Call();
        Call.setId(1);
        List<Call> Calls= new ArrayList<>();
        Calls.add(Call);

        UserType userType = new UserType();
        userType.setName(UserTypes.EMPLOYEE);
        User user = new User();
        user.setId(1);
        user.setFirstName("name");
        user.setLastName("lastName");
        user.setUserType(userType);

        when(sessionManagerService.getCurrentUser("1")).thenReturn(user);
        when(service.getByUserId(1)).thenReturn(Calls);
        ResponseEntity<List<Call>> returnedCalls= controller.getByCurrentUser("1");

        assertNotNull(returnedCalls);
        assertEquals(returnedCalls.getBody().size(), 1);
        assertEquals(returnedCalls.getBody().get(0), Calls.get(0));

        verify(sessionManagerService, times(1)).getCurrentUser("1");
        verify(service, times(1)).getByUserId(1);
    }

    @Test
    public void updateOk() throws ResourceNotExistException, Exception {
        Call Call = new Call();
        Call.setId(1);

        doNothing().when(service).update(Call);
        ResponseEntity returned= controller.update("1",Call);

        assertNotNull(returned);
        assertEquals(returned.getStatusCodeValue(), 200);

        verify(service, times(1)).update(Call);
    }
    /*
        @Test
        public void addOk() throws ResourceNotExistException, Exception {
            CallInput Call = new CallInput();
            Call.setCallDate(new Date());
            Call.setDuration(1);
            Call.setNumberFrom(1);
            Call.setNumberTo(1);
            InfraResponse infraResponse = factory.createProjection(InfraResponse.class);
            infraResponse.setCreatedOn(new Date());
            infraResponse.setCallId(1);
            infraResponse.setMessage("1");
            when(service.createCall(Call)).thenReturn(infraResponse);
            ResponseEntity returned= controller.add("1",Call);
            assertNotNull(returned);
            assertEquals(returned.getStatusCodeValue(), 200);
            verify(service, times(1)).createCall(Call);
        }

    @Test
    public void removeOk() throws ResourceNotExistException, Exception {

        doNothing().when(service).remove(1);
        ResponseEntity returned= controller.remove("1",1);

        assertNotNull(returned);
        assertEquals(returned.getStatusCodeValue(), 200);

        verify(service, times(1)).remove(1);
    }*/
}