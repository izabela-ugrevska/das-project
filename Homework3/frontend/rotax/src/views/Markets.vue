<template>
  <div class="markets">
    <div id="header">
      <img src="../assets/logos/marketsLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете маркетот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfMarkets">
        <div v-for="object in markets" :key="object.name" class="market">
          <template>
            <router-link :to="`/objects/markets/${object.objectId}`">{{ object.name }}</router-link>
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
      markets: []
    }
  },
  methods: {
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

// var filteredMarkets = []
// for (let i = 0; i < markets.length; i++) {
//   if (markets[i].category === 'market') {
//     filteredMarkets.push(markets[i])
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
