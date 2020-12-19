<template>
  <div class="cafes">
    <div id="header">
      <img src="../assets/logos/cafesLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на кафе барот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfCafes">
        <b-table id="cafeTable" hover :items="filteredCafes">
          <template #cell(name)="data">
            <router-link :to="`/objects/other/${data.value}`">{{ data.value }}</router-link>
          </template>
        </b-table>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i></i></h5>
    </div>
  </div>
</template>

<script>
import cafes from '@/data/objects'
export default {
  data () {
    return {
      cafes,
      filteredCafes
    }
  }
}

var filteredCafes = []
for (let i = 0; i < cafes.length; i++) {
  if (cafes[i].category === 'cafe') {
    filteredCafes.push(cafes[i])
  }
}
</script>

<style>
#header{
  align-content: center;
  background: lightgray;
  padding-bottom: 3px;
}
#footer{
  background: lightgray;
  height: 120px;

}
#container{
  height: 420px;
}

.cafes{
  background: lavender;
}
.tableOfCafes{
  width: 200px;
  height: 200px;
  margin-top: 120px;
  margin-bottom: 100px;
  background-color: lightgray;
  font-size: 20px;
}
#cafeTable td {
  display: none;
}
#cafeTable td:nth-child(2) {
  display: block;
  margin-bottom: 15px;
}
#cafeTable th {
  display: none;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
