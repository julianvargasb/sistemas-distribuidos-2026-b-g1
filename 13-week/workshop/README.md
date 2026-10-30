
# Week 13 — Threat Modeling Workshop

<!-- CONFIG-START -->
- FULL_NAME: Wilkyn Julian Vargas Bahamón
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- DOCS_REPO: https://github.com/code-corhuila/opti-docs
- BOUNDARY: opti-api-gateway to opti-sales-api
- CLAIM_ISSUE: https://github.com/code-corhuila/opti-docs/issues/37
- REFLECTION_DOC: https://docs.google.com/document/d/1s9YUMq-EmfB-ChGNWzixQbkq3tAu1_oV_UjB11oNQSI/edit?usp=sharing
- LIBRARY_BOOK: Garcia-Moran et al., Hacking y seguridad en internet, 2nd edition, Ra-Ma / Ediciones de la U. CORHUILA, Biblioteca Antonio Farid Campos Polania. Call number: 005.8 / G216h / Ej.1. Barcode: 0011098. Consulted printed pages: 317 and 321. Publication year pending confirmation against the physical copyright page.
- LIBRARY_RECORD_TIME: 2026-10-28, approximately 18:38–18:40 (Colombia time). Exact time subject to library record verification.
- STORIES: https://github.com/code-corhuila/opti-docs/issues/45, https://github.com/code-corhuila/opti-docs/issues/46, https://github.com/code-corhuila/opti-docs/issues/47
<!-- CONFIG-END -->

## 1. Workshop Scope

This workshop focuses on the security of the OptiView distributed system.

The selected trust boundary is the communication between `opti-api-gateway` and `opti-sales-api`.

The analysis focuses on sales reporting, order-status information, access control, and the protection of sensitive business information.

HU-24 provides the functional context for the security analysis.

The assessment distinguishes source-code and configuration evidence from runtime behavior that has not yet been independently verified.

## 2. Security Analysis

The attack surface was documented by identifying the components, entry points, assets, data flows, and trust boundaries.

The STRIDE methodology was applied to analyze six security threat categories:

- Spoofing
- Tampering
- Repudiation
- Information Disclosure
- Denial of Service
- Elevation of Privilege

The security analysis is documented in Pull Request #44:

https://github.com/code-corhuila/opti-docs/pull/44

The STRIDE analysis includes:

- A concrete reporting endpoint and trust boundary.
- Likelihood, impact, and risk scores.
- Existing controls supported by repository evidence.
- Proposed security mitigations.
- A specific residual risk, its owner, and its review condition.
- Physical-library references supporting input validation and auditing.

The PR has been submitted and updated. Its review and merge status remain subject to the team's workflow.

## 3. Security Backlog

Three security user stories were created and refined in the OptiView team documentation repository.

### Issue #45 — Elevation of Privilege

Restrict seller-sales reporting to callers with the `SERVICE` role.

- STRIDE: E — Elevation of Privilege
- Risk score: 6
- Priority: P1
- Labels: `security`, `P1`
- Acceptance criteria: authentication, role restrictions, automated negative authorization testing, and positive authorized-access testing.
- Source: STRIDE PR #44

Issue:

https://github.com/code-corhuila/opti-docs/issues/45

### Issue #46 — Tampering

Validate sales reporting filters and seller identifiers before processing report requests.

- STRIDE: T — Tampering
- Risk score: 6
- Priority: P1
- Labels: `security`, `P1`
- Acceptance criteria: rejection of malformed seller identifiers, invalid date-time filters, and unexpected query parameters.
- Source: STRIDE PR #44

Issue:

https://github.com/code-corhuila/opti-docs/issues/46

### Issue #47 — Information Disclosure

Prevent unauthorized disclosure of confidential seller-sales reports.

- STRIDE: I — Information Disclosure
- Risk score: 6
- Priority: P1
- Labels: `security`, `P1`
- Acceptance criteria: negative authorization testing, prevention of confidential report disclosure, and positive regression testing.
- Source: STRIDE PR #44

Issue:

https://github.com/code-corhuila/opti-docs/issues/47

### Physical Library Evidence

The physical-library reference was verified using photographs of the CORHUILA library copy.

Bibliographic information:

- Title: Hacking y seguridad en internet
- Main author: Jean Paul Garcia-Moran and collaborators
- Edition: Second edition
- Publisher: Ra-Ma / Ediciones de la U
- Library: CORHUILA — Biblioteca Antonio Farid Campos Polania
- Call number: 005.8 / G216h / Ej.1
- Copy barcode: 0011098
- Chapter 6: Ataques SQL Injection a bases de datos
- Primary consulted page: 317
- Section 6.9: Proteccion frente a SQL Injection
- Complementary consulted page: 321
- Section 6.9.1: Analizando registros

Page 317 explains the importance of validating application inputs and using appropriate filtering strategies to reject dangerous or unexpected values.

This provides conceptual support for validating the `sellerId`, `from`, and `to` parameters of the OptiView seller-sales reporting endpoint.

Page 321 discusses auditing and reviewing database transaction records as complementary security controls.

These references support general security principles. They do not establish that OptiView contains an SQL Injection vulnerability or that all proposed monitoring controls have been implemented.

The publication year remains pending confirmation against the physical copyright page.

The verified physical-library reference was incorporated into Issue #46 and the STRIDE analysis in PR #44.

### CP3 Pending Requirement

The three security issues have been created, labeled, prioritized, and linked to the STRIDE analysis.

Their association with the team's GitHub Project board, specifically the `Backlog` column, remains pending because the correct team Project has not yet been identified or made accessible.

No additional issues need to be created.

## 4. Security Testing

A negative authorization test was developed for the restricted endpoint:

`GET /api/v1/reports/seller-sales`

The endpoint requires the `SERVICE` role.

The test verifies that a request without the required role is rejected before the sales reporting use case is executed.

The test was executed locally against the real `opti-sales-api` source code.

### Local Maven Test Results

```text
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

The proposed `security.yml` file was also checked using YAML Lint.

### YAML Validation Result

```text
Valid YAML
```

These results demonstrate successful local unit-test execution and valid YAML syntax.

They do not demonstrate a successful GitHub Actions execution or confirm the HTTP behavior of a deployed gateway.

HTTP integration tests and verification of the complete CI workflow remain pending.

## 5. Peer Review

A technical peer review was submitted in English on Pull Request #32.

The review addressed an Elevation of Privilege risk involving patient access to another patient's optical formulas.

The recommendation included negative authorization testing and clarification of current versus future security risks.

Peer review:

https://github.com/code-corhuila/opti-docs/pull/32

The STRIDE analysis in PR #44 was also refined to distinguish verified repository evidence from unverified deployment behavior.

## 6. Individual Reflection

The individual reflection documents the technical learning process, security findings, development challenges, peer-review contribution, and proposed improvements for OptiView.

The CP3 reflection explains how three STRIDE findings were converted into testable security backlog stories.

Reflection:

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/05-security-reflection.md

## 7. Checkpoint Status

- CP0: Completed — Trust boundary claimed in Issue #37.
- CP1: Completed — Attack surface documented in the individual fork.
- CP2: Submitted and documented — STRIDE analysis and verified physical-library references incorporated into PR #44. The PR remains open.
- CP3: In progress — Three security backlog issues created, labeled, prioritized, and documented. Association with the team's GitHub Project Backlog remains pending.
- CP4: Documented — Security CI proposal and negative authorization test included in the repository.
- CP5: Documented — Peer review submitted and HU-Status updated.
- CP8: Local evidence completed — Negative authorization unit test passed and YAML syntax validated. GitHub Actions execution has not been confirmed.

### Remaining Work

- Identify the GitHub Project board used by The illusionists.
- Add Issues #45, #46, and #47 to the team Project's `Backlog` column.
- Verify the three issues appear in the correct board.
- Confirm the physical book's publication year against its copyright page.
- Review any outstanding workshop checkpoints and peer feedback.
- Verify all required delivery links and final submission evidence.
- Confirm PR #44 review or merge requirements according to the team's workflow.

## 8. Evidence Links

### Trust Boundary Claim

https://github.com/code-corhuila/opti-docs/issues/37

### Attack Surface

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md

### STRIDE Analysis

https://github.com/code-corhuila/opti-docs/pull/44

### Security Issues

Issue #45 — Elevation of Privilege:

https://github.com/code-corhuila/opti-docs/issues/45

Issue #46 — Tampering:

https://github.com/code-corhuila/opti-docs/issues/46

Issue #47 — Information Disclosure:

https://github.com/code-corhuila/opti-docs/issues/47

### Physical Library Evidence

The physical-library citation, call number, and consulted pages are documented in Issue #46 and STRIDE PR #44.

### Security CI Configuration

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/security.yml

### Negative Authorization Test

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/SalesReportAuthorizationTest.java

### Execution Evidence

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/04-security-ci/HOW-TO-RUN.md

### Peer Review

https://github.com/code-corhuila/opti-docs/pull/32

### HU-Status

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/hu-status/README.md

### Individual Reflection

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/05-security-reflection.md
