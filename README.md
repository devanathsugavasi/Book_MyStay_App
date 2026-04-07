# Book_MyStay_App


## 📌 Overview

**Book My Stay App** is a console-based Hotel Booking Management System developed using **Core Java and Data Structures**.
The project demonstrates how real-world booking systems handle challenges such as **fair request processing, inventory consistency, and prevention of double-booking**.

The system is built incrementally through multiple use cases, each introducing a key concept in software design and data structures.

---

## 🎯 Objectives

* Apply **Core Java concepts** in a real-world scenario
* Understand **Data Structures usage** beyond theory
* Build a **scalable and maintainable system**
* Learn **clean separation of responsibilities**

---

## 🧠 Key Concepts Covered

* Object-Oriented Programming (OOP)
* Collections Framework (List, Set, Map, Queue, Stack)
* Exception Handling
* File Handling (Persistence)
* Multithreading & Synchronization
* Functional Programming (Streams)

---

## ⚙️ Features by Use Cases

### 🔹 UC1 – Room Initialization

* Create room objects
* Display basic room details

### 🔹 UC2 – Room Setup

* Initialize room types and attributes

### 🔹 UC3 – Inventory Management

* Centralized room inventory using HashMap
* Update and track availability

### 🔹 UC4 – Room Search

* Read-only search for available rooms
* Filter unavailable room types

### 🔹 UC5 – Booking Request Queue

* FIFO booking requests using Queue
* Fair request handling

### 🔹 UC6 – Room Allocation

* Assign unique room IDs
* Prevent double booking using Set

### 🔹 UC7 – Add-On Services

* Attach optional services to bookings
* Calculate additional costs

### 🔹 UC8 – Booking History

* Store confirmed bookings using List
* Generate reports

### 🔹 UC9 – Error Handling & Validation

* Custom exceptions
* Input validation and fail-fast design

### 🔹 UC10 – Booking Cancellation

* Rollback using Stack (LIFO)
* Restore inventory safely

### 🔹 UC11 – Concurrent Booking

* Multi-threaded booking simulation
* Thread safety using synchronization

### 🔹 UC12 – Data Persistence

* Save and restore system state using files
* Serialization & deserialization

---

## 🏗️ Project Structure

```
Book_MyStay_App/
│── app/
│   └── src/
│       ├── Room.java
│       ├── RoomInventory.java
│       ├── UseCase3InventorySetup.java
│       ├── UseCase4RoomSearch.java
│       ├── UseCase5BookingRequestQueue.java
│       ├── UseCase6RoomAllocationService.java
│       ├── UseCase7AddOnServiceSelection.java
│       ├── UseCase8BookingHistoryReport.java
│       ├── UseCase9ErrorHandlingValidation.java
│       ├── UseCase10BookingCancellation.java
│       ├── UseCase11ConcurrentBookingSimulation.java
│       ├── UseCase12DataPersistenceRecovery.java
│       
```

---

## ▶️ How to Run

### 🔧 Compile

```bash
javac UseCase4RoomSearch.java
```

### ▶️ Run

```bash
java UseCase4RoomSearch
```

👉 Replace filename for other use cases.

---

## 🌿 Git Workflow (Branch-Based Development)

Each use case is developed in a separate branch:

```bash
git checkout -b uc4-room-search
git add .
git commit -m "Added UC4: Room Search"
git push origin uc4-room-search
```

---

## 💡 Key Learnings

* Difference between **read vs write operations**
* Importance of **data integrity**
* Real-world use of **Queue, Set, Map, Stack**
* Handling **concurrency and persistence**
* Writing **clean, modular Java code**

---

## 🚀 Future Improvements

* Add GUI (JavaFX / Web UI)
* Integrate Database (MySQL)
* REST API development
* Payment integration

---

## 👨‍💻 Author

**Devanath Sugavasi**

---

## 📄 License

This project is for educational purposes.
