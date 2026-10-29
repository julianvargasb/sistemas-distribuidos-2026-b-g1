
## 7. Verification Status

**Execution date:** October 28, 2026, 22:50 (Colombia, UTC-5).

**Environment:**
- Operating system: Windows 11
- Java: Eclipse Temurin JDK 21.0.12.1
- Maven: Apache Maven 3.9.16
- Service: opti-sales-api
- Module: sales-adapters

**Executed command:**

```bash
mvn -pl sales-adapters -am -Dtest=SalesReportAuthorizationTest -Dsurefire.failIfNoSpecifiedTests=false test
```

**Actual console output:**

```text
[INFO] Running co.edu.corhuila.opti.sales.adapter.in.http.SalesReportAuthorizationTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Reactor Summary for opti-sales-api 1.0.0:
[INFO] opti-sales-api ..................................... SUCCESS
[INFO] sales-core ......................................... SUCCESS
[INFO] sales-adapters ..................................... SUCCESS
[INFO] BUILD SUCCESS
[INFO] Total time: 22.495 s
[INFO] Finished at: 2026-10-28T22:50:25-05:00
```

**Security conclusion:**

The negative authorization unit test passed against the real opti-sales-api source code.

The test confirms that a request without the required SERVICE role produces ErrorCode.FORBIDDEN before the controller invokes the report use case.

This provides automated evidence for the authorization control described in security Issue #45.

The HTTP 403 response and the GitHub Actions pipeline have not yet been executed or independently verified.

## 8. Security Workflow YAML Validation

**File:** 13-week/workshop/04-security-ci/security.yml

**Validation tool:** YAML Lint (https://www.yamllint.com/)

**Validation result:** Valid YAML

**Verification performed:**

The complete security.yml content was copied from the OptiView workshop repository and submitted to the YAML Lint validator.

The validator returned the message "Valid YAML", confirming that the file has valid YAML syntax.

**Security controls defined in the workflow:**

1. Secret scanning using Gitleaks.
2. Dependency vulnerability auditing using OWASP Dependency-Check.
3. Negative authorization testing using Maven and JUnit.

**Limitations:**

This validation confirms YAML syntax only. It does not prove that GitHub Actions executed successfully or that the three security gates passed.

**Conclusion:**

The proposed security workflow passed YAML syntax validation. The negative authorization unit test was independently executed and passed locally.

