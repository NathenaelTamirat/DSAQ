# 🎯 DSAQ - Data Structure Questions

## 📥 Clone repository

Copy and run these commands in your terminal to clone the repository and (optionally) checkout the branch used in this workspace:

```bash
git clone https://github.com/NathenaelTamirat/DSAQ.git && cd DSAQ && git checkout NathenaelTamirat
```

## ⚙️ Prerequisites

- ☕ Java JDK 8 or newer installed. Verify with `java -version`.
- 🐚 A POSIX shell (macOS Terminal, Linux). Commands below are copy-paste ready.

---

## 🔢 Problem 13 — Online Exam Submission Platform

- 📄 Source: [Problem 13/OnlineExamSubmissionPlatform.java](Problem%2013/OnlineExamSubmissionPlatform.java)

**Run:**

```bash
cd 'Problem 13' && javac OnlineExamSubmissionPlatform.java && java OnlineExamSubmissionPlatform
```

**Interactive commands (type then Enter):**

- `SET_DEADLINE <timestamp>` — set numeric deadline (simulated time)
- `SUBMIT <student> <est_time> <timestamp>` — submit a job
- `PROCESS` — grade one submission
- `STATUS` — show queues

**How to end the program:**

- Send EOF (Ctrl+D) to exit the interactive loop cleanly
- Or terminate with Ctrl+C

**Notes:**

You can also compile/run from the repository root without changing directories:

```bash
javac 'Problem 13/OnlineExamSubmissionPlatform.java' && java -cp 'Problem 13' OnlineExamSubmissionPlatform
```

---

## 🔗 Problem 46 — Immutable Ledger

- 📄 Source: [Problem 46/ImmutableLedger.java](Problem%2046/ImmutableLedger.java)

**Run (recommended, copy-paste):**

```bash
cd '../Problem 46' && javac ImmutableLedger.java && java ImmutableLedger
```

**Interactive commands (type then Enter):**

- `ADD_BLOCK "some data"` — add a block (data in quotes)
- `VIEW_CHAIN` — print the chain
- `VALIDATE` — check integrity
- `TAMPER <block_id> "new data"` — mutate block data (for testing)

**How to end the program:**

- Send EOF (Ctrl+D) or use Ctrl+C

**Notes:**

From repository root you may run:

```bash
javac 'Problem 46/ImmutableLedger.java' && java -cp 'Problem 46' ImmutableLedger
```

---

## 💰 Problem 53 — High Stakes Auctioneer

- 📄 Source: [Problem 53/HighStakesAuctioneer.java](Problem%2053/HighStakesAuctioneer.java)

**Run (recommended, copy-paste):**

```bash
cd '../Problem 53' && javac HighStakesAuctioneer.java && java HighStakesAuctioneer
```

**Interactive commands (type then Enter):**

- `BID <user> <amount>` — place a higher bid
- `WITHDRAW` — retract top bid
- `CURRENT` — show top bid

**How to end the program:**

- Send EOF (Ctrl+D) or use Ctrl+C

**Notes:**

From repository root you may run:

```bash
javac 'Problem 53/HighStakesAuctioneer.java' && java -cp 'Problem 53' HighStakesAuctioneer
```

---

## 💡 NB

- When following the recommended flow above, start in the repository root after cloning (`cd DSAQ`) and run the exact blocks shown for each problem.
- If your shell interprets spaces differently, the `cd 'Problem 13'` style ensures folder names with spaces are handled correctly.
- If you want me to add example input sequences for any program, tell me which problem and I'll append sample sessions.

---

## 👥 Team Members

- Nathenael Tamirat - BITS/UGR/0297/25
- Oliyad Bekele - BITS/UGR/0303/25
- Yani Akram - BITS/UGR/0351/25

## Gratitude

We would like to express our gratitude to our instructors Mr. Zelalem and Mr. Dagim for this project.
