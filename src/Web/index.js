async function getAllCourses(){
    const result = await fetch("http://localhost:8080/courses");
    const data = await result.json();
    populateCourses(data);
}
function populateCourses(courses){
    const listCourseDiv = document.getElementById("listCourse");

    // Clear the previous content if any
    listCourseDiv.innerHTML = "";

    courses.forEach(course => {
        const courseElement = document.createElement("div");
        courseElement.innerHTML = `
            <h2>Course ID: ${course.id}</h2>
            <p>Course Name: ${course.name}</p>
            <p>Course Code: ${course.code}</p>
        `;
        listCourseDiv.appendChild(courseElement);
    });

}
getAllCourses();