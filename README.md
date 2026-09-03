# Smart-Healthcare-Appointment-Application
A responsive Smart Healthcare Appointment application built with **Kotlin** and **Jetpack Compose**. Users can browse doctors, view profiles, select appointment slots, book appointments, receive status updates, and cancel appointments.

## Features

- Browse a scrollable list of 8 doctors.
- View doctor name, specialization, experience, rating, hospital, and description.
- Select an available appointment slot.
- Confirm an appointment using an Alert Dialog.
- Receive booking and cancellation feedback using Snackbar.
- View animated appointment status updates from **Booked** to **Confirmed**.
- Cancel an appointment easily.
- Responsive design for smartphones and tablets.

## User Flow

1. Open the application.
2. Browse available doctors.
3. Tap a doctor card to view the complete profile.
4. Select an appointment time slot.
5. Click **Book Appointment**.
6. Confirm booking in the dialog box.
7. View the appointment status.
8. Cancel the appointment if required.

## Jetpack Compose Concepts Used

| Concept | Usage |
| --- | --- |
| Material 3 | Scaffold, TopAppBar, Card, Button, AlertDialog, Snackbar |
| LazyColumn | Displays doctors and appointment slots efficiently |
| State Management | Stores selected doctor, selected slot, appointment, and dialog state |
| LaunchedEffect | Changes status from Booked to Confirmed after 2 seconds |
| Animation | AnimatedContent, fadeIn, fadeOut, animateContentSize |
| Custom Composables | DoctorCard, AppointmentSlot, AppointmentStatusCard |
| Responsive UI | BoxWithConstraints provides layouts for phones and tablets |

## Reusable Components

- `DoctorCard()` – displays doctor information in the doctor list.
- `AppointmentSlot()` – displays a selectable appointment time.
- `AppointmentStatusCard()` – displays appointment status and cancel option.
- `DoctorDetailScreen()` – shows detailed doctor profile and slots.

## Technology Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose
- **Design System:** Material 3
- **Minimum Android Version:** Android 5.0 (API 21)

## Project Structure

```text
app/
└── src/main/java/com/example/smarthealthcareappointmentapplication/
    └── MainActivity.kt

