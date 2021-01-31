<template>
  <div class="restaurants container2">
    <div class="container2">
      <br><br><br><br><br>
      <h1 style="font-family: 'Cuprum Regular',serif; color: #f2f2f2; font-size: 64px">РЕСТОРАНИ</h1>
      <h5 style="font-family: 'Cuprum Regular',serif; color: #f2f2f2">
        Кликнете на ресторанот за кој сте заинтересирани, и дознајте повеќе информации!</h5>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <div id="filter">
        <h4 style="color: #f2f2f2">Filter by:</h4>
        <div v-for="tag in tags" :key="tag.value" style="display: inline-block; color: #f2f2f2">
          <input class="checkbox" type="checkbox" :value="tag" v-model="selectedTags" :id="tag">{{tag}}
        </div>
        <p v-show="selectedTags.length != 0">
          Filters: <span v-for="tag in selectedTags" :key="tag.value" class="label">{{ tag }} </span>
        </p>
      </div>
      <b-container class="tableOfRestaurants" style="padding-top: 300px; padding-left: 100px;
      font-family: 'Cuprum Regular',serif;">
        <div v-for="object in activeRestaurants" :key="object.name" class="rest">
          <template>
            <router-link :to="`/objects/restaurants/${object.objectId}`"
                         style="color: #2A1B3C; font-size: 17px;
            font-family: Cuprum Regular, serif; text-transform: uppercase;">
              <b>{{ object.name }}</b></router-link>
          </template>
        </div>
      </b-container>
    </div>
    <div class="footer">
      <h5 style="color: gray; align-content: center; padding-top: 70px">rotax.herokuapp.com © Сите права се задржани - 2021</h5>
    </div>
  </div>
<!--  </div>-->
</template>

<script>
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  data () {
    return {
      tags: ['smoking', 'outdoorSeating'],
      restaurants: [],
      selectedTags: []
    }
  },
  methods: {
    // gets objects from the database from category restaurant
    refreshRestaurants () {
      ObjectAxiosData.retrieveRestaurants().then((res) => {
        this.restaurants = res.data
      })
    }
  },
  created () {
    this.refreshRestaurants()
  },
  computed: {
    // returns the restaurants whose checked properties
    // smoking and/or outsideSeating have the value true
    activeRestaurants: function () {
      if (this.selectedTags.length === 0) return this.restaurants
      const activeRestaurants = []
      const filters = this.selectedTags
      this.restaurants.forEach(function (rest) {
        function restaurantContainsFilter (filter) { // for each filter checks whether the given property(filter) is true for each restaurant
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
.container2{
  height: 645px;
  background-color: #2A1B3C;
  background-image: url("../assets/logos/Позадина-РЕСТОРАНИ-транспарентна.png");
  background-size: 950px;
  background-repeat: no-repeat;
  background-position-x: 310px;
}

.restaurants{
  /*background: #2A1B3C;*/
}
.checkbox{
  width: 20px;
  height: 20px;
  margin-left: 10px;
  margin-right: 5px;
}
#filter{
  position: absolute;
  left: 0px;
  text-align: left;
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
  height: 70px;
  background: #E6E6E6;
  text-align-all: center;
  margin-right: 50px;
  margin-bottom: 50px;
  border-radius: 5px;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
