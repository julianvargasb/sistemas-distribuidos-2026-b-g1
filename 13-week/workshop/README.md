
# Week 13 — Threat Modeling Workshop

<!-- CONFIG-START -->
- FULL_NAME: Wilkyn Julian Vargas Bahamón
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- DOCS_REPO: https://github.com/code-corhuila/opti-docs
- BOUNDARY: opti-api-gateway to opti-sales-api
- CLAIM_ISSUE: https://github.com/code-corhuila/opti-docs/issues/37
- REFLECTION_DOC:https://docs.google.com/document/d/1s9YUMq-EmfB-ChGNWzixQbkq3tAu1_oV_UjB11oNQSI/edit?usp=sharing
- LIBRARY_BOOK: PENDING
- LIBRARY_RECORD_TIME: PENDING
- STORIES: https://github.com/code-corhuila/opti-docs/issues/45, https://github.com/code-corhuila/opti-docs/issues/46, https://github.com/code-corhuila/opti-docs/issues/47
<!-- CONFIG-END -->

## 1. Workshop Scope

This workshop focuses on the security of the OptiView distributed system.

The selected trust boundary is the communication between `opti-api-gateway` and `opti-sales-api`.

The analysis focuses on sales reporting, order-status information, access control, and the protection of sensitive business information.

HU-24 provides the functional context for the security analysis.

## 2. Security Analysis

The attack surface was documented by identifying the components, entry points, assets, and trust boundaries.

The STRIDE methodology was applied to analyze six security threat categories:

- Spoofing
- Tampering
- Repudiation
- Information Disclosure
- Denial of Service
- Elevation of Privilege

The security analysis is documented in Pull Request #44.


## 3. Security Backlog

Three security stories were created and refined in the OptiView
team documentation repository.

### Issue #45 - Elevation of Privilege

Restrict seller-sales reporting to the SERVICE role.

- STRIDE: E - Elevation of Privilege
- Risk score: 6
- Priority: P1
- Acceptance criteria: authentication, role restrictions, and automated
  negative authorization testing.

### Issue #46 - Tampering

Validate sales reporting filters and seller identifiers.

- STRIDE: T - Tampering
- Risk score: 6
- Priority: P1
- Acceptance criteria: invalid input rejection, restricted data access,
  and automated validation tests.

### Issue #47 - Information Disclosure

Prevent unauthorized disclosure of confidential sales reports.

- STRIDE: I - Information Disclosure
- Risk score: 6
- Priority: P1
- Acceptance criteria: HTTP 401/403 verification, confidential data
  protection, and automated negative authorization testing.

All three stories reference STRIDE Pull Request #44 and are labeled
security and P1.

The automated authorization test has passed locally. HTTP integration
tests and execution of the complete CI workflow remain pending.

The physical library citation requires verification of the book's
publication details, library call number, and consulted pages.


## 4. Security Testing

A negative authorization test was developed for the restricted endpoint:

`GET /api/v1/reports/seller-sales`

The test verifies that a request without the required `SERVICE` role is rejected before the sales reporting use case is executed.

The test was executed locally against the real `opti-sales-api` source code.

Actual Maven results:

```text id="ca5m0c"
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

The proposed `security.yml` file was also checked using YAML Lint.

Validation result:

```text id="xk7f5d"
Valid YAML
```

These results demonstrate successful local unit-test execution and valid YAML syntax. They do not demonstrate a successful GitHub Actions execution.

## 5. Peer Review

A technical peer review was submitted in English on Pull Request #32.

The review addressed an Elevation of Privilege risk involving patient access to another patient's optical formulas.

The recommendation included negative authorization testing and clarification of current versus future security risks.

## 6. Individual Reflection

The individual reflection documents the technical learning process, security findings, development challenges, peer-review contribution, and proposed improvements for OptiView.

Reflection:

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/05-security-reflection.md

## 7. Checkpoint Status

- CP0: Completed — Trust boundary claimed.
- CP1: Completed — Attack surface documented.
- CP2: Completed — STRIDE analysis submitted in PR #44.
- CP3: Completed — Three security backlog issues created.
- CP4: Completed — Security CI proposal and negative authorization test documented.
- CP5: Completed — Peer review submitted and HU-Status updated.
- CP8: Completed for local evidence — Negative authorization unit test passed and YAML syntax validated.

Remaining work:

- Complete the verified physical library reference.
- Review outstanding workshop checkpoints and peer feedback.
- Verify all required delivery links and final submission evidence.

## 8. Evidence Links

### Trust Boundary Claim

https://github.com/code-corhuila/opti-docs/issues/37

### Attack Surface

https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md

### STRIDE Analysis

https://github.com/code-corhuila/opti-docs/pull/44

### Security Issues

https://github.com/code-corhuila/opti-docs/issues/45

https://github.com/code-corhuila/opti-docs/issues/46

https://github.com/code-corhuila/opti-docs/issues/47

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
