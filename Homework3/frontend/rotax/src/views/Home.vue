<template>
  <div class="home">
    <div id="header">
      <img src="../assets/logos/logo.png" style="padding-bottom: 3px; width: 270px; height: 100px;">
      <h5 style="color: darkcyan"><i>Пронајдете места пристапни со инвалидска количка</i></h5>
    </div>
    <div id="container">
      <b-container class="bv-example-row">
        <b-row style="align-content: center">
          <div class="category">
            <router-link to="/restaurants">
              <b-col>
                <h5 style="padding-top: 10px"><i>Ресторани</i></h5>
                <img src="../assets/Desktop/utilities.png" style="width: 110px; height: 150px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category">
            <router-link to="/cafes">
              <b-col>
                <h5 style="padding-top: 10px"><i>Кафе-барови</i></h5>
                <img src="../assets/Desktop/glass.png" style="width: 150px; height: 160px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category">
            <router-link to="/markets">
              <b-col>
                <h5 style="padding-top: 10px"><i>Маркети</i></h5>
                <img src="../assets/Desktop/basket.png" style="width: 130px; height: 150px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category" style="margin-right: 0px">
            <router-link to="/other">
              <b-col><h5 style="padding-top: 10px"><i>Останато</i></h5>
                <img src="../assets/Desktop/magnifying-glass.png" style="width: 130px; height: 130px;  margin-top: -10px">
              </b-col>
            </router-link>
          </div>
        </b-row>
      </b-container>
    </div>
    <div id="all_objects">
      <div class="search-wrapper">
        <input type="text" v-model="search" placeholder="Search title.." id="search-bar">
      </div>
      <div class="wrapper">
        <div class="card" v-for="object in filteredList" :key="object.name">
          <router-link :to="`/objects/searched/${object.objectId}`" class="link-to-object">{{object.name}}</router-link>
        </div>
      </div>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i>Инклузивноста е право, а не привилегија!</i></h5>
    </div>
  </div>
</template>
<script>// @ is an alias to /src
// import objects from '@/data/objects'
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  name: 'Home',
  data () {
    return {
      search: '',
      objList: []
    }
  },
  methods: {
    refreshObjects () {
      ObjectAxiosData.retrieveAllObjects().then((res) => {
        this.objList = res.data
      })
    }
  },
  created () {
    this.refreshObjects()
  },
  computed: {
    filteredList () {
      return this.objList.filter(object => {
        return object.name.toLowerCase().includes(this.search.toLowerCase())
      })
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
  #container{
    position: relative;
  }
  .home{
    background: lavender;
  }
  .category{
    width: 200px;
    height: 200px;
    margin-top: 120px;
    margin-bottom: 100px;
    background-color: lightgray;
    margin-right: 100px;
  }
  a{
    color: darkcyan;
  }
  a:hover{
    text-decoration: none;
    color: darkcyan;
  }
  div#all_objects {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
  }

  .search-wrapper {
    position: relative;
  }
  label {
    position: absolute;
    font-size: 12px;
    color: rgba(0,0,0,.50);
    top: 8px;
    left: 12px;
    z-index: -1;
    transition: .15s all ease-in-out;
  }
  #search-bar {
    height: 50px;
    width: 300px;
    padding: 4px 12px;
    color: rgba(0,0,0,.70);
    border: 1px solid rgba(0,0,0,.12);
    transition: .15s all ease-in-out;
    background: white;
  }

  .wrapper {
    display: flex;
    max-width: 1000px;
    flex-wrap: wrap;
    padding-top: 12px;
  }

  .card {
    box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px;
    width: 200px;
    margin: 12px;
    transition: .15s all ease-in-out;
    background: lightgray;
  }
  .link-to-object {
    text-decoration: none;
    padding: 12px;
    color: darkcyan;
    font-size: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>
