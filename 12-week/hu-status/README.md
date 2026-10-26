<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       12-week/hu-status/README.md  (inside YOUR fork). English. -->

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

| DEP-12-A (proposed, not registered HU) | Promote the same tagged image digest across environments | todo | No Week 12 promotion record verified |

| DEP-12-B (proposed, not registered HU) | Provision reproducible configuration from infrastructure as code | todo | No clean-environment recreation evidence verified |

| DEP-12-C (proposed, not registered HU) | Execute blue-green health-gated release and timed rollback | todo | No deploy/traffic/rollback test verified |

## 2. My individual contribution

- Prepared an October 2026 retrospective technical draft for Week 12 Sessions 01–02, relating deployment strategies and IaC to the OptiView documented Docker Compose topology.

- Designed immutable artifact-promotion gates, a proposed blue-green flow, health checks, fallback criteria and a reproducibility/rollback test matrix.

- Existing container-publishing workflow is a separate team contribution; it does not establish individual Week 12 authorship or successful cloud deployment.

## 3. Blockers and risks

- No verified production-like deployment, traffic switch or timed rollback run.

- A single Compose host does not imply load-balanced zero-downtime cutover; a reverse proxy and parallel slots require verification.

- Database migrations, environment parity and release approvals remain unverified.

## 4. Plan for next week

- Confirm deployment host, platform, environment configuration, published digest and owners.

- Run QA health-gated promotion and rollback drill; attach timestamps, CI/PR URLs and tests before declaring any implementation done.

## 5. Compliance self-check

- [ ] Conventional Commits - `type(scope): summary` (documentation commit pending)

- [ ] Per-environment HU branch + PR to that environment (not verified)

- [ ] Testable acceptance criteria (planned; implementation checks pending)

- [ ] Tests added/updated (unit / integration) (not verified)

- [ ] DDD / hexagonal boundaries respected (runtime/code not assessed)

- [ ] No secrets; config via environment variables (full deployment verification pending)

## 6. Evidence links

- Session 01: `12-week/01-session/README.md` and `diagramas/12-week-01-blue-green.svg` (prepared locally; commit pending).

- Session 02: `12-week/02-session/README.md` and `diagramas/12-week-02-iac-rollback.svg` (prepared locally; commit pending).

- Team architecture context: https://github.com/code-corhuila/opti-docs/blob/main/05-architecture/deployment.md.

- Related team CI change (not individual Week 12 evidence): https://github.com/code-corhuila/opti-sales-api/commit/55719ef0a20cbce2f3373cb14de5a11d46be6836

- Moodle reference: Week 12, Sessions 01–02; planning requirements, not an implementation certificate.
