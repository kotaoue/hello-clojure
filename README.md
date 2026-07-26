# hello-clojure

A small repository for learning Clojure.

## Environment setup

### 1. Install Java (JDK 17+ recommended)

Clojure runs on the JVM, so Java is required.

- macOS: `brew install openjdk@17`
- Ubuntu/Debian: `sudo apt-get install openjdk-17-jdk`
- Windows: install a JDK from Adoptium or Oracle

Verify:

```bash
java -version
```

### 2. Install Clojure CLI

Install the official Clojure CLI from:
https://clojure.org/guides/install_clojure

Verify:

```bash
clojure -Sdescribe
```

## Hello World sample

This repository includes one sample program:

- `src/hello_clojure/core.clj`

Run it:

```bash
clojure -M -m hello-clojure.core
```

Expected output:

```text
Hello, world!
```
