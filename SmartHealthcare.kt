package com.example.smarthealthcareappointmentapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HealthcareApp()
                }
            }
        }
    }
}

data class Doctor(
    val id: Int,
    val name: String,
    val specialization: String,
    val experience: String,
    val rating: String,
    val hospital: String,
    val about: String,
    val slots: List<String>
)

data class Appointment(
    val doctorName: String,
    val specialization: String,
    val slot: String,
    val status: String
)

val doctors = listOf(
    Doctor(
        1, "Dr. Ananya Sharma", "Cardiologist",
        "10 Years Experience", "4.8 / 5",
        "City Care Hospital",
        "Specialist in heart care, blood pressure and preventive cardiology.",
        listOf("10:00 AM", "11:30 AM", "2:00 PM", "4:30 PM")
    ),
    Doctor(
        2, "Dr. Rahul Verma", "Dermatologist",
        "8 Years Experience", "4.7 / 5",
        "Skin Wellness Clinic",
        "Specialist in acne treatment, skin allergies and hair care.",
        listOf("9:30 AM", "12:00 PM", "3:00 PM", "5:30 PM")
    ),
    Doctor(
        3, "Dr. Priya Singh", "Pediatrician",
        "12 Years Experience", "4.9 / 5",
        "Sunrise Children Hospital",
        "Child specialist for regular checkups, fever and vaccinations.",
        listOf("10:30 AM", "1:00 PM", "3:30 PM", "6:00 PM")
    ),
    Doctor(
        4, "Dr. Aman Gupta", "Orthopedic Surgeon",
        "15 Years Experience", "4.6 / 5",
        "Health First Hospital",
        "Specialist in bone, joint, back pain and sports injuries.",
        listOf("9:00 AM", "11:00 AM", "2:30 PM", "5:00 PM")
    ),
    Doctor(
        5, "Dr. Neha Kapoor", "Gynecologist",
        "11 Years Experience", "4.8 / 5",
        "Women's Health Centre",
        "Specialist in women's health and regular consultations.",
        listOf("9:30 AM", "12:30 PM", "3:00 PM", "5:30 PM")
    ),
    Doctor(
        6, "Dr. Rohan Mehta", "Neurologist",
        "14 Years Experience", "4.7 / 5",
        "Brain and Spine Clinic",
        "Specialist in migraine, headache, nerve disorders and brain health.",
        listOf("10:00 AM", "12:00 PM", "2:30 PM", "4:00 PM")
    ),
    Doctor(
        7, "Dr. Kavita Joshi", "Dentist",
        "9 Years Experience", "4.6 / 5",
        "Bright Smile Dental Care",
        "Specialist in tooth pain, dental cleaning.",
        listOf("9:00 AM", "11:30 AM", "1:30 PM", "4:30 PM")
    ),
    Doctor(
        8, "Dr. Arjun Malhotra", "General Physician",
        "13 Years Experience", "4.9 / 5",
        "MediLife Hospital",
        "Provides consultation for fever, cold, weakness, diabetes and general health.",
        listOf("8:30 AM", "10:30 AM", "2:00 PM", "6:00 PM")
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthcareApp() {
    var selectedDoctor by remember { mutableStateOf<Doctor?>(null) }
    var selectedSlot by remember { mutableStateOf<String?>(null) }
    var appointment by remember { mutableStateOf<Appointment?>(null) }
    var showConfirmationDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Simulates a real-time appointment status update.
    LaunchedEffect(appointment?.status) {
        if (appointment?.status == "Booked") {
            delay(2000)
            appointment = appointment?.copy(status = "Confirmed")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MediCare Smart Health",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    if (selectedDoctor != null) {
                        Text(
                            text = "← Back",
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .clickable {
                                    selectedDoctor = null
                                    selectedSlot = null
                                },
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Tablet layout: doctor list and doctor profile side by side
            if (maxWidth >= 700.dp) {
                Row(modifier = Modifier.fillMaxSize()) {
                    DoctorListScreen(
                        doctors = doctors,
                        onDoctorClick = {
                            selectedDoctor = it
                            selectedSlot = null
                        },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )

                    if (selectedDoctor != null) {
                        DoctorDetailScreen(
                            doctor = selectedDoctor!!,
                            selectedSlot = selectedSlot,
                            appointment = appointment,
                            onSlotSelected = { selectedSlot = it },
                            onBookClick = { showConfirmationDialog = true },
                            onCancelClick = {
                                appointment = null
                                selectedSlot = null
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        "Appointment cancelled successfully"
                                    )
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                    } else {
                        EmptyDoctorSelection(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                    }
                }
            } else {
                // Phone layout: one screen at a time
                if (selectedDoctor == null) {
                    DoctorListScreen(
                        doctors = doctors,
                        onDoctorClick = {
                            selectedDoctor = it
                            selectedSlot = null
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    DoctorDetailScreen(
                        doctor = selectedDoctor!!,
                        selectedSlot = selectedSlot,
                        appointment = appointment,
                        onSlotSelected = { selectedSlot = it },
                        onBookClick = { showConfirmationDialog = true },
                        onCancelClick = {
                            appointment = null
                            selectedSlot = null
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "Appointment cancelled successfully"
                                )
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

    if (showConfirmationDialog && selectedDoctor != null && selectedSlot != null) {
        AlertDialog(
            onDismissRequest = { showConfirmationDialog = false },
            title = { Text("Confirm Appointment") },
            text = {
                Text(
                    "Book an appointment with ${selectedDoctor!!.name} at $selectedSlot?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        appointment = Appointment(
                            doctorName = selectedDoctor!!.name,
                            specialization = selectedDoctor!!.specialization,
                            slot = selectedSlot!!,
                            status = "Booked"
                        )
                        showConfirmationDialog = false

                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "Appointment booked successfully"
                            )
                        }
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showConfirmationDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun DoctorListScreen(
    doctors: List<Doctor>,
    onDoctorClick: (Doctor) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "Available Doctors",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Select a doctor to view profile and book an appointment.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(doctors, key = { it.id }) { doctor ->
                DoctorCard(
                    doctor = doctor,
                    onClick = { onDoctorClick(doctor) }
                )
            }
        }
    }
}

@Composable
fun DoctorCard(
    doctor: Doctor,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "👨‍⚕️ ${doctor.name}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = doctor.specialization,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )

            Text(text = doctor.experience)
            Text(text = "⭐ Rating: ${doctor.rating}")
            Text(text = doctor.hospital)
        }
    }
}

@Composable
fun DoctorDetailScreen(
    doctor: Doctor,
    selectedSlot: String?,
    appointment: Appointment?,
    onSlotSelected: (String) -> Unit,
    onBookClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Doctor Profile",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "👨‍⚕️ ${doctor.name}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = doctor.specialization,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Experience: ${doctor.experience}")
                    Text("Rating: ⭐ ${doctor.rating}")
                    Text("Hospital: ${doctor.hospital}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = doctor.about)
                }
            }
        }

        item {
            Text(
                text = "Choose Appointment Slot",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        items(doctor.slots) { slot ->
            AppointmentSlot(
                time = slot,
                selected = selectedSlot == slot,
                onClick = { onSlotSelected(slot) }
            )
        }

        item {
            if (selectedSlot != null && appointment == null) {
                Button(
                    onClick = onBookClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Book Appointment at $selectedSlot")
                }
            }
        }

        item {
            if (appointment != null && appointment.doctorName == doctor.name) {
                AppointmentStatusCard(
                    appointment = appointment,
                    onCancelClick = onCancelClick
                )
            }
        }
    }
}

@Composable
fun AppointmentSlot(
    time: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = if (selected) {
            androidx.compose.material3.ButtonDefaults.elevatedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            androidx.compose.material3.ButtonDefaults.elevatedButtonColors()
        }
    ) {
        Text(if (selected) "✓ Selected: $time" else time)
    }
}

@Composable
fun AppointmentStatusCard(
    appointment: Appointment,
    onCancelClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = tween(400)),
        colors = CardDefaults.cardColors(
            containerColor = if (appointment.status == "Confirmed") {
                Color(0xFFDFF7E3)
            } else {
                Color(0xFFFFF3CD)
            }
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Appointment Status",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Doctor: ${appointment.doctorName}")
            Text("Specialization: ${appointment.specialization}")
            Text("Time: ${appointment.slot}")

            AnimatedContent(
                targetState = appointment.status,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "Status Animation"
            ) { status ->
                Text(
                    text = "Status: $status",
                    fontWeight = FontWeight.Bold,
                    color = if (status == "Confirmed") Color(0xFF137333) else Color(0xFF9A6700)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = onCancelClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancel Appointment")
            }
        }
    }
}

@Composable
fun EmptyDoctorSelection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select a doctor from the list",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Doctor profile and appointment slots will appear here.",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
