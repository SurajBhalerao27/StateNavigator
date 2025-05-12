# RandomNav 🎲

**A simple Java utility for navigating through randomly generated values — forward, backward, and with memory.**

---

## ✨ What It Does

This tool acts like a "browser history" for generated values.  
- `next()` → generates and remembers a new value  
- `previous()` ← goes back to a previously generated one  
- Caches all values so you can revisit or replay them  

Originally built to solve a basic frustration:  
> When a test fails with a random input, it’s hard to go back and see what caused it.

---

## 💡 Use Cases

- ✅ Replay test cases in debugging  
- ✅ Procedural game/event content  
- ✅ Quiz or flashcard-style apps  
- ✅ Random data explorers or samplers  

---

## 🛠️ How It Works

```java
RandomStateNavigator<Integer> nav = new RandomStateNavigator<>(() -> new Random().nextInt(100));

System.out.println(nav.next());    // → 42
System.out.println(nav.next());    // → 88
System.out.println(nav.previous()); // ← 42
