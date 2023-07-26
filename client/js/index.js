    
function addCourse() {
    alert('hello');
    const courseName = document.getElementById('courseName').value;
    const courseCode = document.getElementById('courseCode').value;
    const courseData = { name: courseName, code: courseCode };
  

    fetch('http://localhost:8080/courses', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(courseData)
    })
    .then(response => response.json())
    .then(course => {
     
      addCourseRow(course);
    })
    .catch(error => console.error('Error adding course:', error));
  }
  
 
  function addStudent() {
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const major = document.getElementById('major').value;
    const studentData = { firstName, lastName, email, major };
  
    
    fetch('http://localhost:8080/students', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(studentData)
    })
    .then(response => response.json())
    .then(student => {
     
      addStudentRow(student);
    })
    .catch(error => console.error('Error adding student:', error));
  }
  

  function loadCourses() {
    
    fetch('http://localhost:8080/courses')
      .then(response => response.json())
      .then(courses => {
        courses.forEach(course => {
          addCourseRow(course);
        });
      })
      .catch(error => console.error('Error fetching courses:', error));
  }
  

  function loadStudents() {

    fetch('http://localhost:8080/students')
      .then(response => response.json())
      .then(students => {
        students.forEach(student => {
          addStudentRow(student);
        });
      })
      .catch(error => console.error('Error fetching students:', error));
  }
  
  function addCourseRow(course) {
    const courseList = document.getElementById('courseList');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.code}</td>
    `;
    courseList.appendChild(newRow);
  }
  
  function addStudentRow(student) {
    const studentList = document.getElementById('studentList');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
      <td>${student.id}</td>
      <td>${student.firstName}</td>
      <td>${student.lastName}</td>
      <td>${student.email}</td>
      <td>${student.major}</td>
    `;
    studentList.appendChild(newRow);
  }
  
  window.onload = function () {
    loadCourses();
    loadStudents();
  
    const courseForm = document.getElementById('courseForm');
    const studentForm = document.getElementById('studentForm');
  
    courseForm.addEventListener('submit', function (event) {
      event.preventDefault();
      addCourse();
    });
  
    studentForm.addEventListener('submit', function (event) {
      event.preventDefault();
      addStudent();
    });
  };
  