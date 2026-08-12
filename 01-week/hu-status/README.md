<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.

```
 Your weekly grade is read AUTOMATICALLY from this file:
   01-week/hu-status/README.md  (inside YOUR fork). English. -->
```

# Weekly Status - Week 01

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->

* FULL_NAME: Wilkyn Julián Vargas Bahamón
* GITHUB_USER: julianvargasb
* TEAM: The illusionists
* SPRINT_GOAL: Generation of first documentation (PDR) based on the instructions provided by the teacher

<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID      | Title                                   | Status (todo/doing/done) | Evidence (PR or commit URL)                                                     |
| ---------- | --------------------------------------- | ------------------------ | ------------------------------------------------------------------------------- |
| HU-W01-001 | Distributed Systems Concept Graph       | done                     | https://github.com/julianvargasb/sistemas-distribuidos-2026-b-g1/commit/debde1e |
| HU-W01-002 | Initial OptiView PDR Technical Proposal | doing                    | ./optiview_pdr_proposal.md                                                      |

## 2. My individual contribution

* Created a concept graph integrating the main concepts from the two Week 01 distributed systems documents.
* Developed an initial technical proposal for the OptiView PDR.
* Proposed initial bounded contexts for Patient Management, Clinical Management, Order Management, Inventory Management, Billing and Payments, and Notification Management.
* Proposed strong consistency for critical inventory operations.
* Proposed Saga for multi-service work order processes.
* Proposed idempotency for payment operations.
* Proposed asynchronous notifications using events and a message broker.
* Proposed the Transactional Outbox pattern for reliable event publication.
* Proposed resilience mechanisms such as Retry, Backoff, Timeout, and Circuit Breaker.
* Proposed Hexagonal Architecture and an initial testing strategy for OptiView.

## 3. Blockers and risks

* The team is still defining individual responsibilities and refining the initial PDR.
* Some architectural decisions may change after the final distribution of responsibilities and definition of the main bounded contexts.

## 4. Plan for next week

* Refine the OptiView PDR with the team.
* Define individual responsibilities within the project.
* Validate the proposed bounded contexts.
* Review the distributed architecture and communication strategy.
* Continue working on the assigned user stories and technical documentation.

## 5. Compliance self-check

* [x] Conventional Commits - `type(scope): summary`
* [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
* [ ] Testable acceptance criteria
* [ ] Tests added/updated (unit / integration)
* [x] DDD / hexagonal boundaries respected (domain has no I/O)
* [x] No secrets; config via environment variables

## 6. Evidence links

* [Distributed Systems Concept Graph](./distributed_systems_concept_graph.md)
* [Initial OptiView PDR Technical Proposal](./optiview_pdr_proposal.md)

