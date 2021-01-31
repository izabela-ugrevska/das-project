<template>
  <div class="markets">
    <div class="container4">
      <h1 style="color: #f2f2f2; font-family: Cuprum Regular, serif; font-size: 64px; padding-top: 145px">МАРКЕТИ</h1>
      <h5 style="color: #f2f2f2">Кликнете на маркетот за кој сте заинтересирани, и дознајте повеќе информации!</h5>
      <b-container class="tableOfMarkets" style="padding-top: 600px">
        <div v-for="object in markets" :key="object.name" class="market">
          <template>
            <router-link :to="`/objects/markets/${object.objectId}`" style="color: #2A1B3C; font-size: 17px;
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
</template>

<script>
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  data () {
    return {
      markets: []
    }
  },
  methods: {
    // gets all objects form the database from category market
    refreshMarkets () {
      ObjectAxiosData.retrieveMarkets().then((res) => {
        this.markets = res.data
      })
    }
  },
  created () {
    this.refreshMarkets()
  }
}

</script>

<style>
#header{
  align-content: center;
  background: lightgray;
  padding-bottom: 3px;
}

.container4{
  height: 645px;
  background-color: #2A1B3C;
  font-family: "Cuprum Regular", serif;
  background-image: url("../assets/logos/Позадина-МАРКЕТИ-транспарентна.png");
  background-size: 1000px;
  background-repeat: no-repeat;
  background-position-x: 240px;
}

.markets{
  background: lavender;
}
.tableOfMarkets{
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  width: 1000px;
}
.market{
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
