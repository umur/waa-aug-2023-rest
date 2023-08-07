class StudentPage {
    constructor() {
        this.init();
    }

    init() {
        this.data = [
            { id:"1", name: "John Doe", age: 30, occupation: "Engineer" },
            { id:"2", name: "Jane Smith", age: 28, occupation: "Designer" },
            { id:"3", name: "Bob Johnson", age: 35, occupation: "Developer" },
        ];
        this.populateDataFromData();
        this.onLoadTable();
        this.attachEventListeners();
    }

    onLoadTable() {
        setInterval(() => {
            this.populateDataFromData()
        },50000)
    }

    onClickLoadTable() {
        this.populateDataFromData
    }

    onDeleteData() {
        alert("delete data")
    }

    populateDataFromData() {
        const tableBody = document.getElementById("tableBody")
        tableBody.innerHTML = ''
        this.data.forEach((row) => {
            const newRow = document.createElement("tr")

            const IdCell = document.createElement("td")
            IdCell.textContent = row.id
            newRow.appendChild(IdCell)

            const nameCell = document.createElement("td")
            nameCell.textContent = row.name
            newRow.appendChild(nameCell);

            const ageCell = document.createElement("td")
            ageCell.textContent = row.age
            newRow.appendChild(ageCell);

            const occupationCell = document.createElement("td")
            occupationCell.textContent = row.occupation
            newRow.appendChild(occupationCell);

            const actionCell = document.createElement("td")
            const deleteButton = document.createElement("button")
            deleteButton.className = "btn btn-outline-danger"
            deleteButton.id = "delete-data"
            deleteButton.textContent = "Delete"
            deleteButton.onclick = this.onDeleteData
            actionCell.appendChild(deleteButton)
            newRow.appendChild(actionCell)

            tableBody.appendChild(newRow);
        })
    }

    attachEventListeners() {
        const loadTable = document.getElementById("load-table")
        loadTable.addEventListener("click",this.onClickLoadTable)
    }

}
new StudentPage();