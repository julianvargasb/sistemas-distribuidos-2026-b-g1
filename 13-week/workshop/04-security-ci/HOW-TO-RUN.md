
# OptiView — Security Test Execution Guide

**Course:** Distributed Systems  
**Workshop:** Week 13 — Threat Modeling and Security CI  
**Student:** Wilkyn Julian Vargas Bahamón  
**GitHub:** julianvargasb  
**Team:** The illusionists  
**Project:** OptiView  

## 1. Objective

The objective of this activity is to document and verify security controls for the OptiView distributed system.

The analysis focuses on the trust boundary between `opti-api-gateway` and `opti-sales-api`.

The main security requirement is to prevent unauthorized users from accessing confidential seller-sales reports.

The proposed Continuous Integration (CI) workflow includes three security checks:

1. Secret scanning with Gitleaks.
2. Dependency vulnerability auditing with OWASP Dependency-Check.
3. Negative authorization testing with Java, Maven and JUnit.

These controls are intended to detect security problems before code changes are integrated into the main branch.

## 2. Related Security Story

**Security Issue:**  
https://github.com/code-corhuila/opti-docs/issues/45

**Issue Title:**  
[security] Restrict seller-sales reports to SERVICE role

**STRIDE Category:** E — Elevation of Privilege

**Likelihood:** 2  
**Impact:** 3  
**Risk Score:** 6  
**Priority:** P1  

**Related STRIDE Pull Request:**  
https://github.com/code-corhuila/opti-docs/pull/44

### Security Acceptance Criterion

Requests without the required `SERVICE` role must not access restricted seller-sales reports.

An authenticated requester without sufficient permissions must receive HTTP 403.

An automated negative authorization test must verify the authorization restriction.

## 3. Real Service and Endpoint

**Service:** `opti-sales-api`

**Technology Stack:**

- Java 21
- Spring Boot 3.5.6
- Apache Maven
- JUnit 5
- Mockito
- PostgreSQL

**Restricted Endpoint:**

`GET /api/v1/reports/seller-sales`

**Required Role:** `SERVICE`

**Controller:** `ReportsController.java`

**Relevant Security Control:**

```java
RequestRules.requireRole(http, Roles.SERVICE);
```

The controller validates the caller's role before executing the sales reporting operation.

If the request does not contain the required role, the operation must be rejected before confidential sales information is retrieved.

### Source Code Reference

https://github.com/code-corhuila/opti-sales-api/blob/main/sales-adapters/src/main/java/co/edu/corhuila/opti/sales/adapter/in/http/ReportsController.java

## 4. Negative Authorization Test

**Test File:** `SalesReportAuthorizationTest.java`

**Test Method:** `sellerSalesRejectsCallerWithoutServiceRole`

**Workshop File:**

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/SalesReportAuthorizationTest.java

### Test Scenario

**Given:** A request without an authenticated caller carrying the `SERVICE` role.

**When:** The request attempts to access the restricted seller-sales report.

**Then:**

1. The controller rejects the request.
2. The internal error code is `ErrorCode.FORBIDDEN`.
3. The report use case is not invoked.
4. No confidential sales report is retrieved.

### Assertions

The test uses JUnit 5 and Mockito to verify the expected behavior.

```java
assertEquals(ErrorCode.FORBIDDEN, exception.code());
verifyNoInteractions(useCases);
```

The first assertion checks the internal authorization error.

The second assertion verifies that the report use case was not executed.

This test verifies controller-level authorization behavior. A separate HTTP integration test is required to prove that the API returns HTTP 403 over the HTTP interface.

## 5. Local Execution Procedure

### 5.1 Requirements

The following tools were installed and verified on the local computer:

- Operating System: Windows 11
- Java: Eclipse Temurin JDK 21.0.12.1
- Apache Maven: 3.9.16
- Git

### 5.2 Clone the Real Service

Open Windows CMD and execute:

```cmd
cd /d C:\Users\juanj
git clone https://github.com/code-corhuila/opti-sales-api.git
cd opti-sales-api
```

Verify the Maven project:

```cmd
dir pom.xml
```

The `pom.xml` file must exist in the root directory of `opti-sales-api`.

### 5.3 Copy the Security Test

The test was copied from the personal workshop repository into the real service's local test directory.

Target path:

```text
sales-adapters/src/test/java/co/edu/corhuila/opti/sales/adapter/in/http/SalesReportAuthorizationTest.java
```

Command used in Windows CMD:

```cmd
powershell -NoProfile -Command "$url='https://raw.githubusercontent.com/julianvargasb/sistemas-distribuidos-2026-b-g1/main/13-week/workshop/04-security-ci/SalesReportAuthorizationTest.java'; $folder='sales-adapters/src/test/java/co/edu/corhuila/opti/sales/adapter/in/http'; New-Item -ItemType Directory -Force -Path $folder | Out-Null; Invoke-WebRequest -Uri $url -OutFile (Join-Path $folder 'SalesReportAuthorizationTest.java')"
```

Verify that the file exists:

```cmd
dir sales-adapters\src\test\java\co\edu\corhuila\opti\sales\adapter\in\http\SalesReportAuthorizationTest.java
```

The test was copied successfully.

### 5.4 Execute the Negative Authorization Test

From the root directory of `opti-sales-api`, execute:

```cmd
mvn -pl sales-adapters -am -Dtest=SalesReportAuthorizationTest -Dsurefire.failIfNoSpecifiedTests=false test
```

This command compiles the necessary Maven modules and runs the selected negative authorization test.

## 6. Proposed Security CI Pipeline

**Workflow File:** `security.yml`

**Location:**

`13-week/workshop/04-security-ci/security.yml`

**GitHub Reference:**

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/security.yml

### Security Gate 1 — Secret Scanning

Tool: Gitleaks

Purpose: Detect accidentally exposed credentials, tokens and other secrets.

### Security Gate 2 — Dependency Audit

Tool: OWASP Dependency-Check

Purpose: Identify known vulnerabilities in Java dependencies.

### Security Gate 3 — Negative Authorization Tests

Tools: Maven, JUnit 5 and Mockito

Purpose: Verify that callers without the required permissions are rejected before accessing restricted business information.

### CI Implementation Limitation

The workflow is currently stored inside the academic workshop folder.

It is a proposed GitHub Actions configuration, not an activated workflow in the real service.

For automatic execution, it must be adapted to the source repository and placed inside its `.github/workflows/` directory.

The proposed Maven commands also need to run in a workspace containing the actual `opti-sales-api` project and its dependencies.

No successful GitHub Actions pipeline execution is claimed at this stage.

## 7. Negative Authorization Test — Real Execution Evidence

**Execution Date:** October 28, 2026

**Execution Time:** 22:50:25 (Colombia, UTC-5)

**Environment:**

- Windows 11
- Eclipse Temurin JDK 21.0.12.1
- Apache Maven 3.9.16
- Service: `opti-sales-api`
- Module: `sales-adapters`

### Executed Command

```cmd
mvn -pl sales-adapters -am -Dtest=SalesReportAuthorizationTest -Dsurefire.failIfNoSpecifiedTests=false test
```

### Actual Maven Console Output

```text
[INFO] Running co.edu.corhuila.opti.sales.adapter.in.http.SalesReportAuthorizationTest

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] Results:

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] Reactor Summary for opti-sales-api 1.0.0:

[INFO] opti-sales-api ..................................... SUCCESS
[INFO] sales-core ......................................... SUCCESS
[INFO] sales-adapters ..................................... SUCCESS

[INFO] BUILD SUCCESS

[INFO] Total time: 22.495 s
[INFO] Finished at: 2026-10-28T22:50:25-05:00
```

### Results Analysis

| Verification | Result |
|---|---|
| Test class executed | SalesReportAuthorizationTest |
| Number of tests | 1 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |
| Maven build | SUCCESS |
| Execution time | 22.495 seconds |

### Security Conclusion

The negative authorization test passed against the real `opti-sales-api` source code on the local computer.

The test confirms that a request without an authenticated `SERVICE` role produces `ErrorCode.FORBIDDEN` before the controller invokes the report use case.

The Mockito verification confirms that the reporting dependency was not called in this scenario.

This provides automated evidence for the security control documented in Issue #45.

The test does not independently verify the HTTP 403 response through a running HTTP server.

## 8. Security Workflow YAML Validation

**File:** `13-week/workshop/04-security-ci/security.yml`

**Validation Tool:** YAML Lint

**Validation URL:**  
https://www.yamllint.com/

**Validation Result:** Valid YAML

### Verification Procedure

The complete `security.yml` content was copied from the OptiView workshop repository and submitted to the YAML Lint validator.

The validator returned the following message:

```text
Valid YAML
```

This confirms that the submitted file has valid YAML syntax.

### Security Controls Included

1. Secret scanning using Gitleaks.
2. Java dependency vulnerability auditing using OWASP Dependency-Check.
3. Negative authorization testing using Maven and JUnit.

### Validation Limitations

YAML syntax validation does not guarantee that the configuration is accepted or successfully executed by GitHub Actions.

The three CI security gates have not been demonstrated as successfully executed in an automated GitHub Actions run.

A complete CI verification will require integration with the actual service repository, workflow execution and inspection of the resulting logs.

### Final Technical Summary

The Week 13 security workshop produced the following technical evidence:

- A proposed security workflow with three security gates.
- A negative authorization test associated with Issue #45.
- A successful local execution against the real `opti-sales-api` source code.
- Maven output reporting one successful test and zero failures.
- A successful YAML syntax validation.

**Current Status:** Local negative authorization test passed. YAML syntax validated. GitHub Actions execution remains unverified.
