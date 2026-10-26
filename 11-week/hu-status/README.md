<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       11-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 11

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->

- FULL_NAME: Wilkyn Julian Vargas Bahamon

- GITHUB_USER: julianvargasb

- TEAM: The illusionists

- SPRINT_GOAL: Assess and document OptiView observability, user-facing SLOs, symptom-based alerts and an incident runbook for MVP 3.

<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |

|---|---|---|---|

| OBS-11-A (proposed, not registered HU) | Instrument logs, request metrics and distributed trace context | todo | No Week 11 implementation PR/commit verified |

| OBS-11-B (proposed, not registered HU) | Specify user-centered SLI/SLO targets and error-budget policy | todo | Draft in `11-week/02-session/README.md`; publication pending |

| OBS-11-C (proposed, not registered HU) | Define actionable alert and rehearse order incident runbook | todo | Runbook draft; no alert/rehearsal evidence |

## 2. My individual contribution

- Prepared an October 2026 retrospective technical draft for Week 11 Sessions 01–02 based on Moodle requirements and OptiView team documentation; individual runtime instrumentation or alert configuration has not been verified.

- Specified correlation, metrics, trace acceptance checks; proposed measurable SLO targets, alert ownership and an order-failure runbook. These are documentation proposals, not completed code stories.

- Existing `opti-docs` operations guidance is team-authored context, not evidence of my implementation or authorship.

## 3. Blockers and risks

- No verified individual Week 11 instrumentation/test commit or trace recording.

- The proposed SLO thresholds, ownership, routes and alert triggers require team validation.

- A written runbook does not prove a practiced incident response.

## 4. Plan for next week

- Confirm service-specific instrumentation, agreed HU IDs and on-call owners.

- Collect traces, metric exports, log samples, CI results and a controlled incident rehearsal before promoting story status.

## 5. Compliance self-check

- [ ] Conventional Commits - `type(scope): summary` (documentation commit pending)

- [ ] Per-environment HU branch + PR to that environment (not verified)

- [ ] Testable acceptance criteria (planned; implementation checks pending)

- [ ] Tests added/updated (unit / integration) (not verified)

- [ ] DDD / hexagonal boundaries respected (runtime/code not assessed)

- [ ] No secrets; config via environment variables (full deployment verification pending)

## 6. Evidence links

- Session 01: `11-week/01-session/README.md` and `diagramas/11-week-01-observability.svg` (prepared locally; commit pending).

- Session 02: `11-week/02-session/README.md` and `diagramas/11-week-02-slo-runbook.svg` (prepared locally; commit pending).

- Team context: https://github.com/code-corhuila/opti-docs/blob/main/13-operations/observability.md and https://github.com/code-corhuila/opti-docs/blob/main/13-operations/incident-management.md.

- Moodle reference: Week 11, Sessions 01–02; planning requirements, not an implementation certificate.
