<template>
  <div class="cafes">
    <div id="header">
      <img src="../assets/logos/cafesLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на кафе барот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <div id="filter">
        <h5>filter by:</h5>
        <li v-for="tag in tags" :key="tag.value" style="display: inline-block;">
          <input class="checkbox" type="checkbox" :value="tag" v-model="selectedTags" :id="tag">{{tag}}
        </li>
        <p v-show="selectedTags.length != 0">
          Filters: <span v-for="tag in selectedTags" :key="tag.value" class="label">{{ tag }} </span>
        </p>
      </div>
      <b-container class="tableOfCafes">
        <div v-for="cafe in activeCafes" :key="cafe.name" class="cafe">
          <template>
            <router-link :to="`/objects/cafes/${cafe.objectId}`">{{ cafe.name }}</router-link>
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
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  data () {
    return {
      tags: ['smokingType', 'outdoorSeating'],
      cafes: [],
      selectedTags: []
    }
  },
  methods: {
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
    activeCafes: function () {
      if (this.selectedTags.length === 0) return this.cafes
      const activeCafes = []
      const filters = this.selectedTags
      this.cafes.forEach(function (cafe) {
        function cafeContainsFilter (filter) {
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

// var filteredCafes = []
// for (let i = 0; i < cafes.length; i++) {
//   if (cafes[i].category === 'cafe') {
//     filteredCafes.push(cafes[i])
//   }
// }
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
  border: 1px gray solid;
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
