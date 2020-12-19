<template>
  <div class="restaurants">
    <div id="header">
      <img src="../assets/logos/restaurantsLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на ресторанот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfRestaurants">
        <div v-for="object in filteredRestaurants" :key="object.name" class="rest">
          <template>
            <router-link :to="`/objects/restaurants/${object.name}`">{{ object.name }}</router-link>
          </template>
        </div>
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
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  width: 1000px;
}
.rest{
  display: inline-block;
  width: 200px;
  height: 50px;
  background: lightsteelblue;
  text-align-all: center;
  margin-right: 50px;
  margin-bottom: 50px;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
