function loadTouristPackages() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var touristPackages = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Tourist package id</th>\n' +
                '        <th>Tourist package name</th>\n' +
                '        <th>Tourist package direction</th>\n' +
                '        <th>Date start</th>\n' +
                '        <th>Date end</th>\n' +
                '        <th>Date of departure</th>\n' +
                '        <th>Delete</th>\n' +
                '        <th>Clients</th>\n' +
                '    </tr>';
            for (var i = 0; i < touristPackages.length; i++) {
                var touristPackage = touristPackages[i];
                console.log(touristPackage);
                html = html + '<tr><td>' + touristPackage.id + '</td>\n' +
                    '        <td>' + touristPackage.name + '</td>\n' +
                    '        <td>' + touristPackage.direction + '</td>\n' +
                    '        <td>' + touristPackage.dateStart + '</td>' +
                    '        <td>' + touristPackage.dateEnd + '</td>\n' +
                    '        <td>' + touristPackage.dateOfDeparture + '</td>' +
                    '        <td><button type="button" class="btn btn-outline-primary" onclick="deleteTouristPackage(' + touristPackage.id + ')">Delete</button></td>'+
                    '        <td><button type="button" class="btn btn-outline-primary" onclick="showClients(' + touristPackage.id + ')">Clients</button></td></tr>';
            }
            document.getElementById("touristPackagesList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/touristPackages/findAll", true);
    xhttp.send();
}

function showClients(touristPackageId){
    let newWin=window.open("clients.html");
    newWin.onload = function() {
        newWin.document.getElementById("touristPackage").innerText=touristPackageId;
        newWin.showClient();
    };
}


function searchPackageByName() {
    var name = document.getElementById("search_field").value;
    console.log(name);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var touristPackage = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Tourist package id</th>\n' +
                '        <th>Tourist package name</th>\n' +
                '        <th>Tourist package direction</th>\n' +
                '        <th>Date start</th>\n' +
                '        <th>Date end</th>\n' +
                '        <th>Date of departure</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            html = html + '<tr><td>' + touristPackage.id + '</td>\n' +
                '        <td>' + touristPackage.name + '</td>\n' +
                '        <td>' + touristPackage.direction + '</td>\n' +
                '        <td>' + touristPackage.dateStart + '</td>\n' +
                '        <td>' + touristPackage.dateEnd + '</td>\n' +
                '        <td>' + touristPackage.dateOfDeparture + '</td>\n' +
                '        <td><button type="button" class="btn btn-outline-primary" onclick="deleteTouristPackage(' + touristPackage.id + ')">Delete</button></td></tr>';
            document.getElementById("touristPackagesList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/touristPackages/findByName/" + name, true);
    xhttp.send();
}

function deleteTouristPackage(touristPackageId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/touristPackages/delete/" + touristPackageId, true);
    xhttp.send();

    alert("Tourist package deleted!");
    loadTouristPackages();
}

function createTouristPackage() {
    var touristPackageName = document.getElementById("touristPackage_name").value;
    var touristPackageDirection = document.getElementById("touristPackage_direction").value;
    var dateStart = document.getElementById("touristPackage_date_start").value;
    var dateEnd = document.getElementById("touristPackage_date_end").value;
    var dateOfDeparture = document.getElementById("touristPackage_date_of_departure").value;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8080/touristPackages/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({name: touristPackageName, direction: touristPackageDirection, dateStart: dateStart,
        dateEnd: dateEnd, dateOfDeparture: dateOfDeparture}));

    alert("New tourist package created!");
    loadTouristPackages();
}

function searchPackageClear(){
    document.getElementById("search_field").value="";
    loadTouristPackages();
}

function packageClear(){
    document.getElementById("touristPackage_name").value="";
    document.getElementById("touristPackage_direction").value="";
    document.getElementById("touristPackage_date_start").value="";
    document.getElementById("touristPackage_date_end").value="";
    document.getElementById("touristPackage_date_of_departure").value="";
}


loadTouristPackages();

