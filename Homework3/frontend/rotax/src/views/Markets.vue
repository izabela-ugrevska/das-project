<template>
  <div class="markets">
    <div id="header">
      <img src="../assets/logos/marketsLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете маркетот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfMarkets">
        <b-table id="marketTable" hover :items="filteredMarkets">
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
import markets from '@/data/objects'
export default {
  data () {
    return {
      markets,
      filteredMarkets
    }
  }
}

var filteredMarkets = []
for (let i = 0; i < markets.length; i++) {
  if (markets[i].category === 'market') {
    filteredMarkets.push(markets[i])
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

.markets{
  background: lavender;
}
.tableOfMarkets{
  width: 200px;
  height: 200px;
  margin-top: 120px;
  margin-bottom: 100px;
  background-color: lightgray;
  font-size: 20px;
}
#marketTable td {
  display: none;
}
#marketTable td:nth-child(2) {
  display: block;
  margin-bottom: 15px;
}
#marketTable th {
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
