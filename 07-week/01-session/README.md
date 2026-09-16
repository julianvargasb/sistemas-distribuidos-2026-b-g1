\# Week 07 - Session 01



\## Inter-service Communication



This session focused on communication strategies between distributed services using REST, gRPC and asynchronous messaging.



\### Communication models



```text

Synchronous

Service A ── REST / gRPC ──> Service B

&#x20;         <── Response ─────



Asynchronous

Producer ── Event ──> Broker ──> Consumer

&#x20;                        ├──────> Consumer

&#x20;                        └──────> Consumer

