# World Simulation Engine

> A modular, extensible simulation engine for modeling complex socio-economic systems and entity interactions.

##  Project Goal
This project is an engineering study on **Object-Oriented Design**, **System Architecture**, and **Clean Code**. 
The goal is to build a simulation engine capable of evolving a persistent world with population, economy, and dynamic events, focusing on backend logic rather than graphical interfaces.

**Key Focus Areas:**
* Polymorphism & Abstraction (Strategy Pattern for Rules)
* State Management & Encapsulation
* Layered Architecture (Decoupling Domain from Infrastructure)
* Java Core (Streams, Collections, Enums)

## Architecture
The project follows a strict evolution plan to ensure code quality:

* **Phase 1 (MVP):** Core logic implementation using pure Java (No Frameworks). Console-based interface to focus on domain modeling.
* **Phase 2 (Domain):** Advanced OO concepts (Enums, Composition) to model complex behaviors.
* **Phase 3 (Events):** Implementation of an Event-Driven design for dynamic world updates.
* **Phase 4 (Persistence):** Integration with SQL Database using JPA/Hibernate.
* **Phase 5 (API):** Exposing the engine via REST endpoints using Spring Boot.

##  Tech Stack
* **Language:** Java (LTS Version)
* **Build Tool:** Maven/Gradle (To be added)
* **Version Control:** Git

##  Development Roadmap

- [ ] **Phase 0:** Project Setup & Repository Structure
- [ ] **Phase 1:** Core Simulation Loop (World, Time, Population)
- [ ] **Phase 2:** Economy & Professions Implementation
- [ ] **Phase 3:** Event System & Dynamic Rules
- [ ] **Phase 4:** Database Persistence
- [ ] **Phase 5:** REST API & Documentation

---
*Developed by Vítor Henrique Cardoso*