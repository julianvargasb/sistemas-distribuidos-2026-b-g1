# ADR-C3-01: Horizontal Scaling for Sales and Products APIs

## Status

Proposed

## Context

As described in Section 3 (Scalability) of the OptiView architecture design note, sales and product operations may experience increased demand and concurrent requests. A deployment dependent on a single application instance can create availability and performance limitations.

The proposed Huawei Cloud architecture must support workload growth while preserving inventory consistency, transaction idempotency, and operational cost control.

## Decision

Adopt selective horizontal scaling for `opti-sales-api` and `opti-products-api` using Huawei Cloud Container Engine (CCE), with application replicas distributed across two availability zones.

For `opti-sales-api`, configure an initial minimum of 2 replicas and maximum of 6, with scaling triggered when average CPU utilization exceeds 70% for five minutes or p95 request latency exceeds 800 ms for five minutes.

For `opti-products-api`, configure an initial minimum of 2 replicas and maximum of 5, with scaling triggered when average CPU utilization exceeds 65% for five minutes or p95 query latency exceeds 500 ms for five minutes.

These thresholds are proposed engineering targets and must be validated through load testing. Idempotency and concurrency controls must remain effective across all replicas.

## Alternatives considered

- **Vertical scaling:** Increasing the resources of a single application instance was rejected because it does not provide the same level of redundancy and remains limited by the capacity of one instance.
- **Fixed replica count without autoscaling:** Maintaining a constant number of replicas was rejected because it may waste resources during low-demand periods and provide insufficient capacity during traffic peaks.

## Consequences

- **Positive:** Improved application availability, flexible capacity management, better workload distribution, and reduced dependency on individual application instances.
- **Negative:** Increased infrastructure complexity, additional monitoring requirements, potentially higher operating costs, and greater demands on distributed transaction consistency.

The decision remains proposed until technical feasibility, performance, and costs are validated.
