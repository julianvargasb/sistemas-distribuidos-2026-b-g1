<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       02-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 02

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julián Vargas Bahamón
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Practice GitFlow promotion across development, QA, and production environments with traceable Pull Requests and Scrum-based task tracking.
<!-- CONFIG-END -->

## 1. User stories worked this week
| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-W02-001 | GitFlow test page and environment promotion | done | https://github.com/julianvargasb/gitflow-distributed-systems-test/pull/1 |

## 2. My individual contribution
- Created a test repository to demonstrate the GitFlow workflow.
- Created and used the develop, qa, and main branches to represent development, quality assurance, and production.
- Implemented HU-01 using a dedicated development branch.
- Promoted HU-01 to develop through Pull Request #1.
- Promoted HU-01 to qa through Pull Request #2.
- Created release/1.0.0 and promoted the validated version to main through Pull Request #3.
- Created a GitHub Projects board to track the user story using a Scrum-based workflow.
- Assigned HU-01 to the current iteration and tracked it through the workflow until Done.
- Collected visual evidence of the complete workflow.

## 3. Blockers and risks
- No critical blockers were identified during the exercise.
- The workflow was implemented in a test repository for academic demonstration purposes.

## 4. Plan for next week
- Continue applying the GitFlow workflow to new user stories.
- Continue using GitHub Projects to track user stories and iterations.
- Apply the workflow to the team product as new requirements are defined.

## 5. Compliance self-check
- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

## 6. Evidence links
- GitFlow test repository: https://github.com/julianvargasb/gitflow-distributed-systems-test
- Pull Request #1 - HU-01 to develop: https://github.com/julianvargasb/gitflow-distributed-systems-test/pull/1
- Pull Request #2 - HU-01 to QA: https://github.com/julianvargasb/gitflow-distributed-systems-test/pull/2
- Pull Request #3 - Release 1.0.0 to main: https://github.com/julianvargasb/gitflow-distributed-systems-test/pull/3
- [Visual evidence](./evidence/)