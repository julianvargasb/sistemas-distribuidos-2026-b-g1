<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       08-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 08

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julian Vargas Bahamon
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Plan and organize the MVP 2 through story mapping, estimation and distributed-team practices.
<!-- CONFIG-END -->

## 1. User stories worked this week
| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-PLAN-002 | Define story mapping and MVP 2 planning strategy | done | Week 08 session documentation |
| HU-DEVOPS-001 | Document Scrum and DevOps workflow for distributed teams | done | Week 08 session documentation |

## 2. My individual contribution
- Documented Scrum and DevOps practices for the OptiView distributed team.
- Documented the story mapping and MVP 2 planning process.
- Identified relative estimation, WIP limits and flow metrics.
- Documented cross-service dependency management using contract-first development and mocks.
- Added visual diagrams for Scrum/DevOps and MVP 2 story mapping.

## 3. Blockers and risks
- Dependencies between services can block development if contracts are not defined early.
- Excessive WIP can result in multiple unfinished stories.
- MVP 2 scope must remain aligned with the team's real velocity.

## 4. Plan for next week
- Refine the MVP 2 backlog.
- Maintain explicit contracts between dependent services.
- Continue development according to the prioritized backlog and Sprint Goal.

## 5. Compliance self-check
- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

## 6. Evidence links
- `08-week/01-session/README.md`
- `08-week/01-session/diagramas/08-week-01-scrum-devops.svg`
- `08-week/02-session/README.md`
- `08-week/02-session/diagramas/08-week-02-story-map-mvp2.svg`