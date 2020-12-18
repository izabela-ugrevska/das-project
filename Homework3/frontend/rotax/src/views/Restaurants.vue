<template>
  <div class="restaurants">
    <div id="header">
      <img src="../assets/logos/restaurantsLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на ресторанот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfRestaurants">
        <b-table id="restTable" hover :items="filteredRestaurants">
          <template #cell(name)="data">
            <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
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
import restaurants from '@/data/objects'
export default {
  data () {
    return {
      restaurants,
      filteredRestaurants
    }
  }
}

var filteredRestaurants = []
for (let i = 0; i < restaurants.length; i++) {
  if (restaurants[i].category === 'restaurant') {
    filteredRestaurants.push(restaurants[i])
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

.restaurants{
  background: lavender;
}
.tableOfRestaurants{
  width: 200px;
  height: 200px;
  margin-top: 120px;
  margin-bottom: 100px;
  background-color: lightgray;
  font-size: 20px;
}
#restTable td {
  display: none;
}
#restTable td:nth-child(2) {
  display: block;
  margin-bottom: 15px;
}
#restTable th {
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
