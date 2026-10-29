
package co.edu.corhuila.opti.sales.adapter.in.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import co.edu.corhuila.opti.sales.application.port.in.ReportUseCases;

/**
 * Week 13 - OptiView security workshop.
 *
 * Service: opti-sales-api
 * Endpoint: GET /api/v1/reports/seller-sales
 * Issue: https://github.com/code-corhuila/opti-docs/issues/45
 * STRIDE: Elevation of Privilege (E)
 *
 * A request without the SERVICE role must be rejected.
 */
class SalesReportAuthorizationTest {

    @Test
    @DisplayName("Seller-sales report rejects requests without SERVICE role")
    void sellerSalesRejectsCallerWithoutServiceRole() {
        // Arrange: no authenticated SERVICE role is attached.
        ReportUseCases useCases = mock(ReportUseCases.class);
        ReportsController controller = new ReportsController(useCases);

        MockHttpServletRequest request = new MockHttpServletRequest(
                "GET", "/api/v1/reports/seller-sales"
        );

        String sellerId = UUID.randomUUID().toString();

        // Act: attempt to access the restricted report.
        ApiException exception = assertThrows(
                ApiException.class,
                () -> controller.sellerSales(
                        request, sellerId, null, null
                )
        );

        // Assert: the operation is forbidden.
        assertEquals(ErrorCode.FORBIDDEN, exception.code());

        // No confidential sales report should be requested.
        verifyNoInteractions(useCases);
    }
}
