document.getElementById("addStudentForm").addEventListener('click', function (event) {
    event.preventDefault();
    const studentData ={
        id: document.getElementById("id").value,
        email: document.getElementById("email").value,
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        major: document.getElementById("major").value,
    }
    save(studentData);
});

document.getElementById("getAllStudentsBtn").addEventListener("click",()=>getAll());

document.getElementById("getOneStudent").addEventListener('click', (event)=>{
    event.preventDefault();
    const id = document.getElementById("studentId").value;
    getOne(id);
})

document.getElementById("getStudentsByMajor").addEventListener('click', (event)=>{
    event.preventDefault();
    const major = document.getElementById("stdMajor").value;
    getStudentsMajor(major);
})
const getStudentsMajor = (major)=>{
    fetch('http://localhost:8080/students/filterByMajor?major=' + major, )
        .then(response => {
            if (!response.ok) {
                throw new Error('Request failed:', response.status, response.statusText);
            }
            return response.json(); // Parse the response body as JSON
        })
        .then(students => {
            // 'students' will be an array containing the list of student objects
            console.log('Students:', students);
            document.getElementById("listOfStudents").value = JSON.stringify(students);
            // Now you can work with the list of students
            // For example, you can display the students in a table, etc.
            // Example: displayStudentsInTable(students);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
const getOne = (id)=>{
    fetch('http://localhost:8080/students/' + id, )
        .then(response => {
            if (!response.ok) {
                throw new Error('Request failed:', response.status, response.statusText);
            }
            return response.json(); // Parse the response body as JSON
        })
        .then(students => {
            // 'students' will be an array containing the list of student objects
            console.log('Students:', students);
            document.getElementById("listOfStudents").value = JSON.stringify(students);
            // Now you can work with the list of students
            // For example, you can display the students in a table, etc.
            // Example: displayStudentsInTable(students);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}
const save = function (studentData) {
    fetch('http://localhost:8080/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(studentData),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Request failed:', response.status, response.statusText);
            }
            return response;
        })
        .then(data => {
            document.getElementById("saveSucceedMsg").classList.remove("hide")
        })
        .catch(error => {
            console.error('Fetch error:', error);
            document.getElementById("listOfStudents").innerHTML = error;
        });

}

const getAll = ()=>{
    fetch('http://localhost:8080/students', )
        .then(response => {
            if (!response.ok) {
                throw new Error('Request failed:', response.status, response.statusText);
            }
            return response.json(); // Parse the response body as JSON
        })
        .then(students => {
            // 'students' will be an array containing the list of student objects
            console.log('Students:', students);
            document.getElementById("listOfStudents").value = JSON.stringify(students);
            // Now you can work with the list of students
            // For example, you can display the students in a table, etc.
            // Example: displayStudentsInTable(students);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });

}