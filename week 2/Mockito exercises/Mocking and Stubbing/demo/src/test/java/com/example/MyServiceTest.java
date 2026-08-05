package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testMockingAndStubbing() {

        // Create mock object
        ExternalApi api = mock(ExternalApi.class);

        // Stub the method
        when(api.getData()).thenReturn("Hello Mockito");

        // Inject mock
        MyService service = new MyService(api);

        // Call method
        String result = service.fetchData();

        // Verify result
        assertEquals("Hello Mockito", result);

        // Verify interaction
        verify(api).getData();
    }
}