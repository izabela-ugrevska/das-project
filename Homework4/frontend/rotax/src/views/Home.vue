<template>
  <div class="home">
    <div class="container1" style="background-color: #2A1B3C">
      <br> <br>
      <br> <br>
      <br>
      <h1 style="color: #f2f2f2; font-size: 40px">ПРОНАЈДЕТЕ ПРИСТАПНИ МЕСТА ЗА КОЛИЧКА</h1>
      <b-container class="bv-example-row">
        <b-row style="align-content: center">
          <div class="category">
            <router-link to="/restaurants">
              <b-col>
                <h5 style="padding-top: 10px; font-family: 'Cuprum Regular',serif; color: #f2f2f2; font-size: 25px">РЕСТОРАНИ</h5>
                <img src="../assets/Desktop/utilities.png" style="height: 170px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category">
            <router-link to="/cafes">
              <b-col>
                <h5 style="padding-top: 10px;font-family: 'Cuprum Regular',serif; color: #f2f2f2; font-size: 25px">КАФЕ-БАРОВИ</h5>
                <img src="../assets/Desktop/glass.png" style=" height: 170px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category">
            <router-link to="/markets">
              <b-col>
                <h5 style="padding-top: 10px;font-family: 'Cuprum Regular',serif; color: #f2f2f2; font-size: 25px">МАРКЕТИ</h5>
                <img src="../assets/Desktop/basket.png" style="height: 170px; margin-left: -15px; margin-top: -10px">
              </b-col>
            </router-link>
          </div>
          <div class="category" style="margin-right: 0px">
            <router-link to="/other">
              <b-col><h5 style="padding-top: 10px;font-family: 'Cuprum Regular',serif; color: #f2f2f2; font-size: 25px">ОСТАНАТО</h5>
                <img src="../assets/Desktop/magnifying-glass.png" style=" height: 170px;  margin-top: -10px">
              </b-col>
            </router-link>
          </div>
        </b-row>
      </b-container>
    <div id="all_objects">
      <div class="search-wrapper">
        <input type="text" v-model="search" placeholder="Search" id="search-bar">
      </div>
      <br>
      <div class="wrapper">
        <div class="card" v-for="object in filteredList" :key="object.name">
          <router-link :to="`/objects/searched/${object.objectId}`" class="link-to-object">{{object.name}}</router-link>
        </div>
      </div>
    </div>
      <h2 style="padding-top: 90px; color: #f2f2f2">Инклузивноста е право, а не привилегија!</h2>
    <div class="footer">
      <h5 style="color: gray; align-content: center; padding-top: 70px">rotax.herokuapp.com © Сите права се задржани - 2021</h5>
    </div>
    </div>
  </div>
</template>
<script>
import ObjectAxiosData from '../data/ObjectAxiosData'
import UserService from '../services/user.service'
export default {
  name: 'Home',
  data () {
    return {
      search: '',
      objList: [],
      content: ''
    }
  },
  mounted () {
    UserService.getPublicContent().then(
      response => {
        this.content = response.data
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  },
  methods: {
    // returns the objects from all categories in the database
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
    // returns only the objects from the database that contain
    // the letters typed in the search bar
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
  .footer{
    background: #2A1B3C;
    height: 120px;
  }
  .container1{
    position: relative;
    font-family: "Cuprum Regular";
    background-color: #2A1B3C;
    background-image: url("../assets/logos/-позадина-ПОЧЕТНА транспарентна.png");
    background-size: 645px;
    background-repeat: no-repeat;
    background-position-x: 420px;
  }
  .home{
    background: #2A1B3C;
  }
  .category{
    width: 200px;
    height: 200px;
    margin-top: 120px;
    margin-bottom: 100px;
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
    height: 43px;
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
    padding-left: 50px;
  }

  .card {
    box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px;
    width: 200px;
    height: 120px;
    margin: 12px;
    transition: .15s all ease-in-out;
    background: #E6E6E6;
  }
  .link-to-object {
    text-decoration: none;
    padding: 12px;
    color: #2A1B3C;
    font-size: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>
