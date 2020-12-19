<template>
  <div class="restaurants">
    <div id="header">
      <img src="../assets/logos/restaurantsLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на ресторанот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <div id="filter">
        <h4>Filter by:</h4>
        <div v-for="tag in tags" :key="tag.value" style="display: inline-block;">
          <input type="checkbox" :value="tag" v-model="selectedTags" :id="tag">{{tag}}
        </div>
        <p v-show="selectedTags.length != 0">
          Filters: <span v-for="tag in selectedTags" :key="tag.value" class="label">{{ tag }} </span>
        </p>
      </div>
      <b-container class="tableOfRestaurants">
        <div v-for="object in activeRestaurants" :key="object.name" class="rest">
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
      tags: ['smokingtype', 'outdoorSeating'],
      filteredRestaurants,
      selectedTags: []
    }
  },
  computed: {
    activeRestaurants: function () {
      if (this.selectedTags.length === 0) return this.filteredRestaurants
      const activeRestaurants = []
      const filters = this.selectedTags
      this.filteredRestaurants.forEach(function (rest) {
        function restaurantContainsFilter (filter) {
          return rest[filter] === true
        }
        if (filters.every(restaurantContainsFilter)) {
          activeRestaurants.push(rest)
        }
      })
      return activeRestaurants
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
input{
  width: 20px;
  height: 20px;
  margin-left: 10px;
  margin-right: 5px;
}
#filter{
  position: absolute;
  left: 0px;
  text-align: left;
  border: 1px gray solid;
}
.tableOfRestaurants{
  position: absolute;
  top: 50%;
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
  background: lightgray;
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
