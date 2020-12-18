<template>
  <div>
    <h1>Маркети</h1>
    <b-table hover :items="filteredMarkets">
      <template #cell(name)="data">
        <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
      </template>
    </b-table>
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
