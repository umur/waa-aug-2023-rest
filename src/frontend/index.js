window.onload = function () {
  loadStudents();
  loadCourses();
  document.getElementById("submit").onclick = saveStudent;
  document.getElementById("submitCourse").onclick = saveCourse;
};

async function saveStudent(event) {
  event.preventDefault();
  const obj = {
    id: document.getElementById("id").value,
    firstName: document.getElementById("firstName").value,
    lastName: document.getElementById("lastName").value,
    email: document.getElementById("email").value,
    major: document.getElementById("major").value,
    coursesTaken: [],
  };
  await fetch("http://localhost:8080/students", {
    method: "POST",
    body: JSON.stringify(obj),
    headers: {
      "Content-Type": "application/json",
    },
  });
  location.reload();
}

async function loadStudents() {
  fetch("http://localhost:8080/students")
    .then((response) => {
      console.log("r", response);
      return response.json();
    })
    .then((products) => {
      console.log(products);
      let html = `<tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Major</th>
            <th>CoursesTaken</th>
        </tr>`;
      products.forEach((student) => {
        html += `
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.email}</td>
                <td>${student.major}</td>
                <td>${student.coursesTaken.map((d) => d.name).join(", ")}</td>
            </tr>
            `;
      });

      document.getElementById("prod-list").innerHTML = html;
    });
}

async function saveCourse(event) {
  event.preventDefault();
  const obj = {
    id: document.getElementById("course-id").value,
    name: document.getElementById("course-name").value,
    code: document.getElementById("course-code").value,
  };
  await fetch("http://localhost:8080/courses", {
    method: "POST",
    body: JSON.stringify(obj),
    headers: {
      "Content-Type": "application/json",
    },
  });
  location.reload();
}

async function loadCourses() {
  fetch("http://localhost:8080/courses")
    .then((response) => {
      console.log("r", response);
      return response.json();
    })
    .then((products) => {
      console.log(products);
      let html = `<tr>
                <th>ID</th>
                <th>Name</th>
                <th>Code</th>
            </tr>`;
      products.forEach((student) => {
        html += `
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.code}</td>
                </tr>
                `;
      });

      document.getElementById("course-list").innerHTML = html;
    });
}
