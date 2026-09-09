\# Week 06 - Session 01



\## Docker Compose and Service Orchestration



This session focused on the orchestration of distributed services using Docker Compose.



\### Main concepts



\- Multi-service orchestration with Docker Compose.

\- Shared network between containers.

\- Service discovery using service names.

\- Startup dependencies with `depends\_on`.

\- Service availability verification using `healthcheck`.

\- Persistent data using volumes.

\- Configuration through environment variables.



\### Conceptual flow



```text

Frontend

&#x20;  |

API Gateway

&#x20;  |

Backend Services

&#x20;  |

Database

&#x20;  |

Persistent Volume



Docker Compose

&#x20;├── Shared Network

&#x20;├── Service Discovery

&#x20;├── depends\_on

&#x20;└── healthcheck

