
<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       13-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 13

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julian Vargas Bahamón
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Analyze OptiView security threats, create a risk-based security backlog, and validate authorization controls for sales reporting.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-24 | Sales and order-status reporting: security analysis context | doing | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/3ad25a990500bc9b0b89c101ea31617194590db1 |
| W13-CP0 | Claim the gateway-to-sales trust boundary | done | https://github.com/code-corhuila/opti-docs/issues/37 |
| W13-CP1 | Document attack surface and trust boundaries | done | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md |
| W13-CP2 | Document six STRIDE security threats | done | https://github.com/code-corhuila/opti-docs/pull/44 |
| W13-CP3 | Create three risk-based security backlog stories | doing | https://github.com/code-corhuila/opti-docs/issues/45 |
| W13-CP4 | Propose security CI and create an authorization test | done | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md |
| W13-CP5 | Review a peer's STRIDE threat model | done | https://github.com/code-corhuila/opti-docs/pull/32 |
| W13-CP6 | Address peer feedback and refine STRIDE analysis | done | https://github.com/code-corhuila/opti-docs/pull/44#issuecomment-6512085790 |
| W13-CP7 | Refine security backlog stories and acceptance criteria | doing | https://github.com/code-corhuila/opti-docs/issues/45 |
| W13-CP8 | Execute the negative authorization test and validate YAML syntax | done | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md |
| W13-CP9 | Document the security implementation plan and final reflection | done | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/05-security-reflection.md |


## 2. My individual contribution

During Week 13, I worked on the security analysis of the OptiView distributed system, focusing on the trust boundary between `opti-api-gateway` and `opti-sales-api`.

My work was connected to HU-24, which includes sales reporting and order-status information.

### 2.1 Trust boundary and attack surface

I registered the selected trust boundary in team documentation Issue #37.

I created an attack surface document identifying the components, entry points, relevant data, and security risks associated with communication between the API gateway and the sales service.

Evidence:

https://github.com/code-corhuila/opti-docs/issues/37

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md

### 2.2 STRIDE threat modeling

I documented security threats using the six STRIDE categories:

- S: Spoofing
- T: Tampering
- R: Repudiation
- I: Information Disclosure
- D: Denial of Service
- E: Elevation of Privilege

The analysis identifies security risks at the gateway-to-sales boundary and proposes controls to reduce them.

I submitted this documentation through Pull Request #44 in `opti-docs`.

Evidence:

https://github.com/code-corhuila/opti-docs/pull/44

### 2.3 Security backlog

The three security issues have been created, prioritized, and documented with testable acceptance criteria. Their association with the team's GitHub Project Backlog remains pending.

**Issue #45 - Elevation of Privilege**

Restrict seller-sales reports to the SERVICE role.

https://github.com/code-corhuila/opti-docs/issues/45

**Issue #46 - Tampering**

Validate sales reporting filters and seller identifiers.

https://github.com/code-corhuila/opti-docs/issues/46

**Issue #47 - Information Disclosure**

Prevent unauthorized disclosure of sales reports.

https://github.com/code-corhuila/opti-docs/issues/47

These issues document security improvements and testable acceptance criteria for the OptiView project.

The three issues have not yet been linked to the team GitHub Project board. This remaining step is tracked as pending and is not claimed as completed.

### 2.4 Security CI proposal

I prepared a proposed GitHub Actions security workflow containing three security gates:

1. Gitleaks for secret scanning.
2. OWASP Dependency-Check for dependency vulnerability analysis.
3. Maven and JUnit for negative authorization testing.

The proposed workflow is documented in:

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/security.yml

This workflow has not yet been activated or executed in the real service repository.

### 2.5 Negative authorization test

I created `SalesReportAuthorizationTest.java` to verify authorization behavior for the following endpoint:

`GET /api/v1/reports/seller-sales`

The test verifies that a request without the required `SERVICE` role is rejected by the controller.

It also verifies that the reporting use case is not invoked.

The test was copied into a local clone of the real `opti-sales-api` repository and executed using Java 21, Maven, JUnit and Mockito.

Executed command:

```bash
mvn -pl sales-adapters -am -Dtest=SalesReportAuthorizationTest -Dsurefire.failIfNoSpecifiedTests=false test
```

Actual results:

```text
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] Total time: 22.495 s
[INFO] Finished at: 2026-10-28T22:50:25-05:00
```

The execution confirms that the negative authorization unit test passed against the real service source code.

The test verifies an internal forbidden error and does not independently demonstrate the HTTP 403 response from a running server.

Evidence:

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/SalesReportAuthorizationTest.java

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md

### 2.6 YAML validation

I copied the proposed `security.yml` configuration into YAML Lint.

The validator returned:

```text
Valid YAML
```

This confirmed the syntax of the proposed workflow.

However, successful syntax validation does not prove successful GitHub Actions execution.

The procedure and limitations were documented in `HOW-TO-RUN.md`.

### 2.7 Peer security review

I reviewed a teammate's security threat model in Pull Request #32.

Pull Request:

https://github.com/code-corhuila/opti-docs/pull/32

The review focused on the Elevation of Privilege threat for the patient service.

I identified the importance of distinguishing the current role restrictions from a future risk involving patient access.

I recommended adding negative authorization tests to verify that one patient cannot access another patient's optical formulas.

I also suggested a positive test to confirm legitimate access to the patient's own information.

The technical review was submitted in English through GitHub.

## 3. Blockers and risks

The following activities still require attention:

- Verify the status of Pull Request #44 and address any requested changes.
- The proposed GitHub Actions workflow has not been executed automatically in the real service repository.
- The current authorization unit test does not independently verify the HTTP 403 response through an integration test.
- Link Issues #45, #46 and #47 to the official team GitHub Project backlog when access is confirmed.
- Submit the workshop evidence and final commit URL to Moodle.

No successful CI execution is claimed without corresponding GitHub Actions logs.

## 4. Plan for next week

- Follow up on the open security Pull Request and peer-review feedback.
- Improve security controls according to the STRIDE analysis.
- Propose additional HTTP-level authorization tests.
- Coordinate integration of security checks into the real service CI pipeline.
- Maintain the security backlog and its acceptance criteria.
- Complete the pending GitHub Project board association and submit the final workshop links to Moodle.
- Continue supporting the HU-24 sales reporting functionality.

## 5. Compliance self-check

- [x] Conventional Commits - type(scope): summary
- [ ] Per-environment HU branch and PR for application implementation
- [x] Testable acceptance criteria documented in security issues
- [x] Negative authorization unit test created and executed locally
- [x] Security documentation added to the corresponding repository
- [x] DDD and hexagonal architecture boundaries respected by the test design
- [x] No secrets included in the security evidence
- [x] Peer Pull Request reviewed
- [x] YAML syntax validated
- [ ] GitHub Actions security workflow executed successfully
- [x] Physical library reference documented in the security reflection
- [x] Final reflection and implementation plan linked
- [ ] Security issues linked to the official team project board
- [ ] Final workshop submission recorded in Moodle

## 6. Evidence links

### Personal repository

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1

### Week 13 workshop

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/tree/main/13-week/workshop

### CP0 - Trust boundary claim

https://github.com/code-corhuila/opti-docs/issues/37

### CP1 - Attack surface

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md

### CP2 - STRIDE analysis Pull Request

https://github.com/code-corhuila/opti-docs/pull/44

### CP3 - Security stories

https://github.com/code-corhuila/opti-docs/issues/45

https://github.com/code-corhuila/opti-docs/issues/46

https://github.com/code-corhuila/opti-docs/issues/47

### CP4 - Security CI proposal

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/security.yml

### Negative authorization test

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/SalesReportAuthorizationTest.java

### Local execution and YAML validation

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md

### CP5 - Peer review

https://github.com/code-corhuila/opti-docs/pull/32

### CP6 - STRIDE review follow-up

https://github.com/code-corhuila/opti-docs/pull/44#issuecomment-6512085790

### CP7 - Security backlog refinement

https://github.com/code-corhuila/opti-docs/issues/45

https://github.com/code-corhuila/opti-docs/issues/46

https://github.com/code-corhuila/opti-docs/issues/47

### Workshop configuration

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/README.md

### Reflection document

Completed - The final security reflection includes the OptiView implementation plan, sprint priorities, residual risk, and lessons learned.

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/05-security-reflection.md

### Physical library reference

Documented in the security reflection: García-Morán et al., *Hacking y seguridad en internet*, 2nd edition, Ra-Ma / Ediciones de la U, 2013. ISBN 978-958-762-080-1. Physical library call number: `005.8 / G216h / Ej.1`. Pages 317 (input validation) and 321 (security-relevant records and auditing).
