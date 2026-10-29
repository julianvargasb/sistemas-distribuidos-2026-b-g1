
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
