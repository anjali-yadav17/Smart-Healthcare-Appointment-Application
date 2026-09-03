# 🏥 Smart Healthcare Appointment Application

A modern and responsive **Smart Healthcare Appointment Application** built using **Kotlin** and **Jetpack Compose** following **Material Design 3** principles. The application enables users to browse doctors, explore detailed profiles, choose available appointment slots, book appointments, receive real-time status updates, and cancel bookings through a clean, intuitive, and responsive user interface.

This project demonstrates modern Android development practices including **Jetpack Compose**, **State Management**, **Material 3 Components**, **Compose Animations**, **Responsive UI**, and **Side Effects**, making it an excellent learning project for Android development.

---

## 📱 Features

### 👨‍⚕️ Doctor Management
- Browse a list of **8 experienced doctors**
- View doctor details including:
  - Name
  - Specialization
  - Years of Experience
  - Rating
  - Hospital Name
  - Doctor Description
- Smooth scrollable doctor list using **LazyColumn**

### 📅 Appointment Booking
- Select an available appointment slot
- Book appointments through a confirmation dialog
- Prevent booking without selecting a slot
- Display appointment details after successful booking

### 🔔 Appointment Status
- Initial status: **Booked**
- Automatically updates to **Confirmed** after 2 seconds
- Animated status transition using Compose Animation APIs

### ❌ Appointment Cancellation
- Cancel appointments anytime
- Snackbar confirmation after cancellation
- Reset appointment details instantly

### 🎨 Modern User Interface
- Material Design 3 Components
- Responsive layouts for phones and tablets
- Beautiful cards with elevation
- Animated transitions
- Edge-to-edge display
- Clean and user-friendly design

### 📱 Responsive Design
- Mobile-friendly interface
- Tablet layout using **BoxWithConstraints**
- Adaptive UI components
- Optimized spacing and layouts

---

# 🚀 User Flow

```text
Launch Application
        │
        ▼
Browse Doctors
        │
        ▼
Select Doctor
        │
        ▼
Doctor Profile Screen
        │
        ▼
Choose Appointment Slot
        │
        ▼
Book Appointment
        │
        ▼
Confirmation Dialog
        │
        ▼
Appointment Booked
        │
        ▼
Status Changes Automatically
(Booked ➜ Confirmed)
        │
        ▼
Cancel Appointment (Optional)
```

---

# ✨ Jetpack Compose Concepts Used

| Concept | Purpose |
|----------|---------|
| Material 3 | Modern UI components including Scaffold, Cards, Buttons, Snackbar, AlertDialog, TopAppBar |
| LazyColumn | Efficiently displays doctor list and appointment slots |
| State Management | remember, mutableStateOf for managing UI state |
| LaunchedEffect | Automatically changes appointment status after delay |
| SnackbarHost | Displays booking and cancellation messages |
| AlertDialog | Confirms appointment booking |
| AnimatedContent | Smooth status animation between Booked and Confirmed |
| animateContentSize | Smooth UI resizing animations |
| BoxWithConstraints | Responsive layouts for different screen sizes |
| CoroutineScope | Handles asynchronous Snackbar operations |
| MaterialTheme | Provides consistent styling throughout the application |

---

# 🧩 Reusable Composable Components

| Component | Description |
|-----------|-------------|
| `HealthcareApp()` | Main application composable managing navigation and state |
| `DoctorListScreen()` | Displays all available doctors |
| `DoctorCard()` | Reusable card displaying doctor information |
| `DoctorDetailScreen()` | Shows complete doctor profile and appointment slots |
| `AppointmentSlot()` | Displays selectable appointment time slots |
| `AppointmentStatusCard()` | Displays booked appointment details and status |
| `EmptyDoctorSelection()` | Placeholder UI for tablet layout before doctor selection |

---

# 🏗️ Project Architecture

```
MainActivity
      │
      ▼
HealthcareApp
      │
      ├───────────────┐
      ▼               ▼
Doctor List      Doctor Details
      │               │
      ▼               ▼
Doctor Card      Appointment Slot
                      │
                      ▼
              Appointment Status
```

---

# 🛠️ Technology Stack

| Technology | Description |
|------------|-------------|
| Language | Kotlin |
| UI Toolkit | Jetpack Compose |
| Design System | Material Design 3 |
| IDE | Android Studio |
| State Management | Compose State APIs |
| Animation | Compose Animation APIs |
| Concurrency | Kotlin Coroutines |
| Minimum SDK | API 21 (Android 5.0) |
| Target SDK | Latest Android SDK |

---

# 📂 Project Structure

```text
Smart-Healthcare-Appointment-Application
│
├── app
│   └── src
│       └── main
│           ├── java
│           │   └── com.example.smarthealthcareappointmentapplication
│           │       ├── MainActivity.kt
│           │       ├── Doctor.kt
│           │       ├── Appointment.kt
│           │       ├── DoctorListScreen.kt
│           │       ├── DoctorDetailScreen.kt
│           │       ├── DoctorCard.kt
│           │       ├── AppointmentSlot.kt
│           │       └── AppointmentStatusCard.kt
│           │
│           ├── res
│           │   ├── drawable
│           │   ├── mipmap
│           │   ├── values
│           │   └── themes
│           │
│           └── AndroidManifest.xml
│
├── screenshots
│
├── README.md
│
└── build.gradle
```

---

#Screenshots

<img width="720" height="1600" alt="WhatsApp Image 2026-09-03 at 18 21 14" src="https://github.com/user-attachments/assets/29e946e0-ab7e-43ff-9b59-644bf8c32284" />

---

# 🎯 Learning Outcomes

This project demonstrates practical implementation of:

- Modern Android Development
- Jetpack Compose UI
- Material Design 3
- State Management
- Compose Animations
- Responsive UI Development
- Alert Dialogs
- Snackbar Notifications
- LazyColumn
- Coroutines
- Kotlin Best Practices
- Reusable Composable Design
- Android Application Architecture

---

# 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/Smart-Healthcare-Appointment-Application.git
```

### Open in Android Studio

```text
Android Studio
        ↓
Open Existing Project
        ↓
Sync Gradle
        ↓
Run on Emulator or Physical Device
```

---

# 📋 Requirements

- Android Studio Hedgehog or newer
- Kotlin 2.x
- Gradle 8.x
- Android SDK 34+
- Minimum SDK: API 21
- Jetpack Compose Enabled

---

# 🌟 Future Enhancements

- 🔐 Firebase Authentication
- 👤 Patient Login & Registration
- 🔍 Doctor Search & Filters
- ❤️ Favorite Doctors
- 📅 Appointment History
- 💳 Online Payment Gateway
- 🔔 Push Notifications
- 🌙 Dark Mode Support
- ☁️ Firebase Firestore Integration
- 🗂️ Room Database
- 📍 Hospital Location with Google Maps
- 🎥 Video Consultation
- 💬 Doctor-Patient Chat
- 📄 Medical Reports Upload
- ⭐ Doctor Reviews & Ratings

---

# 👩‍💻 Author

**Anjali Yadav**

**B.Tech Computer Science Engineering**  
Lovely Professional University

### Skills

- Kotlin
- Android Development
- Jetpack Compose
- Material Design 3
- UI/UX Design
- Software Testing
- Firebase
- Git & GitHub

---

## ⭐ Show Your Support

If you found this project helpful, please consider giving it a **⭐ Star** on GitHub. It motivates me to build and share more open-source Android projects!

---

## 📄 License

This project is developed for **educational and learning purposes**.
