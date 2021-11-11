function showClient() {
    document.getElementById("clientsList").innerHTML = null;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var clients = JSON.parse(this.responseText);
            if (clients.length!=0) {
                var html = '<tr>\n' +
                    '        <th>Client id</th>\n' +
                    '        <th>Client name</th>\n' +
                    '        <th>Age</th>\n' +
                    '        <th>Client date of birth</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                for (var i = 0; i < clients.length; i++) {
                    var client = clients[i];
                    console.log(client);
                    html = html + '<tr><td>' + client.id + '</td>\n' +
                        '        <td>' + client.name + '</td>\n' +
                        '        <td>' + client.age + '</td>\n' +
                        '        <td>' + client.dateOfBirth + '</td>' +
                        '        <td><button type="button" class="btn btn-outline-primary" onclick="deleteClient(' + client.id + ')">Delete</button></td></tr>';
                }
                document.getElementById("clientsList").innerHTML = html;
            }
            else
                alert("There are no clients for the selected package!");
        }
    };
    let id=document.getElementById("touristPackage").innerText;
    xhttp.open("GET", "http://localhost:8080/clients/findByTouristPackageId/" + id, true);
    xhttp.send();
}

function searchClientByName() {
    var name = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var client = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>Client id</th>\n' +
                    '        <th>Client name</th>\n' +
                    '        <th>Age</th>\n' +
                    '        <th>Client date of birth</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                html = html + '<tr><td>' + client.id + '</td>\n' +
                    '        <td>' + client.name + '</td>\n' +
                    '        <td>' + client.age + '</td>\n' +
                    '        <td>' + client.dateOfBirth + '</td>\n' +
                    '        <td><button type="button" class="btn btn-outline-primary" onclick="deleteClient(' + client.id + ')">Delete</button></td></tr>';
                document.getElementById("clientsList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/clients/findByName/" + name, true);
    xhttp.send();
}

function createClient() {
    var clientName = document.getElementById("client_name").value;
    var clientAge = document.getElementById("client_age").value;
    var clientDateOfBirth = document.getElementById("client_date_of_birth").value;
    var id=document.getElementById("touristPackage").innerText;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8080/clients/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({name: clientName, age: clientAge, dateOfBirth: clientDateOfBirth,
    touristPackage: {id:id}}));

    alert("New client created!");
    showClient();
}

function deleteClient(clientId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/clients/delete/" + clientId, true);
    xhttp.send();

    alert("Client deleted!");
    showClient();
}

function searchClear(){
    document.getElementById("search_field").value="";
    showClient();
}

function clientClear(){
    document.getElementById("client_name").value="";
    document.getElementById("client_age").value="";
    document.getElementById("client_date_of_birth").value="";
}