\# Week 06 - Session 02



\## Environments and Configuration



This session focused on defining how OptiView should operate across development, QA and production environments.



\### Main concepts



\- Development, QA and production environments.

\- Same application artifact across environments.

\- Configuration through environment variables.

\- `.env.example` as configuration reference.

\- Secrets must remain outside Git.

\- Relationship between branches and environments.

\- Orchestration work organized through user stories.



\### Environment flow



```text

Development

&#x20;   |

&#x20;   v

&#x20;  QA

&#x20;   |

&#x20;   v

Production



Same application

Different configuration

Secrets outside Git

