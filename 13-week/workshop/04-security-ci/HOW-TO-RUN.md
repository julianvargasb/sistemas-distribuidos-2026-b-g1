
# OptiView — Security Test Execution Guide

## 1. Objective

Document the proposed security checks for the OptiView distributed system, focusing on the trust boundary between opti-api-gateway and opti-sales-api.

The main objective is to verify that unauthorized users cannot access confidential seller-sales reports.

## 2. Related Security Story

- Issue: https://github.com/code-corhuila/opti-docs/issues/45
- STRIDE category: E — Elevation of Privilege
- Risk score: 6
- Priority: P1

### Acceptance Criterion

An unauthorized caller without the required SERVICE role must not access the restricted seller-sales report.

## 3. Real Service and Endpoint

Service: opti-sales-api

Endpoint:

GET /api/v1/reports/seller-sales

Required role: SERVICE

The ReportsController checks the caller's role before retrieving seller-sales information.

## 4. Negative Authorization Test

Test class:

SalesReportAuthorizationTest.java

Test method:

sellerSalesRejectsCallerWithoutServiceRole

The test creates a request without an authenticated SERVICE role and invokes the report controller.

Expected result:

- The controller rejects the request with ErrorCode.FORBIDDEN.
- No report data is retrieved.
- The ReportUseCases dependency is not invoked.

The corresponding HTTP 403 response must be verified separately at the HTTP layer.

## 5. Local Execution

Prerequisites:

- Java 21
- Maven
- Access to the real opti-sales-api repository

Place SalesReportAuthorizationTest.java in:

sales-adapters/src/test/java/co/edu/corhuila/opti/sales/adapter/in/http/

From the root directory of opti-sales-api, execute:

```bash
mvn -pl sales-adapters -am -Dtest=SalesReportAuthorizationTest -Dsurefire.failIfNoSpecifiedTests=false test
```

Review the Maven output to determine whether the test passed.

## 6. Proposed CI Security Gates

The security.yml file defines three proposed checks:

1. Secret scanning using Gitleaks.
2. Dependency vulnerability auditing using OWASP Dependency-Check.
3. Negative authorization testing with Maven.

The workflow is currently documented in the workshop folder as a proposal.

To execute it automatically, it must be adapted and installed in the real application's .github/workflows directory.

## 7. Verification Status

- Security workflow documented: Yes.
- Negative authorization test written: Yes.
- Test executed successfully: Not yet verified.
- Real console output: Pending.
- GitHub Actions execution URL: Pending.

No successful execution is claimed until actual test results are available.
