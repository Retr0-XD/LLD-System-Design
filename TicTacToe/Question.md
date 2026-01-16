# Complete LLD Interview Question: Tic-Tac-Toe

You are asked to design and implement a **Tic-Tac-Toe game in Java**.

The interviewer will guide you through **multiple stages**. You are expected to evolve your design incrementally while maintaining clean object-oriented principles.

---

## Stage 1: Core Functional Requirements (Baseline)

Design a **console-based Tic-Tac-Toe game** with the following requirements:

1. Two human players
2. Standard **3 × 3 board**
3. Players take turns
4. A move is valid only if the cell is empty and within bounds
5. Detect:

    * Win
    * Draw
6. Print the board after every move
7. Stop the game once it ends

**Expectations:**

* Identify core entities
* Define class responsibilities
* Implement a clean, readable solution
* Avoid premature optimization

---

## Stage 2: Design Quality & OOP Expectations

While implementing Stage 1, ensure:

1. **Single Responsibility Principle**
2. No god classes
3. Clear separation between:

    * Game orchestration
    * Board state
    * Player data
4. Avoid hard-coded values where reasonable

You may write full code or partial code, but it should be logically complete.

---

## Stage 3: Scalability — N × N Board

Extend your design to support an **N × N board**, where:

* N is provided at runtime
* Win condition is N consecutive symbols

**Questions you must be able to answer:**

* What changes in your design?
* Which classes are affected?
* Does your win-checking logic still scale?

---

## Stage 4: Performance Optimization (Context Management)

The current win-checking approach scans rows, columns, and diagonals.

1. Identify the **time complexity** of your solution
2. Optimize winner detection to **O(1) per move**

**Constraints:**

* No full board scan after every move
* Use minimal additional memory

You should be able to explain:

* What state you maintain
* How it is updated
* How it determines a win

---

## Stage 5: Extensibility (Design Thinking)

Discuss (no need to fully code unless asked):

1. How would you add an **AI player**?
2. How would you support:

    * Undo / Redo
    * Replay of a game
3. How would you add a **GUI** or **online multiplayer** without changing core logic?

Focus on **design evolution**, not frameworks.

---

## Stage 6: Constraints & Trade-offs

Be prepared to explain:

1. Why you didn’t optimize in Stage 1
2. When optimization becomes necessary
3. Trade-offs between readability and performance
4. What you would not implement in an interview and why

---

## What You Should Deliver (Your Side)

When you work on this:

1. Implement **Stage 1 fully**
2. Refactor to support **Stage 3**
3. Implement **Stage 4 optimization**
4. Add comments or README explaining:

    * Design decisions
    * Complexity analysis
    * Extension points

---

## How I Will Review Your Submission

When you share the GitHub link, I will review it exactly like an interviewer:

* Class design & naming
* Responsibility separation
* Correctness
* Complexity
* Extensibility
* Over-engineering vs under-engineering
* Interview readiness feedback

I will:

* Point out **interview-level mistakes**
* Suggest **design improvements**
* Tell you **whether this would pass a real LLD round**

---

## Important Instructions (Please Follow)

* Keep it **Java**
* Do **not** use frameworks
* Do **not** over-abstract initially
* Document your evolution (Stage 1 → Stage 4)

---

## Final Note (Very Important)

This is **not easy by design**.
If you can confidently handle this question, you are **LLD-ready** for:

* Product companies
* Backend roles
* System-thinking interviews

Go ahead:

1. Code it
2. Push to GitHub
3. Share the link here

I will review it thoroughly and give you **brutally honest, interview-grade feedback**.
