
# Week 13 — Individual Security Reflection

**Student:** Wilkyn Julian Vargas Bahamón  
**GitHub:** julianvargasb  
**Team:** The illusionists  
**Project:** OptiView  
**Course:** Distributed Systems

## 1. What I learned

During Week 13, I learned that securing a distributed system requires more than checking whether a user is authenticated. It is also necessary to verify authorization, identify trust boundaries, and protect information exchanged between services.

In OptiView, I analyzed the communication between `opti-api-gateway` and `opti-sales-api`, focusing on the sales reporting functionality associated with HU-24.

The STRIDE methodology helped me organize potential security threats into six categories: Spoofing, Tampering, Repudiation, Information Disclosure, Denial of Service, and Elevation of Privilege.

I understood that each threat should have a specific mitigation and a testable acceptance criterion, rather than remaining only as a theoretical risk.

## 2. My technical contribution

I documented the attack surface, developed the STRIDE analysis, and created three security backlog issues related to authorization, input validation, and information disclosure.

One of the most important findings involved the restricted endpoint:

`GET /api/v1/reports/seller-sales`

This endpoint requires the `SERVICE` role. I created a negative authorization test to verify that a request without the required role is rejected before the sales reporting use case is executed.

I ran the test locally against the real `opti-sales-api` source code using Java 21, Maven, JUnit 5, and Mockito.

The result was:

```text id="yc9gpj"
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

This demonstrated the expected controller-level security behavior. However, I recognize that an HTTP integration test is still required to verify the actual HTTP 403 response.

## 3. Difficulties and solutions

One challenge was preparing the local Java environment to execute the security test. I had to configure Java 21, install Maven, clone the service repository, and place the test in the correct Maven module.

Another challenge was distinguishing between documenting a security control and demonstrating that it works.

For this reason, I recorded the actual Maven execution results in `HOW-TO-RUN.md`.

I also validated the syntax of the proposed `security.yml` file using YAML Lint. The result was `Valid YAML`.

This validation confirmed the YAML syntax, but it did not demonstrate that the GitHub Actions security pipeline had been executed successfully.

## 4. Teamwork and peer review

I participated in the collaborative security review by commenting on Pull Request #32, which analyzes the boundary between the API gateway and the patient service.

My observation focused on the Elevation of Privilege risk associated with unauthorized access to another patient's optical formulas.

I recommended distinguishing current authorization restrictions from risks introduced by future patient access and adding negative authorization tests.

This activity demonstrated the importance of reviewing another team member's work, providing technical feedback, and proposing improvements supported by verifiable tests.

## 5. Improvements proposed for OptiView

I propose prioritizing the following security improvements:

1. Maintain role-based authorization controls for restricted sales reports.
2. Add HTTP integration tests to confirm that unauthorized requests return HTTP 403.
3. Validate seller identifiers and reporting filters before processing requests.
4. Prevent confidential sales information from being exposed to unauthorized callers.
5. Integrate secret scanning, dependency auditing, and authorization tests into the actual service CI pipeline.
6. Review security findings regularly and link corrective actions to the team backlog.

These improvements would reduce the risk of unauthorized access and help detect vulnerabilities before changes reach production.

## 6. Final reflection

This workshop allowed me to connect the theoretical concepts of distributed systems security with the real architecture of OptiView.

The most valuable part of the activity was executing an authorization test against the project's source code and documenting the result. This helped me understand the difference between proposing a mitigation and obtaining evidence that a specific control behaves as expected.

I also learned that a successful unit test does not prove that the complete distributed system is secure. Additional integration tests, automated security checks, and continuous review are necessary.

As a student, I consider this work important because it strengthens my ability to analyze technical risks, document evidence, collaborate through GitHub, and propose practical improvements to a distributed application.

## 7. Supporting evidence

**STRIDE analysis:**

https://github.com/code-corhuila/opti-docs/pull/44

**Security backlog:**

https://github.com/code-corhuila/opti-docs/issues/45

https://github.com/code-corhuila/opti-docs/issues/46

https://github.com/code-corhuila/opti-docs/issues/47

**Security CI proposal and test:**

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/tree/main/13-week/workshop/04-security-ci

**Test execution evidence:**

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md

**Peer review:**

https://github.com/code-corhuila/opti-docs/pull/32


## CP3 — Security Backlog Reflection

I learned that identifying security threats is not enough. Each important threat must become a security user story with clear acceptance criteria, an assigned priority, and automated tests.

In OptiView, I created three security issues (#45, #46, and #47) based on the STRIDE analysis of the communication between `opti-api-gateway` and `opti-sales-api`. These stories address Elevation of Privilege, Tampering, and Information Disclosure, each with a risk score of 6 and priority P1.

The first improvement I would prioritize is verifying that `GET /api/v1/reports/seller-sales` rejects requests without the required `SERVICE` role. The local authorization unit test passed, but HTTP integration testing is still needed to verify the expected 401 and 403 responses.

The main challenge is completing the integration tests and connecting the three issues to the team's GitHub Project backlog. The physical library citation also remains pending verification.

**Evidence:**
- Issue #45: https://github.com/code-corhuila/opti-docs/issues/45
- Issue #46: https://github.com/code-corhuila/opti-docs/issues/46
- Issue #47: https://github.com/code-corhuila/opti-docs/issues/47
- STRIDE Pull Request #44: https://github.com/code-corhuila/opti-docs/pull/44
