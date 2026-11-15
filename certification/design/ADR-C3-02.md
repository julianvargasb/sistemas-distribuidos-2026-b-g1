# ADR-C3-02: Multi-AZ Disaster Recovery for Critical Sales Data

## Status

Proposed

## Context

As described in Section 4 (Disaster Recovery) of the OptiView architecture design note, sales transactions and product inventory information are critical to business operations.

An infrastructure failure affecting the primary database could interrupt sales processing and compromise access to transaction records. The proposed architecture therefore requires a recovery strategy that reduces downtime and limits potential data loss.

The recovery objectives are an RTO of 30 minutes and an RPO of 5 minutes. These are design targets, not currently achieved service levels.

## Decision

Adopt an active-standby disaster recovery strategy across two Huawei Cloud availability zones, using a proposed RDS for PostgreSQL Multi-AZ configuration for critical persistence.

The primary database would serve normal operations, while a standby instance in a separate availability zone would provide redundancy.

The strategy includes continuous replication, monitored failover, regular backups, point-in-time recovery, and periodic recovery exercises.

Following a failure, the recovery process must verify database availability, restore application connectivity, and reconcile incomplete sales and inventory operations using the established Saga coordination rules.

Compliance with the proposed RTO and RPO must be demonstrated through recovery testing.

## Alternatives considered

- **Single-zone database with periodic backups:** Rejected because backup restoration alone may require excessive recovery time and may not meet the proposed five-minute RPO.
- **Active-active database architecture:** Rejected for this stage because it introduces greater complexity in data synchronization, conflict resolution, consistency management, and operational costs.

## Consequences

- **Positive:** Improved resilience against availability-zone failures, reduced risk of prolonged service interruption, stronger data protection, and measurable recovery objectives.
- **Negative:** Additional infrastructure costs, replication and failover complexity, operational monitoring requirements, and the need for regular disaster recovery testing.

The proposed RTO and RPO cannot be considered achieved until documented recovery exercises verify actual restoration times and recoverable data.
