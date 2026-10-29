<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       13-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 13

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julian Vargas Bahamón
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Map OptiView trust boundaries and propose security backlog and tests for sales reporting.
<!-- CONFIG-END -->

## 1. User stories worked this week
| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-24 | Sales and order-status reporting: threat-modeling context | doing | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/3ad25a990500bc9b0b89c101ea31617194590db1 |
| W13-CP0 | Claim sales API trust boundary and set up workshop | done | https://github.com/code-corhuila/opti-docs/issues/37 |
| W13-CP1 | Map attack surface and trust boundaries | done | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/3ad25a990500bc9b0b89c101ea31617194590db1 |
| W13-CP2 | STRIDE analysis for gateway-to-sales API boundary | todo | PR not yet verified |
| W13-CP3 | Create three security backlog issues | todo | Issues not yet verified |
| W13-CP4 | Security CI and negative authorization test | todo | Test and workflow not yet verified |
| W13-CP5 | Peer review and checkpoint closeout | doing | This weekly status draft; peer review pending |

## 2. My individual contribution
- Claimed the trust boundary from `opti-api-gateway` to `opti-sales-api` in team documentation issue #37.
- Created `13-week/workshop/README.md` with project and boundary configuration.
- Corrected the CONFIG comment markers in a separate commit without rewriting history.
- Created `13-week/workshop/01-attack-surface.md` with a Mermaid flow diagram, trust-boundary inventory, asset classifications, entry points, and security observations.
- Related the analysis to the HU-24 sales and order-status reporting workflow and OptiView services.

## 3. Blockers and risks
- The physical library book citation and library registration time have not been entered in the workshop CONFIG.
- The reflection document URL has not been entered in the workshop CONFIG.
- Exact report endpoint paths and currently enforced authorization controls still require confirmation against implementation.
- CP2 PR, CP3 issues, CP4 tests, and CP5 peer-review comment require publication and verification.

## 4. Plan for next week
- Complete the six STRIDE categories for the claimed boundary in a separate `opti-docs` security branch and keep the PR open for peer review.
- Create three risk-ranked security stories with automated acceptance criteria in the team GitHub Project.
- Add proposed security CI checks and execute a negative authorization test; record actual output only after execution.
- Complete the library references, reflection evidence, and final workshop checkpoints.

## 5. Compliance self-check
- [x] Conventional Commits - `type(scope): summary` (CP1 and CONFIG correction)
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [ ] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [ ] No secrets; config via environment variables

## 6. Evidence links
- Personal fork: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1
- Workshop folder: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/tree/main/13-week/workshop
- Workshop setup: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/README.md
- Boundary claim: https://github.com/code-corhuila/opti-docs/issues/37
- CP0 initial commit: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/c45fc4e88952310fdd009741e0ae5a9f72446a54
- CONFIG correction: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/acfa8e54de8b6ad0c772bf39070834a61ae33d84
- CP1 attack surface: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/blob/main/13-week/workshop/01-attack-surface.md
- CP1 commit: https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/3ad25a990500bc9b0b89c101ea31617194590db1
- Team documentation: https://github.com/code-corhuila/opti-docs
- CP2 PR: pending
- CP3 stories: pending
- CP5 peer review: pending
- Reflection document: pending
