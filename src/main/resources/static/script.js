// Fetch student data from the backend
async function fetchStudents() {
    try {
        const response = await fetch('http://localhost:8080/students');
        const students = await response.json();
        return students;
    } catch (error) {
        console.error('Error fetching students:', error);
        return [];
    }
}

// Render student data in the table
function renderStudents(students) {
    const studentTableBody = document.getElementById('studentTableBody');

    students.forEach((student) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.major}</td>
        `;
        studentTableBody.appendChild(row);
    });
}

// Main function to fetch and render students
async function loadStudents() {
    const students = await fetchStudents();
    renderStudents(students);
}

// Call the main function when the page loads
document.addEventListener('DOMContentLoaded', loadStudents);