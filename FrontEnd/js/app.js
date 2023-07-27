"use strict";
window.onload=function(){
    // document.getElementById("student-link").onclick = function(){
    //     document.getElementById("course").style.display="block";
    // }
    getStudents();
    getCourses();
}

function getStudents() {

    const response =  fetch("http://localhost:8080/students")
    .then(response=>response.json()).then(usersData=>{
        let row = "";
        usersData.forEach(element => {

             row+=`<tr>
            <td>${element.id} </td>
            <td>${element.firstName}</td>
            <td>${element.lastName}</td>
            <td>${element.email}</td>
            <td>${element.major}</td>
            <td>
            <button class="btn btn-success" onclick="updateStudent(${element.id})">Update</button>
            <button class="btn btn-danger" onclick="deleteStudent(${element.id})">Delete</button></td>
          </tr>`;

        });
        document.getElementById("student-data").innerHTML=row;

    })  
}

function deleteStudent(id){
    fetch(`http://localhost:8080/students/${id}`,{
        method:"DELETE"
    })
    .then(usersData=>{
       getStudents();
    });

}


function saveStudent(){

    let firstName=document.getElementById("firstName").value;
    let lastName=document.getElementById("lastName").value;
    let id=document.getElementById("id").value;
    let email=document.getElementById("email").value;
    let major=document.getElementById("major").value;

    let method="POST";
    let url="http://localhost:8080/students";
    if(document.getElementById("update").value==="1")
    {
        method="PUT";
        url=`http://localhost:8080/students/${id}`

    }


    fetch(url,{

        method:method,
        body:JSON.stringify({
            'id':id,
            'firstName':firstName,
            'lastName':lastName,
            'email':email,
            'major':major


        }),
        headers: {
            'Content-Type': 'application/json'
          },


    }).then((response)=>{
        document.getElementById("student-form").reset();
        getStudents();
    });

}


function getCourses() {

    const response =  fetch("http://localhost:8080/courses")
    .then(response=>response.json()).then(courseData=>{

        let row = "";
        courseData.forEach(element => {

             row+=`<tr>
            <td>${element.id} </td>
            <td>${element.name}</td>
            <td>${element.code}</td>
           
            <td>
            <button class="btn btn-success" onclick="updateCourse(${element.id})">Update</button>
            <button class="btn btn-danger" onclick="deleteCourse(${element.id})">Delete</button></td>
          </tr>`;

        });
        document.getElementById("course-data").innerHTML=row;

    })  
}

function deleteCourse(id){
    fetch(`http://localhost:8080/courses/${id}`,{
        method:"DELETE"
    })
    .then(usersData=>{
       getCourses();
    });
}



function saveCourse(){

        let name=document.getElementById("name").value;
        let code=document.getElementById("code").value;
        let id=document.getElementById("id").value;
        let method="POST";
        let url="http://localhost:8080/courses";
        if(document.getElementById("update").value==="1")
        {
            method="PUT";
            url=`http://localhost:8080/courses/${id}`

        }


        fetch(url,{

            method:method,
            body:JSON.stringify({
                'id':id,
                'name':name,
                'code':code

            }),
            headers: {
                'Content-Type': 'application/json'
              },


        }).then((response)=>{
            document.getElementById("course-form").reset();
            getCourses();
        });

}