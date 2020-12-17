<template>
  <div>
    <h3>Маркети</h3> <br> <br>
    <ul id="marketList">
      <li v-for="market in filteredMarkets" :key="market.name">
        {{ market.name }}
      </li>
    </ul>
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
