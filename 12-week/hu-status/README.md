
<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       12-week/hu-status/README.md (inside YOUR fork). English. -->

# Weekly Status - Week 12

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julian Vargas Bahamon
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Design and assess OptiView MVP 3 image promotion, infrastructure-as-code, blue-green deployment and a verified rollback rehearsal.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| DEP-12-A (proposed, not registered HU) | Promote the same tagged image digest across environments | todo | Deployment planning documentation: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/4aeff79860055980f26065abe7d691c5f23e8225. Environment promotion not verified. |
| DEP-12-B (proposed, not registered HU) | Provision reproducible configuration from infrastructure as code | todo | IaC planning documentation published in Week 12 Session 02. Environment recreation not verified. |
| DEP-12-C (proposed, not registered HU) | Execute blue-green health-gated release and timed rollback | todo | Deployment and rollback proposals documented. Runtime execution not verified. |

## 2. My individual contribution

- Prepared and published technical documentation for Week 12 Sessions 01 and 02, applying cloud deployment and infrastructure planning concepts to the existing OptiView project architecture.
- Reviewed the differences between infrastructure as a service (IaaS), platform as a service (PaaS), managed containers and serverless deployment models.
- Analyzed OptiView's documented Docker Compose deployment topology as the baseline for evaluating production-like environments.
- Documented a proposed immutable artifact promotion process in which the same versioned container image is deployed across development, QA and production environments.
- Proposed a blue-green deployment strategy to reduce service interruption risk when introducing a new application version.
- Defined the importance of health checks, traffic switching and keeping the previous stable application version available for rollback.
- Documented infrastructure-as-code principles for maintaining consistent and reproducible deployment environments.
- Prepared a deployment verification and rollback planning matrix covering image identity, health verification, release validation and recovery evidence.
- Created two technical diagrams illustrating the proposed blue-green deployment process and infrastructure-as-code/rollback workflow.
- Related the Week 12 deployment requirements to the existing OptiView technical documentation and its container-based architecture.
- Published the documentation through commit `4aeff79`.
- The contribution represents technical analysis and deployment planning. No individual production-like deployment or timed rollback execution has been verified.

## 3. Blockers and risks

- No verified Week 12 deployment record demonstrates a working blue-green release or successful traffic switching.
- Existing container publication capabilities do not independently prove successful promotion of the same artifact across development, QA and production.
- A single-host Docker Compose environment does not automatically guarantee zero-downtime deployment.
- Blue-green deployment requires confirmed traffic-routing behavior, health checks and parallel availability of application versions.
- Environment configuration, infrastructure reproducibility and production parity require additional validation.
- Database migration compatibility and recovery procedures must be reviewed before any deployment can be classified as safely reversible.
- A documented rollback strategy is not evidence of a rehearsed or timed rollback.
- Proposed deployment story identifiers require approval against the official OptiView backlog.

## 4. Plan for next week

- Continue with the next MVP 3 requirements, including security considerations and CI/CD improvements.
- Review the deployment environment, selected platform and infrastructure configuration with the team.
- Verify the availability of versioned container images and identify the evidence needed for environment promotion.
- Plan a controlled deployment validation procedure using health checks and measurable recovery criteria.
- Coordinate the execution of a rollback rehearsal and collect timestamps, command outputs and verification results.
- Update the proposed stories with real implementation evidence when corresponding commits, pull requests and test results become available.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary` (documentation commit `4aeff79` published successfully).
- [ ] Per-environment HU branch + PR to that environment (not verified for this contribution).
- [ ] Testable acceptance criteria (documented as proposals; runtime verification pending).
- [ ] Tests added/updated (unit / integration) (not verified).
- [ ] DDD / hexagonal boundaries respected (implementation verification pending).
- [ ] No secrets; config via environment variables (complete deployment verification pending).

## 6. Evidence links

- Week 12 documentation commit: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/4aeff79860055980f26065abe7d691c5f23e8225

- Session 01 documentation: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/12-week/01-session/README.md

- Session 01 blue-green deployment diagram: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/12-week/01-session/diagramas/12-week-01-blue-green.svg

- Session 02 documentation: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/12-week/02-session/README.md

- Session 02 infrastructure-as-code and rollback diagram: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/12-week/02-session/diagramas/12-week-02-iac-rollback.svg

- OptiView deployment architecture (team context): https://github.com/code-corhuila/opti-docs/blob/main/05-architecture/deployment.md

- Related team container publication commit (not individual Week 12 implementation evidence): https://github.com/code-corhuila/opti-sales-api/commit/55719ef0a20cbce2f3373cb14de5a11d46be6836

- Academic reference: CORHUILA, Distributed Systems 2026-B, Week 12, Sessions 01 and 02.

**Evidence scope:** The cited individual commit demonstrates published technical deployment documentation, not an executed MVP 3 release, validated infrastructure recreation or rehearsed rollback.
