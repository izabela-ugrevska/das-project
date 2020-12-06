class Cafe{
    id;longitude;latitude;phone;
    name;website;
    open;outdoors;
    smoking; address;

    constructor(
        id, longitude,
        latitude, name,
        phone, website,
        open, outdoors,
        smoking, address
    ) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.website = website;
        this.outdoors = outdoors;
        this.smoking = smoking;
    }
}
const irish = new Cafe(309875534, 21.4355937, 41.9950681, "Ирски паб Св. Патрик", "",
    "http://www.irishpub.com.mk/", "10:00-24:00  Fr-Sa 10:00-01:00",
    "yes", "yes", "Кеј 13 Ноември");
const casaCubana = new Cafe(2695392360, 21.4343506, 41.9954474, "Casa Cubana", "",
    "", "10:00-24:00  Fr-Sa 10:00-01:00", "yes", "", "Кеј 13 Ноември");
var cafes = [];
cafes.push(irish);
cafes.push(casaCubana);


class Restaurant{
    id;longitude;latitude;phone;
    name;website;
    open;outdoors;
    smoking; address;
    cuisine;

    constructor(
        id, longitude,
        latitude, name,
        phone, website,
        open, outdoors,
        smoking, address, cuisine
    ) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.website = website;
        this.outdoors = outdoors;
        this.smoking = smoking;
        this.cuisine = cuisine;
    }
}

const laTerazza = new Restaurant(3505013993, 21.4317257,
    41.9950911, "Ла Тераца", "+389 2 3113380", "",
    "08:00-24:00  Fr-Sa 08:00-01:00", "yes", "yes","11 Октомври", "Italian");
const amigos = new Restaurant(4149490289, 21.4300742, 41.9933026,
    "Amigos Мексиканска Кантина",
    "+389 71 230314", "http://www.amigos.com.mk/", "08:00-24:00  Fr-Sa 08:00-01:00", "yes",
    "yes", "ул.Македонија", "Mexican");

let restaurants = [];
restaurants.push(laTerazza);
restaurants.push(amigos);

class Market{
    id;longitude;latitude;phone;
    name;website;
    open;address;

    constructor(
        id, longitude,
        latitude, name,
        phone, website,
        open, address
    ) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.website = website;
    }
}

const vero = new Market(4151705280, 21.4207815, 41.9948735,
    "Веро 5", "+389 2 3220244", "https://vero.com.mk/Marketi/Vero5",
    "08:00-22:00");
let Markets = [];
Markets.push(vero);

class Other{
    id;longitude;latitude;phone;
    name;website;
    open;address;

    constructor(
        id, longitude,
        latitude, name,
        phone, website,
        open, address
    ) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.website = website;
    }
}
const bigorski = new Other(6448580245, 20.6094915, 41.6207798,
    "Бигорски Манастир", "+389 (0) 42 333 399", "https://bigorski.org.mk", "Секогаш", "");
let others = [];
others.push(bigorski);
function showLocals(locals, type) {
    for(let i=0; i<locals.length; i++){
        let tableCell = document.createElement("td");
        let newDiv = document.createElement("div");
        let bigText = document.createElement("h3");
        let text = document.createTextNode(locals[i].name);
        let link = document.createElement("a");
        if(type == 'Restaurants'){
            link.href = "restaurant_info.html?id=" + locals[i].id;
        }else if(type == 'Cafes'){
            link.href = "cafe_info.html?id=" + locals[i].id;
        }else if(type == 'Markets'){
            link.href = "market_info.html?id=" + locals[i].id;
        }else if(type == 'Others'){
            link.href = "others_info.html?id=" + locals[i].id;
        }
        link.style.textDecoration = "none";
        link.style.color = "black";
        link.appendChild(text);
        bigText.appendChild(link);
        newDiv.appendChild(bigText);
        newDiv.style.margin = "70px";
        newDiv.style.backgroundColor="lightgray"
        tableCell.appendChild(newDiv);
        let cont = document.getElementById(type);
        cont.appendChild(tableCell);
    }
}
function showRestInfo(locals, type) {
    // localStorage.getItem("id");
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    console.log(id);
    let local = locals.find(rest => rest.id.toString() === id);
    let phone = document.createTextNode(local.phone);
    document.getElementById("phone").appendChild(phone);
    let website = document.createTextNode(local.website);
    document.getElementById("website").appendChild(website);
    if(type != 'Market'){
        let outdoor;
        if(local.outdoors === "yes"){
            outdoor = document.createTextNode("Да");
        }else{
            outdoor = document.createTextNode("Не");
        }
        document.getElementById("outdoor").appendChild(outdoor);
        let smoking;
        if(local.smoking === "yes"){
            smoking = document.createTextNode("Да");
        }else{
            smoking = document.createTextNode("Не");
        }
        document.getElementById("smoking").appendChild(smoking);
    }
    let hours = document.createTextNode(local.open);
    document.getElementById("hours").appendChild(hours);
}