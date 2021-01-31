<template>
  <div class="cafes">
    <div class="container3">
      <h1 style="color: #f2f2f2; padding-top: 150px; font-size: 64px">КАФЕ-БАРОВИ</h1>
      <h5 style="color: #f2f2f2; padding-top: 10px">Кликнете на кафе-барот за кој сте заинтересирани, и дознајте повеќе информации!</h5>
      <br><br><br><br><br><br><br><br><br><br><br><br>
      <div id="filter">
        <h5 style="color: #f2f2f2">Filter by:</h5>
        <li v-for="tag in tags" :key="tag.value" style="display: inline-block; color: #f2f2f2">
          <input class="checkbox" type="checkbox" :value="tag" v-model="selectedTags" :id="tag">{{tag}}
        </li>
        <p v-show="selectedTags.length != 0">
          Filters: <span v-for="tag in selectedTags" :key="tag.value" class="label">{{ tag }} </span>
        </p>
      </div>
      <b-container class="tableOfCafes" style="padding-top: 380px">
        <div v-for="cafe in activeCafes" :key="cafe.name" class="cafe">
          <template>
            <router-link :to="`/objects/cafes/${cafe.objectId}`" style="color: #2A1B3C; font-size: 17px;
            font-family: Cuprum Regular, serif; text-transform: uppercase ">
              <b>{{ cafe.name }}</b></router-link>
          </template>
        </div>
      </b-container>
    </div>
    <div class="footer">
      <h5 style="color: gray; align-content: center; padding-top: 70px">rotax.herokuapp.com © Сите права се задржани - 2021</h5>
    </div>
  </div>
</template>

<script>
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  data () {
    return {
      tags: ['smoking', 'outdoorSeating'],
      cafes: [],
      selectedTags: []
    }
  },
  methods: {
    // gets all cafes from the database
    refreshCafes () {
      ObjectAxiosData.retrieveCafes().then((res) => {
        this.cafes = res.data
      })
    }
  },
  created () {
    this.refreshCafes()
  },
  computed: {
    // returns the cafes whose checked properties
    // smoking and/or outsideSeating have the value true
    activeCafes: function () {
      if (this.selectedTags.length === 0) return this.cafes
      const activeCafes = []
      const filters = this.selectedTags
      this.cafes.forEach(function (cafe) {
        function cafeContainsFilter (filter) { // for each filter checks whether the given property(filter) is true for each cafe
          return cafe[filter] === true
        }
        if (filters.every(cafeContainsFilter)) {
          activeCafes.push(cafe)
        }
      })
      return activeCafes
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
.container3{
  height: 645px;
font-family: "Cuprum Regular", serif;
  background-image: url("../assets/logos/Позадина-КАФЕ-БАРОВИ-транспарентна.png");
  background-size: 950px;
  background-repeat: no-repeat;
  background-position-x: 310px;
}

.cafes{
  background: #2A1B3C;
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
.tableOfCafes{
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  width: 1000px;
}
.cafe{
  display: inline-block;
  width: 200px;
  height: 50px;
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
